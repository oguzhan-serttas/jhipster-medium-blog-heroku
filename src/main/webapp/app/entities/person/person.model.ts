import dayjs from 'dayjs/esm';
import { IRole } from 'app/entities/role/role.model';

export interface IPerson {
  id: number;
  email?: string | null;
  name?: string | null;
  password?: string | null;
  phoneNumber?: string | null;
  createdAt?: dayjs.Dayjs | null;
  updatedAt?: dayjs.Dayjs | null;
  roles?: Pick<IRole, 'id'>[] | null;
}

export type NewPerson = Omit<IPerson, 'id'> & { id: null };
