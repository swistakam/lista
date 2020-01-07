package com.example.projekt2;

import java.util.ArrayList;
import java.util.List;

public class ExpenseDatabase {

    private static List<Expense>expenses = new ArrayList<Expense>();

    public static List<Expense>getExpenses(){
        return expenses;
    }

    static {
        expenses.add(new Expense("Jajka",4.2, ExpenseCategory.FOOD));
        expenses.add(new Expense("Kino",16.7, ExpenseCategory.ENTERTAINMENT));
        expenses.add(new Expense("Mydło w płynie", 8.99,ExpenseCategory.HYGIENE));
    }

    public static void addExpense(Expense expense){
        expense.add(expense);
    }

}
