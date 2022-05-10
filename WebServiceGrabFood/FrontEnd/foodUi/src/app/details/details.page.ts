import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-details',
  templateUrl: './details.page.html',
  styleUrls: ['./details.page.scss'],
})
export class DetailsPage implements OnInit {
  data = null;
  
  opts = {
    freeMode: true,
    slidesPerView: 2.6,
    slidesOffsetBefore: 30,
    slidesOffsetAfter: 100
  }
 
  constructor(private http: HttpClient) { }
 
  ngOnInit() {
    this.http.get('https://devdactic.fra1.digitaloceanspaces.com/foodui/1.json').subscribe((res: any) => {
      this.data = res;
    });
  }
 
  ngAfterViewInit() {    
  
  }

}
