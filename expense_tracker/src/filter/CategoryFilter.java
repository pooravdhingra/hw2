package filter;

import java.util.List;
import java.util.stream.Collectors;
import model.Transaction;
import controller.InputValidation;

/** Filters by exact category (case‑insensitive). */
public class CategoryFilter implements TransactionFilter {

    private final String category;

    public CategoryFilter(String category) {
        if (!InputValidation.isValidCategory(category)) {
            throw new IllegalArgumentException("Invalid category");
        }
        this.category = category.toLowerCase();
    }

    @Override
    public List<Transaction> filter(List<Transaction> input) {
        return input.stream()
                    .filter(t -> t.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
    }
}
