import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
userDetails;
id: string;
  constructor(private route: ActivatedRoute) { 
    this.route.params.subscribe(data => {
      console.log(data);
      this.id = data.id;
    });
    this.route.queryParams.subscribe(data => {
      console.log(data);
      this.userDetails = data;
    })
  }

  ngOnInit() {
  }

}
