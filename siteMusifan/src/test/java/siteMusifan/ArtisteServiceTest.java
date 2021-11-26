package siteMusifan;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Album;
import siteMusifan.entity.Artiste;
import siteMusifan.entity.Concert;
import siteMusifan.entity.Lieu;
import siteMusifan.exceptions.ArtisteException;
import siteMusifan.services.AlbumService;
import siteMusifan.services.ArtisteService;
import siteMusifan.services.ConcertService;
import siteMusifan.services.LieuService;

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
	
	private Artiste getArtiste() {
		Artiste artiste = new Artiste("nomArtisteTest","prenomArtisteTest");

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
	public void testByKeyWithUtilisateur() {
		
	}

	@Test
	public void testByKeyWithAlbums() {
		Album album = new Album();
		albumService.save(album);
		Artiste artiste = getArtiste();
		artiste.addAlbum(album);
		artisteService.save(artiste);
		

		Artiste artisteEnBase = artisteService.byKeyWithAlbums(artiste.getId());
		assertNotNull(artisteEnBase);

//		assertSame(artiste.getLigneConcerts(), artisteEnBase.getLigneConcerts());
//		System.out.println("---------------------------");
//		System.out.println("ligneAlbum : " + artisteEnBase.getLignesAlbums());
//		artisteEnBase.getLignesAlbums().forEach( la -> {
//			System.out.println(la.getId().getAlbum().getId());
//		});
		assertFalse(artisteEnBase.getLignesAlbums().isEmpty());
	}

	@Test
	public void testByKeyWithConcerts() {
		Lieu lieu = new Lieu("nomTest", "20", "rueTest", "00000", "villeTest", "paysTest");
		lieuService.save(lieu);
		Concert concert = new Concert("Pardon My French",LocalDate.of(2022, Month.JULY, 21), lieu,10000,50);
		concertService.save(concert);
		Artiste artiste = getArtiste();
		artiste.addConcert(concert);
		artisteService.save(artiste);
		
		Artiste artisteEnBase = artisteService.byKeyWithConcerts(artiste.getId());
		assertNotNull(artisteEnBase);
//		System.out.println("ligneConcerts : " + artiste.getLigneConcerts());
//		artiste.getLigneConcerts().forEach( lc -> {
//			System.out.println(lc.getId().getConcert().getId() + " " + lc.getId().getArtiste().getId());
//		});
//		System.out.println("ligneConcerts : " + artisteEnBase.getLigneConcerts());
//		artisteEnBase.getLigneConcerts().forEach( lc -> {
//			System.out.println(lc.getId().getConcert().getId() + " " + lc.getId().getArtiste().getId());
//		});
//		assertSame(artiste.getLigneConcerts(), artisteEnBase.getLigneConcerts());
		assertFalse(artisteEnBase.getLigneConcerts().isEmpty());

	}

	@Test
	public void testByKeyWithPublications() {
	
	}


	@Test
	public void testByKeyWithAlbumsAndConcertsAndPublicationsAndUtilisateurs() {
		
	}

	@Test
	public void testByNomArtisteContainingIgnoreCase() {
		
	}
	
	@Test
	public void testByNomArtisteContainingIgnoreCaseFail() {
		
	}
	
}
