package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankValueTest {

  @Test
  public void withNumberCardHasNumericValueOfTheNumber() throws Exception {
    assertThat(Rank.from("7").rankValue())
        .isEqualTo(7);
  }

  @Test
  public void withValueOfQueenHasNumericValueOf10() throws Exception {
    assertThat(Rank.from("Q").rankValue())
        .isEqualTo(10);
  }

  @Test
  public void withAceHasNumericValueOf1() throws Exception {
    assertThat(Rank.from("A").rankValue())
        .isEqualTo(1);
  }


}