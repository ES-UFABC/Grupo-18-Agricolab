import { of } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { GeoApiMapTilerData } from '../model/geo-api-maptiler.model';
import { GeoApi } from '../model/geo-api.model';

export class GeoApiServiceMock {

  getGeocoding(endereco: string): Observable<GeoApi> {
    return of(new GeoApi);
  }

  getGeocodingMapTiler(endereco: string): Observable<GeoApiMapTilerData> {
    return of(new GeoApiMapTilerData);
  }

}
