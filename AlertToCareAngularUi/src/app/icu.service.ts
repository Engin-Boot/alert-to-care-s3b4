import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Icu } from './icu'
import { IcuSub } from './icu-sub';


@Injectable({
  providedIn: 'root'
})
export class IcuService {

  private baseUrl = "http://localhost:8080/icu-mgmt/icu" ;

  constructor( private httpClient : HttpClient ) { }

  getIcusList() : Observable<Icu["data"]> {  
    return this.httpClient.get<Icu["data"]>( `${this.baseUrl}` ) ;
  }

  addIcu( icusub : IcuSub ) : Observable<any> {
    return this.httpClient.post( `${this.baseUrl}`, icusub ) ;
  }

}
