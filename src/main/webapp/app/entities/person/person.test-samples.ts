import dayjs from 'dayjs/esm';

import { IPerson, NewPerson } from './person.model';

export const sampleWithRequiredData: IPerson = {
  id: 31094,
};

export const sampleWithPartialData: IPerson = {
  id: 75319,
  email: 'Brown9@yahoo.com',
  name: 'Cotton payment',
  phoneNumber: 'concept',
  updatedAt: dayjs('2022-08-19T12:29'),
};

export const sampleWithFullData: IPerson = {
  id: 70006,
  email: 'Ignatius_Wyman95@gmail.com',
  name: 'Borders',
  password: 'Kwacha',
  phoneNumber: 'Pants Universal',
  createdAt: dayjs('2022-08-19T09:56'),
  updatedAt: dayjs('2022-08-19T09:23'),
};

export const sampleWithNewData: NewPerson = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
