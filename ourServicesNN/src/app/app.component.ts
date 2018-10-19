import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ourServices';
  pic1: string;
  pic2: string;


  constructor()
  {
    this.pic1 = "/assets/Courier-Service.png";
    this.pic2 = "/assets/domestic-courier.png";

  }

}

