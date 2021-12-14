import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsConcertComponent } from './details-concert.component';

describe('DetailsConcertComponent', () => {
  let component: DetailsConcertComponent;
  let fixture: ComponentFixture<DetailsConcertComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsConcertComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsConcertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
