import { IUser } from 'app/shared/model/user.model';
import { IBlog } from 'app/shared/model/blog.model';
import { IReaction } from 'app/shared/model/reaction.model';
import { IComment } from 'app/shared/model/comment.model';

export interface IApplicationUser {
  id?: number;
  internalUser?: IUser;
  blogs?: IBlog[] | null;
  reactions?: IReaction[] | null;
  comments?: IComment[] | null;
}

export const defaultValue: Readonly<IApplicationUser> = {};
