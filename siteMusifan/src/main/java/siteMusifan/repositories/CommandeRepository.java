package siteMusifan.repositories;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.entity.Commande;
import siteMusifan.entity.Utilisateur;


public interface CommandeRepository extends JpaRepository<Commande, Long> {

	@Transactional
	@Modifying
	@Query("update Commande c set c.utilisateur=null where c.utilisateur=:utilisateur")
	void removeUtilisateurFromCommandeByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
}
