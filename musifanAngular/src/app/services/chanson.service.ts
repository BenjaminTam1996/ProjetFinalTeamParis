import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Chanson } from '../models/chanson';

@Injectable({
  providedIn: 'root',
})
export class ChansonService {
  url: string = 'http://localhost:8080/musifan/api/chansons';

  constructor(private http: HttpClient) {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
    });
  }

  public allChansons(): Observable<Chanson[]> {
    return this.http.get<Chanson[]>(this.url);
  }

  public getById(id: number): Observable<Chanson> {
    return this.http.get<Chanson>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }
}
