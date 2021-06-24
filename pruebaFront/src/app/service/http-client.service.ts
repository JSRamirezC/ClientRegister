import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable()
export class HttpClientService {

  constructor(private httpClient: HttpClient
    ) {
  }

  get(url: string) {
    return this.httpClient.get(url)
      .pipe(catchError(err => {
        return throwError(err);
      }));
  }

  post(url: string, body?: any) {
    return this.httpClient.post(url, body)
      .pipe(catchError(err => {
        return throwError(err);
      }));
  }

  delete(url: string) {
    return this.httpClient.delete(url)
      .pipe(catchError(err => {
        return throwError(err);
      }));
  }

  put(url: string, body?: any) {
    return this.httpClient.put(url, body)
      .pipe(catchError(err => {
        return throwError(err);
      }));
  }

}
