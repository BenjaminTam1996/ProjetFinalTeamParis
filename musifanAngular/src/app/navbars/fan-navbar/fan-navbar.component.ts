import { UtilisateurService } from './../../services/utilisateur.service';
import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/models/utilisateur';
import { Router } from '@angular/router';

@Component({
  selector: 'app-fan-navbar',
  templateUrl: './fan-navbar.component.html',
  styleUrls: ['./fan-navbar.component.css'],
})
export class FanNavbarComponent implements OnInit {
  utilisateur: Utilisateur = new Utilisateur();

  constructor(
    private utilisateurService: UtilisateurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (!!sessionStorage.getItem('id')) {
      let id: number = parseInt(sessionStorage.getItem('id')!);
      this.utilisateurService.byId(id).subscribe((result) => {
        this.utilisateur = result;
      });
    }
  }

  logout() {
    sessionStorage.clear();
    this.router.navigate(['/accueil']);
  }
}
