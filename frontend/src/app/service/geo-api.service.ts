import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, take } from 'rxjs';
import { environment } from 'src/environments/environment';
import { GeoApi } from '../model/geo-api.model';

@Injectable({
  providedIn: 'root'
})
export class GeoApiService {

  private readonly GEO_API = `${environment.GEO_API}`;
  private readonly accessKey: string = '37823801a3838d653b0b00531be7a55b';

  limit: number = 1;
  output: string = 'json';

  constructor(
    private http: HttpClient,
  ) { }

  getGeocoding(endereco: string): Observable<GeoApi> {
    return this.http.get<GeoApi>(`${this.GEO_API}?access_key=${this.accessKey}&limit=${this.limit}&output=${this.output}&query=${endereco}`).pipe(take(1));
  }

}
