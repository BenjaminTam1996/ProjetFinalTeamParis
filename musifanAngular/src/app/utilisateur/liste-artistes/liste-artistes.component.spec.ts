import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeArtistesComponent } from './liste-artistes.component';

describe('ListeArtistesComponent', () => {
  let component: ListeArtistesComponent;
  let fixture: ComponentFixture<ListeArtistesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeArtistesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeArtistesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
