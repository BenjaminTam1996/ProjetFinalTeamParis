import { AccueilComponent } from './accueil/accueil.component';
import { SigninComponent } from './formulaires/signin/signin.component';
import { ConnexionComponent } from './formulaires/connexion/connexion.component';
import { Routes } from '@angular/router';
import { ConcertComponent } from './formulaires/concert/concert.component';

export const routes: Routes = [
  { path: 'accueil', component: AccueilComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'signin', component: SigninComponent },
  { path: 'concertform', component: ConcertComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];
