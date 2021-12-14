import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsLieuComponent } from './details-lieu.component';

describe('DetailsLieuComponent', () => {
  let component: DetailsLieuComponent;
  let fixture: ComponentFixture<DetailsLieuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsLieuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsLieuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
