import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlowerListComponent } from './flower-list/flower-list.component';
import { ColourListComponent } from './colour-list/colour-list.component';

const routes: Routes = [
  { path: "flower", component: FlowerListComponent },
  { path: "colour", component: ColourListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
