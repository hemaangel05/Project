import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {Blueray} from '../model/blueray';
import { FeedServiceService } from '../Service/feed-service.service';
@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  
  
  blueray:Blueray;
  fform:string;
    isEditing:boolean;

  constructor(private fback:FeedServiceService,
    private router:Router
  ) {
     this.blueray=new Blueray();
    this.fform="/assets/fform.png";
  }

  ngOnInit() {  
  }

  save(){
    if(  !this.isEditing)
          this.fback.submitFeedback(this.blueray).subscribe(
            (data)=>{
              this.router.navigateByUrl("/success/?opt=a&name="+data.name);
            },
            (error)=>{alert("This oid already exist");}

          ); 
      }
    }