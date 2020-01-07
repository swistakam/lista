package com.example.projekt2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
    }

    Spinner categorySpinner = findViewById(R.id.expense_category);

    ExpenseCategory[] categories = ExpenseCategory.values();
    ArrayAdapter<ExpenseCategory> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, categories);
categorySpinner.setAdapter(adapter);


}