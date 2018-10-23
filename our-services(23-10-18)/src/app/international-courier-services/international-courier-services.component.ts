import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-international-courier-services',
  templateUrl: './international-courier-services.component.html',
  styleUrls: ['./international-courier-services.component.css']
})
export class InternationalCourierServicesComponent implements OnInit {

  hide: boolean;
  //visible: boolean;

  constructor() {
    this.hide = false;
    //this.visible = true;
  }


  ngOnInit() {
  }

  visible(): void {
    this.hide = !this.hide;
  }

}
