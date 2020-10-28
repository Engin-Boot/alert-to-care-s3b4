import { TestBed } from '@angular/core/testing';

import { IcuService } from './icu.service';

describe('IcuService', () => {
  let service: IcuService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IcuService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
