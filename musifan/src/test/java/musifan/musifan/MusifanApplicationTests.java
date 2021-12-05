package musifan.musifan;

import java.time.LocalDate;
import java.time.Month;

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
	
	@Test
	void contextLoads() {
		
		////Creation artiste + albums
		//The Weeknd
		//------------------------------------------------------------------------------------------------------------------------------------------
		Artiste theWeeknd = new Artiste("The Weeknd");
		artisteService.save(theWeeknd);
		Album album = new Album("After Hours",LocalDate.of(2020, Month.MARCH, 20));
		album.addArtiste(theWeeknd);
		album.addChansons(new Chansons("Alone Again","4:10",album));
		album.addChansons(new Chansons("Too Late","3:59",album));
		album.addChansons(new Chansons("Hardest to Love","3:31",album));
		album.addChansons(new Chansons("Scared to Live","3:11",album));
		album.addChansons(new Chansons("Snowchild","4:07",album));
		album.addChansons(new Chansons("Escape from LA","5:55",album));
		album.addChansons(new Chansons("Heartless","3:18",album));
		album.addChansons(new Chansons("Faith","4:43",album));
		album.addChansons(new Chansons("Blinding Lights","3:20",album));
		album.addChansons(new Chansons("In Your Eyes","3:57",album));
		album.addChansons(new Chansons("Save Your Tears","3:35",album));
		album.addChansons(new Chansons("Repeat After Me","3:15",album));
		album.addChansons(new Chansons("Faith","4:43",album));
		album.addChansons(new Chansons("After Hours","6:01",album));
		album.addChansons(new Chansons("Until I Bleed Out","3:10",album));
		albumService.save(album);
		
		Publication publication = new Publication("Mon tout nouveau album ", theWeeknd);
		theWeeknd.addPublication(publication);
		Publication publication2 = new Publication("Petite apparition surprise chez mon ami John", theWeeknd);
		theWeeknd.addPublication(publication2);
		artisteService.save(theWeeknd);
		publicationService.save(publication);
		publicationService.save(publication2);

		
		//Kygo
		//------------------------------------------------------------------------------------------------------------------------------------------
		Artiste kygo = new Artiste("Kygo");
		artisteService.save(kygo);
		album = new Album("Cloud Nine",LocalDate.of(2016, Month.MAY, 13));
		album.addArtiste(kygo);
		album.addChansons(new Chansons("Intro","2:08",album));
		album.addChansons(new Chansons("Stole The Show","3:42",album));
		album.addChansons(new Chansons("Fiction","4:03",album));
		album.addChansons(new Chansons("Raging","3:44",album));
		album.addChansons(new Chansons("Firestone","4:33",album));
		album.addChansons(new Chansons("Happy Birthday","4:10",album));
		album.addChansons(new Chansons("I'm In Love","3:32",album));
		album.addChansons(new Chansons("Oasis ","3:25",album));
		album.addChansons(new Chansons("Not Alone","3:25",album));
		album.addChansons(new Chansons("Serious","3:54",album));
		album.addChansons(new Chansons("Stay","3:59",album));
		album.addChansons(new Chansons("Nothing Left","3:56",album));
		album.addChansons(new Chansons("Fragile","3:50",album));
		album.addChansons(new Chansons("Carry Me","3:53",album));
		album.addChansons(new Chansons("For What It's Worth","3:03",album));
		albumService.save(album);
		
		//DJ Snake + Bipolar Sunshine
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste snake = new Artiste("DJ Snake");
		artisteService.save(snake);
		album = new Album("Middle",LocalDate.of(2015, Month.OCTOBER, 16));
		album.addChansons(new Chansons("Middle","3:40",album));
		album.addArtiste(snake);
		Artiste sunshine = new Artiste("Bipolar Sunshine");
		artisteService.save(sunshine);
		album.addArtiste(sunshine);
		albumService.save(album);
		
		//Tchami + Malaa
		//------------------------------------------------------------------------------------------------------------------------------------------		
		album = new Album("Made In France",LocalDate.of(2019, Month.JULY, 26));
		album.addChansons(new Chansons("Made In France","4:11",album));
		album.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("DJ Snake").get(0));
		Artiste tchami = new Artiste("Tchami");
		artisteService.save(tchami);
		album.addArtiste(tchami);
		Artiste malaa = new Artiste("Malaa");
		artisteService.save(malaa);
		album.addArtiste(malaa);
		albumService.save(album);
		
		// Petit Biscuit
		//------------------------------------------------------------------------------------------------------------------------------------------		
		album = new Album("Presence",LocalDate.of(2017, Month.NOVEMBER, 10));
		Artiste petitBiscuit = new Artiste("Petit Biscuit");
		artisteService.save(petitBiscuit);
		album.addArtiste(petitBiscuit);
		album.addChansons(new Chansons("Creation Comes Alive","3:18",album));
		album.addChansons(new Chansons("Follow Me","4:41",album));
		albumService.save(album);
		
		// Petit Biscuit
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste sheeran = new Artiste("sheeran@mail.com", "sheeran", "Sheeran", "Edward Christopher", "06 20 84 99 24", null, "Ed Sheeran", "auteur-compositeur-interprete et guitariste", null);
		artisteService.save(sheeran);
		album = new Album("Divide", LocalDate.of(2017, Month.MARCH, 3));
		album.addArtiste(sheeran);
		album.addChansons(new Chansons("Perfect", "4:39", album));
		album.addChansons(new Chansons("Shape of You", "3:53", album));
		album.addChansons(new Chansons("Happier", "4:21", album));
		album.addChansons(new Chansons("Castle on the Hill", "3:39", album));
		albumService.save(album);
		
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
		concertService.save(concert);
		concert = new Concert("Kygo French Tour",LocalDate.of(2022, Month.MAY, 10),lieu,6000,45);
		concert.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("Kygo").get(0));
		concertService.save(concert);
		Concert afterHours = new Concert("The After Hours Tour", LocalDate.of(2022, Month.JULY, 21), lieu, 10000, 50);
		afterHours.addArtiste(theWeeknd);
		concertService.save(afterHours);


		lieu =new Lieu("La Cigale","120","Boulevard de Rochechouart","75018","Paris","France");
		lieuService.save(lieu);
		Concert problems = new Concert("Problems by Petit Biscuit",LocalDate.of(2022, Month.MARCH, 16),lieu,2000,30);
		problems.addArtiste(petitBiscuit);
		concertService.save(problems);

		
		lieu =new Lieu("L'Olympia","28","Boulevard des Capucine","75009","Paris","France");
		lieuService.save(lieu);
		concert = new Concert("Toca by Timmy Trumpet",LocalDate.of(2022, Month.APRIL, 07),lieu,2200,45);
		concertService.save(concert);
		
		lieu =new Lieu("Le Zénith","211","Boulevard Jean-Jaurès Parc de La Villette","75019","Paris","France");
		lieuService.save(lieu);
		concert = new Concert("Thanks God",LocalDate.of(2022, Month.SEPTEMBER, 04),lieu,1500,30);
		concertService.save(concert);
		
		lieu =new Lieu("La Défense Arena","8","Rue des Sorins","92000","Nanterre","France");
		lieuService.save(lieu);
		Concert edSheeranTour = new Concert("= Ed Sheran Tour",LocalDate.of(2022, Month.JULY, 26),lieu,25000,70);
		edSheeranTour.addArtiste(sheeran);
		concertService.save(edSheeranTour);
		
		
		lieu =new Lieu("Stade Pierre Mauroy","261","Boulevard de Tournais","59650","Villeneuve-d'Ascq","France");
		lieuService.save(lieu);
		
		lieu =new Lieu("Halle Tony Garnier","20","Place Docteurs Charles et Christophe Mérieux","69007","Lyon","France");
		lieuService.save(lieu);
		concert = new Concert("Chainsmockers Europe Tour",LocalDate.of(2022, Month.JULY, 20),lieu,15000,80);
		concertService.save(concert);
		
		lieu =new Lieu("Sud de France Arena",null,"Route de la Foire","34470","Pérols","France");
		lieuService.save(lieu);

		
		lieu =new Lieu("Arènes de Nîmes",null,"Boulevard des Arène","30000","Nîmes","France");
		lieuService.save(lieu);
		
		lieu =new Lieu("Mineirinho","1000","Avenue Antônio Abrahão Caram","31275-000","Belo Horizonte","Brésil");
		lieuService.save(lieu);
		
		lieu =new Lieu("Palau Sant Jordi","5","Passeig Olímpic","08038","Barcelone","Espagne");
		lieuService.save(lieu);
		concert = new Concert("Chainsmockers Europe Tour",LocalDate.of(2022, Month.JULY, 27),lieu,17000,80);
		concertService.save(concert);
		
		lieu =new Lieu("Manchester Arena",null,"Victoria Station Approach",null,"Manchester","Royaume-Uni");
		lieuService.save(lieu);
		concert = new Concert("Live Aid 2022",LocalDate.of(2022, Month.AUGUST, 12),lieu,21000,100);
		concert.addArtiste(artisteService.byNomArtisteLikeIgnoreCase("The Weeknd").get(0));

		concertService.save(concert);
		
		
		////Creation Utilisateurs
		//------------------------------------------------------------------------------------------------------------------------------------------
		Utilisateur john = new Utilisateur("john@mail.com", "monAnniversaire", "Dupond", "John", "09 03 60 74 85", null, "johnyday");
		john.addArtiste(theWeeknd);
		john.addArtiste(petitBiscuit);
		Commande commande = new Commande(john);
		commande.addProduit(afterHours, 4);
		Commande commande2 = new Commande(john);
		commande2.addProduit(problems, 1);
		utilisateurService.save(john);
		commandeService.save(commande);
		commandeService.save(commande2);
		
		
		Utilisateur marie = new Utilisateur("m.dolly@monMail.fr", "1234", "Dolly", "Marie", "07 25 14 96 87", null, "marie.dolly");
		marie.addArtiste(sheeran);
		marie.addArtiste(petitBiscuit);
		marie.addArtiste(kygo);
		marie.addArtiste(theWeeknd);
		commande = new Commande(marie);
		commande.addProduit(edSheeranTour, 2);
		utilisateurService.save(marie);
		commandeService.save(commande);
		
		
	}

}
