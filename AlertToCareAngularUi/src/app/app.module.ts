import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http' 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IcuListComponent } from './icu-list/icu-list.component';
import { AddIcuComponent } from './add-icu/add-icu.component';
import { FormsModule } from '@angular/forms';
import { BedListComponent } from './bed-list/bed-list.component';
import { AddBedComponent } from './add-bed/add-bed.component';
import { GetBedByIdComponent } from './get-bed-by-id/get-bed-by-id.component';
import { DeviceListComponent } from './device-list/device-list.component';
import { AddDeviceComponent } from './add-device/add-device.component';
import { MonitorListComponent } from './monitor-list/monitor-list.component';
import { AddMonitorComponent } from './add-monitor/add-monitor.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
// import { HomeComponent } from './home/home.component'

@NgModule({
  declarations: [
    AppComponent,
    IcuListComponent,
    AddIcuComponent,
    BedListComponent,
    AddBedComponent,
    GetBedByIdComponent,
    DeviceListComponent,
    AddDeviceComponent,
    MonitorListComponent,
    AddMonitorComponent,
    PatientListComponent,
    AddPatientComponent
    // HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
