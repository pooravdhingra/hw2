import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import filter.AmountFilter;
import model.Transaction;

public class AmountFilterTest {

    @Test
    public void amountFilter_returnsOnlyMatchingTransactions() {
        List<Transaction> data = Arrays.asList(
            new Transaction(10, "food"),
            new Transaction(60, "bills"),
            new Transaction(30, "travel")
        );

        AmountFilter filter = new AmountFilter(40);
        List<Transaction> result = filter.filter(data);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(t -> t.getAmount() <= 40));
    }
}
