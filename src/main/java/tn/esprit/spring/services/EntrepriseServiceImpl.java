package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import org.apache.log4j.Logger;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
//	@Autowired
	DepartementRepository deptRepoistory;
	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);
	
	public int ajouterEntreprise(Entreprise entreprise) {
		l.debug("Method ajouterEntreprise");
		entrepriseRepoistory.save(entreprise);
		l.info("entreprise ajoutÃ©e avec succÃ©s et son  id egal = "+entreprise.getId());
		return entreprise.getId();
		}
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.debug("method getAllDepartementsNamesByEntreprise ");
		List<String> depNames = new ArrayList<>();
		try {
			Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
			
			if(entrepriseManagedEntity!=null && entrepriseManagedEntity.getDepartements()!=null){
			for(Departement dep : entrepriseManagedEntity.getDepartements()){
				depNames.add(dep.getName());
			}
			l.debug("methode  fini avec succÃ©s ");
			return depNames;
			}
			else {
				l.error("erreur method : " );
				return depNames;
			}
		} catch (Exception e) {
			l.error("erreur method : " +e);
			return depNames;
		}
	}

	


	public Entreprise getEntrepriseById( int entrepriseId) {
	    l.debug("methode getEntrepriseById ");
			
			
			try {
				Entreprise et= entrepriseRepoistory.findById(entrepriseId).orElse(null);
				l.debug("getEntrepriseById fini avec succes ");
				return et;
			} catch (Exception e) {
				l.error("erreur methode getEntrepriseById : " +e);
				return null;
			}	
			
			
		}

}
