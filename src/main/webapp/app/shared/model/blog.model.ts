import { IReaction } from 'app/shared/model/reaction.model';
import { IComment } from 'app/shared/model/comment.model';
import { IApplicationUser } from 'app/shared/model/application-user.model';

export interface IBlog {
  id?: number;
  title?: string | null;
  description?: string | null;
  content?: string | null;
  reactions?: IReaction[] | null;
  comments?: IComment[] | null;
  applicationUser?: IApplicationUser;
}

export const defaultValue: Readonly<IBlog> = {};
