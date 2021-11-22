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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Concert;
import siteMusifan.entity.Lieu;
import siteMusifan.entity.LigneConcert;
import siteMusifan.entity.LigneConcertPK;
import siteMusifan.exceptions.ConcertException;
import siteMusifan.services.ArtisteService;
import siteMusifan.services.ConcertService;
import siteMusifan.services.LieuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
//@Transactional
//@Rollback(true)
public class ConcertServiceTest {
	
	@Autowired
	private ConcertService concertService;
	
	@Autowired
	private LieuService lieuService;
	
	@Autowired
	private ArtisteService artisteService;
	
	
	private Concert getConcert() {
		Concert concert = new Concert("Pardon My French",LocalDate.of(2022, Month.JULY, 21),lieuService.byId(116L),10000,50);
		return concert;
	}

	@Test
	public void testSave() {
		Concert concert = getConcert();
//		LigneConcertPK lcpk = new LigneConcertPK(concert, artisteService.);
//		LigneConcert lc = new LigneConcert(lcpk);
		concertService.save(concert);
		assertNotNull(concertService.byId(concert.getId()));
	}

	@Test(expected = ConcertException.class)
	public void testDelete() {
		Concert concert = getConcert();
		concertService.save(concert);
		concertService.delete(concert);
		assertNull(concertService.byId(concert.getId()));
	}

	@Test
	public void testAllConcert() {
		assertNotNull(concertService.allConcert());
		assertEquals(concertService.allConcert().size(), 1);
	}

	@Test
	public void testAllByDate() {
		assertNotNull(concertService.allByDate(LocalDate.of(2022, Month.JULY, 21)));
		assertEquals(concertService.allByDate(LocalDate.of(2022, Month.JULY, 21)).size(), 1);
	}

	@Test
	public void testAllByLieu() {
		assertNotNull(concertService.allByLieu(lieuService.byId(116L)));
		assertEquals(concertService.allByLieu(lieuService.byId(116L)).size(), 1);
	}

	@Test
	public void testById() {
		assertNotNull(concertService.byId(101L));
	}
	
	@Test(expected = ConcertException.class)
	public void testByIdFail() {
		assertNull(concertService.byId(99999999L));
	}

	@Test
	public void testByNomIgnoreCase() {
		assertNotNull(concertService.ByNomIgnoreCase("pardon my french"));
	}

	@Test
	public void testByNomLikeIgnoreCase() {
		assertNotNull(concertService.ByNomLikeIgnoreCase("pardo%"));
	}

	@Test
	public void testByNomContainingIgnoreCase() {
		assertNotNull(concertService.ByNomContainingIgnoreCase("my"));
	}
	
	@Test
	public void testByNomIgnoreCaseFail() {
		assertEquals(concertService.ByNomIgnoreCase("solidays"),new ArrayList<Lieu>());
	}

	@Test
	public void testByNomLikeIgnoreCaseFail() {
		assertEquals(concertService.ByNomLikeIgnoreCase("soli%"),new ArrayList<Lieu>());
	}

	@Test
	public void testByNomContainingIgnoreCaseFail() {
		assertEquals(concertService.ByNomContainingIgnoreCase("days"),new ArrayList<Lieu>());
	}

}
