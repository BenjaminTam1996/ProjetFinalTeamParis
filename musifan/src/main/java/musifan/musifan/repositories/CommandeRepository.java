package musifan.musifan.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import musifan.musifan.entity.Commande;
import musifan.musifan.entity.Utilisateur;


public interface CommandeRepository extends JpaRepository<Commande, Long> {

	@Transactional
	@Modifying
	@Query("update Commande c set c.utilisateur=null where c.utilisateur=:utilisateur")
	void removeUtilisateurFromCommandeByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
	
	Commande byKeyWithConcerts(@Param("numero") Long numero);
	
	List<Commande> allWithConcerts();
	
	@Modifying
	@Transactional
	@Query("delete from Commande c where c.utilisateur=:utilisateur")
	void deleteByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
}
