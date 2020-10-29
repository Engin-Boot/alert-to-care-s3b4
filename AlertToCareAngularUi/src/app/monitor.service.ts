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

  addMonitor( monitorsub : MonitorSub ) : Observable<any> {
    return this.httpClient.post( `${this.baseUrl2}`, monitorsub ) ;
  }

  getMonitorById( id : number ) : Observable<Monitor> {
    return this.httpClient.get<Monitor>( `${this.baseUrl2}/${id}` ) ;
  }

  updateMonitor( id : number, monitor : Monitor ) : Observable<Object> {
    return this.httpClient.put( `${this.baseUrl2}/${id}`, monitor ) ;
  }

}
