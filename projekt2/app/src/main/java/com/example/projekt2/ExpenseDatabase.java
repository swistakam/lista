package com.example.projekt2;

import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;
import java.util.ArrayList;



public class ExpenseDatabase {

        private static List<Expense> expenses = new ArrayList<Expense>();

        public static List<Expense> getExpenses() {
            return expenses;
        }

        static  {
            expenses.add(new Expense("Pomidory" , 3.2, ExpenseCategory.FOOD));
            expenses.add(new Expense("Kino" , 32, ExpenseCategory.ENTERTAINMENT));
            expenses.add(new Expense("Szampon" , 9.99, ExpenseCategory.HYGIENE));
        }

        public static void addExpense(Expense expense) {
            expenses.add(expense);
        }




}

