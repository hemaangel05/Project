import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DomesticCourierServicesComponent } from './domestic-courier-services.component';

describe('DomesticCourierServicesComponent', () => {
  let component: DomesticCourierServicesComponent;
  let fixture: ComponentFixture<DomesticCourierServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DomesticCourierServicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DomesticCourierServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
