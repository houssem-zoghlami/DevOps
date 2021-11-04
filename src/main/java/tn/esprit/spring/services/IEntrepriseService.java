package tn.esprit.spring.services;
import tn.esprit.spring.entity.Departement;

import java.util.List;

public interface IEntrepriseService {
    public int ajouterDepartement(Departement dep);
    void affecterDepartementAEntreprise(int depId, int entrepriseId);
    List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
    public void deleteDepartementById(int depId);
}
