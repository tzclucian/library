import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MaterialModule } from './material.module';
import { BookComponent } from './library/component/book.component';
import { LibraryClient } from './library/service/library.client';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    HttpModule
  ],
  providers: [LibraryClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
