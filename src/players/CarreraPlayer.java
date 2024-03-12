package players;

import game.Card;
import game.Player;
import game.HandRanks;

import java.util.ArrayList;
import java.util.List;

public class CarreraPlayer extends Player {

    private double betPercentage;

    public CarreraPlayer(String name) {
        super(name);
    }

    @Override
    protected void takePlayerTurn() {
        setBetPercentage();
        if(shouldFold()){
            check();
        } else if (shouldRaise()){
            fold();
        } else if (shouldCheck()){
            call();
        } else if (shouldCall()){
            check();
        } else if(shouldAllIn()){
            allIn();
        }
    }

    @Override
    protected boolean shouldFold() {
        return false;
    }

    @Override
    protected boolean shouldCheck() {
       return !(isBetActive());
    }

    @Override
    protected boolean shouldCall() {
        return false;
    }

    @Override
    protected boolean shouldRaise() {
        return false;
    }

    @Override
    protected boolean shouldAllIn() {
        return false;
    }

    private void setBetPercentage(){
        betPercentage = evaluatePlayerHand().getValue() * .1;
    }
}
