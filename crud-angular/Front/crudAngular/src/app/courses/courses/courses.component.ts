import { Course } from './../model/course';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  courses: Course[] = [
    { _id: '1', name: 'Angular', category: 'frontend' },
    { _id: '2', name: 'Spring', category: 'backend' },
  ];
  displayedColumns: string[] = ['name', 'category'];
  dataSource = this.courses;

  constructor() {}

  ngOnInit(): void {}
}
