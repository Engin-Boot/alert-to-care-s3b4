import { TestBed } from '@angular/core/testing';

import { UpdateVitalsService } from './update-vitals.service';

describe('UpdateVitalsService', () => {
  let service: UpdateVitalsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateVitalsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
