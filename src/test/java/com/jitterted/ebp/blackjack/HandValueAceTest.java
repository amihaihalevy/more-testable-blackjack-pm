package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit DUMMY_SUIT = Suit.DIAMONDS;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = createHand("A", "9");

    assertThat(hand.value())
        .isEqualTo(11 + 9);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Hand hand = createHand("A", "8", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo10IsValuedAt11() throws Exception {
    Hand hand = createHand("A", "10");

    assertThat(hand.value())
        .isEqualTo(11 + 10);

  }

  private Hand createHand(String... ranks) {
    Hand hand = new Hand();
    for (String rank : ranks) {
      hand.add(new Card(DUMMY_SUIT, Rank.from(rank)));
    }
    return hand;
  }

}
