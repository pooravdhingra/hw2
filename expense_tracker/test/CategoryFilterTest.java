import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import filter.CategoryFilter;
import model.Transaction;

public class CategoryFilterTest {

    @Test
    public void categoryFilter_returnsOnlyMatchingTransactions() {
        List<Transaction> data = Arrays.asList(
            new Transaction(15, "food"),
            new Transaction(40, "bills"),
            new Transaction(22, "food")
        );

        CategoryFilter filter = new CategoryFilter("food");
        List<Transaction> result = filter.filter(data);

        assertEquals(2, result.size());
        assertTrue(result.stream()
                         .allMatch(t -> t.getCategory().equalsIgnoreCase("food")));
    }
}
