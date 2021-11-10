package tn.esprit.spring;



import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




import java.util.List;





import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;

import tn.esprit.spring.entities.TimesheetPK;

import tn.esprit.spring.services.EmployeServiceImpl;

import tn.esprit.spring.services.TimesheetServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeSheetTest {
	
	@Autowired
	private EmployeServiceImpl iEmployeService;

	@Autowired
	  private TimesheetServiceImpl timesheetServiceImpl;

	  
	  List<Employe> employes; 
	  List<Mission> missions; 
	

	

	private static final Logger LOGGER = LogManager.getLogger(TimeSheetTest.class);
	
	@Test
	public void testAjouterTimesheet()
	{
		int idemp;
		int idmiss ;
		Employe employe = new Employe( "sana", "romdhani", "sana.romdhani1@esprit.tn", true, Role.INGENIEUR);
		try
		{
		idemp = iEmployeService.ajouterEmploye(employe);
		Mission mission = new Mission("Mission1","Lorem Ipsum");
		idmiss = timesheetServiceImpl.ajouterMission(mission);
		timesheetServiceImpl.ajouterTimesheet(idmiss, idemp, new Date(),new Date());
		Assert.assertNotNull(timesheetServiceImpl.findTimesheet(new TimesheetPK(idmiss, idemp, new Date(), new Date()))); 
		
		LOGGER.info("Added successfully with");
	}
	catch (Exception e) { LOGGER.error("Problem encountred : " + e); }
		
	}
	
	@Test
	public void testValiderTimeSheet() {
		try {
			LOGGER.info("In ValiderTimeSheet() : ");
			LOGGER.debug("lancer methode");
			timesheetServiceImpl.validerTimesheet(1, 1, new Date(), new Date(), 1);
		  } catch (Exception e) {
			LOGGER.error("Erreur dans ValiderTimeSheet() :" + e);
		}
	
	}
	
	@Test
	public void testfindTimesheet()
	{
		int idemp;
		int idmiss ;
		Employe employe = new Employe( "sana", "romdhani", "sana.romdhani1@esprit.tn", true, Role.INGENIEUR);

		idemp = iEmployeService.ajouterEmploye(employe);
		Mission mission = new Mission("Mission1","Lorem Ipsum");
		idmiss = timesheetServiceImpl.ajouterMission(mission);
		timesheetServiceImpl.ajouterTimesheet(idmiss, idemp, new Date(),new Date());
		Assert.assertNotNull(timesheetServiceImpl.findTimesheet(new TimesheetPK(idmiss, idemp, new Date(), new Date()))); 

	}
	
	  
	
	

}
