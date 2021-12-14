import { Observable } from 'rxjs';
import { AuthService } from './../../services/auth.service';
import { ArtisteService } from './../../services/artiste.service';
import { Artiste } from './../../models/artiste';
import { UtilisateurService } from './../../services/utilisateur.service';
import { Role } from './../../models/role';
import {
  FormGroup,
  FormControl,
  Validators,
  AbstractControl,
  ValidationErrors,
  Form,
  AsyncValidatorFn,
} from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Utilisateur } from 'src/app/models/utilisateur';
import { Router } from '@angular/router';
import { debounceTime, map } from 'rxjs/operators';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css'],
})
export class SigninComponent implements OnInit {
  roles = Role;
  form: FormGroup;

  constructor(
    private utilisateurService: UtilisateurService,
    private artisteService: ArtisteService,
    private authService: AuthService,
    private router: Router
  ) {
    this.form = new FormGroup({
      role: new FormControl('', [Validators.required]),
      prenom: new FormControl('', [
        Validators.required,
        Validators.pattern(/^[a-zA-Z]{1,}((\s|-)[a-zA-Z]{2,})*$/),
        Validators.maxLength(200),
      ]),
      nom: new FormControl('', [
        Validators.required,
        Validators.pattern(/^[a-zA-Z]{1,}((\s|-)[a-zA-Z]{2,})*$/),
        Validators.maxLength(200),
      ]),
      pseudo: new FormControl('', [Validators.required]),
      nomArtiste: new FormControl('', [Validators.required]),
      telephone: new FormControl('', [
        Validators.required,
        Validators.pattern(
          /^(?:0|\(?\+33\)?\s?|0033\s?)[1-79](?:[\.\-\s]?\d\d){4}$/
        ),
      ]),
      email: new FormControl(
        '',
        [
          Validators.required,
          Validators.pattern(
            /[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]{2,4}$/
          ),
        ],
        this.checkLogin()
      ),
      description: new FormControl(''),
      passwordGroup: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(
              /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@#_-])([a-zA-Z0-9$@#_-]{5,25})$/
            ),
          ]),
          confirm: new FormControl(''),
        },
        this.checkNotEquals
      ),
    });
  }

  ngOnInit(): void {}

  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      if (this.form.controls['role'].value == 'UTILISATEUR') {
        return this.utilisateurService.checkLogin(control.value).pipe(
          /* Une seconde avant traitement */
          debounceTime(1000),
          map((res: boolean) => {
            return res ? { loginUsed: true } : null;
          })
        );
      }
      return this.artisteService.checkLogin(control.value).pipe(
        /* Une seconde avant traitement */
        debounceTime(1000),
        map((res: boolean) => {
          return res ? { loginUsed: true } : null;
        })
      );
    };
  }

  /* Verification que le mot de passe est le meme que le mot de passe de confirmation */
  checkNotEquals(group: AbstractControl): ValidationErrors | null {
    let formGroup: FormGroup = group as FormGroup;
    if (formGroup.controls['password'].errors) {
      return null;
    }
    return formGroup.controls['password'].value !=
      formGroup.controls['confirm'].value
      ? { checkNotEquals: true }
      : null;
  }

  /* Adapation du message d'erreur renvoye en fonction de l'erreur */
  prenomErrorMessage() {
    if (this.form.get('prenom')!.hasError('required')) {
      return 'prenom obligatoire';
    } else if (this.form.get('prenom')!.hasError('pattern')) {
      return 'Le prénom ne peut contenir uniquement des lettres avec espace ou - pour les prenoms composés';
    }
    return 'maximun 200 caractères';
  }

  nomErrorMessage() {
    if (this.form.get('nom')!.hasError('required')) {
      return 'nom obligatoire';
    } else if (this.form.get('nom')!.hasError('pattern')) {
      return 'Le nom ne peut contenir uniquement des lettres avec espace ou - pour les noms composés';
    }
    return 'maximun 200 caractères';
  }

  pseudoErrorMessage() {
    if (this.form.get('pseudo')!.hasError('required')) {
      return 'pseudo obligatoire';
    }
    return 'Erreur dans le pseudo';
  }

  nomArtisteErrorMessage() {
    if (this.form.get('nomArtiste')!.hasError('required')) {
      return "nom d'artiste obligatoire";
    }
    return "Erreur dans le nom d'artiste";
  }

  telephoneErrorMessage() {
    if (this.form.get('telephone')!.hasError('required')) {
      return 'telephone obligatoire';
    } else if (this.form.get('telephone')!.hasError('pattern')) {
      return 'Veuillez entrer un numéro de telephone';
    }
    return 'Erreur dans le telephone';
  }

  emailErrorMessage() {
    if (this.form.get('email')!.hasError('required')) {
      return 'Email obligatoire';
    } else if (this.form.get('email')!.hasError('pattern')) {
      return 'Veuillez entrer un email';
    } else if (this.form.get('email')!.hasError('loginUsed')) {
      return "L'email existe déjà";
    }
    return "Erreur dans l'email";
  }

  passwordErrorMessage() {
    if (this.form.get('passwordGroup.password')!.hasError('required')) {
      return 'mot de passe obligatoire';
    } else if (this.form.get('passwordGroup.password')!.hasError('pattern')) {
      return 'Le mot de passe doit contenir au moins 5 caratères dont une majuscule, une minuscule, un chiffre et un caractère special : $@#_-';
    }
    return 'Erreur dans le mot de passe';
  }

  /* Creation du compte */
  save() {
    if (this.form.controls['role'].value == 'UTILISATEUR') {
      this.utilisateurService
        .insert(
          new Utilisateur(
            undefined,
            this.form.controls['email'].value,
            this.form.controls['nom'].value,
            this.form.controls['prenom'].value,
            this.form.controls['pseudo'].value,
            this.form.controls['telephone'].value
          ),
          this.form.get('passwordGroup.password')!.value
        )
        .subscribe((utilisateur) => {
          /* Authentification pour eviter la reconnexion de l'utilisateur */
          sessionStorage.setItem('id', String(utilisateur['id']));
          sessionStorage.setItem('role', 'utilisateur');

          sessionStorage.setItem(
            'token',
            btoa(
              this.form.controls['email'].value +
                ':' +
                this.form.get('passwordGroup.password')!.value
            )
          );
          sessionStorage.setItem('email', this.form.controls['email'].value);

          /* Renvoie vers la page utilisateur */
          this.router.navigate(['/utilisateur']);
        });
    } else if (this.form.controls['role'].value == 'ARTISTE') {
      this.artisteService
        .insert(
          new Artiste(
            undefined,
            this.form.controls['email'].value,
            this.form.controls['nom'].value,
            this.form.controls['prenom'].value,
            this.form.controls['nomArtiste'].value,
            this.form.controls['telephone'].value,
            this.form.controls['description'].value
          ),
          this.form.get('passwordGroup.password')!.value
        )
        .subscribe((artiste) => {
          console.log(artiste);
          console.log(artiste['id']);
          /* Authentification pour eviter la reconnexion de l'utilisateur  */
          sessionStorage.setItem('id', String(artiste['id']));
          sessionStorage.setItem('role', 'artiste');

          sessionStorage.setItem(
            'token',
            btoa(
              this.form.controls['email'].value +
                ':' +
                this.form.get('passwordGroup.password')!.value
            )
          );
          sessionStorage.setItem('email', this.form.controls['email'].value);

          /* Envoie vers la page artiste */
          this.router.navigate(['/artiste']);
        });
    }
  }
}
