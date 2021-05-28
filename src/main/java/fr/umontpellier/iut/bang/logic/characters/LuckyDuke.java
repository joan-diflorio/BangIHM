package fr.umontpellier.iut.bang.logic.characters;

/* public class LuckyDuke extends BangCharacter {
    public LuckyDuke() {
        super("Lucky Duke", 4);
    }

    @Override
    public Card randomDraw(Player player) {
        List<Card> randomCards = new ArrayList<>();
        randomCards.add(player.getGame().getDrawnCards().get(0));
        randomCards.add(player.getGame().getDrawnCards().get(0));
        player.getGame().showCards(randomCards);
        player.getGame().setCurrentState(GameState.CHOOSING_DRAWN_CARD_TO_DISCARD);
        return null;
    }

   @Override
    public void playSpecificFirstStep(Player player, Card card) {
        player.getGame().getDrawnCards().remove(card);
        player.addToHand(card);
        if (card.getSuit() == CardSuit.HEART || card.getSuit() == CardSuit.DIAMOND) {
            player.drawToHand();
        }
        player.getGame().resetCurrentPlayer();
    }
}*/
