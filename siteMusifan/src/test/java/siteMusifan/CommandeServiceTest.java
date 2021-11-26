package siteMusifan;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Commande;
import siteMusifan.entity.Utilisateur;
import siteMusifan.exceptions.CommandeException;
import siteMusifan.services.CommandeService;
import siteMusifan.services.UtilisateurService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class CommandeServiceTest {
	
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private UtilisateurService utilisateurService;

	private Commande getCommande() {
		Utilisateur user=new Utilisateur("Moindrot", "berenice");
		utilisateurService.save(user);
		Commande commande = new Commande(user);
		return commande;
	}

	@Test
	public void testSave() {
		Commande commande = getCommande();
		commandeService.save(commande);
		assertNotNull(commandeService.byId(commande.getNumero()));
		Commande commandeEnBase = commandeService.byId(commande.getNumero());
		assertSame( commande.getLignesCommandes(), commandeEnBase.getLignesCommandes());

	}
	

//	@Test(expected = CommandeException.class)
//	public void testDelete() {
//		Commande commande = getCommande();
//		commandeService.save(commande);
//		commandeService.delete(commande);
//		assertNull(commandeService.byId(commande.getNumero()));
//	}

	@Test
	public void testAllCommande() {
		assertNotNull(commandeService.allCommande());
		assertEquals(commandeService.allCommande().size(), 3);
	}

	@Test
	public void testAllWithConcerts() {
		//fail("Not yet implemented");
	}

	@Test
	public void testByKeyWithConcerts() {
		//fail("Not yet implemented");
	}

}
