import { ArtisteService } from './../../services/artiste.service';
import { Artiste } from './../../models/artiste';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-artist-navbar',
  templateUrl: './artist-navbar.component.html',
  styleUrls: ['./artist-navbar.component.css'],
})
export class ArtistNavbarComponent implements OnInit {
  artiste: Artiste = new Artiste();

  constructor(private artisteService: ArtisteService, private router: Router) {}

  ngOnInit(): void {
    if (!!sessionStorage.getItem('id')) {
      let id: number = parseInt(sessionStorage.getItem('id')!);
      this.artisteService.byId(id).subscribe((result) => {
        this.artiste = result;
      });
    }
  }

  logout() {
    sessionStorage.clear();
    this.router.navigate(['/accueil']);
  }
}
