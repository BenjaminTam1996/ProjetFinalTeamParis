import { UtilisateurService } from './../../services/utilisateur.service';
import { Utilisateur } from 'src/app/models/utilisateur';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-liste-musiques',
  templateUrl: './liste-musiques.component.html',
  styleUrls: ['./liste-musiques.component.css'],
})
export class ListeMusiquesComponent implements OnInit {
  utilisateur: Utilisateur = new Utilisateur();
  constructor(private utilisateurService: UtilisateurService) {}

  ngOnInit(): void {
    if (!!sessionStorage.getItem('id')) {
      let id: number = parseInt(sessionStorage.getItem('id')!);
      this.utilisateurService.byIdWithAlbums(id).subscribe((result) => {
        this.utilisateur = result;
        console.log(this.utilisateur);
      });
    }
  }
}
