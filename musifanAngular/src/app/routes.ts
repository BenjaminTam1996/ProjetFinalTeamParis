import { AuthUtilisateurService } from './services/auth-utilisateur.service';
import { AccueilComponent } from './accueil/accueil.component';
import { SigninComponent } from './formulaires/signin/signin.component';
import { ConnexionComponent } from './formulaires/connexion/connexion.component';
import { Routes } from '@angular/router';
import { UtilisateurComponent } from './utilisateur/utilisateur/utilisateur.component';
import { ArtisteComponent } from './artiste/artiste/artiste.component';
import { AuthArtisteService } from './services/auth-artiste.service';

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
    path: 'artiste',
    component: ArtisteComponent,
    canActivate: [AuthArtisteService],
  },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];
