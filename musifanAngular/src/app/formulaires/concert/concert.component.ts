import { ConcertService } from './../../services/concert.service';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Concert } from 'src/app/models/concert';

@Component({
  selector: 'app-concert',
  templateUrl: './concert.component.html',
  styleUrls: ['./concert.component.css'],
})
export class ConcertComponent implements OnInit {
  concertForm: FormGroup;
  nomControl: FormControl;
  dateControl: FormControl;
  placesControl: FormControl;
  prixControl: FormControl;
  lieuControl: FormControl;
  artistesControl: FormControl;

  constructor(private fb: FormBuilder, private concertService: ConcertService) {
    this.nomControl = this.fb.control('', [
      Validators.required,
      Validators.maxLength(200),
    ]);

    this.dateControl = this.fb.control('', [Validators.required]);

    this.placesControl = this.fb.control('', [
      Validators.required,
      //pattern ne permet que nombre
      Validators.pattern(/^[0-9]+$/),
      Validators.min(0),
    ]);

    this.prixControl = this.fb.control('', [
      Validators.required,
      //pattern ne permet que nombre avec décimal
      Validators.pattern(/^[1-9]\d*(\.\d+)?$/),
    ]);

    //Ajouter vérification pas déjà concert même date
    this.lieuControl = this.fb.control('');

    this.artistesControl = this.fb.control('');

    this.concertForm = this.fb.group({
      nomControl: this.nomControl,
      dateControl: this.dateControl,
      placesControl: this.placesControl,
      prixControl: this.prixControl,
      lieuControl: this.lieuControl,
      artistesControl: this.artistesControl,
    });
  }

  ngOnInit(): void {}

  save() {
    this.concertService
      .insert(
        new Concert(
          undefined,
          this.nomControl.value,
          this.dateControl.value,
          this.placesControl.value,
          this.prixControl.value,
          undefined,
          undefined
        )
      )
      .subscribe((result) => {});

    console.log(this.concertForm);
  }
}
