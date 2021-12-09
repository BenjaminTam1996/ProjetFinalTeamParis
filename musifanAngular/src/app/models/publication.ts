export class Publication {
  public constructor(
    private _id?: number | undefined,
    private _description?: string | undefined,
    private _photo?: Byte | undefined,
    private _date?: Date | undefined,
    private _artiste?: Artiste | undefined
  ) {}

  public get artiste(): Artiste | undefined {
    return this._artiste;
  }
  public set artiste(value: Artiste | undefined) {
    this._artiste = value;
  }
  public get date(): Date | undefined {
    return this._date;
  }
  public set date(value: Date | undefined) {
    this._date = value;
  }
  public get photo(): Byte | undefined {
    return this._photo;
  }
  public set photo(value: Byte | undefined) {
    this._photo = value;
  }
  public get description(): string | undefined {
    return this._description;
  }
  public set description(value: string | undefined) {
    this._description = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
}
