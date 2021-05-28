package fr.umontpellier.iut.bang.logic.cards;

import fr.umontpellier.iut.bang.logic.GameState;
import fr.umontpellier.iut.bang.logic.Player;
import fr.umontpellier.iut.bang.logic.Role;

import java.util.List;
import java.util.stream.Collectors;

public class Jail extends BlueCard {
    public Jail(int value, CardSuit suit) {
        super("Jail", value, suit);
    }

    @Override
    public boolean canPlayFromHand(Player player) {
        List<Player> possibleTargets = player.getOtherPlayers()
                .stream()
                .filter(p -> p.getRole() != Role.SHERIFF && p.getCardInPlay("Jail") == null)
                .collect(Collectors.toList());
        return possibleTargets.size() > 0;
    }

    @Override
    public boolean expectsReaction(){
        return true;
    }

    @Override
    public void playedBy(Player player) {
        super.playedBy(player);
        player.removeFromInPlay(this);
        List<Player> possibleTargets = player.getOtherPlayers()
                .stream()
                .filter(p -> p.getRole() != Role.SHERIFF && p.getCardInPlay("Jail") == null)
                .collect(Collectors.toList());
        player.getGame().setPossibleTargets(possibleTargets);
        player.getGame().getNextPossibleCards().clear();
        player.getGame().setCurrentState(GameState.SELECT_JAIL_TARGET);
    }

    @Override
    public void onTargetSelection(Player selectedPlayer){
        selectedPlayer.isGivenJailCard();
    }

}
