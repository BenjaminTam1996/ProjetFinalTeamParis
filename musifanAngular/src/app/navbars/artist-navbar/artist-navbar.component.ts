import { ArtisteService } from './../../services/artiste.service';
import { Artiste } from './../../models/artiste';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-artist-navbar',
  templateUrl: './artist-navbar.component.html',
  styleUrls: ['./artist-navbar.component.css'],
})
export class ArtistNavbarComponent implements OnInit {
  artiste: Artiste = new Artiste();

  constructor(private artisteService: ArtisteService) {}

  ngOnInit(): void {
    if (!!sessionStorage.getItem('id')) {
      let id: number = parseInt(sessionStorage.getItem('id')!);
      this.artisteService.byId(id).subscribe((result) => {
        this.artiste = result;
      });
    }
  }
}
