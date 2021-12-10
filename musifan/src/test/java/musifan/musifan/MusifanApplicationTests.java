package musifan.musifan;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import musifan.musifan.entity.Album;
import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.Chansons;
import musifan.musifan.entity.Commande;
import musifan.musifan.entity.Concert;
import musifan.musifan.entity.Lieu;
import musifan.musifan.entity.Publication;
import musifan.musifan.entity.Utilisateur;
import musifan.musifan.repositories.ChansonsRepository;
import musifan.musifan.services.AlbumService;
import musifan.musifan.services.ArtisteService;
import musifan.musifan.services.CommandeService;
import musifan.musifan.services.ConcertService;
import musifan.musifan.services.LieuService;
import musifan.musifan.services.PublicationService;
import musifan.musifan.services.UtilisateurService;

@SpringBootTest
class MusifanApplicationTests {

	@Autowired
	private LieuService lieuService;
	
	@Autowired
	private ConcertService concertService;

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private ArtisteService artisteService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private PublicationService publicationService;
	
	@Autowired
	private CommandeService commandeService;
	
	@Autowired
	private ChansonsRepository chansonRepository;
	
	@Test
	void contextLoads() {
		
		////Creation artiste + albums
		//The Weeknd
		//------------------------------------------------------------------------------------------------------------------------------------------
		Artiste theWeeknd = new Artiste("week@mail.com", "theWeeknd3.0", null, null, null, null, "The Weeknd", null, null);
		artisteService.save(theWeeknd);
		Album album = new Album("After Hours",LocalDate.of(2020, Month.MARCH, 20));
		album.addArtiste(theWeeknd);
		albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		System.out.println("-----------------");
		System.out.println("album : " + album.getTitre());
		System.out.println("dto : "+ albumService.byIdWithChansons(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album).getId()).getTitre());
		System.out.println("-----------------");
		List<Chansons> chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Alone Again","4:10",album));
		chansons.add(new Chansons("Too Late","3:59",album));
		chansons.add(new Chansons("Hardest to Love","3:31",album));
		chansons.add(new Chansons("Scared to Live","3:11",album));
		chansons.add(new Chansons("Snowchild","4:07",album));
		chansons.add(new Chansons("Escape from LA","5:55",album));
		chansons.add(new Chansons("Heartless","3:18",album));
		chansons.add(new Chansons("Faith","4:43",album));
		chansons.add(new Chansons("Blinding Lights","3:20",album));
		chansons.add(new Chansons("In Your Eyes","3:57",album));
		chansons.add(new Chansons("Save Your Tears","3:35",album));
		chansons.add(new Chansons("Repeat After Me","3:15",album));
		chansons.add(new Chansons("Faith","4:43",album));
		chansons.add(new Chansons("After Hours","6:01",album));
		chansons.add(new Chansons("Until I Bleed Out","3:10",album));
		chansonRepository.saveAll(chansons);
		
		
		Publication publication = new Publication("Mon tout nouveau album ", theWeeknd);
		theWeeknd.addPublication(publication);
		Publication publication2 = new Publication("Petite apparition surprise chez mon ami John", theWeeknd);
		theWeeknd.addPublication(publication2);
		artisteService.save(theWeeknd);
		publicationService.save(publication);
		publicationService.save(publication2);

		
		//Kygo
		//------------------------------------------------------------------------------------------------------------------------------------------
		Artiste kygo = new Artiste("kygo@gmail.fr", "Kygo", null, null, null, null, "Kygo", null, null);
		artisteService.save(kygo);
		album = new Album("Cloud Nine",LocalDate.of(2016, Month.MAY, 13));
		album.addArtiste(kygo);
		albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Intro","2:08",album));
		chansons.add(new Chansons("Stole The Show","3:42",album));
		chansons.add(new Chansons("Fiction","4:03",album));
		chansons.add(new Chansons("Raging","3:44",album));
		chansons.add(new Chansons("Firestone","4:33",album));
		chansons.add(new Chansons("Happy Birthday","4:10",album));
		chansons.add(new Chansons("I'm In Love","3:32",album));
		chansons.add(new Chansons("Oasis ","3:25",album));
		chansons.add(new Chansons("Not Alone","3:25",album));
		chansons.add(new Chansons("Serious","3:54",album));
		chansons.add(new Chansons("Stay","3:59",album));
		chansons.add(new Chansons("Nothing Left","3:56",album));
		chansons.add(new Chansons("Fragile","3:50",album));
		chansons.add(new Chansons("Carry Me","3:53",album));
		chansons.add(new Chansons("For What It's Worth","3:03",album));
		chansonRepository.saveAll(chansons);
		
		//DJ Snake + Bipolar Sunshine
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste snake = new Artiste("Snake.dj@hotmail.com", "DJsnake", null, null, null, null, "DJ Snake", null, null);
		artisteService.save(snake);
		album = new Album("Middle",LocalDate.of(2015, Month.OCTOBER, 16));
		album.addArtiste(snake);
		Artiste sunshine = new Artiste("Bipo.Sun@yahoo.com", "BiPoSun", null, null, null, null, "Bipolar Sunshine", null, null);
		artisteService.save(sunshine);
		album.addArtiste(sunshine);
		albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Middle","3:40",album));
		chansonRepository.saveAll(chansons);
		
		//Tchami + Malaa
		//------------------------------------------------------------------------------------------------------------------------------------------		
		album = new Album("Made In France",LocalDate.of(2019, Month.JULY, 26));
		album.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("DJ Snake").get(0));
		Artiste tchami = new Artiste("tchami@hotmail.fr", "Tchami", null, null, null, null, "Tchami", null, null);
		artisteService.save(tchami);
		album.addArtiste(tchami);
		Artiste malaa = new Artiste("malaa@yahoo.com", "Malaa", null, null, null, null, "Malaa", null, null);
		artisteService.save(malaa);
		album.addArtiste(malaa);
		albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Made In France","4:11",album));
		chansonRepository.saveAll(chansons);
		
		// Petit Biscuit
		//------------------------------------------------------------------------------------------------------------------------------------------		
		album = new Album("Presence",LocalDate.of(2017, Month.NOVEMBER, 10));
		Artiste petitBiscuit = new Artiste("Petit.Biscuit@monMail.com", "MonBiscuit", null, null, null, null, "Petit Biscuit", null, null);
		artisteService.save(petitBiscuit);
		albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		album.addArtiste(petitBiscuit);
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Creation Comes Alive","3:18",album));
		chansons.add(new Chansons("Follow Me","4:41",album));
		chansonRepository.saveAll(chansons);
		
		// Petit Biscuit
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste sheeran = new Artiste("sheeran@mail.com", "sheeran", "Sheeran", "Edward Christopher", "06 20 84 99 24", null, "Ed Sheeran", "auteur-compositeur-interprete et guitariste", null);
		artisteService.save(sheeran);
		album = new Album("Divide", LocalDate.of(2017, Month.MARCH, 3));
		album.addArtiste(sheeran);
		albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Perfect", "4:39", album));
		chansons.add(new Chansons("Shape of You", "3:53", album));
		chansons.add(new Chansons("Happier", "4:21", album));
		chansons.add(new Chansons("Castle on the Hill", "3:39", album));
		chansonRepository.saveAll(chansons);
		
		
		publication = new Publication("Sortie de mon prochaine album prevue prochainement", sheeran);
		sheeran.addPublication(publication);
		publicationService.save(publication);
		
		
		////Création lieu + concert
		//------------------------------------------------------------------------------------------------------------------------------------------
		Lieu lieu = new Lieu("AccorHotels Arena","8","Boulevard de Bercy","75012","Paris","France");
		lieuService.save(lieu);
		Concert concert = new Concert("Pardon My French",LocalDate.of(2022, Month.JUNE, 21),lieu,10000,50);
		concert.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("DJ Snake").get(0));
		concert.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("Tchami").get(0));
		concert.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("Malaa").get(0));
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		concert = new Concert("Kygo French Tour",LocalDate.of(2022, Month.MAY, 10),lieu,6000,45);
		concert.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("Kygo").get(0));
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		Concert afterHours = new Concert("The After Hours Tour", LocalDate.of(2022, Month.JULY, 21), lieu, 10000, 50);
		afterHours.addArtiste(theWeeknd);
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(afterHours));


		lieu =new Lieu("La Cigale","120","Boulevard de Rochechouart","75018","Paris","France");
		lieuService.save(lieu);
		Concert problems = new Concert("Problems by Petit Biscuit",LocalDate.of(2022, Month.MARCH, 16),lieu,2000,30);
		problems.addArtiste(petitBiscuit);
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(problems));

		
		lieu =new Lieu("L'Olympia","28","Boulevard des Capucine","75009","Paris","France");
		lieuService.save(lieu);
		concert = new Concert("Toca by Timmy Trumpet",LocalDate.of(2022, Month.APRIL, 07),lieu,2200,45);
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		
		lieu =new Lieu("Le Zénith","211","Boulevard Jean-Jaurès Parc de La Villette","75019","Paris","France");
		lieuService.save(lieu);
		concert = new Concert("Thanks God",LocalDate.of(2022, Month.SEPTEMBER, 04),lieu,1500,30);
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		
		lieu =new Lieu("La Défense Arena","8","Rue des Sorins","92000","Nanterre","France");
		lieuService.save(lieu);
		Concert edSheeranTour = new Concert("= Ed Sheran Tour",LocalDate.of(2022, Month.JULY, 26),lieu,25000,70);
		edSheeranTour.addArtiste(sheeran);
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(edSheeranTour));
		
		
		lieu =new Lieu("Stade Pierre Mauroy","261","Boulevard de Tournais","59650","Villeneuve-d'Ascq","France");
		lieuService.save(lieu);
		
		lieu =new Lieu("Halle Tony Garnier","20","Place Docteurs Charles et Christophe Mérieux","69007","Lyon","France");
		lieuService.save(lieu);
		concert = new Concert("Chainsmockers Europe Tour",LocalDate.of(2022, Month.JULY, 20),lieu,15000,80);
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		
		lieu =new Lieu("Sud de France Arena",null,"Route de la Foire","34470","Pérols","France");
		lieuService.save(lieu);

		
		lieu =new Lieu("Arènes de Nîmes",null,"Boulevard des Arène","30000","Nîmes","France");
		lieuService.save(lieu);
		
		lieu =new Lieu("Mineirinho","1000","Avenue Antônio Abrahão Caram","31275-000","Belo Horizonte","Brésil");
		lieuService.save(lieu);
		
		lieu =new Lieu("Palau Sant Jordi","5","Passeig Olímpic","08038","Barcelone","Espagne");
		lieuService.save(lieu);
		concert = new Concert("Chainsmockers Europe Tour",LocalDate.of(2022, Month.JULY, 27),lieu,17000,80);
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		
		lieu =new Lieu("Manchester Arena",null,"Victoria Station Approach",null,"Manchester","Royaume-Uni");
		lieuService.save(lieu);
		concert = new Concert("Live Aid 2022",LocalDate.of(2022, Month.AUGUST, 12),lieu,21000,100);
		concert.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("The Weeknd").get(0));

		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		
		
		////Creation Utilisateurs
		//------------------------------------------------------------------------------------------------------------------------------------------
		Utilisateur john = new Utilisateur("john@mail.com", "monAnniversaire", "Dupond", "John", "09 03 60 74 85", null, "johnyday");
		utilisateurService.save(john);
		john.addArtiste(theWeeknd);
		john.addArtiste(petitBiscuit);
		utilisateurService.addLigneUtilisateur(john);
		Commande commande = new Commande(john);
		commande.addProduit(afterHours, 4);
		Commande commande2 = new Commande(john);
		commande2.addProduit(problems, 1);
		commandeService.save(commande);
		commandeService.save(commande2);
		
		
		Utilisateur marie = new Utilisateur("m.dolly@monMail.fr", "1234", "Dolly", "Marie", "07 25 14 96 87", null, "marie.dolly");
		utilisateurService.save(marie);
		marie.addArtiste(sheeran);
		marie.addArtiste(petitBiscuit);
		marie.addArtiste(kygo);
		marie.addArtiste(theWeeknd);
		utilisateurService.addLigneUtilisateur(marie);
		commande = new Commande(marie);
		commande.addProduit(edSheeranTour, 2);
		commandeService.save(commande);
		
		
	}

}
