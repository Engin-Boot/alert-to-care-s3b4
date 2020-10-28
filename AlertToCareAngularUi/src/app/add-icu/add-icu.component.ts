import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IcuSub } from '../icu-sub';
import { IcuService } from '../icu.service';

@Component({
  selector: 'app-add-icu',
  templateUrl: './add-icu.component.html',
  styleUrls: ['./add-icu.component.css']
})
export class AddIcuComponent implements OnInit {

  icusub : IcuSub = new IcuSub() ;

  constructor( private icuService : IcuService,
    private router : Router ) {
  }

  ngOnInit() : void {
  }

  saveIcu() {
    this.icuService.addIcu( this.icusub ).subscribe(data=> {
        console.log(data) ;
        this.goToIcuList() ;
    },
    error => console.log(error)) ;
  }

  goToIcuList() {
    this.router.navigate(['/geticus']) ;
  }

  onSubmit() {
    console.log( this.icusub ) ;
    this.saveIcu() ;
  }

}
