import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ClientService } from './service/client.service';
import { ParameterService } from './service/parameter.service';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientService } from './service/http-client.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, 
    FormsModule, 
    HttpClientModule
  ],
  providers: [
    ClientService,
    ParameterService,
    HttpClientService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
