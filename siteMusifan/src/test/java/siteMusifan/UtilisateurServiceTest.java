package siteMusifan;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Utilisateur;
import siteMusifan.services.UtilisateurService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class UtilisateurServiceTest {

	@Autowired
	private UtilisateurService utilisateurService;
	
	private Utilisateur getUtilisateur() {
		Utilisateur utilisateur = new Utilisateur("nomTest","prenomTest");

		return utilisateur;
	}
	
	@Test
	public void testSave() {
		Utilisateur utilisateur = getUtilisateur();
		System.out.println(utilisateur.getNom() + utilisateur.getPrenom());
		utilisateurService.save(utilisateur);
		assertNotNull(utilisateurService.byId(utilisateur.getId()));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testById() {
		fail("Not yet implemented");
	}

	@Test
	public void testByKeyWithArtistes() {
		fail("Not yet implemented");
	}

	@Test
	public void testByKeyWithCommandes() {
		fail("Not yet implemented");
	}

}
