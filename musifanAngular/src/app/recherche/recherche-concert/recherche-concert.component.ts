import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recherche-concert',
  templateUrl: './recherche-concert.component.html',
  styleUrls: ['./recherche-concert.component.css'],
})
export class RechercheConcertComponent implements OnInit {
  navArtiste = true;
  constructor() {}

  ngOnInit(): void {
    if (sessionStorage.getItem('role') == 'artiste') {
      this.navArtiste = true;
    } else if (sessionStorage.getItem('role') == 'utilisateur') {
      this.navArtiste = false;
    }
  }
}
