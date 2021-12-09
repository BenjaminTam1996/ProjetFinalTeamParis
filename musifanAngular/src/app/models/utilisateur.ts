import { Artiste } from './artiste';
import { Concert } from './concert';
import { Byte } from '@angular/compiler/src/util';

export class Utilisateur {
  public constructor(
    private _id?: number | undefined,
    private _mail?: string | undefined,
    private _nom?: string | undefined,
    private _prenom?: string | undefined,
    private _pseudo?: string | undefined,
    private _telephone?: string | undefined,
    private _artistes?: Artiste[] | undefined,
    private _concerts?: Concert[] | undefined,
    private _photoProfil?: Byte[] | undefined
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
   * @return {string | undefined }
   */
  public get prenom(): string | undefined {
    return this._prenom;
  }

  /**
   * Getter pseudo
   * @return {string | undefined}
   */
  public get pseudo(): string | undefined {
    return this._pseudo;
  }

  /**
   * Getter telephone
   * @return {string | undefined}
   */
  public get telephone(): string | undefined {
    return this._telephone;
  }

  /**
   * Getter photoProfil
   * @return {Byte[] | undefined}
   */
  public get photoProfil(): Byte[] | undefined {
    return this._photoProfil;
  }

  /**
   * Getter artistes
   * @return {Artiste[] | undefined }
   */
  public get artistes(): Artiste[] | undefined {
    return this._artistes;
  }

  /**
   * Getter concerts
   * @return {Concert[] | undefined }
   */
  public get concerts(): Concert[] | undefined {
    return this._concerts;
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
   * Setter pseudo
   * @param {string | undefined} value
   */
  public set pseudo(value: string | undefined) {
    this._pseudo = value;
  }

  /**
   * Setter telephone
   * @param {string | undefined} value
   */
  public set telephone(value: string | undefined) {
    this._telephone = value;
  }

  /**
   * Setter photoProfil
   * @param {Byte[] | undefined} value
   */
  public set photoProfil(value: Byte[] | undefined) {
    this._photoProfil = value;
  }

  /**
   * Setter artistes
   * @param {Artiste[] | undefined} value
   */
  public set artistes(value: Artiste[] | undefined) {
    this._artistes = value;
  }

  /**
   * Setter concerts
   * @param {Concert[] | undefined} value
   */
  public set concerts(value: Concert[] | undefined) {
    this._concerts = value;
  }
}
