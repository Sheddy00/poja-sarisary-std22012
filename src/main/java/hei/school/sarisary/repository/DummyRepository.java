package hei.school.sarisary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hei.school.sarisary.PojaGenerated;
import hei.school.sarisary.repository.model.Dummy;

@PojaGenerated
@Repository
public interface DummyRepository extends JpaRepository<Dummy, String> {

  @Override
  List<Dummy> findAll();
}
