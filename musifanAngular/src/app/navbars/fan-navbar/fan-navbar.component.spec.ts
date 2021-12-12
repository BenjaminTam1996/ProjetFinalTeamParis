import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FanNavbarComponent } from './fan-navbar.component';

describe('FanNavbarComponent', () => {
  let component: FanNavbarComponent;
  let fixture: ComponentFixture<FanNavbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FanNavbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FanNavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
