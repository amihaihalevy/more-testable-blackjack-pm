package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {

  private final List<Card> cards = new ArrayList<>();

  public Hand(List<Card> cards) {
    cards.forEach(this::add);
  }

  public Hand() {
  }

  public void add(Card card) {
    cards.add(card);
  }

  public int value() {
    int handValue = sumOfCardRanks();

    // does the hand contain at least 1 Ace?
    boolean hasAce = containsAce();

    // if the total hand value <= 11, then count the Ace as 11 by adding 10
    if (hasAce && handValue <= 11) {
      handValue += 10;
    }

    return handValue;
  }


  private boolean containsAce() {
    return cards
        .stream()
        .anyMatch(card -> card.rankValue() == 1);
  }

  private int sumOfCardRanks() {
    return cards
        .stream()
        .mapToInt(Card::rankValue)
        .sum();
  }

  void displayHand() {
    System.out.println(cards
                           .stream()
                           .map(Card::display)
                           .collect(Collectors.joining(
                               ansi().cursorUp(6).cursorRight(1).toString())));
  }

  String displayTopCard() {
    return cards.get(0).display();
  }

  boolean busted() {
    return value() > 21;
  }

  boolean beats(Hand hand) {
    return hand.value() < value();
  }

  boolean tiesWith(Hand hand) {
    return hand.value() == value();
  }
}
