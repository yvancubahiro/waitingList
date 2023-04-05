package com.waitingList.waitingList;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("card")
public class Controller {

    private Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    @PostMapping
    public String addCard( @RequestBody Card card){
        try {
            card.arrivalTime = System.currentTimeMillis();
            repository.save(card);
            return "card added to the database";
        }catch (Exception exception){
            return exception.getMessage();
        }
    }

    @DeleteMapping
    public String deleteCard(@RequestParam Long id){
        try{
            repository.deleteById(id);
            return "Card deleted";
        }catch (Exception exception){
            return exception.getMessage();
        }
    }

    @GetMapping
    public List<Card> getCards(){
        try {
            ArrayList<Card> result = (ArrayList<Card>) repository.findAll();
            //ArrayList<Card> result = (ArrayList<Card>) repository.getCards();

            return result;
        }catch (Exception exception){
            return new ArrayList<Card>();
        }

    }
}
