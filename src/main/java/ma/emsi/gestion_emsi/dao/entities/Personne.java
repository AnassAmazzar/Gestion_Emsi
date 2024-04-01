package ma.emsi.gestion_emsi.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nom;
    private Date date_Naissance;
}
