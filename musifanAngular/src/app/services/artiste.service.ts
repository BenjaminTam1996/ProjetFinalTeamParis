import { HttpClient } from '@angular/common/http';
import { Artiste } from './../models/artiste';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ArtisteService {
  private static url: string = 'http://localhost:8080/musifan/api/artiste';

  constructor(private http: HttpClient) {}

  public allArtistes(): Observable<Artiste[]> {
    return this.http.get<Artiste[]>(ArtisteService.url);
  }

  public byId(id: number): Observable<Artiste> {
    return this.http.get<Artiste>(`${ArtisteService.url}/${id}`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${ArtisteService.url}/${id}`);
  }

  public insert(artiste: Artiste, password: string): Observable<Artiste> {
    const o = {
      mail: artiste.mail,
      nom: artiste.nom,
      prenom: artiste.prenom,
      nomArtiste: artiste.nomArtiste,
      telephone: artiste.telephone,
      description: artiste.description,
      publications: {},
      lignesAlbums: {},
      ligneConcerts: {},
      photoProfil: artiste.photoProfil,
      photoBanniere: artiste.photoBanniere,
    };
    return this.http.post<Artiste>(ArtisteService.url, o);
  }

  public update(artiste: Artiste): Observable<Artiste> {
    return this.http.put<Artiste>(
      `${ArtisteService.url}/${artiste.id}`,
      artiste
    );
  }
}
