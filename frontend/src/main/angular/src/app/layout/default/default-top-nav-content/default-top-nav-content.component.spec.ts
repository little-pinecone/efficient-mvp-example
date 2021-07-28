import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DefaultTopNavContentComponent } from './default-top-nav-content.component';

describe('DefaultTopNavContentComponent', () => {
  let component: DefaultTopNavContentComponent;
  let fixture: ComponentFixture<DefaultTopNavContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DefaultTopNavContentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DefaultTopNavContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
