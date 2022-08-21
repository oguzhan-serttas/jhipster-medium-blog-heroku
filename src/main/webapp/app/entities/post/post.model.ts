import dayjs from 'dayjs/esm';
import { IPerson } from 'app/entities/person/person.model';

export interface IPost {
  id: number;
  content?: string | null;
  title?: string | null;
  createdAt?: dayjs.Dayjs | null;
  updatedAt?: dayjs.Dayjs | null;
  person?: Pick<IPerson, 'id'> | null;
}

export type NewPost = Omit<IPost, 'id'> & { id: null };
