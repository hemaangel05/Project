import { Component, OnInit } from '@angular/core';
import { OrderService } from '../service/order.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from '../model/order';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {

  order : Order;
  doo : Date;

  constructor(private orderService: OrderService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.doo = new Date();
    this.order=new Order();
    /*this.activatedRoute.params.subscribe(
      (params) => {
        this.oid = params['oid'];
        if (this.oid) {
          this.orderService.getOrderById(this.oid).subscribe(
            (data) => this.order = data
          );
        }
      }
    );*/
  }

  save() {
    this.orderService.addOrder(this.order).subscribe(
      (data)=>{
        //this.router.navigateByUrl("/?opt=a&cid="+this.customer.cid);
        this.router.navigateByUrl("/success/?opt=a&oid="+data.oid);
      },
      (error)=>{alert("This oid already exist");}
    );
  }

}
