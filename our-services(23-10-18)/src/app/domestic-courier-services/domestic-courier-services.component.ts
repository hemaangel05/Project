import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-domestic-courier-services',
  templateUrl: './domestic-courier-services.component.html',
  styleUrls: ['./domestic-courier-services.component.css']
})
export class DomesticCourierServicesComponent implements OnInit {
  
  hide: boolean;

  constructor() {
    this.hide = false;
  }


  ngOnInit() {
  }

  visible(): void {
    this.hide = !this.hide;
  }
}
