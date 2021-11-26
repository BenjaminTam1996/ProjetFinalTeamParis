package siteMusifan;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Artiste;
import siteMusifan.entity.Commande;
import siteMusifan.entity.Concert;
import siteMusifan.entity.Utilisateur;
import siteMusifan.exceptions.UtilisateurException;
import siteMusifan.services.ArtisteService;
import siteMusifan.services.CommandeService;
import siteMusifan.services.ConcertService;
import siteMusifan.services.UtilisateurService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class UtilisateurServiceTest {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private ArtisteService artisteService;
	
	@Autowired
	private ConcertService concertService;
	
	@Autowired
	private CommandeService commandeService;
	
	private Utilisateur getUtilisateur() {
		Utilisateur utilisateur = new Utilisateur("nomTest","prenomTest");

		return utilisateur;
	}
	
	private Utilisateur getUtilisateurWithArtiste() {
		Artiste artiste = new Artiste("artisteTest", "test");
		artisteService.save(artiste);
		Utilisateur utilisateur = getUtilisateur();
		utilisateur.addArtiste(artiste);
		return utilisateur;
	}
	
	@Test
	public void testCreation() {
		Utilisateur utilisateur = getUtilisateur();
		utilisateurService.save(utilisateur);
		assertNotNull(utilisateurService.byId(utilisateur.getId()));
	}
	
	@Test(expected=UtilisateurException.class)
	public void testDelete() {
		Utilisateur utilisateur = getUtilisateur();
		utilisateurService.save(utilisateur);
		utilisateurService.delete(utilisateur);
		assertNull(utilisateurService.byId(utilisateur.getId()));
	}

	@Test
	public void testById() {
		assertNotNull(utilisateurService.byId(100L));
	}

	@Test(expected = UtilisateurException.class)
	public void testByIdFail() {
		assertNotNull(utilisateurService.byId(99999999999999L));
	}

	
	@Test
	public void testByKeyWithArtistes() {
		Utilisateur utilisateur = getUtilisateurWithArtiste();
		utilisateurService.save(utilisateur);
		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithArtistes(utilisateur.getId());
		assertNotNull(utilisateurEnBase);
		assertSame( utilisateur.getLignesUtilisateurs(), utilisateurEnBase.getLignesUtilisateurs());
		assertFalse(utilisateurEnBase.getLignesUtilisateurs().isEmpty());
	}

	
	
	@Test
	public void testByKeyWithArtistesFail() {
		Utilisateur utilisateur = getUtilisateur();
		utilisateurService.save(utilisateur);
		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithArtistes(utilisateur.getId());
		assertTrue(utilisateurEnBase.getLignesUtilisateurs().isEmpty());
	}
	
	@Test
	public void testByKeyWithCommandes() {
		Utilisateur utilisateur = getUtilisateur();
		Commande commande = new Commande(utilisateur);
		Concert concert = new Concert();
		concertService.save(concert);
		commande.addProduit(concert, 2);
		utilisateur.addCommande(commande);
		utilisateurService.save(utilisateur);
		commandeService.save(commande);

		
		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithCommandes(utilisateur.getId());
//		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithCommandes(100L);
		assertFalse(utilisateurEnBase.getListeConcert().isEmpty());
		assertSame(utilisateur.getListeConcert(), utilisateurEnBase.getListeConcert());
	}
	
	@Test
	public void testByKeyWithCommandesFail() {
		Utilisateur utilisateur = getUtilisateur();
		utilisateurService.save(utilisateur);
		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithCommandes(utilisateur.getId());
		assertTrue(utilisateurEnBase.getListeConcert().isEmpty());
	}
	
	@Test
	public void testByKeyWithCommandesAndArtistes() {
		Utilisateur utilisateur = getUtilisateur();
		Commande commande = new Commande(utilisateur);
		Artiste artiste = new Artiste("artisteAvecUnNom", "artisteAvecUnPrenom");
		artisteService.save(artiste);
		utilisateur.addCommande(commande);
		utilisateur.addArtiste(artiste);
		utilisateurService.save(utilisateur);
		commandeService.save(commande);

		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithCommandesAndArtistes(utilisateur.getId());
//		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithCommandesAndArtistes(100L);
		assertFalse(utilisateurEnBase.getLignesUtilisateurs().isEmpty() && utilisateurEnBase.getListeConcert().isEmpty());		
	}

	@Test
	public void testByKeyWithCommandesAndArtistesFail() {
		Utilisateur utilisateur = getUtilisateur();
		utilisateurService.save(utilisateur);
		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithCommandesAndArtistes(utilisateur.getId());
		assertTrue(utilisateurEnBase.getListeConcert().isEmpty() && utilisateurEnBase.getLignesUtilisateurs().isEmpty());
	}
}
