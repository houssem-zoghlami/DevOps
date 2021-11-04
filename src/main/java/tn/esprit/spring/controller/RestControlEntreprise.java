package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.services.IEntrepriseService;

import java.util.List;

@RestController
public class RestControlEntreprise {

    @Autowired
    IEntrepriseService ientrepriseservice;

    // Ajouter Entreprise : http://localhost:8081/SpringMVC/servlet/ajouterEntreprise
    //{"id":1,"name":"SSII Consulting","raisonSocial":"Cite El Ghazela"}

    // http://localhost:8081/SpringMVC/servlet/affecterDepartementAEntreprise/1/1
    @PutMapping(value = "/affecterDepartementAEntreprise/{iddept}/{identreprise}")
    public void affecterDepartementAEntreprise(@PathVariable("iddept")int depId, @PathVariable("identreprise")int entrepriseId) {
        ientrepriseservice.affecterDepartementAEntreprise(depId, entrepriseId);
    }


    // http://localhost:8081/SpringMVC/servlet/ajouterDepartement
    //{"id":1,"name":"Telecom"}

    @PostMapping("/ajouterDepartement")
    @ResponseBody
    public int ajouterDepartement(@RequestBody Departement dep) {
        return ientrepriseservice.ajouterDepartement(dep);
    }

    // http://localhost:8081/SpringMVC/servlet/getAllDepartementsNamesByEntreprise/1
    @GetMapping(value = "getAllDepartementsNamesByEntreprise/{identreprise}")
    @ResponseBody
    public List<String> getAllDepartementsNamesByEntreprise(@PathVariable("identreprise") int entrepriseId) {
        return ientrepriseservice.getAllDepartementsNamesByEntreprise(entrepriseId);
    }

    // URL : http://localhost:8081/SpringMVC/servlet/deleteDepartementById/3
    @DeleteMapping("/deleteDepartementById/{iddept}")
    @ResponseBody
    public void deleteDepartementById(@PathVariable("iddept") int depId) {
        ientrepriseservice.deleteDepartementById(depId);

    }
}
