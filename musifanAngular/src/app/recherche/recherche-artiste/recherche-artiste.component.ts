import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recherche-artiste',
  templateUrl: './recherche-artiste.component.html',
  styleUrls: ['./recherche-artiste.component.css'],
})
export class RechercheArtisteComponent implements OnInit {
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
