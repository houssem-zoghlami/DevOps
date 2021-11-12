package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entity.Entreprise;

public interface IEntrepriseService {
	
	public int ajouterEntreprise(Entreprise entreprise);

	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);

	public Entreprise getEntrepriseById(int entrepriseId);
}
