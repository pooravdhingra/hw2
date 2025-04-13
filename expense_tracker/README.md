# hw2- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 


Adding Transaction

• Adds transaction to table based on amount and category input


Filtering

• Filter the table by Amount (≤ value) or Category.

• Uses the Strategy design pattern (TransactionFilter, AmountFilter, CategoryFilter).

• Demonstrates extensibility: new filter algorithms can be dropped‑in without touching existing code.


Immutability

• Transaction is now an immutable value object.• ExpenseTrackerModel returns an unmodifiable view of its internal list.

• Enforces the open‑closed principle and prevents accidental mutation from outside the model layer.


Docs

• Project now ships pre‑generated Javadoc in jdoc/.

• Aids understandability and grading.


## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTrackerApp
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.