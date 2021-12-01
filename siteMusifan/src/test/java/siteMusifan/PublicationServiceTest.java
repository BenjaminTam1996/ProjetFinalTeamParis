package siteMusifan;

import siteMusifan.config.AppConfig;
import siteMusifan.entity.Artiste;
import siteMusifan.entity.Publication;
import siteMusifan.entity.Utilisateur;
import siteMusifan.exceptions.PublicationException;
import siteMusifan.exceptions.UtilisateurException;
import siteMusifan.services.ArtisteService;
import siteMusifan.services.PublicationService;


import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
@Rollback(true)
public class PublicationServiceTest {
	
	@Autowired
	private PublicationService publicationService;
	
	@Autowired
	private ArtisteService artisteService;

	private Publication getPublication() {
		Artiste artiste = new Artiste("artisteTest", "test");
		artisteService.save(artiste);
		Publication publi = new Publication("ma publi",artiste);
		return publi;
	}
	
	@Test
	public void testSave() {
		Publication publication = getPublication();
		publicationService.save(publication);
		assertNotNull(publicationService.byId(publication.getId()));
	}
	
	@Test
	public void testById() {
		Publication publication = getPublication();
		publicationService.save(publication);
		assertNotNull(publicationService.byId(107L));
	}

	@Test(expected=PublicationException.class)
	public void testDelete() {
		Publication publication = getPublication();
		publicationService.save(publication);
		//System.out.println(publicationService.byId(publication.getId()));
		publicationService.delete(publication);
		//System.out.println(publicationService.byId(publication.getId()));
		assertNull(publicationService.byId(publication.getId()));
	}

	@Test
	public void testAllPublication() {
		assertNotNull(publicationService.allPublication());
	}
	
//	@Test
//	public void testByArtiste() {
//		Publication publication = getPublication();
//		publicationService.save(publication);
//		System.out.println("-------------");
//		System.out.println(publication.getArtiste());
//		System.out.println(publicationService.byArtiste(publication.getArtiste()));
//		assertNotNull(publicationService.byArtiste(publication.getArtiste()));
//	}
}
