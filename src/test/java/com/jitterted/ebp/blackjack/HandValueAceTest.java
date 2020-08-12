package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    List<Card> cards = List.of(new Card(Suit.DIAMONDS, Rank.from("A")),
                               new Card(Suit.DIAMONDS, Rank.from("5")));
    Hand hand = new Hand(cards);

    assertThat(hand.handValueOf())
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    var cards = List.of(new Card(Suit.DIAMONDS, Rank.from("A")),
                        new Card(Suit.DIAMONDS, Rank.from("8")),
                        new Card(Suit.DIAMONDS, Rank.from("3")));
    Hand hand = new Hand(cards);

    assertThat(hand.handValueOf())
        .isEqualTo(1 + 8 + 3);
  }

}
