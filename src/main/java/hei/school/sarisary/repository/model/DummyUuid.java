package hei.school.sarisary.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import hei.school.sarisary.PojaGenerated;

@PojaGenerated
@Entity
@Getter
@Setter
public class DummyUuid {
  @Id private String id;
}
