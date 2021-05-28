package fr.umontpellier.iut.bang.logic.cards;

import fr.umontpellier.iut.bang.logic.Player;

public class GeneralStore extends OrangeCard {
    public GeneralStore(int value, CardSuit suit) {
        super("General Store", value, suit);
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        player.drawCardsToDistribute();
    }
}

