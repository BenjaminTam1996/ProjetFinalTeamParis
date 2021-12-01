package siteMusifan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Album;
import siteMusifan.entity.Artiste;
import siteMusifan.entity.Chansons;
import siteMusifan.entity.Concert;
import siteMusifan.entity.Lieu;
import siteMusifan.entity.LigneAlbum;
import siteMusifan.entity.LigneAlbumPK;
import siteMusifan.entity.Publication;
import siteMusifan.exceptions.ArtisteException;
import siteMusifan.services.AlbumService;
import siteMusifan.services.ArtisteService;
import siteMusifan.services.ConcertService;
import siteMusifan.services.LieuService;
import siteMusifan.services.PublicationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class ArtisteServiceTest {

	@Autowired
	private ArtisteService artisteService;

	@Autowired
	private ConcertService concertService;

	@Autowired
	private LieuService lieuService;

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private PublicationService publicationService;

	private Artiste getArtiste() {
		Album album = new Album("After Hours",LocalDate.of(2020, Month.MARCH, 20));
		Artiste artiste = new Artiste("The Weeknd");
		artisteService.save(artiste);
		album.addArtiste(artiste);
		album.addChansons(new Chansons("Alone Again","4:10",album));
		album.addChansons(new Chansons("Too Late","3:59",album));
		artiste.addAlbum(album);
		albumService.save(album);
		Publication publication = new Publication("publication test", artiste);
		artiste.addPublication(publication);
		artisteService.save(artiste);
		publicationService.save(publication);
		Lieu lieu = new Lieu("nomTest", "20", "rueTest", "00000", "villeTest", "paysTest");
		lieuService.save(lieu);
		Concert concert = new Concert("Pardon My French", LocalDate.of(2022, Month.JULY, 21), lieu, 10000, 50);
		artiste.addConcert(concert);
		concert.addArtiste(artiste);
		concertService.save(concert);
		return artiste; 
	}

	@Test
	public void testSave() {
		Artiste artiste = getArtiste();
		artisteService.save(artiste);
		assertNotNull(artisteService.byId(artiste.getId()));
	}

	@Test(expected = ArtisteException.class)
	public void testDelete() {
		Artiste artiste = getArtiste();
		artisteService.save(artiste);
		artisteService.delete(artiste);
		assertNull(artisteService.byId(artiste.getId()));
//		assertEquals(albumService.byTitreLikeIgnoreCase("After Hours"), null);
//		assertEquals(publicationService.allPublication().size(), 0);
//		assertEquals(concertService.allConcert().size(), 0);
	}

	@Test
	public void testById() {
		Artiste artiste = getArtiste();
		artisteService.save(artiste);
		assertNotNull(artisteService.byId(artiste.getId()));
	}

	@Test(expected = ArtisteException.class)
	public void testByIdFail() {
		assertNotNull(artisteService.byId(9999999999L));
	}

	@Test
	public void testByKeyWithAlbums() {


		Artiste artiste = getArtiste();
		artisteService.save(artiste);

		Artiste artisteEnBase = artisteService.byKeyWithAlbums(artiste.getId());
		assertNotNull(artisteEnBase);
		assertNotEquals(artisteEnBase.getLignesAlbums().size(), 0);
	}


	@Test
	public void testByKeyWithConcerts() {
		Artiste artiste = getArtiste();
		artisteService.save(artiste);

		Artiste artisteEnBase = artisteService.byKeyWithConcerts(artiste.getId());
		assertNotNull(artisteEnBase);

		assertFalse(artisteEnBase.getLigneConcerts().isEmpty());

		
	}

	@Test
	public void testByKeyWithPublications() {
		Artiste artiste = getArtiste();
		artisteService.save(artiste);
		
		Artiste artiseEnBase = artisteService.byKeyWithPublications(artiste.getId());
		assertFalse(artiseEnBase.getPublications().isEmpty());
		
	}

	@Test
	public void testByKeyWithAlbumsAndConcertsAndPublicationsAndUtilisateurs() {

		Artiste artiste = getArtiste();
		artisteService.save(artiste);
		
		Artiste artisteEnBase = artisteService.byKeyWithArtisteComplet(artiste.getId());
		assertFalse(artisteEnBase.getLigneConcerts().isEmpty() && artisteEnBase.getLignesAlbums().isEmpty() && artisteEnBase.getPublications().isEmpty());		
	}

	@Test
	public void testByNomArtisteContainingIgnoreCase() {
		Artiste artiste1 = new Artiste("Steave");
		artisteService.save(artiste1);
		Artiste artiste2 = new Artiste("Stone");
		artisteService.save(artiste2);
		assertNotNull(artisteService.byNomArtisteContainingIgnoreCase("st"));
	}

	@Test
	public void testByNomArtisteContainingIgnoreCaseFail() {
		assertTrue(artisteService.byNomArtisteContainingIgnoreCase("xw").isEmpty());
	}

	@Test
	public void testByNomArtisteIgnoreCase() {
		Artiste artiste1 = new Artiste("Steave");
		artisteService.save(artiste1);
		assertNotNull(artisteService.byNomArtisteIgnoreCase("steave"));
	}

	@Test
	public void testByNomArtisteIgnoreCaseFail() {
		assertTrue(artisteService.byNomArtisteIgnoreCase("wx").isEmpty());
	}

	@Test
	public void testByNomArtisteLikeIgnoreCase() {
		Artiste artiste1 = new Artiste("Steave");
		artisteService.save(artiste1);
		Artiste artiste2 = new Artiste("Stone");
		artisteService.save(artiste2);
		assertNotNull(artisteService.byNomArtisteLikeIgnoreCase("st%"));
	}

	@Test
	public void testByNomArtisteLikeIgnoreCaseFail() {
		assertTrue(artisteService.byNomArtisteLikeIgnoreCase("wx").isEmpty());
	}
	
}
