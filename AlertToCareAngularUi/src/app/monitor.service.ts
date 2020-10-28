import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Monitor } from './monitor';
import { MonitorSub } from './monitor-sub';

@Injectable({
  providedIn: 'root'
})

export class MonitorService {

  private baseUrl = "http://localhost:8080/bed-device/allMaps" ;
  private baseUrl2 = "http://localhost:8080/bed-device/map" ;

  constructor( private httpClient : HttpClient ) { }

  getMonitorList() : Observable<Monitor["data"]> {
    return this.httpClient.get<Monitor["data"]>( `${this.baseUrl}` ) ;
  }

  addBed( monitorsub : MonitorSub ) : Observable<any> {
    return this.httpClient.post( `${this.baseUrl2}`, monitorsub ) ;
  }

}
