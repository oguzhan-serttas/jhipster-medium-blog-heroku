import { IPerson } from 'app/entities/person/person.model';
import { IPost } from 'app/entities/post/post.model';

export interface ILike {
  id: number;
  person?: Pick<IPerson, 'id'> | null;
  post?: Pick<IPost, 'id'> | null;
}

export type NewLike = Omit<ILike, 'id'> & { id: null };
