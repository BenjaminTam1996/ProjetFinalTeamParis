package siteMusifan;

import static org.junit.Assert.assertEquals;
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
import siteMusifan.entity.Chansons;
import siteMusifan.exceptions.AlbumException;
import siteMusifan.services.AlbumService;
import siteMusifan.services.ArtisteService;
import siteMusifan.services.ChansonsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class AlbumServiceTest {

	@Autowired
	private ChansonsService chansonsService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ArtisteService artisteService;
	
	//Méthodes réation album
	//-------------------------------------------------------------------------------------------------------
	private Album getAlbum1() {
		Album album = new Album("After Hours",LocalDate.of(2020, Month.MARCH, 20));
		Artiste artiste = new Artiste("The Weeknd");
		artisteService.save(artiste);
		album.addArtiste(artiste);
		album.addChansons(new Chansons("Alone Again","4:10",album));
		album.addChansons(new Chansons("Too Late","3:59",album));
		return album;
	}
	
	private Album getAlbum2() {
		Album album = new Album("Presence",LocalDate.of(2017, Month.NOVEMBER, 10));
		album.addChansons(new Chansons("Creation Comes Alive","3:18",album));
		album.addChansons(new Chansons("Follow Me","4:41",album));
		return album;
	}
	
	
	//Test save et delete
	//-------------------------------------------------------------------------------------------------------
	@Test
	public void testSaveAlbumAndChanson() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(albumService.byIdWithChansons(album.getId()));
		assertNotNull(chansonsService.allChansons());
	}

	@Test(expected = AlbumException.class)
	public void testDeleteAlbum() {
		Album album = getAlbum1();
		albumService.save(album);
		albumService.delete(album);
		assertNull(albumService.byIdWithChansons(album.getId()));
		assertEquals(chansonsService.allChansons().size(), 0);
	}

	//Test recherche all
	//-------------------------------------------------------------------------------------------------------
	@Test
	public void testAllAlbum() {
		Album album = getAlbum1();
		albumService.save(album);
		album = getAlbum2();
		albumService.save(album);
		assertEquals(albumService.allAlbum().size(), 2);
	}

	@Test
	public void testByIdWithChansons() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(albumService.byIdWithChansons(album.getId()));
	}

	@Test
	public void testByIdWithArtistes() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(albumService.byIdWithArtistes(album.getId()));
	}

	@Test
	public void testByIdWithChansonsAndArtistes() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(albumService.byIdWithChansonsAndArtistes(album.getId()));
	}

	@Test
	public void testAllChansons() {
		Album album = getAlbum1();
		albumService.save(album);
		assertEquals(chansonsService.allChansons().size(), 2);
	}

	//Test des pages
	//-------------------------------------------------------------------------------------------------------
	@Test
	public void testAlbumFirstPage() {
	}

	@Test
	public void testAlbumNextPage() {
	}

	@Test
	public void testAlbumPreviousPage() {
	}
	
	@Test
	public void testChansonsFirstPage() {
	}

	@Test
	public void testChansonsNextPage() {
	}

	@Test
	public void testChansonsPreviousPage() {
	}
	
	//Test recherche par titre
	//-------------------------------------------------------------------------------------------------------
	@Test
	public void testAlbumByTitreIgnoreCase() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(albumService.byTitreIgnoreCase("after Hours"));
	}
	
	@Test
	public void testAlbumByTitreLikeIgnoreCase() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(albumService.byTitreLikeIgnoreCase("aft%"));
	}
	
	@Test
	public void testAlbumByTitreContainingIgnoreCase() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(albumService.byTitreContainingIgnoreCase("Hour"));
	}
	
	@Test
	public void testChansonsByTitreIgnoreCase() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(chansonsService.byTitreIgnoreCase("Alone Again"));
	}
	
	@Test
	public void testChansonsByTitreLikeIgnoreCase() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(chansonsService.byTitreLikeIgnoreCase("Alon%"));
	}
	
	@Test
	public void testChansonsByTitreContainingIgnoreCase() {
		Album album = getAlbum1();
		albumService.save(album);
		assertNotNull(chansonsService.byTitreContainingIgnoreCase("Agai"));
	}
}
