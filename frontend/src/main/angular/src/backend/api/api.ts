export * from './books.service';
import { BooksService } from './books.service';
export * from './landingPage.service';
import { LandingPageService } from './landingPage.service';
export const APIS = [BooksService, LandingPageService];
