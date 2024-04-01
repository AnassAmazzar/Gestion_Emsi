package ma.emsi.gestion_emsi.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
public class Proffesseur extends Personne {
    private Date d_affectation;
    @OneToOne(mappedBy = "proffesseur")
    private Cours cours;

//    public Proffesseur(Object o, String baryAlan, Date date, Date date1) {
//        super(null, baryAlan, date);
//        this.d_affectation=date1;
//    }


    @Override
    public String toString() {
        return "Proffesseur{"+ super.toString() +
                " d_affectation=" + d_affectation +
                ", cours=" + cours.getTitre() +
                '}';
    }
}
