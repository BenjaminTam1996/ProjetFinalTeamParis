package siteMusifan;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Utilisateur;
import siteMusifan.exceptions.UtilisateurException;
import siteMusifan.services.UtilisateurService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
//@Transactional
//@Rollback(true)
public class UtilisateurServiceTest {

	@Autowired
	private UtilisateurService utilisateurService;
	
	private Utilisateur getUtilisateur() {
		Utilisateur utilisateur = new Utilisateur("nomTest","prenomTest");

		return utilisateur;
	}
	
	@Test
	public void testCreation() {
		Utilisateur utilisateur = getUtilisateur();
		utilisateurService.save(utilisateur);
		assertNotNull(utilisateurService.byId(utilisateur.getId()));
	}
	
//	@Test
//	public void testUpdate() {
//		Utilisateur utilisateur = getUtilisateur();
//		utilisateur.getLignesUtilisateurs().add(null);
//		utilisateurService.save(utilisateur);
//		assertNotNull(utilisateurService.byId(utilisateur.getId()));
//	}

	@Test(expected=UtilisateurException.class)
	public void testDelete() {
		Utilisateur utilisateur = getUtilisateur();
		utilisateurService.save(utilisateur);
		utilisateurService.delete(utilisateur);
		assertNull(utilisateurService.byId(utilisateur.getId()));
	}

	@Test
	public void testById() {
		assertNotNull(utilisateurService.byId(104L));
	}

	@Test(expected = UtilisateurException.class)
	public void testByIdFail() {
		assertNotNull(utilisateurService.byId(99999999999999L));
	}

	
	@Test
	public void testByKeyWithArtistes() {

	}

	@Test
	public void testByKeyWithCommandes() {
		
	}
	
	@Test
	public void testByKeyWithCommandesAndArtistes() {
		
	}

}
