package com.waitingList.waitingList;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("card")
public class Controller {

    private Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    @PostMapping
    public String addCard(@RequestBody Card card){
        try {
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

    public List<Card> getCards(){
        try {
            List<Card> result = repository.findAll();
            return result;
        }catch (Exception exception){
            return new ArrayList<Card>();
        }

    }
}
