import { TestBed } from '@angular/core/testing';

import { OportunidadeService } from './oportunidade.service';

describe('OportunidadeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OportunidadeService = TestBed.get(OportunidadeService);
    expect(service).toBeTruthy();
  });
});
