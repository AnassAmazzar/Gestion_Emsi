package ma.emsi.gestion_emsi.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class Seance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dates;
    private Date h_debut;
    private Date h_fin;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Etudiant> etudiants = new ArrayList<>();
    @ManyToOne
    private Cours cours;

//    public Seance(Object o, Date date, Date date1, Date date2) {
//        this.dates=date;
//        this.h_debut=date1;
//        this.h_fin=date2;
//    }


    @Override
    public String toString() {
        return "Seance{" +
                "id=" + id +
                ", dates=" + dates +
                ", h_debut=" + h_debut +
                ", h_fin=" + h_fin +
                ", cours=" + cours.getTitre() +
                '}';
    }
}
