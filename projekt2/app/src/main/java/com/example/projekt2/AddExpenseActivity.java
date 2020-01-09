package com.example.projekt2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        Spinner categorySpinner = findViewById(R.id.expense_category);

        ExpenseCategory[] categories = ExpenseCategory.values();
        ArrayAdapter<ExpenseCategory> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, categories);
        categorySpinner.setAdapter(adapter);


        Button newExpenseButton = findViewById(R.id.add_expense);

        newExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewExpense();
            }
        });

    }


    private void addNewExpense() {
        EditText nameEditText = findViewById(R.id.expense_name);
        EditText priceEditText = findViewById(R.id.expense_price);
        Spinner categorySpinner = findViewById(R.id.expense_category);

        String title = nameEditText.getText().toString();
        double price = Double.parseDouble(priceEditText.getText().toString());
        ExpenseCategory category = (ExpenseCategory) categorySpinner.getSelectedItem();

        Expense expense = new Expense(title, price, category);
        ExpenseDatabase.addExpense(expense);

        finish();
    }



}