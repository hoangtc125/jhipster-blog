import { IApplicationUser } from 'app/shared/model/application-user.model';
import { IBlog } from 'app/shared/model/blog.model';
import { Emotion } from 'app/shared/model/enumerations/emotion.model';

export interface IReaction {
  id?: number;
  emotion?: Emotion | null;
  applicationUser?: IApplicationUser;
  blog?: IBlog;
}

export const defaultValue: Readonly<IReaction> = {};
