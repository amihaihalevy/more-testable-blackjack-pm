package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;

public enum Suit {
  CLUBS("♣", Ansi.Color.BLACK),
  DIAMONDS("♦", Ansi.Color.RED),
  HEARTS("♥", Ansi.Color.RED),
  SPADES("♠", Ansi.Color.BLACK);

  private final Ansi.Color color;
  private final String symbol;

  Suit(String symbol, Ansi.Color color) {
    this.symbol = symbol;
    this.color = color;
  }

  public String symbol() {
    return symbol;
  }

  public Ansi.Color cardColor() {
    return color;
  }
}
