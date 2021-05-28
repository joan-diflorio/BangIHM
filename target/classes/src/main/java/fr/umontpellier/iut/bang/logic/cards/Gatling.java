package fr.umontpellier.iut.bang.logic.cards;

import fr.umontpellier.iut.bang.logic.GameState;

public class Gatling extends LoopingCard {
    public Gatling(int value, CardSuit suit) {
        super("Gatling", value, suit);
    }

    public String getProtectionCardName() {
        return "Missed!";
    }

    public GameState getTargetState() {
        return GameState.TARGET_HAS_MISSED;
    }

}
