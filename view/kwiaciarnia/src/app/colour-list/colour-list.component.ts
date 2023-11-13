import { Component, OnInit } from '@angular/core';
import { Colour } from '../colour';
import { HttpClientService } from '../http-client-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-colour-list',
  templateUrl: './colour-list.component.html',
  styleUrl: './colour-list.component.css'
})
export class ColourListComponent implements OnInit {

  colours: Colour[] = [];
  copyColours: Colour[] = [];

  ngOnInit(): void {
    this.httpClient.getAllColours()
      .subscribe({  
        next: data => {
          this.colours = data;
          this.copyColours = data;
        }
      });
  }

  constructor(private httpClient: HttpClientService, private router: Router){

  }

  addColour(){
    this.router.navigate(['add-colour']);
  }

  editColour(id: number){
    this.router.navigate(['edit-colour',id]);   
  }

  deleteColour(id: number){
    this.httpClient.deleteFlower(id).subscribe(data => {
      this.colours = this.colours.filter(x => x.id != id);
      this.copyColours = this.copyColours.filter(x => x.id != id);
    });
  }

  search(input: string){
    this.colours = this.copyColours
      .filter(x => x.colourName!.toLowerCase().includes(input.toLowerCase()));
  }

}
