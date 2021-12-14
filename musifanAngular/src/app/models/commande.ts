import { Utilisateur } from 'src/app/models/utilisateur';
import { Concert } from 'src/app/models/concert';
export class Commande {
  public constructor(
    private _id?: number | undefined,
    private _date?: Date | undefined,
    private _utilisateur?: Utilisateur | undefined,
    private _concert?: Concert | undefined
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

  public get concert(): Concert | undefined {
    return this._concert;
  }
  public set concert(value: Concert | undefined) {
    this._concert = value;
  }
  public get utilisateur(): Utilisateur | undefined {
    return this._utilisateur;
  }
  public set utilisateur(value: Utilisateur | undefined) {
    this._utilisateur = value;
  }
  public get date(): Date | undefined {
    return this._date;
  }
  public set date(value: Date | undefined) {
    this._date = value;
  }
}
