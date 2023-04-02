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
  password_input:String;
  ADMIN_PASSWORD = "admin";

  constructor(private service : ServiceService){
    this.isAdmin = false;
    this.firstname = "";
    this.lastname = "";
    this.illness = "";
    this.message = "";
    this.priority = 0;
    this.password_input = "";
  }

  ngOnInit(): void{
    this.service.getCards().subscribe((response)=>this.cards = response);
    if(document.cookie == "true"){
      this.isAdmin = true;
    }else if(document.cookie == "false"){
      this.isAdmin = false;
    }
  }

  addCard(){
    if(this.firstname == "" || this.lastname =="" || this.illness == ""){
      this.message = "All the fields must be completed ! ";
    }else{
      this.message = "";
      let newCard = new Card(this.firstname,this.lastname,0,this.illness,this.priority,0);
      console.log(newCard);
      this.service.addCard(newCard);
      window.location.reload();
      this.firstname = "";
      this.lastname = "";
      this.illness = "";
      this.priority = 0;
    }

  }

  login(){
    if(this.password_input == this.ADMIN_PASSWORD){
      this.isAdmin = true;
      document.cookie = "true";
      this.password_input = "";
    }else{
      alert("Wrong password !");
    }
  }

  signout(){
    if(this.isAdmin){
      this.isAdmin = false;
      document.cookie = "false";
    }else{
      alert("already signed out !")
    }
  }

}
