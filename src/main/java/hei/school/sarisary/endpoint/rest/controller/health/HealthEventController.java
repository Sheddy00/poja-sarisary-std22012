package hei.school.sarisary.endpoint.rest.controller.health;

import hei.school.sarisary.PojaGenerated;
import hei.school.sarisary.endpoint.event.EventProducer;
import hei.school.sarisary.endpoint.event.gen.UuidCreated;
import hei.school.sarisary.repository.DummyUuidRepository;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static hei.school.sarisary.endpoint.rest.controller.health.PingController.KO;
import static hei.school.sarisary.endpoint.rest.controller.health.PingController.OK;
import static java.util.UUID.randomUUID;

@PojaGenerated
@RestController
@AllArgsConstructor
public class HealthEventController {

  DummyUuidRepository dummyUuidRepository;
  EventProducer eventProducer;

  @GetMapping(value = "/health/event")
  public ResponseEntity<String> random_uuid_is_fired_then_created() throws InterruptedException {
    var randomUuid = randomUUID().toString();
    var event = new UuidCreated().toBuilder().uuid(randomUuid).build();

    eventProducer.accept(List.of(event));

    Thread.sleep(20_000);
    return dummyUuidRepository.findById(randomUuid).map(dummyUuid -> OK).orElse(KO);
  }
}
