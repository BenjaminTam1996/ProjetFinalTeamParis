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
   * Getter date
   * @return {Date }
   */
  public get date(): Date {
    return this._date;
  }

  /**
   * Setter date
   * @param {Date } value
   */
  public set date(value: Date) {
    this._date = value;
  }

  /**
   * Getter nbPlace
   * @return {number }
   */
  public get nbPlace(): number {
    return this._nbPlace;
  }

  /**
   * Setter nbPlace
   * @param {number } value
   */
  public set nbPlace(value: number) {
    this._nbPlace = value;
  }

  /**
   * Getter prix
   * @return {number }
   */
  public get prix(): number {
    return this._prix;
  }

  /**
   * Setter prix
   * @param {number } value
   */
  public set prix(value: number) {
    this._prix = value;
  }

  /**
   * Getter lieu
   * @return {Lieu }
   */
  public get lieu(): Lieu {
    return this._lieu;
  }

  /**
   * Setter lieu
   * @param {Lieu } value
   */
  public set lieu(value: Lieu) {
    this._lieu = value;
  }

  /**
   * Getter artistes
   * @return {Artiste[] }
   */
  public get artistes(): Artiste[] {
    return this._artistes;
  }

  /**
   * Setter artistes
   * @param {Artiste[] } value
   */
  public set artistes(value: Artiste[]) {
    this._artistes = value;
  }
}
