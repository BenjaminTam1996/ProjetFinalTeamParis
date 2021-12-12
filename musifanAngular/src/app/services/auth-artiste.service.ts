import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthArtisteService {
  constructor(private http: HttpClient, private router: Router) {}

  public canActivate(): boolean {
    if (sessionStorage.getItem('role') == 'artiste') {
      return true;
    } else {
      this.router.navigate(['/connexion'], { queryParams: { error: 'auth' } });
    }
    return false;
  }
}
