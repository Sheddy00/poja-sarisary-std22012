package hei.school.sarisary.service.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Date;

@Service
public class SaryService {
    private AmazonS3 amazonS3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public String generatePresignedUrl(String id, String filename, Date expiration) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, id + "/" + filename)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(expiration);
        URL url = amazonS3Client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    public String saveTransformedImage(String id, byte[] imageData) {
        String key = id + "/transformed.jpg";
        amazonS3Client.putObject(bucketName, key, new ByteArrayInputStream(imageData), null);

        Date expiration = new Date(System.currentTimeMillis() + 3600000);
        return generatePresignedUrl(id, "transformed.jpg", expiration);
    }
}

