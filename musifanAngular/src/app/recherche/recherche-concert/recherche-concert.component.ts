import { ConcertService } from './../../services/concert.service';
import { Concert } from 'src/app/models/concert';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recherche-concert',
  templateUrl: './recherche-concert.component.html',
  styleUrls: ['./recherche-concert.component.css'],
})
export class RechercheConcertComponent implements OnInit {
  navArtiste = true;

  concerts: Concert[] = [];
  chaine: string = '';
  constructor(private concertService: ConcertService) {}

  ngOnInit(): void {
    this.initConcerts();
    console.log(this.concerts);
    if (sessionStorage.getItem('role') == 'artiste') {
      this.navArtiste = true;
    } else if (sessionStorage.getItem('role') == 'utilisateur') {
      this.navArtiste = false;
    }
  }

  initConcerts() {
    this.concertService.allConcerts().subscribe((result: any[]) => {
      this.concerts = [];

      for (let value of result) {
        this.concerts.push(
          new Concert(
            value['id'],
            value['nom'],
            value['nbPlace'],
            value['prix']
          )
        );
      }
    });
  }

  /* Recherche de nom parmis les noms de concert. */
  filtre(): Concert[] {
    return this.concerts.filter((c) => {
      return c.nom!.indexOf(this.chaine) !== -1;
    });
  }
}
