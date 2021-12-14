import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Concert } from '../models/concert';

@Injectable({
  providedIn: 'root',
})
export class ConcertService {
  url: string = 'http://localhost:8080/musifan/api/concert';

  constructor(private http: HttpClient) {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
    });
  }

  public allConcerts(): Observable<any[]> {
    return this.http.get<any[]>(this.url, {
      headers: this.httpHeaders,
    });
  }

  public getById(id: number): Observable<Concert> {
    return this.http.get<Concert>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(this.url + '/' + id, { headers: this.httpHeaders });
  }

  public insert(concert: Concert): Observable<Concert> {
    // console.log(concert);
    const object = {
      nom: concert.nom,
      date: concert.date,
      nbPlace: concert.nbPlace,
      prix: concert.prix,
      lieu: concert.lieu,
      artistes: concert.artistes,
    };
    // console.log(object);
    return this.http.post<Concert>(this.url, object, {
      headers: this.httpHeaders,
    });
  }

  public update(concert: Concert): Observable<Concert> {
    // console.log(concert);
    return this.http.put<Concert>(this.url + '/' + concert.id, concert, {
      headers: this.httpHeaders,
    });
  }
}
