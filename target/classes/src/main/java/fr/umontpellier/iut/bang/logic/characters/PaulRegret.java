package fr.umontpellier.iut.bang.logic.characters;

import fr.umontpellier.iut.bang.logic.Player;

public class PaulRegret extends BangCharacter {
    public PaulRegret() {
        super("Paul Regret", 3);
    }

    @Override
    public void onStartGame(Player player) {
        player.incrementDistanceIncrementToOthers(1);
    }
}
