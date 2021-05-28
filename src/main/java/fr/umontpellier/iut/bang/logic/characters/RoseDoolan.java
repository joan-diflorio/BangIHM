package fr.umontpellier.iut.bang.logic.characters;

import fr.umontpellier.iut.bang.logic.Player;

public class RoseDoolan extends BangCharacter {
    public RoseDoolan() {
        super("Rose Doolan", 4);
    }

    @Override
    public void onStartGame(Player player) {
        player.incrementDistanceDecrementToOthers(1);
    }
}
