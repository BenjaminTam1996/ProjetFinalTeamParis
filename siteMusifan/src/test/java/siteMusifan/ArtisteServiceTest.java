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
import siteMusifan.entity.Artiste;
import siteMusifan.services.ArtisteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class ArtisteServiceTest {

	@Autowired
	private ArtisteService artisteService;
	
	private Artiste getArtiste() {
		Artiste artiste = new Artiste("nomArtisteTest","prenomArtisteTest");

		return artiste;
	}
	
	
	@Test
	public void testSave() {
		Artiste artiste = getArtiste();
		artisteService.save(artiste);
		System.out.println("testCreation");
		assertNotNull(artisteService.byId(artiste.getId()));
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
	public void testByKeyWithUtilisateur() {
		fail("Not yet implemented");
	}

	@Test
	public void testByKeyWithAlbums() {
		fail("Not yet implemented");
	}

	@Test
	public void testByKeyWithConcerts() {
		fail("Not yet implemented");
	}

	@Test
	public void testByKeyWithPublications() {
		fail("Not yet implemented");
	}

	@Test
	public void testByNomArtisteContainingIgnoreCase() {
		fail("Not yet implemented");
	}

}
