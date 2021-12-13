import { AuthService } from './services/auth.service';
import { ParametresComponent } from './formulaires/parametres/parametres.component';
import { ListeMusiquesComponent } from './utilisateur/liste-musiques/liste-musiques.component';
import { ListeConcertsComponent } from './utilisateur/liste-concerts/liste-concerts.component';
import { ListeArtistesComponent } from './utilisateur/liste-artistes/liste-artistes.component';
import { AuthUtilisateurService } from './services/auth-utilisateur.service';
import { AccueilComponent } from './accueil/accueil.component';
import { SigninComponent } from './formulaires/signin/signin.component';
import { ConnexionComponent } from './formulaires/connexion/connexion.component';
import { Routes } from '@angular/router';
import { UtilisateurComponent } from './utilisateur/utilisateur/utilisateur.component';
import { ArtisteComponent } from './artiste/artiste/artiste.component';
import { AuthArtisteService } from './services/auth-artiste.service';
import { ConcertComponent } from './formulaires/concert/concert.component';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'signin', component: SigninComponent },
  {
    path: 'utilisateur',
    component: UtilisateurComponent,
    canActivate: [AuthUtilisateurService],
  },
  {
    path: 'listeArtistes',
    component: ListeArtistesComponent,
    canActivate: [AuthUtilisateurService],
  },
  {
    path: 'listeConcerts',
    component: ListeConcertsComponent,
    canActivate: [AuthUtilisateurService],
  },
  {
    path: 'listeMusiques',
    component: ListeMusiquesComponent,
    canActivate: [AuthUtilisateurService],
  },
  {
    path: 'artiste',
    component: ArtisteComponent,
    canActivate: [AuthArtisteService],
  },
  {
    path: 'artiste/:id',
    component: ArtisteComponent,
    canActivate: [AuthUtilisateurService],
  },
  {
    path: 'parametres',
    component: ParametresComponent,
    canActivate: [AuthService],
  },
  { path: 'concertform', component: ConcertComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];
