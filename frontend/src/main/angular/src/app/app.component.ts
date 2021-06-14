import {Component, OnInit} from '@angular/core';
import {LandingPageService} from "../backend";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'angular';

  constructor(private readonly landingPageService: LandingPageService) {
  }

  ngOnInit(): void {
    this.landingPageService.getLandingPageData().subscribe(d => this.title = d);
  }
}
