package com.waitingList.waitingList;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

@RestController
@RequestMapping("card")
public class Controller {

    private Repository repository;

    public Controller(Repository repository){
        this.repository = repository;
    }

    @PostMapping
    public String addCard(Card card){
        try {
            card.arrivalTime = new Timestamp(System.currentTimeMillis());
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

            /*list.sort((o1, o2)
                    -> o1.getCustomProperty().compareTo(
                    o2.getCustomProperty()))*/

            result.sort((o1,o2)-> o1.getPriority().compareTo(o2.getPriority()));
            result.sort((o1,o2)->o1.getArrivalTime().compareTo(o2.getArrivalTime()));

            return result;
        }catch (Exception exception){
            return new ArrayList<Card>();
        }

    }
}
