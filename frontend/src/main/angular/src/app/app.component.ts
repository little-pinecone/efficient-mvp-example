import {Component, OnInit} from '@angular/core';
import {Home, HomePageService} from "../backend";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'angular';
  homeTest?: Home

  constructor(private readonly homePageService: HomePageService) {
  }

  ngOnInit(): void {
    this.homePageService.getHomePageData().subscribe(d => this.homeTest = d);
  }
}
