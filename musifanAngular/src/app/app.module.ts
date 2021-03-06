import { routes } from './routes';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ConnexionComponent } from './formulaires/connexion/connexion.component';
import { SigninComponent } from './formulaires/signin/signin.component';
import { ParametresComponent } from './formulaires/parametres/parametres.component';
import { AlbumComponent } from './formulaires/album/album.component';
import { ConcertComponent } from './formulaires/concert/concert.component';
import { PublicationComponent } from './formulaires/publication/publication.component';
import { PhotosComponent } from './formulaires/photos/photos.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { ArtisteComponent } from './artiste/artiste/artiste.component';
import { UtilisateurComponent } from './utilisateur/utilisateur/utilisateur.component';
import { ArtistNavbarComponent } from './navbars/artist-navbar/artist-navbar.component';
import { FanNavbarComponent } from './navbars/fan-navbar/fan-navbar.component';
import { ListeArtistesComponent } from './utilisateur/liste-artistes/liste-artistes.component';
import { ListeConcertsComponent } from './utilisateur/liste-concerts/liste-concerts.component';
import { ListeMusiquesComponent } from './utilisateur/liste-musiques/liste-musiques.component';
import { DetailsAlbumComponent } from './album/details-album/details-album.component';
import { DetailsLieuComponent } from './lieu/details-lieu/details-lieu.component';
import { DetailsPublicationComponent } from './publication/details-publication/details-publication.component';
import { DetailsConcertComponent } from './concert/details-concert/details-concert.component';
import { FooterComponent } from './footer/footer/footer.component';
import { RechercheArtisteComponent } from './recherche/recherche-artiste/recherche-artiste.component';
import { RechercheConcertComponent } from './recherche/recherche-concert/recherche-concert.component';

@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    SigninComponent,
    ParametresComponent,
    AlbumComponent,
    ConcertComponent,
    PublicationComponent,
    PhotosComponent,
    AccueilComponent,
    ArtisteComponent,
    UtilisateurComponent,
    ArtistNavbarComponent,
    FanNavbarComponent,
    ListeArtistesComponent,
    ListeConcertsComponent,
    ListeMusiquesComponent,
    DetailsAlbumComponent,
    DetailsLieuComponent,
    DetailsPublicationComponent,
    DetailsConcertComponent,
    FooterComponent,
    RechercheArtisteComponent,
    RechercheConcertComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
