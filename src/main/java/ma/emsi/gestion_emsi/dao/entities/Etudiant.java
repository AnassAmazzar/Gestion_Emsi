package ma.emsi.gestion_emsi.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Personne {
    private String matricule;
    @ManyToMany(mappedBy = "etudiants", fetch = FetchType.EAGER)
    private Collection<Seance> seances = new ArrayList<>();
    /*
    public Etudiant(Object o, String johnSnow, Date date, String s) {
        super(null,johnSnow, date);
        this.matricule=s;
    }
    */

    @Override
    public String toString() {
        return "Etudiant{" + super.toString() +
                " matricule='" + matricule + '\'' +
                '}';
    }
}
