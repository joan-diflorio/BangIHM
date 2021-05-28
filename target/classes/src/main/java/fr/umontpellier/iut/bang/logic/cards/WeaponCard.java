package fr.umontpellier.iut.bang.logic.cards;

import fr.umontpellier.iut.bang.logic.Player;

public abstract class WeaponCard extends BlueCard {
    public WeaponCard(String name, int value, CardSuit suit) {
        super(name, value, suit);
    }

    public int getRange() {
        return 1;
    }

    @Override
    public void playedBy(Player player) {
        player.setWeapon(this);
    }

    @Override
    public boolean canPlayFromHand(Player player) {
        WeaponCard weapon = player.getWeapon();
        return weapon == null || !weapon.getName().equals(getName());
    }

    public void onRemoveFromPlay(Player player) {}

    public boolean canBeDiscarded() {
        return true;
    }
}
