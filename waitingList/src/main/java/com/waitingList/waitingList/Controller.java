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

            updatePriorities();

            return "Card deleted";
        }catch (Exception exception){
            return exception.getMessage();
        }
    }

    private void updatePriorities() {
        if(repository.count() != 0){
            List<Card> cards = repository.findAll();
            for(Card card : cards){
                card.increasePriority();
            }
            repository.saveAll(cards);
        }

    }

    @GetMapping
    public List<Card> getCards(){
        try {
            ArrayList cards;
            if(repository.count() > 1) {
                cards = (ArrayList<Card>) repository.findSorted();
            }else{
                cards = (ArrayList<Card>) repository.findAll();
            }
            return cards;
        }catch (Exception exception){
            return new ArrayList<Card>();
        }

    }
}
