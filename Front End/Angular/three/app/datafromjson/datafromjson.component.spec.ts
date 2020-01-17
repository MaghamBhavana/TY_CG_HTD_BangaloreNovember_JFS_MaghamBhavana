import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DatafromjsonComponent } from './datafromjson.component';

describe('DatafromjsonComponent', () => {
  let component: DatafromjsonComponent;
  let fixture: ComponentFixture<DatafromjsonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DatafromjsonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DatafromjsonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
