import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Device } from './device';
import { DeviceSub } from './device-sub';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  private baseUrl = "http://localhost:8080/device-mgmt/devices" ;

  constructor( private httpClient : HttpClient ) { }

  getDevicesList() : Observable<Device["data"]> {  
    return this.httpClient.get<Device["data"]>( `${this.baseUrl}` ) ;
  }

  addDevice( devicesub : DeviceSub ) : Observable<any> {
    return this.httpClient.post( `${this.baseUrl}`, devicesub ) ;
  }

}
