package siteMusifan;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Lieu;
import siteMusifan.services.LieuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class LieuServiceTest {

	@Autowired
	private LieuService lieuService;
	
	private Lieu getLieu() {
		Lieu lieu = new Lieu("AccorHotels Arena","8","Boulevard de Bercy","75012","Paris","France");
		return lieu;
	}
	
	private Lieu getLieu2(String nom,String numeroRue,String rue,String codePostal,String vill,String pays) {
		return new Lieu(nom, numeroRue, rue, codePostal, vill, pays);
	}
	
	@Test
	public void testSave() {
		Lieu lieu = getLieu();
		lieuService.save(lieu);
		assertNotNull(lieuService.byId(lieu.getId()));
	}

	@Test
	public void testDelete() {
		
	}

	@Test
	public void testAllLieu() {

	}

	@Test
	public void testById() {
		
	}

	@Test
	public void testByNomIgnoreCase() {
		
	}

	@Test
	public void testByNomLikeIgnoreCase() {
		
	}

	@Test
	public void testByNomContainingIgnoreCase() {
		
	}

	@Test
	public void testByVilleIgnoreCase() {
		
	}

	@Test
	public void testByVilleLikeIgnoreCase() {
		
	}

	@Test
	public void testByPaysContainingIgnoreCase() {
		
	}

	@Test
	public void testByPaysIgnoreCase() {
		
	}

	@Test
	public void testByPaysLikeIgnoreCase() {
		
	}

	@Test
	public void testByVilleContainingIgnoreCase() {
		
	}

}
