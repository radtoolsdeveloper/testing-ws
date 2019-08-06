import { ActivatedRoute, Router } from '@angular/router';
import { StudentComponent } from './../student/student.component';
import { RestService } from './../rest.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-student-registration',
  templateUrl: './student-registration.component.html',
  styleUrls: ['./student-registration.component.css']
})
export class StudentRegistrationComponent implements OnInit {
  @Input() studentData = { name: '', age: '', registrationNumber: 0 };
  constructor(private rest: RestService, private route: ActivatedRoute, private router: Router) {

  }

  ngOnInit() {
  }

  addStudent() {
    this.rest.addStudent(this.studentData).subscribe((result) => {
      //this.router.navigate(['/student-retrieve/' + result.referenceNumber]);
      //this.router.navigate(['/student/allstudent']);
    }, (err) => {
      console.log(err);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
    });
  }

}
