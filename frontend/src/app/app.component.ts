import { Component } from '@angular/core';
import { Card } from './Card';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  card : Card;
  isAdmin : boolean;

  constructor(){
    this.isAdmin = true;
    let time = new Date();
    this.card = new Card("Yvan","Michaella",time,"malaria",2,53241)
  }
}
