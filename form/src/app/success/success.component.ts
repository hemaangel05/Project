import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from '../service/order.service';
import { Order } from '../model/order';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  order : Order;

  constructor(private orderService: OrderService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        let oid = params['oid'];
        let opt = params['opt'];
        if (oid && opt=='a') {
          this.orderService.getOrderById(oid).subscribe(
            (data) => this.order = data
          );
        }
      }
    );
    console.log(this.order.price);
  }

}
