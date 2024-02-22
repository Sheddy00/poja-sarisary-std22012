package hei.school.sarisary.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import hei.school.sarisary.PojaGenerated;

@PojaGenerated
public class BucketConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.s3.bucket", () -> "dummy-bucket");
  }
}
