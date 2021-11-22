package siteMusifan;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Artiste;
import siteMusifan.entity.Utilisateur;
import siteMusifan.exceptions.UtilisateurException;
import siteMusifan.services.ArtisteService;
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
	
	@Test
	public void testUpdate() {
		Utilisateur utilisateur = getUtilisateurWithArtiste();
		utilisateurService.save(utilisateur);
		assertNotNull(utilisateurService.byId(utilisateur.getId()).getLignesUtilisateurs());
		Utilisateur utilisateurEnBase = utilisateurService.byId(utilisateur.getId());
		assertSame( utilisateur.getLignesUtilisateurs(), utilisateurEnBase.getLignesUtilisateurs());
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
		assertNotNull(utilisateurService.byKeyWithArtistes(utilisateur.getId()));
		Utilisateur utilisateurEnBase = utilisateurService.byKeyWithArtistes(utilisateur.getId());
		assertSame( utilisateur.getLignesUtilisateurs(), utilisateurEnBase.getLignesUtilisateurs());
	}

	@Test
	public void testByKeyWithCommandes() {
		
	}
	
	@Test
	public void testByKeyWithCommandesAndArtistes() {
		
	}

}
