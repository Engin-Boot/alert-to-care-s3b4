import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckVitalsComponent } from './check-vitals.component';

describe('CheckVitalsComponent', () => {
  let component: CheckVitalsComponent;
  let fixture: ComponentFixture<CheckVitalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CheckVitalsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckVitalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
