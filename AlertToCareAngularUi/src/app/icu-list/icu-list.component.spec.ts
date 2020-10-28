import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IcuListComponent } from './icu-list.component';

describe('IcuListComponent', () => {
  let component: IcuListComponent;
  let fixture: ComponentFixture<IcuListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IcuListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IcuListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
