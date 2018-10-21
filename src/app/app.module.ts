import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { HomeComponent } from './home/home.component';
import { AppComponent } from './app.component';
import { OrderFormComponent } from './order-form/order-form.component';
import { SuccessComponent } from './success/success.component';
import { InternationalCourierServicesComponent } from './international-courier-services/international-courier-services.component';
import { DomesticCourierServicesComponent } from './domestic-courier-services/domestic-courier-services.component';
import { SeaFreightComponent } from './sea-freight/sea-freight.component';
import { LogisticsComponent } from './logistics/logistics.component';
import { AirFreightComponent } from './air-freight/air-freight.component';

const paths : Routes = [
  { path : 'po', component : OrderFormComponent},
  { path : 'success/:oid', component : SuccessComponent},
  {path:'', component:InternationalCourierServicesComponent},
  {path:'dc', component:DomesticCourierServicesComponent},
  {path:'sf', component:SeaFreightComponent},
  {path:'lo', component:LogisticsComponent},
  {path:'af', component:AirFreightComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    SuccessComponent,
    OrderFormComponent,
    InternationalCourierServicesComponent,
    DomesticCourierServicesComponent,
    SeaFreightComponent,
    LogisticsComponent,
    AirFreightComponent,
     HomeComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AngularFontAwesomeModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
