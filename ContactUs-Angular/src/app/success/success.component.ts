import { Component, OnInit } from '@angular/core';
import { Blueray } from '../model/blueray';
import { InventoryService } from '../Service/inventory.service';
import {  ActivatedRoute } from '@angular/router';
import { FeedServiceService } from '../Service/feed-service.service';


@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {
blueray:Blueray;
constructor(private fback: FeedServiceService,
  private activatedRoute: ActivatedRoute) {
     this.blueray=  new Blueray();
   }

ngOnInit() {
  this.activatedRoute.queryParams.subscribe(
    (params) => {
      let name = params['name'];
      let opt = params['opt'];
      if (name && opt=='a') {
        this.fback.getCustomerByName(name).subscribe(
          (data) => this.blueray = data
        );
      }
    }
  );
}

}
