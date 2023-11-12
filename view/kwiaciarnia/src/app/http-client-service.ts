import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Colour } from "./colour";
import { Flower } from "./flower";
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class HttpClientService {

    url = "http://localhost:8080";
    localFlowers: Flower[] = [];
    localColours: Colour[] = [];

    constructor(private httpClient: HttpClient){

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
        return this.httpClient.delete(`${this.url}/delete/${id}`)
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
}
