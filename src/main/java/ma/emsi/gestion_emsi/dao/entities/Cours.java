package ma.emsi.gestion_emsi.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;
    @OneToOne
    private Proffesseur proffesseur;
    @OneToMany(mappedBy = "cours")
    private Collection<Seance> seances;

//    public Cours(Object o, String javaEE, String s) {
//        this.titre=javaEE;
//        this.description=s;
//    }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", proffesseur=" + proffesseur.getNom() +
                '}';
    }
}
