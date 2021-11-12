package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService ientrepriseservice;

	@Autowired
    EntrepriseRepository entrepriseRepoistory;

	Integer idE;


	@Test
	public void testAjouterEntreprise()  {
		 idE=ientrepriseservice.ajouterEntreprise(new Entreprise("cars","sa "));
		assertNotNull(idE);
	}

	@Test
	public void testGetEntrpriseById() {
	Entreprise e =ientrepriseservice.getEntrepriseById(17); 
	assertEquals(17, e.getId());
	}
	
   @Test
	public void testGetAllDepartementsNamesByEntreprise() {
		
	List<String> depNames = ientrepriseservice.getAllDepartementsNamesByEntreprise(17);
		assertNotNull(depNames);
	}



}