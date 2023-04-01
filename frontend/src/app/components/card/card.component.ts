import { Component, Input } from '@angular/core';
import { Card } from 'src/app/Card';
import { ServiceService } from 'src/app/service.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {

  @Input() card!: Card;
  @Input() isAdmin! : Boolean;

  constructor(private service: ServiceService){}

  ngOnInit(){
  }

  delete(){
    this.service.deleteCard(this.card);
    console.log(this.card.id+" deleted");
  }
}
