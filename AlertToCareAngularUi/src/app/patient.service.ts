import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';
import { PatientSub } from './patient-sub';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private baseUrl = "http://localhost:8080/patient-mgmt/patients" ;
  private baseUrl2 = "http://localhost:8080/patient-mgmt/patient" ;


  constructor( private httpClient : HttpClient ) { }

  getPatientList() : Observable<Patient["data"]> {
    return this.httpClient.get<Patient["data"]>( `${this.baseUrl}` ) ;
  }

  addPatient( patientsub : PatientSub ) : Observable<any> {
    return this.httpClient.post( `${this.baseUrl2}`, patientsub ) ;
  }
  
}
