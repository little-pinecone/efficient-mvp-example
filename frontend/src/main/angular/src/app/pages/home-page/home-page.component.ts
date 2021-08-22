import {Component, OnInit} from '@angular/core';
import {Home, HomePageClient} from "../../../backend";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  homeContent?: Home;

  constructor(private readonly homePageClient: HomePageClient) {
  }

  ngOnInit(): void {
    this.homePageClient.getHomePageData().subscribe(d => this.homeContent = d);
  }

}
