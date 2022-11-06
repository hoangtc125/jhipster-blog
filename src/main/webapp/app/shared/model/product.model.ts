import { IApplicationUser } from 'app/shared/model/application-user.model';

export interface IProduct {
  id?: number;
  name?: string | null;
  price?: number | null;
  applicationUser?: IApplicationUser;
}

export const defaultValue: Readonly<IProduct> = {};
