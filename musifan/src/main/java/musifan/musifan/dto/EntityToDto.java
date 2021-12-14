package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;

import musifan.musifan.entity.Chansons;
import musifan.musifan.entity.JsonViews;
import musifan.musifan.entity.LigneAlbum;
import musifan.musifan.entity.LigneCommande;
import musifan.musifan.entity.LigneConcert;
import musifan.musifan.entity.LigneUtilisateur;
import musifan.musifan.entity.Publication;

public class EntityToDto {
	
	public static Album AlbumToAlbumDto(musifan.musifan.entity.Album album) {
		//Conversion d'un album entity en album dto
		Album albumDto = new Album();
		albumDto.setTitre(album.getTitre());
		albumDto.setId(album.getId());
		albumDto.setPhoto(album.getPhoto());
		albumDto.setDate(album.getDate());
		
		for(Chansons chansons : album.getChansons()) {
			Chanson chansonDto = new Chanson();
			chansonDto.setId(chansons.getId());
			chansonDto.setTitre(chansons.getTitre());
			chansonDto.setDuree(chansons.getDuree());
			chansonDto.setAlbum(albumDto);
			albumDto.getChansons().add(chansonDto);
		}
//		for(Chanson c : albumDto.getChansons()) {
//			System.out.println(c.getTitre());
//		}

		
		for(LigneAlbum la : album.getLignesAlbums()) {
			Artiste artisteDto = new Artiste();
			artisteDto.setId(la.getId().getArtiste().getId());
			artisteDto.setMail(la.getId().getArtiste().getMail());
			artisteDto.setPassword(la.getId().getArtiste().getPassword());
			artisteDto.setNom(la.getId().getArtiste().getNom());
			artisteDto.setPrenom(la.getId().getArtiste().getPrenom());
			artisteDto.setTelephone(la.getId().getArtiste().getTelephone());
			artisteDto.setPhotoProfil(la.getId().getArtiste().getPhotoProfil());
			artisteDto.setPhotoBanniere(la.getId().getArtiste().getPhotoBanniere());
			artisteDto.setNomArtiste(la.getId().getArtiste().getNomArtiste());
			artisteDto.setDescription(la.getId().getArtiste().getDescription());
			albumDto.getArtistes().add(artisteDto);
		}
		
		return albumDto;
	}
	
	public static Artiste ArtisteToArtisteDto(musifan.musifan.entity.Artiste artiste) {
		Artiste artisteDto = new Artiste();
		artisteDto.setNom(artiste.getNom());
		artisteDto.setId(artiste.getId());
		artisteDto.setDescription(artiste.getDescription());
		artisteDto.setMail(artiste.getMail());
		artisteDto.setNomArtiste(artiste.getNomArtiste());
		artisteDto.setPassword(artiste.getPassword());
		artisteDto.setPhotoBanniere(artiste.getPhotoBanniere());
		artisteDto.setPhotoProfil(artiste.getPhotoBanniere());
		artisteDto.setPrenom(artiste.getPrenom());
		artisteDto.setTelephone(artiste.getTelephone());
		
		System.out.println(artiste.getPublications());
		
		for(Publication p : artiste.getPublications()) {
			musifan.musifan.dto.Publication publicationDto = new musifan.musifan.dto.Publication();
			publicationDto.setId(p.getId());
			publicationDto.setImage(p.getImage());
			publicationDto.setDesciption(p.getDesciption());
			publicationDto.setDate(p.getDate());
			publicationDto.setArtiste(artisteDto);;
			artisteDto.getPublications().add(publicationDto);
		}
		
		for(LigneAlbum la : artiste.getLignesAlbums()) {
			Album albumDto = AlbumToAlbumDto(la.getId().getAlbum());
			artisteDto.getAlbums().add(albumDto);
		}
		
		for(LigneConcert lc : artiste.getLigneConcerts()) {
			Concert concertDto = ConcertToConcertDto(lc.getId().getConcert());
			artisteDto.getConcerts().add(concertDto);
		}
		
		return artisteDto;
	}
	
	public static Lieu LieuToLieuDto(musifan.musifan.entity.Lieu lieu) {
		Lieu lieuDto = new Lieu();
		lieuDto.setId(lieu.getId());
		lieuDto.setNom(lieu.getNom());
		lieuDto.setNumRue(lieu.getNumRue());
		lieuDto.setRue(lieu.getRue());
		lieuDto.setCodePostal(lieu.getCodePostal());
		lieuDto.setVille(lieu.getVille());
		lieuDto.setPays(lieu.getPays());
		
		for (musifan.musifan.entity.Concert c : lieu.getListeConcerts()){
			Concert concertDto = new Concert();
			concertDto.setId(c.getId());
			concertDto.setLieu(lieuDto);
			concertDto.setDate(c.getDate());
			concertDto.setNom(c.getNom());
			concertDto.setNbPlace(c.getNbPlace());
			concertDto.setPrix(c.getPrix());
			lieuDto.getListeConcerts().add(concertDto);
		}
		
		return lieuDto;
	}
	
	public static Concert ConcertToConcertDto(musifan.musifan.entity.Concert concert) {
		//Conversion d'un album entity en album dto
		Concert concertDto = new Concert();
		concertDto.setId(concert.getId());
		concertDto.setNom(concert.getNom());
		concertDto.setDate(concert.getDate());
		concertDto.setLieu(LieuToLieuDto(concert.getLieu()));
		concertDto.setNbPlace(concert.getNbPlace());
		concertDto.setPrix(concert.getPrix());
		
		for (LigneConcert lc : concert.getLigneConcerts()){
			Artiste artisteDto = new Artiste();
			artisteDto.setId(lc.getId().getArtiste().getId());
			artisteDto.setMail(lc.getId().getArtiste().getMail());
			artisteDto.setPassword(lc.getId().getArtiste().getPassword());
			artisteDto.setNom(lc.getId().getArtiste().getNom());
			artisteDto.setPrenom(lc.getId().getArtiste().getPrenom());
			artisteDto.setTelephone(lc.getId().getArtiste().getTelephone());
			artisteDto.setPhotoProfil(lc.getId().getArtiste().getPhotoProfil());
			artisteDto.setPhotoBanniere(lc.getId().getArtiste().getPhotoBanniere());
			artisteDto.setNomArtiste(lc.getId().getArtiste().getNomArtiste());
			artisteDto.setDescription(lc.getId().getArtiste().getDescription());
			concertDto.getArtistes().add(artisteDto);
		}
		
		return concertDto;
	}
	
	public static Commande CommandeToCommandeDto(musifan.musifan.entity.Commande commande) {
		//Conversion d'un album entity en album dto
		Commande commandeDto = new Commande();
		commandeDto.setNumero(commande.getNumero());;
		commandeDto.setDate(commande.getDate());
		commandeDto.setUtilisateur(commande.getUtilisateur());
		
		for (LigneCommande lc : commande.getLignesCommandes()){
			Concert concertDto = new Concert();
			concertDto.setId(lc.getId().getProduit().getId());
			concertDto.setNom(lc.getId().getProduit().getNom());
			concertDto.setDate(lc.getId().getProduit().getDate());
			concertDto.setLieu(LieuToLieuDto(lc.getId().getProduit().getLieu()));
			concertDto.setNbPlace(lc.getId().getProduit().getNbPlace());
			concertDto.setPrix(lc.getId().getProduit().getPrix());
			commandeDto.setQuantite(lc.getQuantite());
			commandeDto.setConcert(concertDto);
		}
		
		return commandeDto;
	}
	
	
	public static Utilisateur UtilisateurToUtilisateurDto(musifan.musifan.entity.Utilisateur utilisateur) {
		//Conversion d'un album entity en album dto
		Utilisateur utilisateurDto = new Utilisateur();
		utilisateurDto.setId(utilisateur.getId());
		utilisateurDto.setMail(utilisateur.getMail());
		utilisateurDto.setPassword(utilisateur.getPassword());
		utilisateurDto.setNom(utilisateur.getNom());
		utilisateurDto.setPrenom(utilisateur.getPrenom());
		utilisateurDto.setTelephone(utilisateur.getTelephone());
		utilisateurDto.setPseudo(utilisateur.getPseudo());
		
		
		
		for(musifan.musifan.entity.Commande c : utilisateur.getListeConcert()) {
			for ( LigneCommande lc    : c.getLignesCommandes()) {
				Commande commandeDto = new Commande();
				commandeDto.setNumero(lc.getId().getCommande().getNumero());
				commandeDto.setDate(lc.getId().getCommande().getDate());
				commandeDto.setUtilisateur(lc.getId().getCommande().getUtilisateur());
				commandeDto.setQuantite(lc.getQuantite());
				commandeDto.setConcert(ConcertToConcertDto(lc.getId().getProduit()));
				utilisateurDto.getCommande().add(commandeDto);
			}
			
		}

		
		for(LigneUtilisateur lu : utilisateur.getLignesUtilisateurs()) {
			Artiste artisteDto = ArtisteToArtisteDto(lu.getId().getArtiste());
//			artisteDto.setId(lu.getId().getArtiste().getId());
//			artisteDto.setMail(lu.getId().getArtiste().getMail());
//			artisteDto.setPassword(lu.getId().getArtiste().getPassword());
//			artisteDto.setNom(lu.getId().getArtiste().getNom());
//			artisteDto.setPrenom(lu.getId().getArtiste().getPrenom());
//			artisteDto.setTelephone(lu.getId().getArtiste().getTelephone());
//			artisteDto.setPhotoProfil(lu.getId().getArtiste().getPhotoProfil());
//			artisteDto.setPhotoBanniere(lu.getId().getArtiste().getPhotoBanniere());
//			artisteDto.setNomArtiste(lu.getId().getArtiste().getNomArtiste());
//			artisteDto.setDescription(lu.getId().getArtiste().getDescription());
			utilisateurDto.getArtistes().add(artisteDto);
		}
		
		return utilisateurDto;
	}
}
