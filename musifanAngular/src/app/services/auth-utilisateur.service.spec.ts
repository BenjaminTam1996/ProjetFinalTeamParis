import { TestBed } from '@angular/core/testing';

import { AuthUtilisateurService } from './auth-utilisateur.service';

describe('AuthUtilisateurService', () => {
  let service: AuthUtilisateurService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthUtilisateurService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
