import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlowerListComponent } from './flower-list/flower-list.component';
import { ColourListComponent } from './colour-list/colour-list.component';
import { AddFlowerComponent } from './add-flower/add-flower.component';
import { EditFlowerComponent } from './edit-flower/edit-flower.component';
import { AddColourComponent } from './add-colour/add-colour.component';
import { EditColourComponent } from './edit-colour/edit-colour.component';

const routes: Routes = [
  { path: "flower", component: FlowerListComponent },
  { path: "colour", component: ColourListComponent},
  { path: "add-flower", component: AddFlowerComponent},
  { path: "edit-flower/:id", component: EditFlowerComponent},
  { path: "add-colour", component: AddColourComponent},
  { path: "edit-colour/:id", component: EditColourComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
