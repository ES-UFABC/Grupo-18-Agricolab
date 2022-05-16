import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MapaService } from 'src/app/service/mapa.service';
import { MapaServiceMock } from 'src/app/service/mapa.service.mock';

import { MapaComponent } from './mapa.component';

describe('MapaComponent', () => {
  let component: MapaComponent;
  let fixture: ComponentFixture<MapaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MapaComponent ],
      providers: [
        { provide: MapaService, useClass: MapaServiceMock },
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MapaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
