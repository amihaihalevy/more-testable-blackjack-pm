package com.jitterted.ebp.blackjack;

public class Wallet {
  private int balance;

  public Wallet(int initialAmount) {
    balance = initialAmount;
  }

  public Wallet() {
    balance = 0;
  }

  public boolean isEmpty() {
    return balance == 0;
  }

  public void add(int amount) {
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int amount) {
    checkSufficientBalance(amount);
    balance -= amount;
  }

  private void checkSufficientBalance(int amount) {
    if (amount > balance) {
      throw new IllegalStateException();
    }
  }
}
