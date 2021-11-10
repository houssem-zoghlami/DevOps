package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.service.IEmployeService;
import tn.esprit.spring.service.IEntrepriseService;

import java.util.Date;
import java.util.List;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class EmployeServiceImplTest {
    @Autowired
    IEmployeService iemployeservice;

    @Autowired
    EmployeRepository employerepository;
    @Autowired
    IEntrepriseService entrepriseService ;

    Integer idE=1;
    int idCont = 0 ;
    Date currentDate = new Date(System.currentTimeMillis());
    Contrat contrat = new Contrat(currentDate, "CDI", 1000);
    Entreprise entreprise=new Entreprise("socato","hello");




    @Test
    public void testAjouterEmploye()  {
        idE=iemployeservice.ajouterEmploye(new Employe("houssem","zoghlami", "gg@ds.ds", true, Role.ADMINISTRATEUR));
        assertNotNull(idE);
    }
    @Test
    public void testDeleteEmployeById()
    {
        if(idE!=null){
            int i = iemployeservice.deleteEmployeById(idE);

            assertEquals(0, i);}
        else {
            int i = iemployeservice.deleteEmployeById(1);

            assertEquals(0, i);}
    }

    @Test
    public void testMettreAjourEmailByEmployeId() {
        List<Employe> employees = iemployeservice.getAllEmployes();
        for (Employe emp : employees) {
            idE = emp.getId();
        }
        iemployeservice.mettreAjourEmailByEmployeId("change@mail.com", idE);
    }



//    @Test
//    public void testGetEmployeById() {
//        Employe en =iemployeservice.getEmployePrenomById(1);
//        assertEquals(1, en.getId());
//    }


    }
