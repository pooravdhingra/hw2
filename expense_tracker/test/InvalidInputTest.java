import static org.junit.Assert.*;

import org.junit.*;

import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;

public class InvalidInputTest {

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
    public void invalidAmount_doesNotModifyState() {
        boolean added = controller.addTransaction(-10.0, "food");
        assertFalse(added);
        assertEquals(0, model.getTransactions().size());
        assertEquals(0, view.getTableModel().getRowCount());
    }

    @Test
    public void invalidCategory_doesNotModifyState() {
        boolean added = controller.addTransaction(25.0, "123");
        assertFalse(added);
        assertEquals(0, model.getTransactions().size());
        assertEquals(0, view.getTableModel().getRowCount());
    }
}
