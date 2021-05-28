package fr.umontpellier.iut.bang.logic.cards;

import fr.umontpellier.iut.bang.logic.GameState;
import fr.umontpellier.iut.bang.logic.Player;

import java.util.List;

public class CatBalou extends RemovingCard {

    public CatBalou(int value, CardSuit suit) {
        super("Cat Balou", value, suit);
    }

    @Override
    public List<Player> getTargets(Player player) {
        return player.getOtherPlayers();
    }

    public GameState getNextState() {
        return GameState.DISCARD_ANY_CARD;
    }

    @Override
    public void transferCardTo(Card card, Player player) {
        player.getGame().addToDiscard(card);
    }

}