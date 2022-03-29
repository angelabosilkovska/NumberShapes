package com.android.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button testNumber;
    private EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testNumber = (Button) findViewById(R.id.button);
        testNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testNumber();
            }
        });

    }

    class Number {
        int number;

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);

            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }
            else {
                return false;
            }
        }
        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;

            while (triangularNumber < number){
                x++;
                triangularNumber = triangularNumber + x;
            }
            if(triangularNumber == number) {
                return true;
            }
            else{
                return false;
            }
        }
    }
    public void testNumber(){

        input = (EditText) findViewById(R.id.editTextNumberDecimal);

        Number myNumber = new Number();
        myNumber.number = Integer.parseInt(input.getText().toString());

        String message = input.getText().toString();

        if (myNumber.isSquare() && myNumber.isTriangular()) {
            message +=  " is square and triangular";
        }
        else if (myNumber.isSquare()) {
            message +=  " is square";
        }
        else if (myNumber.isTriangular()) {
            message +=  " is triangular";
        }
        else {
            message +=  " is not square nor triangular";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        System.out.println(message);

    }
}