package siteMusifan;

import static org.junit.Assert.assertFalse;
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
import siteMusifan.entity.Concert;
import siteMusifan.entity.Lieu;
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
		Artiste artiste = new Artiste("nomArtisteTest", "prenomArtisteTest");

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
	}

	@Test
	public void testById() {
		assertNotNull(artisteService.byId(100L));
	}

	@Test(expected = ArtisteException.class)
	public void testByIdFail() {
		assertNotNull(artisteService.byId(9999999999L));
	}

	@Test
	public void testByKeyWithAlbums() {
		///////// A mettre si besoin de reconstruire base de donnees avant mise en commun de
		///////// tous les tests !!!
//		Album album = new Album();
//		albumService.save(album);
//		Artiste artiste = getArtiste();
//		artiste.addAlbum(album);
//		artisteService.save(artiste);

		///////// A utiliser quand mise en commun de tous les tests !!!
//		Artiste artiste = getArtiste();
//		Album album = new Album();
//		album.addArtiste(artiste);
//		artisteService.save(artiste);
//		albumService.save(album);

		///////// A modifier quand mise en commun de tous les tests !!! mettre artiste.getId() au lieu de 182L !!!
		Artiste artisteEnBase = artisteService.byKeyWithAlbums(117L);
		assertNotNull(artisteEnBase);
//		assertSame(album.getLigneConcerts(), artisteEnBase.getLigneConcerts());

//		System.out.println("---------------------------");
//		System.out.println("ligneAlbum : " + artisteEnBase.getLignesAlbums());
//		artisteEnBase.getLignesAlbums().forEach( la -> {
//			System.out.println(la.getId().getAlbum().getId());
//		});
//		System.out.println("ligneAlbum : " + album.getLignesAlbums());
//		album.getLignesAlbums().forEach( la -> {
//			System.out.println(la.getId().getAlbum().getId());
//		});
		assertFalse(artisteEnBase.getLignesAlbums().isEmpty());
	}


	@Test
	@Transactional(propagation = Propagation.NEVER)
	public void testByKeyWithConcerts() {
		Lieu lieu = new Lieu("nomTest", "20", "rueTest", "00000", "villeTest", "paysTest");
		lieuService.save(lieu);
		Artiste artiste = getArtiste();
		Concert concert = new Concert("Pardon My French", LocalDate.of(2022, Month.JULY, 21), lieu, 10000, 50);
		concert.addArtiste(artiste);
		artisteService.save(artiste);
		concertService.save(concert);

		Artiste artisteEnBase = artisteService.byKeyWithConcerts(artiste.getId());
		assertNotNull(artisteEnBase);
//		System.out.println("ligneConcerts : " + concert.getLigneConcerts());
//		concert.getLigneConcerts().forEach( lc -> {
//			System.out.println(lc.getId().getConcert().getId() + " " + lc.getId().getArtiste().getId());
//		});
//		System.out.println("-----------------");
//		System.out.println("ligneConcerts : " + artisteEnBase.getLigneConcerts());
//		artisteEnBase.getLigneConcerts().forEach( lc -> {
//			System.out.println(lc.getId().getConcert().getId() + " " + lc.getId().getArtiste().getId());
//		});
//		assertSame(concert.getLigneConcerts(), artisteEnBase.getLigneConcerts());
		assertFalse(artisteEnBase.getLigneConcerts().isEmpty());
//		lieuService.delete(lieu);
//		artisteService.delete(artisteEnBase);
//		concertService.delete(concert);
		
	}

	@Test
	public void testByKeyWithPublications() {
//		Artiste artiste = getArtiste();
//		Publication publication  = new Publication("", artiste);
//		artiste.addPublication(publication);
//		artisteService.save(artiste);
//		publicationService.save(publication);
		
		//////Probleme lob lors de la remonte des publications
//		Artiste artiseEnBase = artisteService.byKeyWithPublications(artiste.getId());
////		assertSame(artiseEnBase.getPublications(), publication.getPublications());
//		assertFalse(artiseEnBase.getPublications().isEmpty());
		
	}

	@Test
	public void testByKeyWithAlbumsAndConcertsAndPublicationsAndUtilisateurs() {
		Lieu lieu = new Lieu("nomTestArtisteComplet", "20", "rueTestArtisteComplet", "00000", "villeTestArtisteComplet", "paysTestArtisteComplet");
		lieuService.save(lieu);
		Artiste artiste = getArtiste();
		Concert concert = new Concert("concertTestArtisteComplet", LocalDate.of(2022, Month.JULY, 21), lieu, 10000, 50);
		concert.addArtiste(artiste);
		Album album = new Album();
		artiste.addAlbum(album);
//		album.addArtiste(artiste);
		albumService.save(album);
		Publication publication  = new Publication("publication test artiste complet", artiste);
		artiste.addPublication(publication);
		artisteService.save(artiste);
		publicationService.save(publication);
		concertService.save(concert);
		
		//////Impossible a teste du au probleme lob lors de la remonte des publications
//		Artiste artisteEnBase = artisteService.byKeyWithArtisteComplet(artiste.getId());
//		assertFalse(artisteEnBase.getLigneConcerts().isEmpty() && artisteEnBase.getLignesAlbums().isEmpty() && artisteEnBase.getPublications().isEmpty());		
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
