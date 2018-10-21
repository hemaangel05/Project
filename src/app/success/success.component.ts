import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../service/order.service';
import { Order } from '../model/order';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  order : Order;
  oid : number;
  opt : string;

  constructor(private orderService: OrderService,
    private activatedRoute: ActivatedRoute,
    private router : Router) { }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        this.oid = params['oid'];
        this.opt = params['opt'];
        if (this.oid && this.opt=='a') {
          this.orderService.getOrderById(this.oid).subscribe(
            (data) => this.order = data
          );
        }
      }
    );
    //console.log(this.order.price);
  }
  
  cancelOrder(isConfirmed :boolean) {
    if(isConfirmed){
      this.orderService.deleteOrderById(this.order.oid).subscribe(
        (resp) =>{
          if(resp.ok){
            console.log(this.order.oid);
            this.router.navigateByUrl("/success/?opt=d&oid="+this.order.oid);
          }
        }
      );
    }else{
      this.router.navigateByUrl("/");
    }
  }

  continueOrder() {
    if (this.oid && this.opt=='d') {
      this.router.navigateByUrl("/po");
    }
  }

}
