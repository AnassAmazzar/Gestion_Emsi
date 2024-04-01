package ma.emsi.gestion_emsi.dao.repository;

import jakarta.transaction.Transactional;
import ma.emsi.gestion_emsi.dao.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface PersonneRepo extends JpaRepository<Personne, Long> {
    @Modifying
    @Query("update Etudiant e set e.nom = :nom where e.id = :id")
    void updateById(@Param(value = "id") long id, @Param(value = "nom") String nom);
}
