import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { CoursesService } from './../services/courses.service';
import { Course } from './../model/course';
import { Component, OnInit } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  courses$: Observable<Course[]>;
  displayedColumns: string[] = ['name', 'category'];
  //dataSource = this.courses;

  constructor(coursesService: CoursesService,
    public dialog: MatDialog) {

    this.courses$ = coursesService.listCourses()
    .pipe(
      catchError(error => {
        console.log(error)
        this.openErrorDialog(error.name + " " + error.statusText);
        return of([]);
      })
    )
  }

  openErrorDialog(errorMessage: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMessage,
    });
  }

  ngOnInit(): void {}
}
