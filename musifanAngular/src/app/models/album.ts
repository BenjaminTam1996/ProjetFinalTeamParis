import { Byte } from '@angular/compiler/src/util';
import { Chanson } from './chanson';

export class Album {
  public constructor(
    private _id?: number | undefined,
    private _titre?: string | undefined,
    private _date?: Date | undefined,
    private _photo?: Byte[] | undefined,
    private _chansons?: Chanson[] | undefined,
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
   * Getter titre
   * @return {string }
   */
  public get titre(): string | undefined {
    return this._titre;
  }

  /**
   * Getter date
   * @return {Date }
   */
  public get date(): Date | undefined {
    return this._date;
  }

  /**
   * Getter photo
   * @return {Byte[] }
   */
  public get photo(): Byte[] | undefined {
    return this._photo;
  }

  /**
   * Getter chansons
   * @return {Chanson[] }
   */
  public get chansons(): Chanson[] | undefined {
    return this._chansons;
  }

  /**
   * Getter artistes
   * @return {Artiste[] }
   */
  public get artistes(): Artiste[] | undefined {
    return this._artistes;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter titre
   * @param {string } value
   */
  public set titre(value: string | undefined) {
    this._titre = value;
  }

  /**
   * Setter date
   * @param {Date } value
   */
  public set date(value: Date | undefined) {
    this._date = value;
  }

  /**
   * Setter photo
   * @param {Byte[] } value
   */
  public set photo(value: Byte[] | undefined) {
    this._photo = value;
  }

  /**
   * Setter chansons
   * @param {Chanson[] } value
   */
  public set chansons(value: Chanson[] | undefined) {
    this._chansons = value;
  }

  /**
   * Setter artistes
   * @param {Artiste[] } value
   */
  public set artistes(value: Artiste[] | undefined) {
    this._artistes = value;
  }
}
