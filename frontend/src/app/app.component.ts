import { Component } from '@angular/core';
import { Card } from './Card';
import { ServiceService } from './service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  isAdmin : boolean;
  cards : Card[] = [];
  
  firstname:String;
  lastname:String;
  illness:String;
  priority:number;
  message:String;

  constructor(private service : ServiceService){
    this.isAdmin = true;
    this.firstname = "";
    this.lastname = "";
    this.illness = "";
    this.message = "";
    this.priority = 0;
  }

  ngOnInit(): void{
    this.service.getCards().subscribe((response)=>this.cards = response)
  }

  addCard(){
    let time = new Date();
    if(this.firstname == "" || this.lastname =="" || this.illness == ""){
      this.message = "All the fields must be completed ! ";
    }else{
      this.message = "";
      let newCard = new Card(this.firstname,this.lastname,time,this.illness,this.priority,0);
      console.log(newCard);
      this.service.addCard(newCard);
      this.firstname = "";
      this.lastname = "";
      this.illness = "";
      this.priority = 0;
    }

  }

}
