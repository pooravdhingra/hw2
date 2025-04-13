import controller.ExpenseTrackerController;
import filter.AmountFilter;
import filter.CategoryFilter;
import filter.TransactionFilter;
import javax.swing.JOptionPane;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;

public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();
      
      // Call controller to add transaction
      boolean added = controller.addTransaction(amount, category);
      
      if (!added) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });

    view.getApplyFilterBtn().addActionListener(e -> {
      String type  = view.getSelectedFilterType();
      String value = view.getFilterValue();

      try {
        TransactionFilter f =
            type.equals("Amount")
            ? new AmountFilter(Double.parseDouble(value))
            : new CategoryFilter(value);

        controller.applyFilter(f);
      } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(view, "Amount must be numeric");
      } catch (IllegalArgumentException iae) {
          JOptionPane.showMessageDialog(view, iae.getMessage());
      }
    });

    view.getRemoveFilterBtn().addActionListener(e -> controller.clearFilter());

  }

}