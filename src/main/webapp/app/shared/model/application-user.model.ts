import { IUser } from 'app/shared/model/user.model';
import { IBlog } from 'app/shared/model/blog.model';
import { IReaction } from 'app/shared/model/reaction.model';
import { IComment } from 'app/shared/model/comment.model';
import { IProduct } from 'app/shared/model/product.model';

export interface IApplicationUser {
  id?: number;
  internalUser?: IUser;
  blogs?: IBlog[] | null;
  reactions?: IReaction[] | null;
  comments?: IComment[] | null;
  products?: IProduct[] | null;
}

export const defaultValue: Readonly<IApplicationUser> = {};
