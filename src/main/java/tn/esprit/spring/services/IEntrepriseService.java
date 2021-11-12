package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Entreprise;

public interface IEntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public int deleteEntrepriseById(int entrepriseId);
	public void deleteDepartementById(int depId);
	public Entreprise getEntrepriseById(int entrepriseId);
}
