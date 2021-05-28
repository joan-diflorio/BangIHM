package fr.umontpellier.iut.bang.logic.characters;

import fr.umontpellier.iut.bang.logic.GameState;
import fr.umontpellier.iut.bang.logic.Player;
import fr.umontpellier.iut.bang.logic.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class KitCarlson extends BangCharacter {
    public KitCarlson() {
        super("Kit Carlson", 4);
    }

    @Override
    public void onStartTurn(Player player) {
        List<Card> drawnCards = new ArrayList<>();
        drawnCards.add(player.drawCard());
        drawnCards.add(player.drawCard());
        drawnCards.add(player.drawCard());
        player.getGame().setCurrentState(GameState.CHOOSING_DRAWN_CARD_TO_DISCARD);
        player.getGame().showCards(drawnCards);
    }

    @Override
    public void playSpecificFirstStep(Player player, Card card) {
        player.getGame().getDrawnCards().remove(card);
        player.getGame().addToDraw(card);
        List<Card> drawnCards = player.getGame().getDrawnCards();
        while (!drawnCards.isEmpty()) {
            player.addToHand(drawnCards.remove(0));
        }
        player.getGame().resetCurrentPlayer();
    }
}
