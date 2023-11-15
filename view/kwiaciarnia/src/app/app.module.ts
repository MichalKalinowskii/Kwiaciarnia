import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';
import { FlowerListComponent } from './flower-list/flower-list.component';
import { ColourListComponent } from './colour-list/colour-list.component';
import { FormsModule } from '@angular/forms';
import { SearchedPipe } from './search-pipe.pipe';
import { HttpClientModule } from '@angular/common/http';
import { EditFlowerComponent } from './edit-flower/edit-flower.component';
import { AddFlowerComponent } from './add-flower/add-flower.component';
import { FormFlowerComponent } from './form-flower/form-flower.component';
import { AddColourComponent } from './add-colour/add-colour.component';
import { EditColourComponent } from './edit-colour/edit-colour.component';
import { FormColourComponent } from './form-colour/form-colour.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    FlowerListComponent,
    ColourListComponent,
    SearchedPipe,
    EditFlowerComponent,
    AddFlowerComponent,
    FormFlowerComponent,
    AddColourComponent,
    EditColourComponent,
    FormColourComponent
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
