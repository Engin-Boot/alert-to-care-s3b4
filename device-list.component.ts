import { Component, OnInit } from '@angular/core';
import { Device } from '../device';
import { DeviceService } from '../device.service';

@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css']
})
export class DeviceListComponent implements OnInit {

  devices : Device ;

  constructor( private deviceService : DeviceService ) { }

  ngOnInit(): void {
    this.getDevices() ;
  }

  getDevices() {
    this.deviceService.getDevicesList().subscribe(response => {
      this.devices = response.data ;
      console.log( this.devices ) ; 
    }) ;
  }
}
