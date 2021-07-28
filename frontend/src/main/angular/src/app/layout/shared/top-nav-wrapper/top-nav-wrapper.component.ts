import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-top-nav-wrapper',
  templateUrl: './top-nav-wrapper.component.html',
  styleUrls: ['./top-nav-wrapper.component.scss']
})
export class TopNavWrapperComponent implements OnInit {

  public isMenuCollapsed: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

}
