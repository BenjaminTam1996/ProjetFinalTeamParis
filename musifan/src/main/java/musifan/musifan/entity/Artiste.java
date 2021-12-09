package musifan.musifan.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name="artiste_id")),
	@AttributeOverride(name = "mail", column = @Column(name="artiste_mail")),
	@AttributeOverride(name = "password", column = @Column(name = "artiste_password")),
	@AttributeOverride(name = "nom", column = @Column(name = "artiste_nom")),
	@AttributeOverride(name = "prenom", column = @Column(name = "artiste_prenom")),
	@AttributeOverride(name = "telephone", column = @Column(name = "artiste_telephone")),
	@AttributeOverride(name = "photoProfil", column = @Column(name = "artiste_photo_profil")),
	@AttributeOverride(name = "version", column = @Column(name = "artiste_version")),
})
@NamedQueries({
	@NamedQuery(name="Artiste.byKeyWithUtilisateurs",
			query="select a from Artiste a left join fetch a.lignesUtilisateurs where a.id=:key"),
	@NamedQuery(name="Artiste.byKeyWithAlbums",
			query="select a from Artiste a left join fetch a.lignesAlbums where a.id=:key"),
	@NamedQuery(name="Artiste.byKeyWithConcerts",
			query="select a from Artiste a left join fetch a.ligneConcerts where a.id=:key"),
	@NamedQuery(name="Artiste.byKeyWithPublications",
			query="select a from Artiste a left join fetch a.publications where a.id=:key")
})
@Table(name="artiste")
@SequenceGenerator(name="seqCompte", sequenceName = "seq_artiste", initialValue = 100, allocationSize = 1)
public class Artiste extends Compte {
	@Column(name="artiste_nom_atiste")
	@JsonView({JsonViews.Common.class,})
	private String nomArtiste;
	
	@Lob
	@Column(name="artiste_photo_banniere")
	@JsonView({JsonViews.Common.class,})
	private Byte[] photoBanniere;
	
	@Column(name="artiste_description")
	@JsonView({JsonViews.Common.class,})
	private String description;
	
	@OneToMany(mappedBy = "artiste", fetch = FetchType.LAZY)
	@JsonView({JsonViews.UtilisateurAvecPublicationsArtiste.class, JsonViews.ArtisteComplet.class})	
	private Set<Publication> publications = new HashSet<Publication>();
	
	@OneToMany(mappedBy = "id.artiste")
	@JsonView({JsonViews.ArtisteComplet.class, JsonViews.UtilisateurAvecAlbumsArtiste.class})
	private Set<LigneAlbum> lignesAlbums = new HashSet<LigneAlbum>();
	
	@OneToMany(mappedBy = "id.artiste")
	private Set<LigneUtilisateur> lignesUtilisateurs = new HashSet<LigneUtilisateur>();
	
	@OneToMany(mappedBy = "id.artiste")
	@JsonView({JsonViews.ArtisteComplet.class,})
	private Set<LigneConcert> ligneConcerts = new HashSet<LigneConcert>();
		
	public Artiste() {
		
	}

	public Artiste(String nom, String prenom) {
		super(nom, prenom);
	}

	public Artiste(String mail, String password, String nom, String prenom, String telephone, Byte[] photoProfil, String nomArtiste, String description, Byte[] photoBanniere) {
		super(mail, password, nom, prenom, telephone, photoProfil);
		this.description = description;
		this.nomArtiste = nomArtiste;
		this.photoBanniere = photoBanniere;
	}
	
	public Artiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public Byte[] getPhotoBanniere() {
		return photoBanniere;
	}

	public void setPhotoBanniere(Byte[] photoBanniere) {
		this.photoBanniere = photoBanniere;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	public Set<LigneAlbum> getLignesAlbums() {
		return lignesAlbums;
	}

	public void setLignesAlbums(Set<LigneAlbum> lignesAlbums) {
		this.lignesAlbums = lignesAlbums;
	}

	public Set<LigneUtilisateur> getLignesUtilisateurs() {
		return lignesUtilisateurs;
	}

	public void setLignesUtilisateurs(Set<LigneUtilisateur> lignesUtilisateurs) {
		this.lignesUtilisateurs = lignesUtilisateurs;
	}

	public Set<LigneConcert> getLigneConcerts() {
		return ligneConcerts;
	}

	public void setLigneConcerts(Set<LigneConcert> ligneConcerts) {
		this.ligneConcerts = ligneConcerts;
	}
	
	//Ajouter un album a la liste d'album d'un artiste
	public void addAlbum(Album album) {
		lignesAlbums.add(new LigneAlbum(new LigneAlbumPK(album, this)));
	}
	
	public void addConcert(Concert concert) {
		ligneConcerts.add(new LigneConcert(new LigneConcertPK(concert, this)));
	}
	
	//Ajouter une publication a la liste de publication d'un artiste
	public void addPublication(Publication publication) {
		publications.add(new Publication(publication.getDesciption(), publication.getArtiste()));
	}
}
