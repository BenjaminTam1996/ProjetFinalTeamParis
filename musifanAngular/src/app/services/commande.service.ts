import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class CommandeService {
  url: string = "http://localhost:8080/musifan/api/commande";
  constructor() {}
}
