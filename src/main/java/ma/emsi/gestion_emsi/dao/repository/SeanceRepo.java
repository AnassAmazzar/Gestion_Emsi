package ma.emsi.gestion_emsi.dao.repository;

import jakarta.transaction.Transactional;
import ma.emsi.gestion_emsi.dao.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface SeanceRepo extends JpaRepository<Seance, Integer> {
}
