import { ConcertService } from './../../services/concert.service';
import { ArtisteService } from './../../services/artiste.service';
import { Component, OnInit } from '@angular/core';
import { Concert } from 'src/app/models/concert';
import { ActivatedRoute } from '@angular/router';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-details-concert',
  templateUrl: './details-concert.component.html',
  styleUrls: ['./details-concert.component.css'],
})
export class DetailsConcertComponent implements OnInit {
  concert: Concert = new Concert();
  navArtiste = true;
  concertComplet = false;

  constructor(
    private concertService: ConcertService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.concertService.getById(params['id']).subscribe((result) => {
          this.concert = result;
          console.log(this.concert);
        });
      }
    });

    if (this.concert.nbPlace == 0) {
      this.concertComplet = true;
    }

    if (sessionStorage.getItem('role') == 'artiste') {
      this.navArtiste = true;
    } else if (sessionStorage.getItem('role') == 'utilisateur') {
      this.navArtiste = false;
    }
  }
}
