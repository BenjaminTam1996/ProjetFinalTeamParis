import { AuthService } from './../../services/auth.service';
import { UtilisateurService } from './../../services/utilisateur.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  form: FormGroup;
  showMessage = false;
  message = '';

  constructor(
    private authService: AuthService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    /* Creation du formulaire pilote par le code */
    this.form = new FormGroup({
      email: new FormControl('', [
        Validators.required,
        Validators.pattern(/[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]{2,4}$/),
      ]),
      password: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
    console.log(this.form);
    /* Renvoie vers le formulaire de connexion, si l'utilisateur essaye de se connecter sur une page alors qu'il n'a pas l'autorisation ou qu'il n'est pas connecte*/
    this.activatedRoute.queryParams.subscribe((params) => {
      if (!!params['error']) {
        if (params['error']) {
          this.message = 'authentification requise';
          this.showMessage = true;
        }
      }
    });
  }

  /* Adapation du message d'erreur renvoye en fonction de l'erreur : */
  emailErrorMessage() {
    if (this.form.get('email')!.hasError('required')) {
      return 'Email obligatoire';
    } else if (this.form.get('email')!.hasError('pattern')) {
      return 'Veuillez entrer un email';
    }
    return "Erreur dans l'email";
  }

  passwordErrorMessage() {
    if (this.form.get('password')!.hasError('required')) {
      return 'mot de passe obligatoire';
    }
    return 'Erreur dans le mot de passe';
  }

  /* Verification de l'authentification */
  check() {
    this.authService
      .auth(
        this.form.controls['email'].value,
        this.form.controls['password'].value
      )
      .subscribe(
        (ok) => {
          this.showMessage = false;

          sessionStorage.setItem(
            'token',
            btoa(
              this.form.controls['email'].value +
                ':' +
                this.form.controls['password'].value
            )
          );

          sessionStorage.setItem('email', this.form.controls['email'].value);

          /* Si on a un utilisateur, on a un attribut pseudo */
          if (!!ok['pseudo']) {
            sessionStorage.setItem('role', 'utilisateur');
            this.router.navigate(['/utilisateur']);
          } else if (!!ok['nomArtiste']) {
            /* Sinon, si on a un artiste, on a un attribut nomArtiste */
            sessionStorage.setItem('role', 'artiste');
            this.router.navigate(['/artiste']);
          }
        },
        (error) => {
          this.message = 'Votre mail ou mot de passe est incorrect';
          this.showMessage = true;
        }
      );
  }
}
