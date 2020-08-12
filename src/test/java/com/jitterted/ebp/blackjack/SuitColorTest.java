package com.jitterted.ebp.blackjack;

import org.fusesource.jansi.Ansi;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SuitColorTest {
  @Test
  public void suitOfDiamondsIsColorRed() throws Exception {
    assertThat(Suit.DIAMONDS.cardColor())
        .isEqualTo(Ansi.Color.RED);
  }

  @Test
  public void suitOfHeartsIsColorRed() throws Exception {
    assertThat(Suit.HEARTS.cardColor())
        .isEqualTo(Ansi.Color.RED);
  }

}
