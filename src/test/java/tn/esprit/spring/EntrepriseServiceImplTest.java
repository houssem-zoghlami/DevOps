package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class EntrepriseServiceImplTest {

    @Autowired
    EntrepriseRepository entrepriseRepoistory;

    @Autowired
    DepartementRepository deptRepoistory;

    @Autowired
    IEntrepriseService IEntrepriseService;

    Integer idDepartement;

    @Test
    public void testAjouterDepartement()  {
        idDepartement = IEntrepriseService.ajouterDepartement(new Departement("IT"));
        assertNotNull(idDepartement);
    }

    @Test
    public void testDeleteDepartementById()
    {   idDepartement=1;
        assertNotNull(idDepartement);
           IEntrepriseService.deleteDepartementById(idDepartement);

    }

}
