import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Concert } from '../models/concert';
import { Lieu } from '../models/lieu';

@Injectable({
  providedIn: 'root',
})
export class LieuService {
  url: string = 'http://localhost:8080/musifan/api/lieu';

  constructor(private http: HttpClient) {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
    });
  }

  public allLieux(): Observable<Lieu[]> {
    return this.http.get<Lieu[]>(this.url);
  }

  public getById(id: number): Observable<Lieu> {
    return this.http.get<Lieu>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(this.url + '/' + id, { headers: this.httpHeaders });
  }

  public insert(lieu: Lieu): Observable<Lieu> {
    // console.log(lieu);
    const object = {
      nom: lieu.nom,
      numRue: lieu.numRue,
      rue: lieu.rue,
      codePostal: lieu.codePostal,
      ville: lieu.ville,
      pays: lieu.pays,
      listeConcerts: lieu.listeConcerts,
    };
    // console.log(object);
    return this.http.post<Lieu>(this.url, object, {
      headers: this.httpHeaders,
    });
  }
}
