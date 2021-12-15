import { ArtisteService } from './../../services/artiste.service';
import { Component, OnInit } from '@angular/core';
import { Artiste } from 'src/app/models/artiste';
import { Observable } from 'rxjs';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-recherche-artiste',
  templateUrl: './recherche-artiste.component.html',
  styleUrls: ['./recherche-artiste.component.css'],
})
export class RechercheArtisteComponent implements OnInit {
  navArtiste = true;
  artistes: Artiste[] = [];
  chaine: string = '';

  constructor(private artisteService: ArtisteService) {}

  ngOnInit(): void {
    this.initArtistes();
    if (sessionStorage.getItem('role') == 'artiste') {
      this.navArtiste = true;
    } else if (sessionStorage.getItem('role') == 'utilisateur') {
      this.navArtiste = false;
    }
  }

  initArtistes() {
    this.artisteService.allArtistes().subscribe((result: Artiste[]) => {
      this.artistes = [];

      for (let value of result) {
        this.artistes.push(
          new Artiste(
            value['id'],
            undefined,
            undefined,
            undefined,
            value['nomArtiste']
          )
        );
      }
    });
  }

  /* Recherche de nom parmis les noms d'artistes'. */
  filtre(): Artiste[] {
    return this.artistes.filter((a) => {
      return a.nomArtiste!.indexOf(this.chaine) !== -1;
    });
  }
}
