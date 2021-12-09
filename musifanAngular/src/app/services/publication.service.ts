import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Publication } from "../models/publication";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class PublicationService {
  url: string = "http://localhost:8080/musifan/api/publication";

  constructor(private http: HttpClient) {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: "Basic " + sessionStorage.getItem("token"),
      "Content-Type": "application/json",
    });
  }

  public allpublication(): Observable<Publication[]> {
    return this.http.get<Publication[]>(this.url);
  }

  public getById(id: number): Observable<Publication> {
    return this.http.get<Publication>(this.url + "/" + id, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(this.url + "/" + id, { headers: this.httpHeaders });
  }

  public insert(publication: Publication): Observable<Publication> {
    const object = {
      nom: publication.description,
      photo: publication.photo,
      date: publication.date,
      artiste: publication.artiste,
    };
    return this.http.post<Publication>(this.url, object, {
      headers: this.httpHeaders,
    });
  }
}
