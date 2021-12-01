package musifan.musifan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import musifan.musifan.entity.Commande;
import musifan.musifan.entity.LigneCommande;
import musifan.musifan.entity.LigneCommandePK;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandePK> {
	@Transactional
	@Modifying
	@Query("delete from LigneCommande lc where lc.id.commande=:commande")
	void deleteByCommande(@Param("commande") Commande commande);

}
