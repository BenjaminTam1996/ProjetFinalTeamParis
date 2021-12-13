import { UtilisateurService } from './../../services/utilisateur.service';
import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/models/utilisateur';

@Component({
  selector: 'app-liste-artistes',
  templateUrl: './liste-artistes.component.html',
  styleUrls: ['./liste-artistes.component.css'],
})
export class ListeArtistesComponent implements OnInit {
  utilisateur: Utilisateur = new Utilisateur();

  constructor(private utilisateurService: UtilisateurService) {}

  ngOnInit(): void {
    if (!!sessionStorage.getItem('id')) {
      let id: number = parseInt(sessionStorage.getItem('id')!);
      this.utilisateurService.byIdWithArtiste(id).subscribe((result) => {
        this.utilisateur = result;
      });
    }
  }
}
