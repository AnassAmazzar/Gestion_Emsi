package ma.emsi.gestion_emsi.dao.repository;

import jakarta.transaction.Transactional;
import ma.emsi.gestion_emsi.dao.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CoursRepo extends JpaRepository<Cours, Integer> {
}
