import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DeviceSub } from '../device-sub';
import { DeviceService } from '../device.service';

@Component({
  selector: 'app-add-device',
  templateUrl: './add-device.component.html',
  styleUrls: ['./add-device.component.css']
})

export class AddDeviceComponent implements OnInit {

  devicesub : DeviceSub = new DeviceSub() ;

  constructor( private deviceService : DeviceService,
    private router : Router ) {
  }

  ngOnInit() : void {
  }

  saveDevice() {
    this.deviceService.addDevice( this.devicesub ).subscribe(data=> {
        console.log(data) ;
        this.goToDeviceList() ;
    },
    error => console.log(error)) ;
  }

  goToDeviceList() {
    this.router.navigate(['/getdevices'])
  }

  onSubmit() {
    console.log( this.devicesub ) ;
    this.saveDevice() ;
  }


}
