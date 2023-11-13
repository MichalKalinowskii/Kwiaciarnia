import { Component, Input, OnInit } from '@angular/core';
import { Flower } from '../flower';
import { Colour } from '../colour';
import { HttpClientService } from '../http-client-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-flower',
  templateUrl: './edit-flower.component.html',
  styleUrl: './edit-flower.component.css'
})
export class EditFlowerComponent implements OnInit{
  flower: Flower = new Flower(1, "", new Colour(1,""));

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(param => {
      let id = param["id"];
      
      this.httpClient.getFlowerByID(id).subscribe(data => {
        this.flower = data;
      })
    })
  }

  constructor(private httpClient: HttpClientService, private activatedRoute: ActivatedRoute){
  }

  editFlower(flower: Flower){
    this.httpClient.putFlower(flower);
  }
}
