import { Artiste } from './artiste';
import { Lieu } from './lieu';

export class Concert {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _date?: Date | undefined,
    private _nbPlace?: number | undefined,
    private _prix?: number | undefined,
    private _lieu?: Lieu | undefined,
    private _artistes?: Artiste[] | undefined
  ) {}

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string | undefined {
    return this._nom;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string | undefined) {
    this._nom = value;
  }

  /**
   * Getter date
   * @return {Date }
   */
  public get date(): Date | undefined {
    return this._date;
  }

  /**
   * Setter date
   * @param {Date } value
   */
  public set date(value: Date | undefined) {
    this._date = value;
  }

  /**
   * Getter nbPlace
   * @return {number }
   */
  public get nbPlace(): number | undefined {
    return this._nbPlace;
  }

  /**
   * Setter nbPlace
   * @param {number } value
   */
  public set nbPlace(value: number | undefined) {
    this._nbPlace = value;
  }

  /**
   * Getter prix
   * @return {number }
   */
  public get prix(): number | undefined {
    return this._prix;
  }

  /**
   * Setter prix
   * @param {number } value
   */
  public set prix(value: number | undefined) {
    this._prix = value;
  }

  /**
   * Getter lieu
   * @return {Lieu }
   */
  public get lieu(): Lieu | undefined {
    return this._lieu;
  }

  /**
   * Setter lieu
   * @param {Lieu } value
   */
  public set lieu(value: Lieu | undefined) {
    this._lieu = value;
  }

  /**
   * Getter artistes
   * @return {Artiste[] }
   */
  public get artistes(): Artiste[] | undefined {
    return this._artistes;
  }

  /**
   * Setter artistes
   * @param {Artiste[] } value
   */
  public set artistes(value: Artiste[] | undefined) {
    this._artistes = value;
  }
}
