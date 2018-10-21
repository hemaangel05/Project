import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InternationalCourierServicesComponent } from './international-courier-services.component';

describe('InternationalCourierServicesComponent', () => {
  let component: InternationalCourierServicesComponent;
  let fixture: ComponentFixture<InternationalCourierServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InternationalCourierServicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InternationalCourierServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
