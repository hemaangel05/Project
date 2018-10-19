import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AngularFontAwesomeModule } from 'angular-font-awesome';

import { AppComponent } from './app.component';
import { OrderFormComponent } from './order-form/order-form.component';
import { SuccessComponent } from './success/success.component';

const paths : Routes = [
  { path : '', component : OrderFormComponent},
  { path : 'success/:oid', component : SuccessComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    SuccessComponent,
    OrderFormComponent
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
