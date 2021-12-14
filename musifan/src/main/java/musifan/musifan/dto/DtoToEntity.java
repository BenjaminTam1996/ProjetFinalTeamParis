package musifan.musifan.dto;

import java.util.HashSet;
import java.util.Set;

import musifan.musifan.entity.Album;
import musifan.musifan.entity.Artiste;
import musifan.musifan.entity.Chansons;
import musifan.musifan.entity.Commande;
import musifan.musifan.entity.Concert;
import musifan.musifan.entity.Lieu;
import musifan.musifan.entity.LigneAlbum;
import musifan.musifan.entity.LigneAlbumPK;
import musifan.musifan.entity.LigneCommande;
import musifan.musifan.entity.LigneCommandePK;
import musifan.musifan.entity.LigneConcert;
import musifan.musifan.entity.LigneConcertPK;
import musifan.musifan.entity.LigneUtilisateur;
import musifan.musifan.entity.LigneUtilisateurPk;
import musifan.musifan.entity.Utilisateur;


public class DtoToEntity {

	public static musifan.musifan.entity.Album DtoAlbumToEntity(musifan.musifan.dto.Album album) {

		// Conversion d'un album dto en album entity
		Album albumEntity = new Album();
		albumEntity.setTitre(album.getTitre());
		albumEntity.setId(album.getId());
		albumEntity.setPhoto(album.getPhoto());
		albumEntity.setDate(album.getDate());

		for (musifan.musifan.dto.Chanson chansons : album.getChansons()) {
			Chansons chansonEntity = new Chansons();
			chansonEntity.setId(chansons.getId());
			chansonEntity.setTitre(chansons.getTitre());
			chansonEntity.setDuree(chansons.getDuree());
			chansonEntity.setAlbum(albumEntity);
			albumEntity.getChansons().add(chansonEntity);
		}

		Set<LigneAlbum> lignesAlbums = new HashSet<LigneAlbum>();
		for (musifan.musifan.dto.Artiste a : album.getArtistes()) {
			musifan.musifan.entity.Artiste artisteEntity = new Artiste();
			artisteEntity.setId(a.getId());
			artisteEntity.setMail(a.getMail());
			artisteEntity.setPassword(a.getPassword());
			artisteEntity.setNom(a.getNom());
			artisteEntity.setPrenom(a.getPrenom());
			artisteEntity.setTelephone(a.getTelephone());
			artisteEntity.setPhotoProfil(a.getPhotoProfil());
			artisteEntity.setPhotoBanniere(a.getPhotoBanniere());
			artisteEntity.setNomArtiste(a.getNomArtiste());
			artisteEntity.setDescription(a.getDescription());

			LigneAlbum ligneAlbum = new LigneAlbum(new LigneAlbumPK(albumEntity, artisteEntity));
			lignesAlbums.add(ligneAlbum);
		}
		albumEntity.setLignesAlbums(lignesAlbums);
//		for(LigneAlbum la : lignesAlbums) {
//			System.out.println(la.getId().getArtiste().getNomArtiste());
//			System.out.println(la.getId().getAlbum().getTitre());
//		}
//		System.out.println(albumEntity.getLignesAlbums());

		return albumEntity;
	}

	public static musifan.musifan.entity.Artiste DtoArtisteToEntity(musifan.musifan.dto.Artiste artiste) {

		// Conversion d'un Artiste dto en Artiste entity
		Artiste artisteEntity = new Artiste();
		artisteEntity.setNom(artiste.getNom());
		artisteEntity.setId(artiste.getId());
		artisteEntity.setDescription(artiste.getDescription());
		artisteEntity.setMail(artiste.getMail());
		artisteEntity.setNomArtiste(artiste.getNomArtiste());
		artisteEntity.setPassword(artiste.getPassword());
		artisteEntity.setPhotoBanniere(artiste.getPhotoBanniere());
		artisteEntity.setPhotoProfil(artiste.getPhotoBanniere());
		artisteEntity.setPrenom(artiste.getPrenom());
		artisteEntity.setTelephone(artiste.getTelephone());
		
		for (musifan.musifan.dto.Publication p : artiste.getPublications()) {
			musifan.musifan.entity.Publication publicationEntity = new musifan.musifan.entity.Publication();
			publicationEntity.setId(p.getId());
			publicationEntity.setImage(p.getImage());
			publicationEntity.setDesciption(p.getDesciption());
			publicationEntity.setDate(p.getDate());
			publicationEntity.setArtiste(artisteEntity);
			artisteEntity.getPublications().add(publicationEntity);
		}

		Set<LigneAlbum> lignesAlbums = new HashSet<LigneAlbum>();
		for (musifan.musifan.dto.Album album : artiste.getAlbums()) {
			Album albumEntity = DtoAlbumToEntity(album);
			LigneAlbum ligneAlbum = new LigneAlbum(new LigneAlbumPK(albumEntity, artisteEntity));
			lignesAlbums.add(ligneAlbum);
		}
		artisteEntity.setLignesAlbums(lignesAlbums);

		Set<LigneConcert> lignesConcerts = new HashSet<LigneConcert>();
		for (musifan.musifan.dto.Concert c : artiste.getConcerts()) {
			musifan.musifan.entity.Concert concertEntity = ConcertDtoToConcertEntity(c);
			LigneConcert ligneConcert = new LigneConcert(new LigneConcertPK(concertEntity, artisteEntity));
			lignesConcerts.add(ligneConcert);
		}
		artisteEntity.setLigneConcerts(lignesConcerts);
		

//		for(LigneAlbum la : lignesAlbums) {
//			System.out.println(la.getId().getArtiste().getNomArtiste());
//			System.out.println(la.getId().getAlbum().getTitre());
//		}
//		System.out.println(albumEntity.getLignesAlbums());

		return artisteEntity;
	}

	public static Concert ConcertDtoToConcertEntity(musifan.musifan.dto.Concert concert) {
		// Conversion d'un album entity en album dto
		musifan.musifan.entity.Concert concertEntity = new musifan.musifan.entity.Concert();
		concertEntity.setId(concert.getId());
		concertEntity.setNom(concert.getNom());
		concertEntity.setDate(concert.getDate());
		musifan.musifan.entity.Lieu lieuEntity = new Lieu();
		lieuEntity.setId(concert.getLieu().getId());
		lieuEntity.setNom(concert.getLieu().getNom());
		lieuEntity.setNumRue(concert.getLieu().getNumRue());
		lieuEntity.setRue(concert.getLieu().getRue());
		lieuEntity.setCodePostal(concert.getLieu().getCodePostal());
		lieuEntity.setVille(concert.getLieu().getVille());
		lieuEntity.setPays(concert.getLieu().getPays());
		
		
		concertEntity.setLieu(lieuEntity);
		concertEntity.setNbPlace(concert.getNbPlace());
		concertEntity.setPrix(concert.getPrix());

		
		Set<LigneConcert> lignesConcert = new HashSet<LigneConcert>();
		for (musifan.musifan.dto.Artiste a : concert.getArtistes()) {
			Artiste artisteEntity = new Artiste();
			artisteEntity.setId(a.getId());
			artisteEntity.setMail(a.getMail());
			artisteEntity.setPassword(a.getPassword());
			artisteEntity.setNom(a.getNom());
			artisteEntity.setPrenom(a.getPrenom());
			artisteEntity.setTelephone(a.getTelephone());
			artisteEntity.setPhotoProfil(a.getPhotoProfil());
			artisteEntity.setPhotoBanniere(a.getPhotoBanniere());
			artisteEntity.setNomArtiste(a.getNomArtiste());
			artisteEntity.setDescription(a.getDescription());

			LigneConcert ligneConcert = new LigneConcert(new LigneConcertPK(concertEntity, artisteEntity));
			lignesConcert.add(ligneConcert);
		}
		concertEntity.setLigneConcerts(lignesConcert);

		return concertEntity;
	}

	
	public static musifan.musifan.entity.Commande DtoCommandeToEntity(musifan.musifan.dto.Commande commande) {

		// Conversion d'une commande dto en commande entity
		musifan.musifan.entity.Commande commandeEntity = new Commande();
		commandeEntity.setNumero(commande.getNumero());;
		commandeEntity.setDate(commande.getDate());
		commandeEntity.setClient(commande.getUtilisateur());
		
	

		Set<LigneCommande> lignesCommandes = new HashSet<LigneCommande>();
		musifan.musifan.entity.Concert concertEntity = new Concert();
			
		concertEntity.setId(commande.getConcert().getId());
		concertEntity.setNom(commande.getConcert().getNom());
		concertEntity.setDate(commande.getConcert().getDate());
		musifan.musifan.entity.Lieu lieuEntity = new Lieu();
		lieuEntity.setId(commande.getConcert().getLieu().getId());
		lieuEntity.setNom(commande.getConcert().getLieu().getNom());
		lieuEntity.setNumRue(commande.getConcert().getLieu().getNumRue());
		lieuEntity.setRue(commande.getConcert().getLieu().getRue());
		lieuEntity.setCodePostal(commande.getConcert().getLieu().getCodePostal());
		lieuEntity.setVille(commande.getConcert().getLieu().getVille());
		lieuEntity.setPays(commande.getConcert().getLieu().getPays());
			
			
		concertEntity.setLieu(lieuEntity);
		concertEntity.setNbPlace(commande.getConcert().getNbPlace());
		concertEntity.setPrix(commande.getConcert().getPrix());

		LigneCommande ligneCommande = new LigneCommande(new LigneCommandePK(commandeEntity, concertEntity),commande.getQuantite());
		lignesCommandes.add(ligneCommande);
		commandeEntity.setLignesCommandes(lignesCommandes);
		return commandeEntity;
	}
	
	
	public static musifan.musifan.entity.Utilisateur DtoUtilisateurToUtilisateur(musifan.musifan.dto.Utilisateur utilisateur) {

		// Conversion d'un utilisateur dto en album entity
		musifan.musifan.entity.Utilisateur utilisateurEntity = new Utilisateur();
		utilisateurEntity.setId(utilisateur.getId());
		utilisateurEntity.setMail(utilisateur.getMail());
		utilisateurEntity.setPassword(utilisateur.getPassword());
		utilisateurEntity.setNom(utilisateur.getNom());
		utilisateurEntity.setPrenom(utilisateur.getPrenom());
		utilisateurEntity.setTelephone(utilisateur.getTelephone());
		utilisateurEntity.setPseudo(utilisateur.getPseudo());

		Set<Commande> Commandes = new HashSet<Commande>();
		Set<LigneCommande> lignesCommandes = new HashSet<LigneCommande>();
		for (musifan.musifan.dto.Commande commande : utilisateur.getCommande()) {
			Commande commandeEntity = new Commande();
			commandeEntity.setNumero(commande.getNumero());
			commandeEntity.setDate(commande.getDate());
			commandeEntity.setClient(utilisateurEntity);
			
			LigneCommande ligneCommande = new LigneCommande(new LigneCommandePK(commandeEntity, ConcertDtoToConcertEntity(commande.getConcert())),commande.getQuantite());
			commandeEntity.getLignesCommandes().add(ligneCommande);
			Commandes.add(commandeEntity);
		}

		utilisateurEntity.setListeConcert(Commandes);

		Set<LigneUtilisateur> lignesUtilisateurs = new HashSet<LigneUtilisateur>();
		for (musifan.musifan.dto.Artiste a : utilisateur.getArtistes()) {
			musifan.musifan.entity.Artiste artisteEntity = new Artiste();
			artisteEntity.setId(a.getId());
			artisteEntity.setMail(a.getMail());
			artisteEntity.setPassword(a.getPassword());
			artisteEntity.setNom(a.getNom());
			artisteEntity.setPrenom(a.getPrenom());
			artisteEntity.setTelephone(a.getTelephone());
			artisteEntity.setPhotoProfil(a.getPhotoProfil());
			artisteEntity.setPhotoBanniere(a.getPhotoBanniere());
			artisteEntity.setNomArtiste(a.getNomArtiste());
			artisteEntity.setDescription(a.getDescription());

			LigneUtilisateur ligneUtilisateur = new LigneUtilisateur(new LigneUtilisateurPk(utilisateurEntity, artisteEntity));
			lignesUtilisateurs.add(ligneUtilisateur);
		}
		utilisateurEntity.setLignesUtilisateurs(lignesUtilisateurs);
//	

		return utilisateurEntity;
	}
}
