import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeConcertsComponent } from './liste-concerts.component';

describe('ListeConcertsComponent', () => {
  let component: ListeConcertsComponent;
  let fixture: ComponentFixture<ListeConcertsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListeConcertsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListeConcertsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
