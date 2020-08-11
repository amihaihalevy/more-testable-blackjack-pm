package com.jitterted.ebp.blackjack;

import java.util.List;
import java.util.stream.Collectors;

public class Rank {
  private static final List<String> RANKS = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
  private final String rank;

  public Rank(String rank) {
    this.rank = rank;
  }


  public static Rank from(String rank) {
    return new Rank(rank);
  }

  public static List<Rank> allRanks() {
    return RANKS.stream()
                .map(Rank::new)
                .collect(Collectors.toList());
  }

  public String display() {
    return rank;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Rank rank1 = (Rank) o;

    return rank.equals(rank1.rank);
  }

  @Override
  public int hashCode() {
    return rank.hashCode();
  }

  private int numericRankValue() {
    return Integer.parseInt(display());
  }

  private boolean isFaceCard() {
    return "JQK".contains(display());
  }

  private boolean isAce() {
    return display().equals("A");
  }

  public int rankValue() {
    if (isFaceCard()) {
      return 10;
    } else if (isAce()) {
      return 1;
    } else {
      return numericRankValue();
    }
  }
}
