import { Component, OnInit } from '@angular/core';
import { Book } from './library/model/book.model';
import { LibraryClient } from './library/service/library.client';
import { Author } from './library/model/author.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  private books: Book[] = [];

  constructor(private libraryClient: LibraryClient) {
  }

  ngOnInit(): void {
    this.libraryClient.findBookById('lucian')
      .subscribe(
        (data) => {
          let bookById = new Book(data);
          this.books.push(bookById);
          console.log('Got the book');
        },
        (err) => {
          // Do nothing atm
          console.log('Failed to retrieve resource from backend');
        });
    console.log("Step 2");
  }
}
