import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlowerListComponent } from './flower-list/flower-list.component';
import { ColourListComponent } from './colour-list/colour-list.component';
import { AddFlowerComponent } from './add-flower/add-flower.component';
import { EditFlowerComponent } from './edit-flower/edit-flower.component';

const routes: Routes = [
  { path: "flower", component: FlowerListComponent },
  { path: "colour", component: ColourListComponent},
  { path: "add-flower", component: AddFlowerComponent},
  { path: "edit-flower/:id", component: EditFlowerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
