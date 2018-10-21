import { Component } from '@angular/core';
import {Info} from './model/info';
import { InventoryService } from '../app/Service/inventory.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  logo: string;
  icon1: string;
  icon2:string;
  icon3:string;
  icon4:string;
  icon5:string;
  title1 = 'Blue';
title2="Ray";
info:Info[];
constructor(private inv:InventoryService,private activatedRoute : ActivatedRoute)
  {
    this.logo = "/assets/logo.png";
    this.icon1="/assets/fform.png";
    this.icon2="/assets/information.png ";
    this.icon3="/assets/th.jpg";
    this.icon4="/assets/loyalty.jpg";
    this.icon5="/assets/wallpaper.jpg";



  }
  ngOnInit() {
    this.inv.getInformation().subscribe(
      (data) => this.info=data
     );

  }
}

