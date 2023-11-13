import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Flower } from '../flower';
import { Colour } from '../colour';
import { HttpClientService } from '../http-client-service';

@Component({
  selector: 'app-form-flower',
  templateUrl: './form-flower.component.html',
  styleUrl: './form-flower.component.css'
})
export class FormFlowerComponent implements OnInit{

  @Input() flower: Flower = new Flower(0, "", new Colour(0,""));
  @Output() submitEvent = new EventEmitter<Flower>();
  colours: Colour[] = [];
  flowerColourName: string = "test";

  ngOnInit(): void {
    this.httpClient.getAllColours()
    .subscribe({
      next: data => {
        this.colours = data;
      }
    })
    this.flowerColourName = this.flower.colour.colourName;
  }

  constructor(private httpClient: HttpClientService){

  }

  submit(form: NgForm){
    if(form.invalid){
      return;
    }
    this.submitEvent.emit(this.flower);
  }
}
