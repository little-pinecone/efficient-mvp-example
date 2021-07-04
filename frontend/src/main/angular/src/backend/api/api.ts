export * from './books.service';
import { BooksService } from './books.service';
export * from './homePage.service';
import { HomePageService } from './homePage.service';
export const APIS = [BooksService, HomePageService];
