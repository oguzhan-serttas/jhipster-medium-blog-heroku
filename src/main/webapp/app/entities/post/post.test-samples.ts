import dayjs from 'dayjs/esm';

import { IPost, NewPost } from './post.model';

export const sampleWithRequiredData: IPost = {
  id: 35989,
};

export const sampleWithPartialData: IPost = {
  id: 59985,
};

export const sampleWithFullData: IPost = {
  id: 93202,
  content: 'Seychelles',
  title: 'Reverse-engineered Agent intelligence',
  createdAt: dayjs('2022-08-19T06:20'),
  updatedAt: dayjs('2022-08-19T02:25'),
};

export const sampleWithNewData: NewPost = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
