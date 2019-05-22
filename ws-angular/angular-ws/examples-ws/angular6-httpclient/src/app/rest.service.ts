import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class RestService {

  private endPoint: string = 'http://localhost:8083/';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  constructor(private http: HttpClient) {
  }

  private extractData(resp: Response) {
    let body = resp;
    return body || {};
  }

  getStudents(): Observable<any> {
    return this.http.get(this.endPoint + 'student/allstudent').pipe(
      map(this.extractData));
  }

  getStudent(registrationNumber): Observable<any> {
    return this.http.get(this.endPoint + 'student/' + registrationNumber).pipe(
      map(this.extractData));
  }

  addStudent(student): Observable<any> {
    console.log(student);
    
    return this.http.post<any>(this.endPoint + 'register/student', JSON.stringify(student), this.httpOptions).pipe(
      tap((student) => console.log(`added student w/ registrationNumber=${student.registrationNumber}`)),
      catchError(this.handleError<any>('addProduct'))
    );
  }

  updateStudent(registrationNumber, student): Observable<any> {
    return this.http.put(this.endPoint + 'students/' + registrationNumber, JSON.stringify(student), this.httpOptions).pipe(
      tap(_ => console.log(`updated student registrationNumber=${registrationNumber}`)),
      catchError(this.handleError<any>('updateProduct'))
    );
  }

  deleteStudent(registrationNumber): Observable<any> {
    return this.http.delete<any>(this.endPoint + 'students/' + registrationNumber, this.httpOptions).pipe(
      tap(_ => console.log(`deleted student registrationNumber=${registrationNumber}`)),
      catchError(this.handleError<any>('deleteProduct'))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}

//https://www.djamware.com/post/5b87894280aca74669894414/angular-6-httpclient-consume-restful-api-example
