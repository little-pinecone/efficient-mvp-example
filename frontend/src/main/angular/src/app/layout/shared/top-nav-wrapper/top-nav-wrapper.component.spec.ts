import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopNavWrapperComponent } from './top-nav-wrapper.component';

describe('TopNavWrapperComponent', () => {
  let component: TopNavWrapperComponent;
  let fixture: ComponentFixture<TopNavWrapperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TopNavWrapperComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TopNavWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
