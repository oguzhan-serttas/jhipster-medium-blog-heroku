import { IPerson } from 'app/entities/person/person.model';

export interface IRole {
  id: number;
  role?: string | null;
  tasks?: Pick<IPerson, 'id'>[] | null;
}

export type NewRole = Omit<IRole, 'id'> & { id: null };
