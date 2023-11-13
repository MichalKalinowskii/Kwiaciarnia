import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Colour } from "./colour";
import { Flower } from "./flower";
import { Injectable } from '@angular/core';
import { Router } from "@angular/router";

@Injectable({
    providedIn: 'root'
  })
export class HttpClientService {

    url = "http://localhost:8080";
    localFlowers: Flower[] = [];
    localColours: Colour[] = [];

    constructor(private httpClient: HttpClient, private router: Router){

    }

    getFlowers(){
        return this.httpClient.get<Flower[]>(`${this.url}/flower`)
            .pipe(
                map(data => 
                    data.map(item=>
                        new Flower(item.id,item.name,new Colour(item.colour.id,item.colour.colourName))
                    )
                )
            )
            .pipe(map(flowers => {
                return[...flowers, ...this.localFlowers]
            }))
    }

    getFlowerByID(id: number){
        return this.httpClient.get<Flower>(`${this.url}/flower/${id}`)
            .pipe(
                map(data => 
                    new Flower(data.id,data.name,new Colour(data.colour.id,data.colour.colourName)) 
                )
            );
    }

    deleteFlower(id: number){
        return this.httpClient.delete(`${this.url}/flower/delete/${id}`);
    }

    getAllColours(){
        return this.httpClient.get<Colour[]>(`${this.url}/colour`)
            .pipe(
                map(data => 
                    data.map(item => 
                        new Colour(item.id, item.colourName))
                )
            )
            .pipe(map(colours => {
                return[...colours, ...this.localColours]
            }))
    }

    putFlower(flower: Flower){
        this.httpClient.put<Flower>(`${this.url}/flower/update`, flower)
        .subscribe(response => {
            this.router.navigate(['flower']);
        });
    }

    createFlower(flower: Flower){
        this.httpClient.post<Flower>(`${this.url}/flower/create`, flower)
        .subscribe(response => {
            this.router.navigate(['flower']);
        });
    }

    getColourByID(id: number){
        return this.httpClient.get<Colour>(`${this.url}/colour/${id}`)
            .pipe(
                map(data => 
                    new Colour(data.id, data.colourName) 
                )
            );
    }

    putColour(colour: Colour){
        this.httpClient.put<Colour>(`${this.url}/colour/update`, colour)
        .subscribe(response => {
            this.router.navigate(['colour']);
        });
    }

    deleteColour(id: number){
        return this.httpClient.delete(`${this.url}/colour/delete/${id}`);
    }

    createColour(colourName: string){
        this.httpClient.post<Colour>(`${this.url}/colour/create/${colourName}`, null)
        .subscribe(response => {
            this.router.navigate(['colour']);
        });
    }
}
