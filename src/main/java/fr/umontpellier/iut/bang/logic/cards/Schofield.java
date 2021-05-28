package fr.umontpellier.iut.bang.logic.cards;

public class Schofield extends WeaponCard {
    public Schofield(int value, CardSuit suit) {
        super("Schofield", value, suit);
    }

    @Override
    public int getRange() {
        return 2;
    }
}
