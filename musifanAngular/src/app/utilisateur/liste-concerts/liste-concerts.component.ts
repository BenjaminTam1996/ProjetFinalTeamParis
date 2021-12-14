import { Utilisateur } from 'src/app/models/utilisateur';
import { UtilisateurService } from './../../services/utilisateur.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-liste-concerts',
  templateUrl: './liste-concerts.component.html',
  styleUrls: ['./liste-concerts.component.css'],
})
export class ListeConcertsComponent implements OnInit {
  utilisateur: Utilisateur = new Utilisateur();
  constructor(private utilisateurService: UtilisateurService) {}

  ngOnInit(): void {
    if (!!sessionStorage.getItem('id')) {
      let id: number = parseInt(sessionStorage.getItem('id')!);
      this.utilisateurService.byIdWithCommande(id).subscribe((result) => {
        this.utilisateur = result;
        console.log(this.utilisateur);
      });
    }
  }
}
