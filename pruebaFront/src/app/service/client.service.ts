import { Injectable } from '@angular/core';
import { HttpClientService } from './http-client.service';
import {ClientDto} from '../clases/client.dto';
import { catchError, map } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Injectable()
export class ClientService {

    urlClient = "localhost:8080//colfondos/clients";

    constructor(private httpClientService: HttpClientService
        ) {
    }

    guardarCliente(clientDto:ClientDto){
        return this.httpClientService.post(this.urlClient + "/guardar",clientDto).pipe(map((response: HttpResponse<any>) => {
            if (response.status == 200) {
                alert('Anexo cargado');
                return response.body;
            }  else {
                alert("Error al guardar");
            }
            return null;
        }), catchError(err => {
            alert("Error al enviar la petición");
            return throwError(err)
        }));
    }
}