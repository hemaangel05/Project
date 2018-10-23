import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sea-freight',
  templateUrl: './sea-freight.component.html',
  styleUrls: ['./sea-freight.component.css']
})
export class SeaFreightComponent implements OnInit {

  
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
