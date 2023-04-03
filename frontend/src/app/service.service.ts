import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'; 
import { Observable } from 'rxjs';
import { Card } from './Card';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  private apiUrl = "http://localhost:8080/card";

  constructor(private http:HttpClient) {}

  getCards():Observable<Card[]>{
    return this.http.get<Card[]>(this.apiUrl);
  }

  deleteCard(card:Card):Observable<Card>{
    const url = this.apiUrl+"?id="+card.id;
    console.log(url);
    return this.http.delete<Card>(url);
  }

  addCard(card:Card):any{
    let headers = new HttpHeaders({ 'Content-Type': 'application/JSON' });
    let id;
    let json_data = JSON.stringify(card);
    console.log(json_data);
    this.http.post<Card>(this.apiUrl,card,{headers: headers}).subscribe(data=>{console.log(data)});
    return id;
  }

  sort(cards:Card[]){
    cards.sort((a, b) => (a.priority > b.priority) ? 1 : -1);
    return cards;
  }
}
