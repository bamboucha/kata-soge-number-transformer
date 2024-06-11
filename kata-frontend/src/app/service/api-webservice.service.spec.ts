import { TestBed } from '@angular/core/testing';

import { ApiWebserviceService } from './api-webservice.service';

describe('ApiWebserviceService', () => {
  let service: ApiWebserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiWebserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
