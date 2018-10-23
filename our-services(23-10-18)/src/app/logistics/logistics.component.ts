import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logistics',
  templateUrl: './logistics.component.html',
  styleUrls: ['./logistics.component.css']
})
export class LogisticsComponent implements OnInit {
  
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
