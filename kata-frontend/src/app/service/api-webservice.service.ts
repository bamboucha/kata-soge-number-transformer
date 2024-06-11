import { Inject, Injectable } from '@angular/core';
import { Observable, filter, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiWebserviceService {
  private apiHost = environment.apiNumberHost;

  constructor(private http: HttpClient) { }

  public getTransformedNumber(input: Number): Observable<string> {
    return this.http.get(`${this.apiHost}api/transform/${input}`, { responseType: 'text' });
  }
}
