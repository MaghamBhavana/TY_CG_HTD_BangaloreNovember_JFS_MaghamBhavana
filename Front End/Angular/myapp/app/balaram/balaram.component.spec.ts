import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BalaramComponent } from './balaram.component';

describe('BalaramComponent', () => {
  let component: BalaramComponent;
  let fixture: ComponentFixture<BalaramComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BalaramComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BalaramComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
