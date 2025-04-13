package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseTrackerModel {

  private final List<Transaction> transactions = new ArrayList<>();

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  public List<Transaction> getTransactions() {
    return Collections.unmodifiableList(transactions);
  }

}