import { Album } from './../../models/album';
import { ActivatedRoute } from '@angular/router';
import { AlbumService } from './../../services/album.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details-album',
  templateUrl: './details-album.component.html',
  styleUrls: ['./details-album.component.css'],
})
export class DetailsAlbumComponent implements OnInit {
  album: Album = new Album();
  navArtiste = true;

  constructor(
    private albumService: AlbumService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.albumService.getById(params['id']).subscribe((result) => {
          this.album = result;
        });
      }
    });

    if (sessionStorage.getItem('role') == 'artiste') {
      this.navArtiste = true;
    } else if (sessionStorage.getItem('role') == 'utilisateur') {
      this.navArtiste = false;
    }
  }
}
