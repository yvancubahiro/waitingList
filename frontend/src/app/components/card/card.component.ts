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
  time!: Date;
  display_arrivalTime!: String;

  constructor(private service: ServiceService){}

  ngOnInit(){
    this.time = new Date(this.card.arrivalTime);
    this.display_arrivalTime = this.time.getHours()+":"+this.time.getMinutes()+":"+this.time.getSeconds()+"";
  }
  

  delete(){
    this.service.deleteCard(this.card).subscribe(data=>{console.log(data)});
    window.location.reload();
  }
}
