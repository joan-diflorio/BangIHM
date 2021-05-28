package fr.umontpellier.iut.bang.logic.cards;

import fr.umontpellier.iut.bang.logic.GameState;
import fr.umontpellier.iut.bang.logic.Player;

import java.util.List;

public class Panic extends RemovingCard {

    public Panic(int value, CardSuit suit) {
        super("Panic!", value, suit);
    }

    @Override
    public boolean canPlayFromHand(Player player) {
        return !player.getPlayersInRange(1).isEmpty();
    }

    @Override
    public List<Player> getTargets(Player player) {
        return player.getPlayersInRange(1);
    }

    public GameState getNextState() {
        return GameState.PICK_UP_ANY_CARD;
    }

    @Override
    public void transferCardTo(Card card, Player player) {
        player.addToHand(card);
    }

}
