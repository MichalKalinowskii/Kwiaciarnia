import { Component, OnInit } from '@angular/core';
import { Colour } from '../colour';
import { HttpClientService } from '../http-client-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-colour',
  templateUrl: './edit-colour.component.html',
  styleUrl: './edit-colour.component.css'
})
export class EditColourComponent implements OnInit{
  colour: Colour = new Colour(0,"");

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(param => {
      let id = param["id"];
      
      this.httpClient.getColourByID(id).subscribe(data => {
        this.colour = data;
      })
    })
  }

  constructor(private httpClient: HttpClientService, private activatedRoute: ActivatedRoute){

  }

  editColour(colour: Colour){
    this.httpClient.putColour(colour);
  }
}
