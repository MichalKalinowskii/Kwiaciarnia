import { Component } from '@angular/core';
import { Flower } from '../flower';
import { HttpClientService } from '../http-client-service';

@Component({
  selector: 'app-add-flower',
  templateUrl: './add-flower.component.html',
  styleUrl: './add-flower.component.css'
})
export class AddFlowerComponent {

  constructor(private httpClient: HttpClientService){

  }

  addFlower(flower: Flower){
    this.httpClient.createFlower(flower);
  }

}
