import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Utilisateur } from './../models/utilisateur';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private static url: string = 'http://localhost:8080/musifan/api/utilisateur';

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
      'http://localhost:8080/musifan/api/utilisateur/login/' + login
    );
  }

  public byId(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(`${UtilisateurService.url}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  /* Remonte un utilisateur, par rapport a son id, avec sa liste d'artiste */
  public byIdWithArtiste(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.url + '/artistes/' + id,
      { headers: this.httpHeaders }
    );
  }

  /* Remonte un utilisateur, par rapport a son id, avec les publications de ses artistes */
  public byIdWithPublicationArtiste(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.url + '/publications/' + id,
      { headers: this.httpHeaders }
    );
  }

  /* Remonte un utilisateur, par rapport a son id, avec ses commandes */
  public byIdWithCommande(id: number): Observable<any> {
    return this.http.get<Utilisateur>(
      UtilisateurService.url + '/commandes/' + id,
      { headers: this.httpHeaders }
    );
  }

  public byIdWithAlbums(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(
      UtilisateurService.url + '/albums/' + id,
      { headers: this.httpHeaders }
    );
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${UtilisateurService.url}/${id}`, {
      headers: this.httpHeaders,
    });
  }

  public insert(
    utilisateur: Utilisateur,
    password: string
  ): Observable<Utilisateur> {
    const o = {
      mail: utilisateur.mail,
      nom: utilisateur.nom,
      prenom: utilisateur.prenom,
      pseudo: utilisateur.pseudo,
      password: password,
      telephone: utilisateur.telephone,
      photoProfil: utilisateur.photoProfil,
    };
    return this.http.post<Utilisateur>(UtilisateurService.url, o);
  }

  public update(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.http.put<Utilisateur>(
      `${UtilisateurService.url}/${utilisateur.id}`,
      utilisateur,
      { headers: this.httpHeaders }
    );
  }

  public updateArtiste(
    idUtilisateur: number,
    idArtiste: number
  ): Observable<Utilisateur> {
    const o = {
      ligneUtilisateur: [
        {
          id: {
            artiste: {
              id: idArtiste,
            },
          },
        },
      ],
    };
    return this.http.put<Utilisateur>(
      UtilisateurService.url + '/artistes/' + idUtilisateur,
      o,
      { headers: this.httpHeaders }
    );
  }
}
