package filter;

import java.util.List;
import model.Transaction;

/** Strategy for filtering a list of transactions. */
public interface TransactionFilter {
    List<Transaction> filter(List<Transaction> input);
}
