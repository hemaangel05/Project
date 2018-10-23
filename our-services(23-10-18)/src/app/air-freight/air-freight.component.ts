import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-air-freight',
  templateUrl: './air-freight.component.html',
  styleUrls: ['./air-freight.component.css']
})
export class AirFreightComponent implements OnInit {
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
