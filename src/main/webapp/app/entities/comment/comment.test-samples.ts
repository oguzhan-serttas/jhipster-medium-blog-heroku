import dayjs from 'dayjs/esm';

import { IComment, NewComment } from './comment.model';

export const sampleWithRequiredData: IComment = {
  id: 78899,
};

export const sampleWithPartialData: IComment = {
  id: 40657,
  createdAt: dayjs('2022-08-18T19:24'),
};

export const sampleWithFullData: IComment = {
  id: 34202,
  comment: 'Baby New',
  createdAt: dayjs('2022-08-19T13:35'),
  updatedAt: dayjs('2022-08-19T05:11'),
};

export const sampleWithNewData: NewComment = {
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
