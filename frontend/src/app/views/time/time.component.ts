import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.scss']
})
export class TimeComponent implements OnInit {

  constructor(
    private titleService: Title
  ) { 
    this.titleService.setTitle("Time - Agricolab");
  }
  
  ngOnInit(): void {
  }

}
