import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Album } from '../models/album';

@Injectable({
  providedIn: 'root',
})
export class AlbumService {
  url: string = 'http://localhost:8080/musifan/api/album';

  constructor(private http: HttpClient) {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
    });
  }

  public allAlbums(): Observable<Album[]> {
    return this.http.get<Album[]>(this.url);
  }

  public getById(id: number): Observable<Album> {
    return this.http.get<Album>(this.url + '/' + id, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(this.url + '/' + id, { headers: this.httpHeaders });
  }

  public insert(album: Album): Observable<Album> {
    // console.log(album;
    const lignesAlbums: any[] = [];
    const object = {
      titre: album.titre,
      date: album.date,
      photo: album.photo,
      chansons: album.chansons,
      artistes: album.artistes,
    };
    // console.log(object);
    return this.http.post<Album>(this.url, object, {
      headers: this.httpHeaders,
    });
  }
}
