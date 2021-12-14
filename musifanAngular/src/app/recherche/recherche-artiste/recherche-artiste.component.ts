import { ArtisteService } from './../../services/artiste.service';
import { Component, OnInit } from '@angular/core';
import { Artiste } from 'src/app/models/artiste';
import { Observable } from 'rxjs';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-recherche-artiste',
  templateUrl: './recherche-artiste.component.html',
  styleUrls: ['./recherche-artiste.component.css'],
})
export class RechercheArtisteComponent implements OnInit {
  artistesTrouvés: Observable<Artiste[]> | undefined = undefined;
  trouve: boolean = false;
  navArtiste = true;
  rechercheForm: FormGroup;
  rechercheControl: FormControl;

  constructor(private fb: FormBuilder, private artisteService: ArtisteService) {
    this.rechercheControl = this.fb.control('', [Validators.required]);
    this.rechercheForm = this.fb.group({
      rechercheControl: this.rechercheControl,
    });
  }

  ngOnInit(): void {
    this.trouve = false;
    if (sessionStorage.getItem('role') == 'artiste') {
      this.navArtiste = true;
    } else if (sessionStorage.getItem('role') == 'utilisateur') {
      this.navArtiste = false;
    }
  }

  click(): void {
    this.artisteService
      .searchArtistes(this.rechercheControl.value)
      .subscribe((result) => {
        // this.artistesTrouvés = result;
      });
    // if (this.artistesTrouvés[0] != 0) {
    //   this.trouve = true;
    // }
  }
}
