import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercheArtisteComponent } from './recherche-artiste.component';

describe('RechercheArtisteComponent', () => {
  let component: RechercheArtisteComponent;
  let fixture: ComponentFixture<RechercheArtisteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RechercheArtisteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercheArtisteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
