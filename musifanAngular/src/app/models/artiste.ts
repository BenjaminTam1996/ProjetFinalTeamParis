import { Album } from "./album";
import { Publication } from "./publication";
import { Concert } from "./concert";
import { Byte } from "@angular/compiler/src/util";

export class Artiste {
  public constructor(
    private _id?: number | undefined,
    private _mail?: string | undefined,
    private _nom?: string | undefined,
    private _prenom?: string | undefined,
    private _nomArtiste?: string | undefined,
    private _telephone?: string | undefined,
    private _description?: string | undefined,
    private _publications?: Publication[] | undefined,
    private _albums?: Album[] | undefined,
    private _concerts?: Concert[] | undefined,
    private _photoProfil?: Byte[] | undefined,
    private _photoBanniere?: Byte[] | undefined
  ) {}

  /**
   * Getter id
   * @return {number | undefined}
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter mail
   * @return {string | undefined}
   */
  public get mail(): string | undefined {
    return this._mail;
  }

  /**
   * Getter nom
   * @return {string | undefined}
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Getter prenom
   * @return {string | undefined}
   */
  public get prenom(): string | undefined {
    return this._prenom;
  }

  /**
   * Getter nomArtiste
   * @return {string | undefined}
   */
  public get nomArtiste(): string | undefined {
    return this._nomArtiste;
  }

  /**
   * Getter telephone
   * @return {string | undefined}
   */
  public get telephone(): string | undefined {
    return this._telephone;
  }

  /**
   * Getter description
   * @return {string | undefined}
   */
  public get description(): string | undefined {
    return this._description;
  }

  /**
   * Getter publications
   * @return {Publication[] | undefined}
   */
  public get publications(): Publication[] | undefined {
    return this._publications;
  }

  /**
   * Getter albums
   * @return {Album[] | undefined}
   */
  public get albums(): Album[] | undefined {
    return this._albums;
  }

  /**
   * Getter concerts
   * @return {Concert[] | undefined}
   */
  public get concerts(): Concert[] | undefined {
    return this._concerts;
  }

  /**
   * Getter photoProfil
   * @return {Byte[] | undefined}
   */
  public get photoProfil(): Byte[] | undefined {
    return this._photoProfil;
  }

  /**
   * Getter photoBanniere
   * @return {Byte[] | undefined}
   */
  public get photoBanniere(): Byte[] | undefined {
    return this._photoBanniere;
  }

  /**
   * Setter id
   * @param {number | undefined} value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter mail
   * @param {string | undefined} value
   */
  public set mail(value: string | undefined) {
    this._mail = value;
  }

  /**
   * Setter nom
   * @param {string | undefined} value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Setter prenom
   * @param {string | undefined} value
   */
  public set prenom(value: string | undefined) {
    this._prenom = value;
  }

  /**
   * Setter nomArtiste
   * @param {string | undefined} value
   */
  public set nomArtiste(value: string | undefined) {
    this._nomArtiste = value;
  }

  /**
   * Setter telephone
   * @param {string | undefined} value
   */
  public set telephone(value: string | undefined) {
    this._telephone = value;
  }

  /**
   * Setter description
   * @param {string | undefined} value
   */
  public set description(value: string | undefined) {
    this._description = value;
  }

  /**
   * Setter publications
   * @param {Publication[] | undefined} value
   */
  public set publications(value: Publication[] | undefined) {
    this._publications = value;
  }

  /**
   * Setter albums
   * @param {Album[] | undefined} value
   */
  public set albums(value: Album[] | undefined) {
    this._albums = value;
  }

  /**
   * Setter concerts
   * @param {Concert[] | undefined} value
   */
  public set concerts(value: Concert[] | undefined) {
    this._concerts = value;
  }

  /**
   * Setter photoProfil
   * @param {Byte[] | undefined} value
   */
  public set photoProfil(value: Byte[] | undefined) {
    this._photoProfil = value;
  }

  /**
   * Setter photoBanniere
   * @param {Byte[] | undefined} value
   */
  public set photoBanniere(value: Byte[] | undefined) {
    this._photoBanniere = value;
  }
}
