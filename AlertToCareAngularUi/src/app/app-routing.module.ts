import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBedComponent } from './add-bed/add-bed.component';
import { AddDeviceComponent } from './add-device/add-device.component';
import { AddIcuComponent } from './add-icu/add-icu.component';
import { AddMonitorComponent } from './add-monitor/add-monitor.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { BedListComponent } from './bed-list/bed-list.component';
import { DeviceListComponent } from './device-list/device-list.component';
import { GetBedByIdComponent } from './get-bed-by-id/get-bed-by-id.component';
import { HomeComponent } from './home/home.component';
import { IcuListComponent } from './icu-list/icu-list.component';
import { MonitorListComponent } from './monitor-list/monitor-list.component';
import { PatientListComponent } from './patient-list/patient-list.component';

const routes: Routes = [
  { path : 'geticus', component : IcuListComponent },
  { path : 'addicu', component : AddIcuComponent },
  { path : 'getbeds', component : BedListComponent },
  { path : 'addbed', component : AddBedComponent },
  { path : 'getbedbyid', component : GetBedByIdComponent },
  { path : 'getdevices', component : DeviceListComponent },
  { path : 'adddevice', component : AddDeviceComponent },
  { path : 'getmonitors', component : MonitorListComponent },
  { path : 'addmonitor', component : AddMonitorComponent },
  { path : 'getpatients', component : PatientListComponent },
  { path : 'addpatient', component : AddPatientComponent },
  { path : '', component : HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
