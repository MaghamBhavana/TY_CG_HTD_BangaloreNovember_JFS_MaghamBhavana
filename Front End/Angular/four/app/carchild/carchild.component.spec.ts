import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CarchildComponent } from './carchild.component';

describe('CarchildComponent', () => {
  let component: CarchildComponent;
  let fixture: ComponentFixture<CarchildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CarchildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CarchildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
