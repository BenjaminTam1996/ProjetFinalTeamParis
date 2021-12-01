package musifan.musifan;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import musifan.musifan.entity.Concert;
import musifan.musifan.entity.Lieu;
import musifan.musifan.services.AlbumService;
import musifan.musifan.services.ArtisteService;
import musifan.musifan.services.ConcertService;
import musifan.musifan.services.LieuService;

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
	
	@Test
	void contextLoads() {
		Lieu lieu = new Lieu("AccorHotels Arena","8","Boulevard de Bercy","75012","Paris","France");
		lieuService.save(lieu);
		Concert concert = new Concert("Pardon My French",LocalDate.of(2022, Month.JUNE, 21),lieu,10000,50);
		concertService.save(concert);
		concert = new Concert("Kygo French Tour",LocalDate.of(2022, Month.MAY, 10),lieu,6000,45);
		concertService.save(concert);


		lieu =new Lieu("La Cigale","120","Boulevard de Rochechouart","75018","Paris","France");
		lieuService.save(lieu);
		concert = new Concert("Problems by Petit Biscuit",LocalDate.of(2022, Month.MARCH, 16),lieu,2000,30);
		concertService.save(concert);
		
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
		concert = new Concert("= Ed Sheran Tour",LocalDate.of(2022, Month.JULY, 26),lieu,25000,70);
		concertService.save(concert);
		
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
		concertService.save(concert);
	}

}
