import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PainelNegociacaoComponent } from './painel-negociacao.component';

describe('PainelNegociacaoComponent', () => {
  let component: PainelNegociacaoComponent;
  let fixture: ComponentFixture<PainelNegociacaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PainelNegociacaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PainelNegociacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
