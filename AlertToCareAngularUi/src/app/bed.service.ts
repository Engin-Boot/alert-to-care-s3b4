import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bed } from './bed';
import { BedSub } from './bed-sub';

@Injectable({
  providedIn: 'root'
})
export class BedService {

  private baseUrl = "http://localhost:8080/bed-mgmt/allBeds" ;
  private baseUrl2 = "http://localhost:8080/bed-mgmt/bed" ;


  constructor( private httpClient : HttpClient ) { }

  getBedList() : Observable<Bed["data"]> {
    return this.httpClient.get<Bed["data"]>( `${this.baseUrl}` ) ;
  }

  addBed( bedsub : BedSub ) : Observable<any> {
    return this.httpClient.post( `${this.baseUrl2}`, bedsub ) ;
  }

  // not yet working -- get bed by id
  getBedyId( id : number ) : Observable<Bed["data"]> {
    return this.httpClient.get<Bed["data"]>(`${this.baseUrl}/${id}`) ;
  }

}
