package com.example.projekt2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addExpenseButton = findViewById(R.id.add_expense);

        addExpenseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), AddExpenseActivity.class);
                startActivity(intent);
            }

        });




    }
    @Override
    public void onResume(){
        super.onResume();
        TextView expensesTextView = findViewById(R.id.expenses);

        String expensesString = "";

        List<Expense> expenses = ExpenseDatabase.getExpenses();

        for (Expense expense : expenses) {
            expensesString += expense.getName() + " " + expense.getCategory() + " " + expense.getPrice() + "\n";
        }

        expensesTextView.setText(expensesString);

    }

    private class ExpenseListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ExpenseDatabase.getExpenses().size();
        }

        @Override
        public Expense getItem(int position) {
            return ExpenseDatabase.getExpenses().get(position);
        }

        @Override
        public long getItemId(int position) {
            return  position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_expense, null);
            }

            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView price = (TextView) convertView.findViewById(R.id.price);
            TextView category = (TextView) convertView.findViewById(R.id.category);
            Expense item = getItem(position);
            title.setText(item.getName());

            price.setText(String.format("%.2f", item.getPrice()) + "zł");
            category.setText(item.getCategory().getName());

            return convertView;
        }

    }



}
