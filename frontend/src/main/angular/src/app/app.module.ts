import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ApiModule, BASE_PATH} from "../backend";
import {HttpClientModule} from "@angular/common/http";
import {environment} from "../environments/environment";
import { HomePageComponent } from './pages/home-page/home-page.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { DefaultLayoutComponent } from './layout/default/default-layout/default-layout.component';
import { TopNavWrapperComponent } from './layout/shared/top-nav-wrapper/top-nav-wrapper.component';
import { DefaultTopNavContentComponent } from './layout/default/default-top-nav-content/default-top-nav-content.component';
import { PageContentComponent } from './layout/page-content/page-content.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    DefaultLayoutComponent,
    TopNavWrapperComponent,
    DefaultTopNavContentComponent,
    PageContentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ApiModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [{ provide: BASE_PATH, useValue: environment.API_BASE_PATH }],
  bootstrap: [AppComponent]
})
export class AppModule { }
