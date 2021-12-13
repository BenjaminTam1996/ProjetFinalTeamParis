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
