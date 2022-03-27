package l.godefroy.Api.controller;
import l.godefroy.Api.model.Betlist;
import l.godefroy.Api.service.BetListServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BetListController {

    private BetListServiceImpl betListService;

    @Autowired
    //@Qualifier("clientService")
    public void setBetListService(BetListServiceImpl betListService){
        this.betListService=betListService;
    }

    @GetMapping("/Bets")
    public List<Betlist> find() {
        return betListService.find();
    }

    @PostMapping("/Bets")
    @ResponseStatus(HttpStatus.CREATED)
    public String addBet(@RequestBody Betlist betlist){
        betListService.addBet(betlist);
        return "Nouvel utilisateur ajouté";
    }

    @PutMapping("/Bets/{id}")
    public Betlist changeBetState(@PathVariable Long id, @RequestBody Map<String, Object> payload){
        return betListService.changeBetState(id, (int) payload.get("etat"));
    }

    @DeleteMapping("/Bets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        betListService.delete(id);
    }
}
