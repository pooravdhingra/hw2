package filter;

import java.util.List;
import java.util.stream.Collectors;
import model.Transaction;
import controller.InputValidation;

/** Filters by maximum amount (≤ amount). */
public class AmountFilter implements TransactionFilter {

    private final double maxAmount;

    public AmountFilter(double maxAmount) {
        if (!InputValidation.isValidAmount(maxAmount)) {
            throw new IllegalArgumentException("Invalid amount");
        }
        this.maxAmount = maxAmount;
    }

    @Override
    public List<Transaction> filter(List<Transaction> input) {
        return input.stream()
                    .filter(t -> t.getAmount() <= maxAmount)
                    .collect(Collectors.toList());
    }
}
