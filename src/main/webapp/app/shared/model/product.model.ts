export interface IProduct {
  id?: number;
  name?: string | null;
  price?: number | null;
}

export const defaultValue: Readonly<IProduct> = {};
