import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService implements CanActivate {
  constructor(private http: HttpClient, private router: Router) {}

  public canActivate(): boolean {
    if (!!sessionStorage.getItem('token')) {
      return true;
    } else {
      this.router.navigate(['/connexion'], { queryParams: { error: 'auth' } });
    }
    return false;
  }

  /* S'authentifier */
  public auth(mail: string, password: string): Observable<any> {
    const httpHeaders: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(mail + ':' + password),
      'Content-Type': 'application/json',
    });
    return this.http.get('http://localhost:8080/musifan/api/auth', {
      headers: httpHeaders,
    });
  }
}
