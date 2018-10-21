import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Order } from '../model/order';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  baseUrl: string;

  constructor(private http: Http) {
    this.baseUrl = "http://localhost:2020/orders";
   }

   getBaseUrlById(oid: number): string {
    return this.baseUrl + "/" + oid;
  }

  getSearchUrl(field: string, value: string): string {
    return this.baseUrl + "/" + field + "/" + value;
  }

  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }

  getAllOrders(): Observable<Order[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }

  searchOrders(field: string, value: string): Observable<Order[]> {
    return this.http.get(this.getSearchUrl(field,value)).pipe(
      map(data => data.json())
    );
  }

  getOrderById(oid : number): Observable<Order> {
    return this.http.get(this.getBaseUrlById(oid)).pipe(
      map(data => data.json())
    );
  }

  deleteOrderById(oid : number): Observable<Response> {
    return this.http.delete(this.getBaseUrlById(oid));
  }

  addOrder(order: Order): Observable<Order> {
    return this.http.post(this.baseUrl, JSON.stringify(order), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }

  updateOrder(order: Order): Observable<Order> {
    return this.http.put(this.baseUrl, JSON.stringify(order), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }
}