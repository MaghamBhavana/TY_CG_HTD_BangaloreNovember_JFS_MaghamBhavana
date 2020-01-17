import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MobilechildComponent } from './mobilechild.component';

describe('MobilechildComponent', () => {
  let component: MobilechildComponent;
  let fixture: ComponentFixture<MobilechildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MobilechildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MobilechildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
