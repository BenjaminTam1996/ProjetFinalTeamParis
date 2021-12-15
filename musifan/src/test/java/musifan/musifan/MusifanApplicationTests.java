package musifan.musifan;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

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
import musifan.musifan.repositories.AlbumRepository;
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
		Artiste theWeeknd = new Artiste("week@mail.com", "theWeeknd3$0", null, null, null, null, "The Weeknd", null, null);
		theWeeknd = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(theWeeknd));
		Album album = new Album("After Hours",LocalDate.of(2020, Month.MARCH, 20));
		album.addArtiste(theWeeknd);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		
		
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
		theWeeknd = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(theWeeknd));
		publicationService.save(publication);
		publicationService.save(publication2);

		
		//Kygo
		//------------------------------------------------------------------------------------------------------------------------------------------
		Artiste kygo = new Artiste("kygo@gmail.fr", "Kygo", null, null, null, null, "Kygo", "Kygo , de son vrai nom Kyrre Gørvell-Dahll, né le 11 septembre 1991 à Singapour, est un DJ, musicien, auteur-compositeur et producteur norvégien. Il est connu pour ses compositions Firestone feat Conrad Sewell (2014) et Stole the Show feat. Parson James (2015). En 2015, il est classé 33e au DJ Mag Top 100 DJ4 puis 26e l'année suivante. ", null);
		kygo = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(kygo));
		album = new Album("Cloud Nine",LocalDate.of(2016, Month.MAY, 13));
		album.addArtiste(kygo);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
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
		snake = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(snake));
		album = new Album("Middle",LocalDate.of(2015, Month.OCTOBER, 16));
		album.addArtiste(snake);
		Artiste sunshine = new Artiste("Bipo.Sun@yahoo.com", "BiPoSun", null, null, null, null, "Bipolar Sunshine", null, null);
		sunshine = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(sunshine));
		album.addArtiste(sunshine);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Middle","3:40",album));
		chansonRepository.saveAll(chansons);
		
		//Tchami + Malaa
		//------------------------------------------------------------------------------------------------------------------------------------------		
		album = new Album("Made In France",LocalDate.of(2019, Month.JULY, 26));
		album.addArtiste(musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artisteService.byNomArtisteLikeIgnoreCase("DJ Snake").get(0)));
		Artiste tchami = new Artiste("tchami@hotmail.fr", "Tchami", null, null, null, null, "Tchami", null, null);
		tchami = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(tchami));
		album.addArtiste(tchami);
		Artiste malaa = new Artiste("malaa@yahoo.com", "Malaa", null, null, null, null, "Malaa", null, null);
		malaa = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(malaa));
		album.addArtiste(malaa);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Made In France","4:11",album));
		chansonRepository.saveAll(chansons);
		
		// Petit Biscuit
		//------------------------------------------------------------------------------------------------------------------------------------------		
		album = new Album("Presence",LocalDate.of(2017, Month.NOVEMBER, 10));
		Artiste petitBiscuit = new Artiste("Petit.Biscuit@monMail.com", "MonBiscuit", null, null, null, null, "Petit Biscuit", null, null);
		petitBiscuit = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(petitBiscuit));
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		album.addArtiste(petitBiscuit);
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Creation Comes Alive","3:18",album));
		chansons.add(new Chansons("Follow Me","4:41",album));
		chansonRepository.saveAll(chansons);
		
		// Ed Sheeran
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste sheeran = new Artiste("sheeran@mail.com", "sheeran", "Sheeran", "Edward Christopher", "06 20 84 99 24", null, "Ed Sheeran", "auteur-compositeur-interprete et guitariste", null);
		sheeran = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(sheeran));
		album = new Album("Divide", LocalDate.of(2017, Month.MARCH, 3));
		album.addArtiste(sheeran);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Perfect", "4:39", album));
		chansons.add(new Chansons("Shape of You", "3:53", album));
		chansons.add(new Chansons("Happier", "4:21", album));
		chansons.add(new Chansons("Castle on the Hill", "3:39", album));
		chansonRepository.saveAll(chansons);
		
		
		publication = new Publication("Sortie de mon prochain album prevue prochainement", sheeran);
		sheeran.addPublication(publication);
		publicationService.save(publication);
		
		// Adele
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste adele = new Artiste("adele@mail.com", "$Adele30", null, "Adele Adkins", null, null, "Adele", null, null);
		adele = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(adele));
		album = new Album("30", LocalDate.of(2021, Month.NOVEMBER, 19));
		album.addArtiste(adele);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Strangers by Nature", "3:02", album));
		chansons.add(new Chansons("Easy On Me", "3:44", album));
		chansons.add(new Chansons("	My Little Love", "6:29", album));
		chansons.add(new Chansons("Cry Your Heart Out", "4:15", album));
		chansons.add(new Chansons("Oh My God", "3:45", album));
		chansons.add(new Chansons("Can I Get It", "3:30", album));
		chansons.add(new Chansons("	I Drink Wine", "6:16", album));
		chansons.add(new Chansons("All Night Parking ", "2:41", album));
		chansons.add(new Chansons("Woman like Me", "5:00", album));
		chansons.add(new Chansons("Hold On", "6:06", album));
		chansons.add(new Chansons("To Be Loved", "6:43", album));
		chansons.add(new Chansons("Love Is a Game", "6:43", album));
		chansonRepository.saveAll(chansons);
		
		
		publication = new Publication("Voici mon dernier album 30", adele);
		adele.addPublication(publication);
		publicationService.save(publication);		
		
		// Taylor Swift
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste swift = new Artiste("swift@mail.com", "$Taylor1", null, "Taylor Swift", null, null, "Taylor Swift", "Taylor Alison Swift, née le 13 décembre 1989 à Reading, en Pennsylvanie, est une auteure-compositrice-interprète et actrice américaine. Son lyrisme narratif, qui s’inspire souvent de ses expériences personnelles, est largement salué par la critique et la couverture médiatique. ", null);
		swift = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(swift));
		album = new Album("Red", LocalDate.of(2021, Month.NOVEMBER, 12));
		album.addArtiste(swift);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("State of Grace", "4:55", album));
		chansons.add(new Chansons("Red", "3:43", album));
		chansons.add(new Chansons("Treacherous", "4:02", album));
		chansons.add(new Chansons("I Knew You Were Trouble", "3:39", album));
		chansons.add(new Chansons("All Too Well", "5:29", album));
		chansons.add(new Chansons("22", "3:50", album));
		chansons.add(new Chansons("I Almost Do", "4:04", album));
		chansons.add(new Chansons(	"We Are Never Ever Getting Back Together", "3:13", album));
		chansons.add(new Chansons("Stay Stay Stay", "3:25", album));
		chansons.add(new Chansons("The Last Time", "4:59", album));
		chansons.add(new Chansons("Holy Ground", "3:22", album));
		chansons.add(new Chansons("Sad Beautiful Tragic", "4:44", album));
		chansonRepository.saveAll(chansons);
		
		
		publication = new Publication("Voici la réedition de l'album Red", swift);
		swift.addPublication(publication);
		publicationService.save(publication);		// Doja Cat
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste doja = new Artiste("doja@mail.com", "$Doja1", null, "Doja Cat", null, null, "Doja Cat", null, null);
		doja = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(doja));
		album = new Album("Planet Her", LocalDate.of(2021, Month.JUNE, 25));
		album.addArtiste(doja);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Woman", "2:52", album));
		chansons.add(new Chansons("Naked", "3:43", album));
		chansons.add(new Chansons("Payday", "3:33", album));
		chansons.add(new Chansons("Get Into It (Yuh)", "2:18", album));
		chansons.add(new Chansons("	Need to Know", "3:30", album));
		chansons.add(new Chansons("I Don’t Do Drugs", "3:08", album));
		chansons.add(new Chansons("	Love To Dream", "3:36", album));
		chansons.add(new Chansons("	You Right", "3:06", album));
		chansons.add(new Chansons("	Been Like This", "2:57", album));
		chansons.add(new Chansons("Options", "2:39", album));
		chansons.add(new Chansons("	Ain’t Shit", "2:54", album));
		chansons.add(new Chansons("Imagine", "2:28", album));
		chansonRepository.saveAll(chansons);
		
		
		publication = new Publication("Voici mon dernier album Planet Her", doja);
		doja.addPublication(publication);
		publicationService.save(publication);		
		
		// Ninho
		//------------------------------------------------------------------------------------------------------------------------------------------		
		Artiste ninho = new Artiste("ninho@mail.com", "$Ninho1", null, "Ninho", null, null, "Ninho", null, null);
		ninho = artisteService.save(musifan.musifan.dto.EntityToDto.ArtisteToArtisteDto(ninho));
		album = new Album("Jefe", LocalDate.of(2021, Month.DECEMBER, 3));
		album.addArtiste(ninho);
		album = albumService.save(musifan.musifan.dto.EntityToDto.AlbumToAlbumDto(album));
		chansons = new ArrayList<Chansons>();
		chansons.add(new Chansons("Jefe", "2:57", album));
		chansons.add(new Chansons("VVS", "3:07", album));
		chansons.add(new Chansons("Sky Priority", "2:49", album));
		chansons.add(new Chansons("OG", "3:47", album));
		chansons.add(new Chansons("	Arme de poing", "3:35", album));
		chansons.add(new Chansons("Vérité", "3:19", album));
		chansons.add(new Chansons("No Life", "3:57", album));
		chansons.add(new Chansons("	YSL", "3:38", album));
		chansons.add(new Chansons("	Aïcha", "3:39", album));
		chansons.add(new Chansons("Mood", "2:53", album));
		chansons.add(new Chansons("	Athéna", "3:16", album));
		chansons.add(new Chansons("La maison que je voulais", "3:41", album));
		chansonRepository.saveAll(chansons);
		
		
		publication = new Publication("Voici mon dernier album Jefe", ninho);
		ninho.addPublication(publication);
		publicationService.save(publication);
		
		////Création lieu + concert
		//------------------------------------------------------------------------------------------------------------------------------------------
		Lieu lieu = new Lieu("AccorHotels Arena","8","Boulevard de Bercy","75012","Paris","France");
		lieuService.save(lieu);
		Concert concert = new Concert("Pardon My French",LocalDate.of(2022, Month.JUNE, 21),lieu,10000,50);
		concert.addArtiste(musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artisteService.byNomArtisteLikeIgnoreCase("DJ Snake").get(0)));
		concert.addArtiste(musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artisteService.byNomArtisteLikeIgnoreCase("Tchami").get(0)));
		concert.addArtiste(musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artisteService.byNomArtisteLikeIgnoreCase("Malaa").get(0)));
		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		concert = new Concert("Kygo French Tour",LocalDate.of(2022, Month.MAY, 10),lieu,6000,45);
		concert.addArtiste(musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artisteService.byNomArtisteLikeIgnoreCase("Kygo").get(0)));
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
		concert.addArtiste(musifan.musifan.dto.DtoToEntity.DtoArtisteToEntity(artisteService.byNomArtisteLikeIgnoreCase("The Weeknd").get(0)));

		concertService.create(musifan.musifan.dto.EntityToDto.ConcertToConcertDto(concert));
		
		
		////Creation Utilisateurs
		//------------------------------------------------------------------------------------------------------------------------------------------
		Utilisateur john = new Utilisateur("john@mail.com", "monAnniversaire", "Dupond", "John", "09 03 60 74 85", null, "johnyday");
		john = utilisateurService.save(musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(john));
		john.addArtiste(theWeeknd);
		john.addArtiste(petitBiscuit);
		john.addArtiste(ninho);
		john.addArtiste(adele);
		john.addArtiste(malaa);
		john.addArtiste(kygo);
		utilisateurService.addLigneUtilisateur(john);
		Commande commande = new Commande(john);
		commande.addProduit(musifan.musifan.dto.DtoToEntity.ConcertDtoToConcertEntity(concertService.ByNomIgnoreCase("The After Hours Tour").get(0)), 4);
		Commande commande2 = new Commande(john);
		commande2.addProduit(musifan.musifan.dto.DtoToEntity.ConcertDtoToConcertEntity(concertService.ByNomIgnoreCase("Problems by Petit Biscuit").get(0)), 1);
		commandeService.save(musifan.musifan.dto.EntityToDto.CommandeToCommandeDto(commande));
		commandeService.save(musifan.musifan.dto.EntityToDto.CommandeToCommandeDto(commande2));
		
		
		Utilisateur marie = new Utilisateur("m.dolly@monMail.fr", "1234", "Dolly", "Marie", "07 25 14 96 87", null, "marie.dolly");
		marie = utilisateurService.save(musifan.musifan.dto.EntityToDto.UtilisateurToUtilisateurDto(marie));
		marie.addArtiste(sheeran);
		marie.addArtiste(petitBiscuit);
		marie.addArtiste(kygo);
		marie.addArtiste(theWeeknd);
		utilisateurService.addLigneUtilisateur(marie);
		commande = new Commande(marie);
		commande.addProduit(musifan.musifan.dto.DtoToEntity.ConcertDtoToConcertEntity(concertService.ByNomIgnoreCase("Chainsmockers Europe Tour").get(0)), 2);
		commandeService.save(musifan.musifan.dto.EntityToDto.CommandeToCommandeDto(commande));
		
		
		
	}

}
