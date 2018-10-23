import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  icon1: String;
  icon2: String;
  icon3: String;
  icon4: String;

  constructor() {

    this.icon1 = 'assets/images/pic1.jpeg';
    this.icon2 = 'assets/images/pic2.jpeg';
    this.icon3 = 'assets/images/pic3.jpeg';
    this.icon4 = 'assets/images/pic5.jpeg';
  }

  ngOnInit() {
  }

}
