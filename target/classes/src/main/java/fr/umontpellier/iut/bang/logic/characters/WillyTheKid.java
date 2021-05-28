package fr.umontpellier.iut.bang.logic.characters;

import fr.umontpellier.iut.bang.logic.Player;

public class WillyTheKid extends BangCharacter {
    public WillyTheKid() {
        super("Willy the Kid", 4);
    }

    @Override
    public void onStartGame(Player player) {
        player.incrementUnlimitedBangs(1);
    }
}
