import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { FlowerListComponent } from './flower-list/flower-list.component';
import { ColourListComponent } from './colour-list/colour-list.component';
import { FormsModule } from '@angular/forms';
import { HighlightSearchedPipe } from './highlight-searched-pipe.pipe';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    FlowerListComponent,
    ColourListComponent,
    HighlightSearchedPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
