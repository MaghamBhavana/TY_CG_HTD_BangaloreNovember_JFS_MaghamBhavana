import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RamyaComponent } from './ramya.component';

describe('RamyaComponent', () => {
  let component: RamyaComponent;
  let fixture: ComponentFixture<RamyaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RamyaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RamyaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
