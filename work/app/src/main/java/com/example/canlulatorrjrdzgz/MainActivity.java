package com.example.canlulatorrjrdzgz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity{
    private TextView solutionTextView, resultTextView;
    private StringBuilder inputStringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solutionTextView = findViewById(R.id.solution_tv);
        resultTextView = findViewById(R.id.result_tv);
        inputStringBuilder = new StringBuilder();

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                inputStringBuilder.append(button.getText());
                updateSolution();
            }
        };

        int[] buttonIds = {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
                R.id.button_8, R.id.button_9, R.id.button_plus, R.id.button_minus,
                R.id.button_multiply, R.id.button_divide, R.id.button_dot,
                R.id.button_open_bracket, R.id.button_close_bracket
        };

        for (int buttonId : buttonIds) {
            Button button = findViewById(buttonId);
            button.setOnClickListener(buttonClickListener);
        }

        Button equalsButton = findViewById(R.id.button_equals);
        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });

        Button clearButton = findViewById(R.id.button_c);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInput();
            }
        });

    }

    private void updateSolution() {
        solutionTextView.setText(inputStringBuilder.toString());
    }
    private void calculateResult() {
        try {
            String input = inputStringBuilder.toString();
            Expression expression = new ExpressionBuilder(input).build();
            double result = (int)expression.evaluate();
            resultTextView.setText(String.valueOf(result));

        } catch (Exception e) {
            resultTextView.setText("Error");
        }
    }

    private void clearInput() {
        inputStringBuilder.setLength(0);
        solutionTextView.setText("");
        resultTextView.setText("0");
    }
}
