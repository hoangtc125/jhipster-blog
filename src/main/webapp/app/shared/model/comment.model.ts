import { IApplicationUser } from 'app/shared/model/application-user.model';
import { IBlog } from 'app/shared/model/blog.model';

export interface IComment {
  id?: number;
  content?: string | null;
  applicationUser?: IApplicationUser;
  blog?: IBlog;
}

export const defaultValue: Readonly<IComment> = {};
