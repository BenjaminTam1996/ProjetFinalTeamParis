import { ActivatedRoute } from '@angular/router';
import { ArtisteService } from './../../services/artiste.service';
import { Component, OnInit } from '@angular/core';
import { Artiste } from 'src/app/models/artiste';

@Component({
  selector: 'app-artiste',
  templateUrl: './artiste.component.html',
  styleUrls: ['./artiste.component.css'],
})
export class ArtisteComponent implements OnInit {
  artiste: Artiste = new Artiste();
  navArtiste = true;

  constructor(
    private artisteService: ArtisteService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    console.log(sessionStorage.getItem('role'));
    if (
      !!sessionStorage.getItem('id') &&
      sessionStorage.getItem('role') == 'artiste'
    ) {
      let id: number = parseInt(sessionStorage.getItem('id')!);
      this.artisteService.byId(id).subscribe((result) => {
        this.artiste = result;
        console.log(this.artiste);
        this.navArtiste = true;
      });
    } else if (sessionStorage.getItem('role') == 'utilisateur') {
      this.activatedRoute.params.subscribe((params) => {
        if (!!params['id']) {
          this.artisteService.byId(params['id']).subscribe((result) => {
            this.artiste = result;
            console.log(this.artiste);
            this.navArtiste = false;
          });
        }
      });
    }
  }
}
