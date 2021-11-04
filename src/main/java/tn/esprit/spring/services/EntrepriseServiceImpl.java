package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;


import javax.transaction.Transactional;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
    private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);

    @Autowired
    EntrepriseRepository entrepriseRepoistory;
    @Autowired
    DepartementRepository deptRepoistory;

    public int ajouterDepartement(Departement dep) {
        try {
            l.info("In ajouterDepartement");
            l.debug("add Department.");
            deptRepoistory.save(dep);
            l.debug("Department added.");
            return dep.getId();
        }catch (Exception e) {
            l.error("Error in ajouterDepartement(Departement dep) : " + e);
            return 0;
        }

    }

    public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
        //Le bout Master de cette relation N:1 est departement
        //donc il faut rajouter l'entreprise a departement
        // ==> c'est l'objet departement(le master) qui va mettre a jour l'association
        //Rappel : la classe qui contient mappedBy represente le bout Slave
        //Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
        try {
            l.info("In affecterDepartementAEntreprise");
            l.debug("find Entreprise.");
            Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
            l.debug("after find Entreprise :" + entrepriseManagedEntity);
            l.debug("find Departement.");
            Departement depManagedEntity = deptRepoistory.findById(depId).orElse(null);
            l.debug("after find Departement :" + depManagedEntity);
            l.debug("insert  Entreprise to Departement:" + depManagedEntity);
            if (entrepriseManagedEntity != null && depManagedEntity != null) {
                depManagedEntity.setEntreprise(entrepriseManagedEntity);
                l.debug("after insert  Entreprise to Departement:" + depManagedEntity.getEntreprise());
                deptRepoistory.save(depManagedEntity);
                l.debug("Save in Database");
            }
        } catch (Exception e) {
            l.error("Error in affecterDepartementAEntreprise(int depId, int entrepriseId) : " + e);
        }
    }

    public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
        try {
            l.info("In getAllDepartementsNamesByEntreprise");
            l.debug("find Entreprise.");
            Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
            l.debug("after find Entreprise :" + entrepriseManagedEntity);
            l.debug("Create depNames");
            List<String> depNames = new ArrayList<>();
            if (entrepriseManagedEntity != null) {
                l.debug("Start finding all departments name");
                for (Departement dep : entrepriseManagedEntity.getDepartements()) {
                    depNames.add(dep.getName());
                    l.debug("departments name :" + dep.getName());
                }
            }
            return depNames;
        } catch (Exception e) {
            l.error("Error in getAllDepartementsNamesByEntreprise(int entrepriseId) : " + e);
            return Collections.emptyList();
        }
    }

    @Transactional
    public void deleteDepartementById(int depId) {
        try {
            l.info("In deleteDepartementById");
            deptRepoistory.findById(depId).ifPresent(departement -> deptRepoistory.delete(departement));
            l.debug("Departement deleted");
        } catch (Exception e) {
            l.error("Error in deleteDepartementById(int depId) : " + e);
        }
    }

}
