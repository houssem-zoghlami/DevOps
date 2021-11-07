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

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeSheetTest {
	
	@Autowired
	ITimesheetService it;
	@Autowired
	EmployeServiceImpl iEmployeService;
	
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
		idmiss = it.ajouterMission(mission);
		it.ajouterTimesheet(idmiss, idemp, new Date(),new Date());
		Assert.assertNotNull(it.findTimesheet(new TimesheetPK(idmiss, idemp, new Date(), new Date()))); 
		
		LOGGER.info("Added successfully with");
		}
		catch (Exception e) { LOGGER.error("Problem encountred : " + e); }
		
	}
	
	@Test
	public void TestSearchTimesheet()
	{
		int idemp;
		int idmiss ;
		Employe employe = new Employe( "sana", "romdhani", "sana.romdhani1@esprit.tn", true, Role.INGENIEUR);

		idemp = iEmployeService.ajouterEmploye(employe);
		Mission mission = new Mission("Mission1","Lorem Ipsum");
		idmiss = it.ajouterMission(mission);
		it.ajouterTimesheet(idmiss, idemp, new Date(),new Date());
		Assert.assertNotNull(it.findTimesheet(new TimesheetPK(idmiss, idemp, new Date(), new Date()))); 

	}

}
