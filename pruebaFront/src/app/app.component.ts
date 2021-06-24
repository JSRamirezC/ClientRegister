import { Component, OnInit } from '@angular/core';
import { ClientDto } from './clases/client.dto';
import { ClientService } from './service/client.service';
import { ParameterService } from './service/parameter.service';
import { ParameterDto } from './clases/parameter.dto';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'pruebaFront';
  parameters: ParameterDto[] = [];
  identElegida;
  client: ClientDto;
  urlParam = " http://localhost:8080//colfondos/param";
  urlClient = "http://localhost:8080//colfondos/clients/guardar";
  error;

  constructor(private _clientService: ClientService,
    private httpClient: HttpClient,
    private _ParameterService: ParameterService) {

  }

  ngOnInit(): void {
    this.httpClient.get<any>(this.urlParam + "/listadoParam").subscribe(data => {
      data.respuesta.forEach(element => {
        var temp = new ParameterDto();
        temp.id = element.id;
        temp.description = element.description;
        this.parameters.push(temp);
      }
      )
    }, error => this.error = error);
    this.client = new ClientDto();
    console.log(this.client);
    this.identElegida = '';

  }

  capturar(): void {
    this.client.typeid = this.identElegida;
    console.log(this.identElegida);
  }

  guardar() {
    return this.httpClient.post(this.urlClient, this.client).subscribe(data => { 
      alert("El client ha sigo guardado Y/O modificado con exito");
      this.client = new ClientDto();
    });
  }
}