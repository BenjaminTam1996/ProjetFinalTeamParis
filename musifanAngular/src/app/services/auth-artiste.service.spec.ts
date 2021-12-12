import { TestBed } from '@angular/core/testing';

import { AuthArtisteService } from './auth-artiste.service';

describe('AuthArtisteService', () => {
  let service: AuthArtisteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthArtisteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
