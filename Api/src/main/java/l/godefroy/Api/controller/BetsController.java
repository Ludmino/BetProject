package l.godefroy.Api.controller;
import l.godefroy.Api.model.Bets;
import l.godefroy.Api.service.BetsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BetsController {

    private BetsServiceImpl betsService;

    @Autowired
    //@Qualifier("clientService")
    public void setBetListService(BetsServiceImpl betsService){
        this.betsService=betsService;
    }

    @GetMapping("/Bet")
    public List<Bets> find() {
        return betsService.find();
    }

    @PostMapping("/Bet")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveBet(@RequestBody Bets bets){
        betsService.saveBet(bets);
        return "Nouveau bet ajouté";
    }

    @DeleteMapping("/Bet/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        betsService.delete(id);
    }

}
