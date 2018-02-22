import { Author } from './author.model';

export class Book {
  id: string;
  content: string;
  author: Author;

  constructor(object: any) {
    this.id = object.id;
    this.content = object.content;
    this.author = object.author;
  }
}
