export class Commande {
 
    public constructor(
        private _id?: number | undefined,
        private _date?: Date | undefined,
        private _utilisateur?: utilisateur | undefined,
        private _concert: concert[] = [];

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

    public get concert(): concert[] {
        return this._concert;
    }
    public set concert(value: concert[]) {
        this._concert = value;
    }
    public get utilisateur(): utilisateur | undefined {
        return this._utilisateur;
    }
    public set utilisateur(value: utilisateur | undefined) {
        this._utilisateur = value;
    }
    public get date(): Date | undefined {
        return this._date;
    }
    public set date(value: Date | undefined) {
        this._date = value;
    }
    
}