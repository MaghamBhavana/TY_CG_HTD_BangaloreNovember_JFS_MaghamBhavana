import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoviechildComponent } from './moviechild.component';

describe('MoviechildComponent', () => {
  let component: MoviechildComponent;
  let fixture: ComponentFixture<MoviechildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoviechildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoviechildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
