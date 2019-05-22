import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { StudentComponent } from './student/student.component';
import { StudentUpdateComponent } from './student-update/student-update.component';
import { StudentRegistrationComponent } from './student-registration/student-registration.component';
import { StudentRetrieveComponent } from './student-retrieve/student-retrieve.component';
import { StudentDeleteComponent } from './student-delete/student-delete.component';

const appRoutes: Routes = [
  {
    path: 'students',
    component: StudentComponent,
    data: { title: 'Student List' }
  },
  {
    path: 'student-retrieve/:registrationNumber',
    component: StudentRetrieveComponent,
    data: { title: 'Student Retrieval' }
  },
  {
    path: 'student-reg',
    component: StudentRegistrationComponent,
    data: { title: 'Student Reg' }
  },
  {
    path: 'student-update/:registrationNumber',
    component: StudentUpdateComponent,
    data: { title: 'Student Update' }
  },
  {
    path: '',
    redirectTo: '/students',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    StudentRetrieveComponent,
    StudentDeleteComponent,
    StudentUpdateComponent,
    StudentRegistrationComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }