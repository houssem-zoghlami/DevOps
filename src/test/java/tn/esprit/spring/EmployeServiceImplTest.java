package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import tn.esprit.spring.entity.Employe;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.service.IEmployeService;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class EmployeServiceImplTest {
    @Autowired
    IEmployeService iemployeservice;

    @Autowired
    EmployeRepository employerepository;

    Integer ide;
    @Test
    public void testAjouterEmploye()  {
        ide=iemployeservice.ajouterEmploye(new Employe("Ghaith","Magherbi", "devops@test.tn", true, Role.ADMINISTRATEUR));
        assertNotNull(ide);
    }
    @Test
    public void testGetallEmps() {
    	iemployeservice.getAllEmployes(); 
	}
    @Test
    public void testGetAllEmployeNamesJPQL() {
    	iemployeservice.getAllEmployeNamesJPQL(); 
	}
    @Test
    public void testGetNombreEmployeJPQL() {
    	iemployeservice.getNombreEmployeJPQL(); 
	}


    @Test
    public void testMettreAjourEmailByEmployeId() {
		List <Employe> employees = iemployeservice.getAllEmployes();
		for (Employe emp : employees) {
			ide = emp.getId(); 
		}
		iemployeservice.mettreAjourEmailByEmployeId("ajour@mail.com", ide);
	}
    @Test
    public void testMettreAjourEmailByEmployeIdJPQL() {
		List <Employe> employees = iemployeservice.getAllEmployes();
		for (Employe emp : employees) {
			ide = emp.getId(); 
		}
		iemployeservice.mettreAjourEmailByEmployeIdJPQL("ajour@mail.com", ide);
	}
    @Test
    public void testGetEmployePrenomById() {
    	List <Employe> employees = iemployeservice.getAllEmployes();
		for (Employe emp : employees) {
			ide = emp.getId(); 
		}
		
		iemployeservice.getEmployePrenomById(ide);

    }
    @Test
    public void testAffecterEmployeADepartement() {
		List <Employe> employees = iemployeservice.getAllEmployes();
		for (Employe emp : employees) {
			ide = emp.getId(); 
		}
		
		iemployeservice.affecterEmployeADepartement(ide, 1);
		
    }


    }
