import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BhavanaComponent } from './bhavana.component';

describe('BhavanaComponent', () => {
  let component: BhavanaComponent;
  let fixture: ComponentFixture<BhavanaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BhavanaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BhavanaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
