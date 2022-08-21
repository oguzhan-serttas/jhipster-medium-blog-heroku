import dayjs from 'dayjs/esm';
import { IPerson } from 'app/entities/person/person.model';
import { IPost } from 'app/entities/post/post.model';

export interface IComment {
  id: number;
  comment?: string | null;
  createdAt?: dayjs.Dayjs | null;
  updatedAt?: dayjs.Dayjs | null;
  person?: Pick<IPerson, 'id'> | null;
  post?: Pick<IPost, 'id'> | null;
}

export type NewComment = Omit<IComment, 'id'> & { id: null };
