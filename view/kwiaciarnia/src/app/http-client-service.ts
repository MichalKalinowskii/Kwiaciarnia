import { HttpClient } from "@angular/common/http";
import { map } from "rxjs";
import { Colour } from "./colour";
import { Flower } from "./flower";
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })
export class HttpClientService {

    url = "http://localhost:8080/";
    localFlowers: Flower[] = [];

    constructor(private httpClient: HttpClient){

    }

    getFlowers(){
        return this.httpClient.get<Flower[]>("http://localhost:8080/flower")
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

}
