import { Course } from './../model/course';
import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {

  private readonly API = '../../../assets/listaJsonCursos.json';

  constructor(private httpClient: HttpClient) {}

  listCourses() {
    return this.httpClient.get<Course[]>(this.API)
    //pipe funciona como uma espécie de Filter, interceptando a info antes de de fato ser utilizada
    .pipe(
      first(),
      delay(1000),
      tap(
          cursoRecebidoDaChamadaHttp => console.log(cursoRecebidoDaChamadaHttp)
    ));
  }
}
