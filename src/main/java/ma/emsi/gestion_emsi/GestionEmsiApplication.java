package ma.emsi.gestion_emsi;

import ma.emsi.gestion_emsi.dao.entities.*;
import ma.emsi.gestion_emsi.dao.repository.CoursRepo;
import ma.emsi.gestion_emsi.dao.repository.PersonneRepo;
import ma.emsi.gestion_emsi.dao.repository.SeanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class GestionEmsiApplication implements CommandLineRunner {
    static int mat=0;
    @Autowired
    CoursRepo coursRepository;
    @Autowired
    PersonneRepo personneRepository;
    @Autowired
    SeanceRepo seanceRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionEmsiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save a student
        Etudiant e1 = new Etudiant();
        e1.setNom("John Snow");
        e1.setDate_Naissance(new Date(2002, 06, 01));
        e1.setMatricule("E001");
        personneRepository.save(e1);

        // Create and save a professor
        Proffesseur pr1 = new Proffesseur();
        pr1.setNom("Bary Alan");
        pr1.setDate_Naissance(new Date(1995, 06, 01));
        pr1.setD_affectation(new Date(1980, 01, 15));
        personneRepository.save(pr1);

        // Create and save a course
        Cours cours1 = new Cours();
        cours1.setTitre("JavaEE");
        cours1.setDescription("Java Test 1");
        cours1.setProffesseur(pr1);
        coursRepository.save(cours1);

        // Create and save a session
        Seance seance1 = new Seance();
        seance1.setDates(new Date());
        seance1.setH_debut(new Date(2024, 03, 25));
        seance1.setH_fin(new Date(2024, 03, 28));
        seance1.setCours(cours1);
        seance1.setEtudiants(Arrays.asList(e1));
        seanceRepository.save(seance1);

        //Update
        personneRepository.updateById(e1.getId(), "Adame Toto");

        //Delete
        seanceRepository.delete(seance1);
        personneRepository.delete(e1);


        //Recherche
        System.out.println(personneRepository.findById(pr1.getId()));
        System.out.println(personneRepository.findById(e1.getId()));
        System.out.println(coursRepository.findById(cours1.getId()));
        System.out.println(seanceRepository.findById(seance1.getId()));

        /*
        Cours cours1 = new Cours(null, "JavaEE", "Java Test 1");
        Cours cours2 = new Cours(null, "JavaEE", "Java Test 1");
        Cours cours3 = new Cours(null, "JavaEE", "Java Test 1");

        Seance seance1 = new Seance(null, new Date(), new Date(2024, 03, 25), new Date(2024, 03, 28));
        Seance seance2 = new Seance(null, new Date(), new Date(2024, 03, 25), new Date(2024, 03, 28));
        Seance seance3 = new Seance(null, new Date(), new Date(2024, 03, 25), new Date(2024, 03, 28));

        Etudiant e1 = new Etudiant(null, "John Snow", new Date(2002,06,01), "E00"+mat++, Arrays.asList(seance1,seance2));

        Etudiant e2 = new Etudiant(null, "Fahim Chawki", new Date(2000,12,06), "E00"+mat++);
        Etudiant e3 = new Etudiant(null, "John week", new Date(2003,04,10), "E00"+mat++);


        Proffesseur pr1 = new Proffesseur(null, "Bary Alan", new Date(1980, 01, 15),new Date());
        Proffesseur pr2 = new Proffesseur(null, "Mohamed Amine", new Date(1975, 11, 07),new Date());
        Proffesseur pr3 = new Proffesseur(null, "Kall Ell", new Date(1960, 07, 30),new Date());
        */

    }
}
