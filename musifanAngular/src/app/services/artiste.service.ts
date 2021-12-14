import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Artiste } from './../models/artiste';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ArtisteService {
  private static url: string = 'http://localhost:8080/musifan/api/artiste';

  constructor(private http: HttpClient) {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
    });
  }

  /* Verification que le login n'est pas deja en base  */
  public checkLogin(login: string): Observable<boolean> {
    return this.http.get<boolean>(
      'http://localhost:8080/musifan/api/artiste/login/' + login
    );
  }

  public allArtistes(): Observable<Artiste[]> {
    return this.http.get<Artiste[]>(ArtisteService.url, {
      headers: this.httpHeaders,
    });
  }

  public byId(id: number): Observable<Artiste> {
    return this.http.get<Artiste>(`${ArtisteService.url}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${ArtisteService.url}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public insert(artiste: Artiste, password: string): Observable<Artiste> {
    const o = {
      mail: artiste.mail,
      nom: artiste.nom,
      prenom: artiste.prenom,
      nomArtiste: artiste.nomArtiste,
      password: password,
      telephone: artiste.telephone,
      description: artiste.description,
      photoProfil: artiste.photoProfil,
      photoBanniere: artiste.photoBanniere,
    };
    return this.http.post<Artiste>(ArtisteService.url, o);
  }

  public update(artiste: Artiste): Observable<Artiste> {
    return this.http.put<Artiste>(
      `${ArtisteService.url}/${artiste.id}`,
      artiste,
      { headers: this.httpHeaders }
    );
  }
}
