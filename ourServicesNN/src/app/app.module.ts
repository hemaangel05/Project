import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import { AppComponent } from './app.component';
import { InternationalCourierServicesComponent } from './international-courier-services/international-courier-services.component';
import { DomesticCourierServicesComponent } from './domestic-courier-services/domestic-courier-services.component';
import { SeaFreightComponent } from './sea-freight/sea-freight.component';
import { LogisticsComponent } from './logistics/logistics.component';
import { AirFreightComponent } from './air-freight/air-freight.component';
import { HomeComponent } from './home/home.component';

const RouteMaps : Routes=[
  {path:'', component:InternationalCourierServicesComponent},
  {path:'dc', component:DomesticCourierServicesComponent},
  {path:'sf', component:SeaFreightComponent},
  {path:'lo', component:LogisticsComponent},
  {path:'af', component:AirFreightComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    InternationalCourierServicesComponent,
    DomesticCourierServicesComponent,
    SeaFreightComponent,
    LogisticsComponent,
    AirFreightComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(RouteMaps),
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
