import { Component, EventEmitter, Input, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Colour } from '../colour';

@Component({
  selector: 'app-form-colour',
  templateUrl: './form-colour.component.html',
  styleUrl: './form-colour.component.css'
})
export class FormColourComponent {
  @Input() colour: Colour = new Colour(0,"");
  @Output() submitEvent = new EventEmitter<Colour>();

  submit(form: NgForm){
    if(form.invalid){
      return;
    }
    this.submitEvent.emit(this.colour);
  }

}
