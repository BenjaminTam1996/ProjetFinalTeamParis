package siteMusifan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import siteMusifan.entity.Commande;
import siteMusifan.entity.LigneCommande;
import siteMusifan.entity.LigneCommandePK;


public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandePK> {

	@Query("delete from LigneCommande lc where lc.id.commande=:commande")
	void deleteByCommande(@Param("commande") Commande commande);

}
