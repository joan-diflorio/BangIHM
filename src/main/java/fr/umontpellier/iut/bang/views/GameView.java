package fr.umontpellier.iut.bang.views;

import fr.umontpellier.iut.bang.IGame;
import fr.umontpellier.iut.bang.logic.Player;
import fr.umontpellier.iut.bang.logic.cards.Card;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public abstract class GameView extends Pane {

    private IGame game;

    public GameView(IGame game) {
        this.game = game;
    }

    public IGame getIGame() {
        return game;
    }

    public void setGame(IGame game) {
        this.game = game;
    }

    /**
     * Pour définir le message qui indique à l'utilisateur la prochaine action qu'il peut faire
     * Varie en fonction de l'état du jeu (GameState)
     */
    protected abstract void bindNextActionMessage();

    /**
     * Pour définir l'action à exécuter quand l'utilisateur choisit de passer
     */
    protected abstract void setPassSelectedListener();

    /**
     * Pour définir l'action à exécuter quand le joueur qui a le tour change
     */
    protected void setCurrentPlayerChangesListener(ChangeListener<? super Player> whenCurrentPlayerChanges) {
        game.currentPlayerProperty().addListener(whenCurrentPlayerChanges);
    }

    /**
     * Pour définir l'action à exécuter lorsqu'un joueur meurt
     */
    protected void setRemoveDeadPlayerAreaListener(ListChangeListener<Player> removeAreaListener) {
        game.playersProperty().addListener(removeAreaListener);
    }

    /**
     * Pour définir l'action à exécuter lorsqu'une carte d'attaque vient d'être jouée
     */
    protected void setCurrentAttackChangesListener(ChangeListener<? super Card> whenCurrentAttackChanges) {
        game.currentAttackProperty().addListener(whenCurrentAttackChanges);
    }

}
