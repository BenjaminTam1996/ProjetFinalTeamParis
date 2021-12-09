import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Commande } from "../models/commande";

@Injectable({
  providedIn: "root",
})
export class CommandeService {
  url: string = "http://localhost:8080/musifan/api/commande";
  constructor(private http: HttpClient) {}

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: "Basic " + sessionStorage.getItem("token"),
      "Content-Type": "application/json",
    });
  }

  public allConcerts(): Observable<Commande[]> {
    return this.http.get<Commande[]>(this.url);
  }

  public getById(id: number): Observable<Commande> {
    return this.http.get<Commande>(this.url + "/" + id, {
      headers: this.httpHeaders,
    });
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(this.url + "/" + id, { headers: this.httpHeaders });
  }

  public insert(commande: Commande): Observable<Commande> {
    const object = {
      date: commande.date,
      utilisateur: commande.utilisateur,
      concert: commande.concert,
    };
    return this.http.post<Commande>(this.url, object, {
      headers: this.httpHeaders,
    });
  }
}
