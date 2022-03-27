package l.godefroy.Api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bets", schema = "public")
public class Bets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int choice;
    private int amount;
    private int userid;
    private int betid;

    public Bets(){}

    public Bets(Long id, int choice, int amount, int userid,int betid) {
        this.id = id;
        this.choice = choice;
        this.amount = amount;
        this.userid = userid;
        this.betid = betid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBetid() {
        return betid;
    }

    public void setBetid(int betid) {
        this.betid = betid;
    }
}