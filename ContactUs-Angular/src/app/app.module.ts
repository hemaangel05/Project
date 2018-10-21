import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule,Routes}  from '@angular/router';
import { AppComponent } from './app.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { BranchesComponent } from './branches/branches.component';
import { CareerComponent } from './career/career.component';
import { SuccessComponent } from './success/success.component';
const RouteMaps : Routes=[
 {path:'success/:name', component:SuccessComponent},
{path:'ff', component:FeedbackComponent},
{path:'bb',component:BranchesComponent},
{path:'cc',component:CareerComponent}

];
@NgModule({
  declarations: [
    AppComponent,
    FeedbackComponent,
    BranchesComponent,
    CareerComponent,
    SuccessComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(RouteMaps),
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {


 }
