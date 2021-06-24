import { Injectable } from '@angular/core';
import { HttpClientService } from './http-client.service';
import { catchError, map } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Injectable()
export class ParameterService {

    urlParam = " http://localhost:8080//colfondos/param";

    constructor(private httpClientService: HttpClientService
        ) {
    }

    listadoParams(){
        return this.httpClientService.get(this.urlParam + "/listadoParam").pipe(map((response: HttpResponse<any>) => {
            if (response.status == 200) {
                return response.body;
            }  else {
                alert(`${response.status} al cargar los tipos de documentos `);
            }
            return null;
        }), catchError(err => {
            const newLocal = 'Error al enviar la petición de tipos de documentos';
            alert(newLocal);
            return throwError(err)
        }));
    }
}