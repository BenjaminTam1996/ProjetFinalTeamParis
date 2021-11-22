package siteMusifan.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import commandesJPA.entity.Produit;
import commandesJPA.exceptions.ProduitException;
import siteMusifan.entity.Lieu;
import siteMusifan.repositories.LieuRepository;

public class LieuService {
	@Autowired
	private LieuRepository lieuRepository;
	
	@Autowired
	private Validator validator;
	
	
	public void save(Lieu lieu) {
		Set<ConstraintViolation<Lieu>> violations = validator.validate(lieu);
		if(violations.isEmpty()) {
			lieuRepository.save(lieu);
		}else {
			throw new LieuException();
		}	
	}	
	
	public void delete(Produit produit) {
		produit = byId(produit.getId());	//On va cherche le produit en base de donnée
		Produit produitEnBase=produitRepository.findById(produit.getId()).orElseThrow(ProduitException::new);
		lignecommandeRepository.deleteByProduit(produitEnBase);
		produitRepository.delete(produitEnBase);
	}
	
	public List<Produit> allProduit(){
		return produitRepository.findAll();
	}
	
	public Produit byId(Long id) {
		return produitRepository.findById(id).orElseThrow(ProduitException::new);
	}
	
	public List<Produit> byName(String nom) {
		return produitRepository.findByName(nom);
	}
}
