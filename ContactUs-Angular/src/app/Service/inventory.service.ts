import { Injectable } from '@angular/core';
import { Branch } from '../model/branch';
import { Http,RequestOptions,Headers } from '@angular/http';
import { Info } from '../model/info';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
branches:Branch[];
baseUrl:string;

  constructor(private http: Http) { 

    this.baseUrl = "http://localhost:3131/info";


    this.branches=[
     { branch:'HYDERABAD - (TELANGANA)',location:'D.No.501, Vidya Nagar, Pragati Nagar, Begumpet, Hyderabad-500016, Ts, India'},
    { branch:'BANGALORE - (KARNATAKA)',location:'NO 13 , 6 CROSS 1 ST MAIN SAMPANGI RAMA NAGAR SHANTHI NAGAR BANGALORE +91-9133444629 +91-9133555625'} ,
  { branch:'PUNE - (MAHARASTRA)',location:'102, Siddhi Kesav, Near Zilla Parishad, Station Road, Pune 411 011. +91-2041250017 +91-9779115222'}

];
  }
  getAllBranches(){
    return this.branches;
  }

  getInformation(): Observable<Info[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }
  


}
