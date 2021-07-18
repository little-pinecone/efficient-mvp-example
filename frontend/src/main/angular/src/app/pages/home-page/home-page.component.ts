import {Component, OnInit} from '@angular/core';
import {Home, HomePageService} from "../../../backend";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  homeContent?: Home;

  constructor(private readonly homePageService: HomePageService) {
  }

  ngOnInit(): void {
    this.homePageService.getHomePageData().subscribe(d => this.homeContent = d);
  }

}
