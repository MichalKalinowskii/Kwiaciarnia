import { Component, OnInit } from '@angular/core';
import { Flower } from '../flower';
import { Router } from '@angular/router';
import { Colour } from '../colour';
import { HttpClientService } from '../http-client-service';

@Component({
  selector: 'app-flower-list',
  templateUrl: './flower-list.component.html',
  styleUrl: './flower-list.component.css'
})
export class FlowerListComponent implements OnInit{

  errorOccured: boolean = false;

  flowers: Flower[] = [];

  copyFlowers: Flower[] = [];

  deletedFlower: string = "";

  ngOnInit(): void {
    this.httpClient.getFlowers()
      .subscribe({  
        next: data => {
          this.flowers = data;
          this.copyFlowers = data;
        }
      })
  }

  constructor(private router: Router, private httpClient: HttpClientService){

  }

  search(input: string){
    this.flowers = this.copyFlowers
      .filter(x => x.name!.toLowerCase().includes(input.toLowerCase()));
  }

  editFlower(id: number){
    this.router.navigate(['edit-flower/',id]);
  }

  deleteFlower(id: number){
    this.httpClient.deleteFlower(id);
  }

  addFlower(){
    this.router.navigate(['add-flower']);
  }

}
