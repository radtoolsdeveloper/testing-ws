import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentRetrieveComponent } from './student-retrieve.component';

describe('StudentRetrieveComponent', () => {
  let component: StudentRetrieveComponent;
  let fixture: ComponentFixture<StudentRetrieveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentRetrieveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentRetrieveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
