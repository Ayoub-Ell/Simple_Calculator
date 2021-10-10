package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultEdit;
    private enum Operator {none, add, minus, multiply, divide}
    private double value1 =0, value2 = 0;
    private Operator operator = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton (View view) {
        int ID = view.getId();
        resultEdit = (TextView)findViewById(R.id.resultEdit);

        switch (ID) {
            case R.id.btn00:
                resultEdit.setText(resultEdit.getText() + "0");
                break;
            case R.id.btn01:
                resultEdit.setText(resultEdit.getText() + "1");
                break;
            case R.id.btn02:
                resultEdit.setText(resultEdit.getText() + "2");
                break;
            case R.id.btn03:
                resultEdit.setText(resultEdit.getText() + "3");
                break;
            case R.id.btn04:
                resultEdit.setText(resultEdit.getText() + "4");
                break;
            case R.id.btn05:
                resultEdit.setText(resultEdit.getText() + "5");
                break;
            case R.id.btn06:
                resultEdit.setText(resultEdit.getText() + "6");
                break;
            case R.id.btn07:
                resultEdit.setText(resultEdit.getText() + "7");
                break;
            case R.id.btn08:
                resultEdit.setText(resultEdit.getText() + "8");
                break;
            case R.id.btn09:
                resultEdit.setText(resultEdit.getText() + "9");
                break;
            case R.id.btnClear:
                resultEdit.setText("");
                break;
            case R.id.btnDot:
                resultEdit.setText(resultEdit.getText() + ".");
                break;
            case R.id.btnAdd:
                operator = Operator.add;
                value1 = Double.parseDouble(resultEdit.getText().toString());
                resultEdit.setText("");
                break;
            case R.id.btnMinus:
                operator = Operator.minus;
                value1 = Double.parseDouble(resultEdit.getText().toString());
                resultEdit.setText("");
                break;
            case R.id.btnMultiply:
                operator = Operator.multiply;
                value1 = Double.parseDouble(resultEdit.getText().toString());
                resultEdit.setText("");
                break;
            case R.id.btnDivide:
                operator = Operator.divide;
                value1 = Double.parseDouble(resultEdit.getText().toString());
                resultEdit.setText("");
                break;
            default:
                resultEdit.setText("ERROR");
                break;
        }
    }

    public void btnResultClick (View view) {
        if (operator != Operator.none) {
            resultEdit = (TextView) findViewById(R.id.resultEdit);
            value2 = Double.parseDouble(resultEdit.getText().toString());
            double result = 0;
            if (operator == Operator.add) {
                result = value1 + value2;
            } else if (operator == Operator.minus) {
                result = value1 - value2;
            } else if (operator == Operator.multiply) {
                result = value1 * value2;
            } else if (operator == Operator.divide) {
                result = value1 / value2;
            }
            operator = Operator.none;
            value1 = result;
            if (result - (int) result != 0) {
                resultEdit.setText(String.valueOf(result));
            } else
                resultEdit.setText(String.valueOf((int) result));
        }
    }
}
