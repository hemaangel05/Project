import { Injectable } from '@angular/core';
import { Http,RequestOptions,Headers } from '@angular/http';
import { Blueray } from '../model/blueray';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class FeedServiceService {
  baseUrl2:string;

  constructor(private http: Http) {

    this.baseUrl2 = "http://localhost:3131/fbform";

   }


  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }
  getBaseUrlByName(name: string): string {
    return this.baseUrl2 + "/" + name;
  }

  getCustomerByName(name: string): Observable<Blueray> {
    return this.http.get(this.getBaseUrlByName(name)).pipe(
      map(data => data.json())
    );
  }
  submitFeedback(feedback: Blueray): Observable<Blueray> {
      return this.http.post(this.baseUrl2, JSON.stringify(feedback),
       this.getJsonContentTypeHeader()).pipe(
        map(data => data.json())
      );
    }
  
}
