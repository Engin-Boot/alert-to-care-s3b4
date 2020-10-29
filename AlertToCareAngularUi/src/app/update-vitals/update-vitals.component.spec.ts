import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVitalsComponent } from './update-vitals.component';

describe('UpdateVitalsComponent', () => {
  let component: UpdateVitalsComponent;
  let fixture: ComponentFixture<UpdateVitalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateVitalsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateVitalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
