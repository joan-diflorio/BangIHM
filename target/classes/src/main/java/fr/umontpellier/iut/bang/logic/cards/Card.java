package fr.umontpellier.iut.bang.logic.cards;

import fr.umontpellier.iut.bang.logic.Player;

public abstract class Card {
    /**
     * Le nom de la carte
     */
    private String name;
    /**
     * Valeur de "poker" (de 2 à 14, où 11 = Valet, 12 = Dame, 13 = Roi, 14 = As)
     */
    private int value;
    /**
     * Couleur de la carte (pique, cœur, carreau ou trèfle)
     */
    private CardSuit suit;

    public Card(String name, int value, CardSuit suit) {
        this.name = name;
        this.value = value;
        this.suit = suit;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    /**
     * @param player le joueur qui a la carte en main
     * @return true si le joueur a le droit de jouer la carte depuis sa main si c'est son tour
     */
    public abstract boolean canPlayFromHand(Player player);

    /**
     * Action à exécuter lorsque le joueur joue la carte depuis sa main
     * @param player le joueur qui joue la carte
     */
    public abstract void playedBy(Player player);

    /**
     * @return la représentation de la valeur de poker (2 à l'as) de la carte sous forme d'une chaîne de caractères
     */
    public String getValueString() {
        switch (value) {
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            case 14:
                return "A";
            default:
                return Integer.toString(value);
        }
    }

    /**
     * @return la représentation de la valeur + couleur de poker de la carte sous forme d'une chaîne de caractères
     */
    public String getPokerString() {
        return getValueString() + suit.toString();
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, getPokerString());
    }

    public boolean expectsReaction(){
        return false;
    }

    public void onPass(Player attacker, Player passingPlayer) {
    }

    public void onReact(Player targetPlayer, Card reactingCard) {
    }

    public void onTargetSelection(Player targetPlayer) {
    }

    public String getImageName() {
        return "images/cards/" + getName().toLowerCase(). replaceAll("[. !]+", "")+ "_" + getValueString() + getSuit().toJSON() + ".png";
    }
}