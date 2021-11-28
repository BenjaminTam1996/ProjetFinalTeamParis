package siteMusifan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Concert;
import siteMusifan.entity.Lieu;
import siteMusifan.exceptions.LieuException;
import siteMusifan.services.ConcertService;
import siteMusifan.services.LieuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class LieuServiceTest {

	@Autowired
	private LieuService lieuService;
	
	@Autowired
	private ConcertService concertService;
	
	private Lieu getLieu() {
		Lieu lieu = new Lieu("AccorHotels Arena","8","Boulevard de Bercy","75012","Paris","France");
		return lieu;
	}
	
	private Concert getConcert() {
		Concert concert = new Concert("Pardon My French",LocalDate.of(2022, Month.JULY, 21),10000,50);
		return concert; 
	}
	
	@Test
	public void testSave() {
		Lieu lieu = getLieu();
		lieuService.save(lieu);
		assertNotNull(lieuService.byId(lieu.getId()));
	}

	@Test(expected = LieuException.class)
	public void testDelete() {
		Lieu lieu = getLieu();
		lieuService.save(lieu);
		Concert concert = getConcert();
		concert.setLieu(lieu);
		concertService.save(concert);
		lieuService.delete(lieu);
		assertNull(lieuService.byId(lieu.getId()));
		assertEquals(concertService.byId(concert.getId()).getLieu(), null);
	}

	@Test
	public void testAllLieu() {
		Lieu lieu = getLieu();
		lieuService.save(lieu);
		assertNotNull(lieuService.allLieu());
		assertEquals(lieuService.allLieu().size(), 1);
	}

	@Test
	public void testById() {
		Lieu lieu = getLieu();
		lieuService.save(lieu);
		assertNotNull(lieuService.byId(lieu.getId()));
	}
	
	@Test(expected = LieuException.class)
	public void testByIdFail() {
		assertNull(lieuService.byId(999999999999999999L));
	}

	@Test
	public void testByNomIgnoreCase() {
		assertNotNull(lieuService.ByNomIgnoreCase("accorhotels Arena"));
	}

	@Test
	public void testByNomLikeIgnoreCase() {
		assertNotNull(lieuService.ByNomIgnoreCase("accor%"));
	}

	@Test
	public void testByNomContainingIgnoreCase() {
		assertNotNull(lieuService.ByNomIgnoreCase("arena"));
	}
	
	@Test
	public void testByNomIgnoreCaseFail() {
		assertEquals(lieuService.ByNomIgnoreCase("La villette"),new ArrayList<Lieu>());
	}

	@Test
	public void testByNomLikeIgnoreCaseFail() {
		assertEquals(lieuService.ByNomIgnoreCase("lav%"),new ArrayList<Lieu>());
	}

	@Test
	public void testByNomContainingIgnoreCaseFail() {
		assertEquals(lieuService.ByNomIgnoreCase("vilette"),new ArrayList<Lieu>());
	}

	@Test
	public void testByVilleIgnoreCase() {
		assertNotNull(lieuService.ByVilleIgnoreCase("paris"));
	}

	@Test
	public void testByVilleLikeIgnoreCase() {
		assertNotNull(lieuService.ByVilleIgnoreCase("pa%"));
	}

	@Test
	public void testByVilleContainingIgnoreCase() {
		assertNotNull(lieuService.ByVilleIgnoreCase("ris"));
	}
	
	@Test
	public void testByVilleIgnoreCaseFail() {
		assertEquals(lieuService.ByVilleIgnoreCase("marseille"),new ArrayList<Lieu>());
	}

	@Test
	public void testByVilleLikeIgnoreCaseFail() {
		assertEquals(lieuService.ByVilleIgnoreCase("lav%"),new ArrayList<Lieu>());
	}

	@Test
	public void testByVilleContainingIgnoreCaseFail() {
		assertEquals(lieuService.ByVilleIgnoreCase("vilette"),new ArrayList<Lieu>());
	}


	@Test
	public void testByPaysIgnoreCase() {
		assertNotNull(lieuService.ByPaysIgnoreCase("france"));
	}

	@Test
	public void testByPaysLikeIgnoreCase() {
		assertNotNull(lieuService.ByPaysIgnoreCase("fr%"));
	}

	@Test
	public void testByPaysContainingIgnoreCase() {
		assertNotNull(lieuService.ByPaysIgnoreCase("ran"));
	}
	
	@Test
	public void testByPaysIgnoreCaseFail() {
		assertEquals(lieuService.ByPaysIgnoreCase("marseille"),new ArrayList<Lieu>());
	}

	@Test
	public void testByPaysLikeIgnoreCaseFail() {
		assertEquals(lieuService.ByPaysIgnoreCase("lav%"),new ArrayList<Lieu>());
	}

	@Test
	public void testByPaysContainingIgnoreCaseFail() {
		assertEquals(lieuService.ByPaysIgnoreCase("vilette"),new ArrayList<Lieu>());
	}
}
