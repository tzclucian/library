import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Book } from '../model/book.model';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LibraryClient {

  private libraryBookPath: string = 'http://localhost:8123/api/library/versions/1/book';

  constructor(private http: Http) {
  }

  findBookById(bookId: string): Observable<Book> {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get(
      this.libraryBookPath + '/' + bookId,
      {headers: headers})
      .map(res => res.json());
  }

  findAllBooks(): any {
  }
}
