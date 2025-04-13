import static org.junit.Assert.*;

import org.junit.*;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;

public class AddTransactionViewTest {

    private ExpenseTrackerModel  model;
    private ExpenseTrackerView   view;
    private ExpenseTrackerController controller;

    @BeforeClass
    public static void enableHeadless() {
        System.setProperty("java.awt.headless", "true");
    }

    @Before
    public void arrange() {
        model       = new ExpenseTrackerModel();
        view        = new ExpenseTrackerView();
        controller  = new ExpenseTrackerController(model, view);
    }

    @Test
    public void addTransaction_updatesModelAndTable() {
        /* Act */
        boolean added = controller.addTransaction(50.00, "food");

        /* Assert */
        assertTrue(added);
        assertEquals(1, model.getTransactions().size());
        assertEquals(50.00, model.getTransactions().get(0).getAmount(), 0.01);

        // table: 1 data row + 1 total row
        assertEquals(2, view.getTableModel().getRowCount());
        // total row – last row, 4th column
        double total = (double) view.getTableModel()
                                    .getValueAt(view.getTableModel().getRowCount() - 1, 3);
        assertEquals(50.00, total, 0.01);
    }
}
