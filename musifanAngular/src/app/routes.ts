import { AccueilComponent } from './accueil/accueil.component';
import { SigninComponent } from './formulaires/signin/signin.component';
import { ConnexionComponent } from './formulaires/connexion/connexion.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'signin', component: SigninComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];
