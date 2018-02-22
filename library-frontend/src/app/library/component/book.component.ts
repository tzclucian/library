import { Component, Input, Output } from '@angular/core';
import { Book } from '../model/book.model';
import { Author } from '../model/author.model';

@Component({
  selector: 'book-component',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent {

  @Input()
  // @Output()
  public book: Book;

  constructor() {
    this.book = new Book({
      'id': '',
      'content': '',
      'author': new Author({
        'name': ''
      })
    });
  }
}
