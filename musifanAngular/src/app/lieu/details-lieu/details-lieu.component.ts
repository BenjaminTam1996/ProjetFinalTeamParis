import { ActivatedRoute } from '@angular/router';
import { LieuService } from './../../services/lieu.service';
import { Lieu } from './../../models/lieu';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details-lieu',
  templateUrl: './details-lieu.component.html',
  styleUrls: ['./details-lieu.component.css'],
})
export class DetailsLieuComponent implements OnInit {
  lieu: Lieu = new Lieu();
  navArtiste = true;

  constructor(
    private lieuService: LieuService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.lieuService.getById(params['id']).subscribe((result) => {
          this.lieu = result;
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
