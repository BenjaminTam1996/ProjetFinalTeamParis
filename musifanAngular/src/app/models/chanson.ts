import { Album } from './album';

export class Chanson {
  public constructor(
    private _id?: number | undefined,
    private _titre?: string | undefined,
    private _duree?: string | undefined,
    private _album?: Album | undefined
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
   * Getter titre
   * @return {string }
   */
  public get titre(): string | undefined {
    return this._titre;
  }

  /**
   * Setter titre
   * @param {string } value
   */
  public set titre(value: string | undefined) {
    this._titre = value;
  }

  /**
   * Getter duree
   * @return {string }
   */
  public get duree(): string | undefined {
    return this._duree;
  }

  /**
   * Setter duree
   * @param {string } value
   */
  public set duree(value: string | undefined) {
    this._duree = value;
  }

  /**
   * Getter album
   * @return {Album }
   */
  public get album(): Album | undefined {
    return this._album;
  }

  /**
   * Setter album
   * @param {Album } value
   */
  public set album(value: Album | undefined) {
    this._album = value;
  }
}
