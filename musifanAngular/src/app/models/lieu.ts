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
   * Getter numRue
   * @return {string }
   */
  public get numRue(): string | undefined {
    return this._numRue;
  }

  /**
   * Setter numRue
   * @param {string } value
   */
  public set numRue(value: string | undefined) {
    this._numRue = value;
  }

  /**
   * Getter rue
   * @return {string }
   */
  public get rue(): string | undefined {
    return this._rue;
  }

  /**
   * Setter rue
   * @param {string } value
   */
  public set rue(value: string | undefined) {
    this._rue = value;
  }

  /**
   * Getter codePostal
   * @return {string }
   */
  public get codePostal(): string | undefined {
    return this._codePostal;
  }

  /**
   * Setter codePostal
   * @param {string } value
   */
  public set codePostal(value: string | undefined) {
    this._codePostal = value;
  }

  /**
   * Getter ville
   * @return {string }
   */
  public get ville(): string | undefined {
    return this._ville;
  }

  /**
   * Setter ville
   * @param {string } value
   */
  public set ville(value: string | undefined) {
    this._ville = value;
  }

  /**
   * Getter pays
   * @return {string }
   */
  public get pays(): string | undefined {
    return this._pays;
  }

  /**
   * Setter pays
   * @param {string } value
   */
  public set pays(value: string | undefined) {
    this._pays = value;
  }

  /**
   * Getter concerts
   * @return {Concert[] }
   */
  public get concerts(): Concert[] | undefined {
    return this._concerts;
  }

  /**
   * Setter concerts
   * @param {Concert[] } value
   */
  public set concerts(value: Concert[] | undefined) {
    this._concerts = value;
  }
}
