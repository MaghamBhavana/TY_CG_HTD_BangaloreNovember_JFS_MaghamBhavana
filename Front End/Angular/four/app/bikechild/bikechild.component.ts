import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bikechild',
  templateUrl: './bikechild.component.html',
  styleUrls: ['./bikechild.component.css']
})
export class BikechildComponent implements OnInit {

  @Input() bikeDetails;
  constructor() { }

  ngOnInit() {
  }

}
