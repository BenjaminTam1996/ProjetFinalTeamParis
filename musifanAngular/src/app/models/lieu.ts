import { Concert } from './concert';

export class Lieu {
  public constructor(
    private _id?: number | undefined,
    private _nom?: string | undefined,
    private _numRue?: string | undefined,
    private _rue?: string | undefined,
    private _codePostal?: string | undefined,
    private _ville?: string | undefined,
    private _pays?: string | undefined,
    private _concerts?: Concert[] | undefined
  ) {}

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number {
    return this._id;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Getter numRue
   * @return {string }
   */
  public get numRue(): string {
    return this._numRue;
  }

  /**
   * Setter numRue
   * @param {string } value
   */
  public set numRue(value: string) {
    this._numRue = value;
  }

  /**
   * Getter rue
   * @return {string }
   */
  public get rue(): string {
    return this._rue;
  }

  /**
   * Setter rue
   * @param {string } value
   */
  public set rue(value: string) {
    this._rue = value;
  }

  /**
   * Getter codePostal
   * @return {string }
   */
  public get codePostal(): string {
    return this._codePostal;
  }

  /**
   * Setter codePostal
   * @param {string } value
   */
  public set codePostal(value: string) {
    this._codePostal = value;
  }

  /**
   * Getter ville
   * @return {string }
   */
  public get ville(): string {
    return this._ville;
  }

  /**
   * Setter ville
   * @param {string } value
   */
  public set ville(value: string) {
    this._ville = value;
  }

  /**
   * Getter pays
   * @return {string }
   */
  public get pays(): string {
    return this._pays;
  }

  /**
   * Setter pays
   * @param {string } value
   */
  public set pays(value: string) {
    this._pays = value;
  }

  /**
   * Getter concerts
   * @return {Concert[] }
   */
  public get concerts(): Concert[] {
    return this._concerts;
  }

  /**
   * Setter concerts
   * @param {Concert[] } value
   */
  public set concerts(value: Concert[]) {
    this._concerts = value;
  }
}
