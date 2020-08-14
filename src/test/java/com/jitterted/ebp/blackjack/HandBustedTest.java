package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandBustedTest {

  private static final Suit DUMMY_SUIT = Suit.DIAMONDS;

  @Test
  public void handWithValueOf22IsBusted() throws Exception {
    Hand hand = createHand("Q", "10", "2");

    assertThat(hand.busted())
        .isTrue();
  }

  @Test
  public void handWithValueOf20IsNotBusted() throws Exception {
    Hand hand = createHand("Q", "10");

    assertThat(hand.busted())
        .isFalse();
  }

  @Test
  public void handWithValueOf21IsNotBusted() throws Exception {
    Hand hand = createHand("Q", "8", "3");

    assertThat(hand.busted())
        .isFalse();
  }


  private Hand createHand(String... ranks) {
    Hand hand = new Hand();
    for (String rank : ranks) {
      hand.add(new Card(DUMMY_SUIT, Rank.from(rank)));
    }
    return hand;
  }

}