import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BikechildComponent } from './bikechild.component';

describe('BikechildComponent', () => {
  let component: BikechildComponent;
  let fixture: ComponentFixture<BikechildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BikechildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BikechildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
