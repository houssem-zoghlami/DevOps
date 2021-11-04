package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.services.IEntrepriseService;

import java.util.List;

@Controller
public class IControllerEntrepriseImpl {


    @Autowired
    IEntrepriseService ientrepriseservice;

    public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
        ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
    }


    public int ajouterDepartement(Departement dep) {
        return ientrepriseservice.ajouterDepartement(dep);
    }

    public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
        return ientrepriseservice.getAllDepartementsNamesByEntreprise(entrepriseId);
    }

    public void deleteDepartementById(int depId) {
        ientrepriseservice.deleteDepartementById(depId);

    }
}
