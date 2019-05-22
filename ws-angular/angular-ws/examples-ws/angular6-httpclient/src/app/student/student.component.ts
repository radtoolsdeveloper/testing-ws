import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  students: any = [];

  constructor(public rest: RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.students = [{
      "name": "abc",
      "age": 25,
      "registrationNumber": 1
    }]
    this.getStudents();
  }

  getStudents() {
    this.students = [];
    this.rest.getStudents().subscribe((data: {}) => {
      console.log(data);
      this.students = data;
    });
  }

  add() {
    this.router.navigate(['/student-reg']);
  }

  delete(id) {
    this.rest.deleteStudent(id)
      .subscribe(res => {
        this.getStudents();
      }, (err) => {
        console.log(err);
      }
      );
  }

}