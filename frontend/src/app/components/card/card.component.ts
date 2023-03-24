import { Component, Input } from '@angular/core';
import { Card } from 'src/app/Card';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {

  @Input() card!: Card;
  @Input() isAdmin! : Boolean;


  ngOnInit(){
  }

  delete(){
    console.log(this.card.id+" deleted");
  }
}
