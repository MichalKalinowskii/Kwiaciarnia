import { Component } from '@angular/core';
import { HttpClientService } from '../http-client-service';
import { Colour } from '../colour';

@Component({
  selector: 'app-add-colour',
  templateUrl: './add-colour.component.html',
  styleUrl: './add-colour.component.css'
})
export class AddColourComponent {

  constructor(private httpClient: HttpClientService){}

  addColour(colour: Colour){
    this.httpClient.createColour(colour.colourName);
  }

}
