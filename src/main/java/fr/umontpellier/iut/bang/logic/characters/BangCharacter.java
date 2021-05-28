package fr.umontpellier.iut.bang.logic.characters;

import fr.umontpellier.iut.bang.logic.Player;
import fr.umontpellier.iut.bang.logic.cards.Card;

public abstract class BangCharacter {
    /**
     * Le nom du personnage
     */
    private String name;
    /**
     * Le nombre de points de vie du personnage (détermine le nombre max de points de vie du joueur)
     */
    private int healthPoints;

    public BangCharacter(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BangCharacter that = (BangCharacter) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void onEmptyHand(Player player) {
    }

    public void onDecrementHealth(int n, Player player, Player attacker) {
    }

    public void playSpecificFirstStep(Player player, Card card) {}

    /**
     * Cette méthode est appelée au début du tour d'un joueur pour lui faire piocher deux cartes.
     * Elle peut être redéfinie dans les sous-classes si le personnage modifie cette action.
     *
     * @param player le joueur associé au personnage
     */
    public void onStartTurn(Player player) {
        player.drawToHand();
        player.drawToHand();
        player.getGame().resetCurrentPlayer();
    }

    /**
     * Cette méthode est exécutée lorsque le joueur "dégaine" (il retourne la carte du dessus de la pioche pour un
     * tirage aléatoire (Jail, Barrel, etc.)).
     * Elle peut être redéfinie dans les sous-classes si le personnage modifie cette action
     *
     * @param player le joueur associé au personnage
     * @return la carte qui a été tirée
     */
    public Card randomDraw(Player player) {
        Card card = player.drawCard();
        return card;
    }

    public void onStartGame(Player player) {}

    public void onPlayerDeath(Player player, Player deadPlayer) {
    }

    public int getNumberOfMissedRequired() {
        return 1;
    }
}
