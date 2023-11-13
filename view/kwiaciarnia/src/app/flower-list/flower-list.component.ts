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

  flowers: Flower[] = [];

  copyFlowers: Flower[] = [];

  ngOnInit(): void {
    this.httpClient.getFlowers()
      .subscribe({  
        next: data => {
          this.flowers = data;
          this.copyFlowers = data;
        }
      });
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
    this.httpClient.deleteFlower(id).subscribe(data => {
      this.flowers = this.flowers.filter(x => x.id != id);
      this.copyFlowers = this.copyFlowers.filter(x => x.id != id);
    });
  }

  addFlower(){
    this.router.navigate(['add-flower']);
  }

}
