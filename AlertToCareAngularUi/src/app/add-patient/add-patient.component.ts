import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientSub } from '../patient-sub';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  patientsub : PatientSub = new PatientSub() ;

  constructor( private patientService : PatientService,
    private router : Router ) {
  }

  ngOnInit() : void {
  }

  savePatient() {
    this.patientService.addPatient( this.patientsub ).subscribe( data=> {
      console.log( "data----- "  + data ) ;
      this.goToPatientList() ;
    },
    error =>  {
      console.log( error ),
      alert( error.error.message ) ;
    }) ;
  }

  goToPatientList() {
    this.router.navigate(['/getpatients'])
  }

  onSubmit() {
    
    console.log( "this.patientsub : " + this.patientsub ) ;
    this.savePatient() ;
  }


}
