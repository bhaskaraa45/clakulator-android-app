package com.bhaskar.calkulator.aa45;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    Button btn_clear ,btn_0, btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_point,btn_equal,btn_ac,btn_plus,btn_minus,btn_mul,btn_div,btn_close,btn_open;
    EditText answer , showAnswer ;
    EditText equation;
    static DecimalFormat df = new DecimalFormat("#.###");


    @Override
    protected void onStart() {
        super.onStart();
        RelativeLayout parent = findViewById(R.id.parent);
        boolean dark;
        int currentMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        dark= currentMode == Configuration.UI_MODE_NIGHT_YES;
        if(dark){
            parent.setBackgroundColor(getResources().getColor(R.color.primary_dark));
            answer.setTextColor(getResources().getColor(R.color.white));
            showAnswer.setTextColor(getResources().getColor(R.color.white));
            equation.setTextColor(getResources().getColor(R.color.white));
        }else{
            parent.setBackgroundColor(getResources().getColor(R.color.white));
            answer.setTextColor(getResources().getColor(R.color.black));
            showAnswer.setTextColor(getResources().getColor(R.color.black));
            equation.setTextColor(getResources().getColor(R.color.black));
        }

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        RelativeLayout parent = findViewById(R.id.parent);
        boolean dark;
        int currentMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        dark= currentMode == Configuration.UI_MODE_NIGHT_YES;
        if(dark) {
            parent.setBackgroundColor(getResources().getColor(R.color.primary_dark));
            answer.setTextColor(getResources().getColor(R.color.white));
            showAnswer.setTextColor(getResources().getColor(R.color.white));
            equation.setTextColor(getResources().getColor(R.color.white));

        }
        else {
            parent.setBackgroundColor(getResources().getColor(R.color.white));
            answer.setTextColor(getResources().getColor(R.color.black));
            showAnswer.setTextColor(getResources().getColor(R.color.black));
            equation.setTextColor(getResources().getColor(R.color.black));
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //buttons
        btn_clear = findViewById(R.id.btn_clear);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_point = findViewById(R.id.btn_point);
        btn_ac = findViewById(R.id.btn_ac);
        btn_plus = findViewById(R.id.btn_plus);
        btn_equal = findViewById(R.id.btn_);
        btn_minus = findViewById(R.id.btn_minus);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);
        btn_close = findViewById(R.id.btn_close);
        btn_open = findViewById(R.id.btn_open);

        //textView
        answer = findViewById(R.id.answer);
        showAnswer = findViewById(R.id.showAnswer);
        equation = findViewById(R.id.equation);
        answer.setText("0");
        final String[] eqn = new String[1] ;
        final boolean[] equal = {false};
        eqn[0] = "";
        equation.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                equation.setSelection(equation.getText().toString().length());
            }

            @Override
            public void afterTextChanged(Editable s) {
                equation.setSelection(equation.getText().toString().length());
            }
        });
        answer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                answer.setSelection(answer.getText().toString().length());
            }

            @Override
            public void afterTextChanged(Editable s) {
                answer.setSelection(answer.getText().toString().length());
            }
        });
        showAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showAnswer.setSelection(showAnswer.getText().toString().length());
            }

            @Override
            public void afterTextChanged(Editable s) {
                showAnswer.setSelection(showAnswer.getText().toString().length());
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to check the input is "=" or not
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 0;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));

            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 1;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 2;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 3;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 4;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 5;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 6;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 7;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 8;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += 9;
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                if(!pointCheck(eqn[0])) {


                    //if no digit before '.' then add '0.'
                    if (eqn[0].length() == 0 || !((int) eqn[0].charAt(eqn[0].length() - 1) >= 48 && (int) eqn[0].charAt(eqn[0].length() - 1) <= 57)) {
                        eqn[0] += "0.";
                    } else {
                        eqn[0] += '.';
                    }
                }
                equation.setText(eqn[0]);
                answer.setText(whenPressedNumberKey(eqn[0]));
            }
        });


        //operators
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal[0] = false;
                if(eqn[0].length()>0 && isOperator(eqn[0].charAt(eqn[0].length()-1))){
                    StringBuilder sb = new StringBuilder(eqn[0]);
                    sb.deleteCharAt(sb.length()-1);
                    eqn[0] = sb.toString();
                }
                eqn[0] += '+';
                equation.setText(eqn[0]);
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal[0] = false;
                if(eqn[0].length()>0 && isOperator(eqn[0].charAt(eqn[0].length()-1))){
                    StringBuilder sb = new StringBuilder(eqn[0]);
                    sb.deleteCharAt(sb.length()-1);
                    eqn[0] = sb.toString();
                }
                eqn[0] += '-';
                equation.setText(eqn[0]);
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal[0] = false;
                if(eqn[0].length()>0 && isOperator(eqn[0].charAt(eqn[0].length()-1))){
                    StringBuilder sb = new StringBuilder(eqn[0]);
                    sb.deleteCharAt(sb.length()-1);
                    eqn[0] = sb.toString();
                }

                if(eqn[0].length()==0 || eqn[0].charAt(eqn[0].length()-1)!='('){
                    eqn[0] += 'x';
                }
                equation.setText(eqn[0]);


            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal[0] = false;
                if(eqn[0].length()>0 && isOperator(eqn[0].charAt(eqn[0].length()-1))){
                    StringBuilder sb = new StringBuilder(eqn[0]);
                    sb.deleteCharAt(sb.length()-1);
                    eqn[0] = sb.toString();
                }
                if(eqn[0].length()==0 || eqn[0].charAt(eqn[0].length()-1)!='('){
                    eqn[0] += '/';
                }
                equation.setText(eqn[0]);
            }
        });
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += "(";
                equation.setText(eqn[0]);
            }
        });
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0]){
                    eqn[0] = "";
                }
                equal[0] = false;
                eqn[0] += ")";
                equation.setText(eqn[0]);
            }
        });



        btn_equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                equal[0] = true;
                if(eqn[0].length()>0) {
                    String[] str = whenPressedEqual(eqn[0]);
                    answer.setText(str[1]);
                    equation.setText(str[1]);
                    showAnswer.setText(str[0] + " = " + str[1]);
                    eqn[0] = str[1];
                }

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(equal[0] || eqn[0].length()==1){
                    eqn[0] = "";
                    equation.setText(eqn[0]);
                    answer.setText("0");
                }
                equal[0] = false;
                StringBuilder sb = new StringBuilder(eqn[0]);
                if(sb.length()>1) {
                    sb.deleteCharAt(sb.length() - 1);

                    eqn[0] = sb.toString();
                    equation.setText(eqn[0]);

                    answer.setText(whenPressedNumberKey(eqn[0]));
                }


            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equal[0]=false;
                eqn[0]="";
                answer.setText("0");
                equation.setText("");
                showAnswer.setText("");
            }
        });
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(showAnswer.getText().toString());
                if(!sb.toString().equals("") && equal[0]){
                    String[] strings = sb.toString().split(" = ");
                    answer.setText(strings[1]);
                    equation.setText(strings[0]);
                    equal[0] = false;
                    eqn[0] = "";
                    eqn[0]+=strings[0];
                }
            }
        });
    }
    public static boolean pointCheck(String s){
        int i = s.length()-1;
        while(i>=0){
            if(s.charAt(i)=='.') return true;
            if(isOperator(s.charAt(i))) return false;
            if(s.charAt(i)=='(' || s.charAt(i)==')') return false;
            i--;
        }

        return false;
    }

    private  static String[] whenPressedEqual(String eqn){
        String[] res = new String[2];
        eqn = makeParenthesized(eqn);
        if(isMathematicalEquation(eqn)){
            eqn = makeMathematicalEqn(eqn);
            res[0] = eqn;
            double[] ans = evaluate(eqn);
            long uttor = (long) ans[1];
            if(ans[0]==1) {
                if (uttor == ans[1]) {
                    res[1]=""+uttor;
                    return res;
                } else {
                    res[1]= df.format(ans[1]);
                    return res;
                }
            }
        }
        res[1]= "Error";
        return res;
    }
    private static String whenPressedNumberKey(String eqn){
        eqn = makeParenthesized(eqn);
        eqn = makeMathematicalEqn(eqn);
        double[] ans = evaluate(eqn);
        long uttor = (long) ans[1];
        if(ans[0]==1) {
            if (uttor == ans[1]) {
                return "" + uttor;
            } else {
                return df.format(ans[1]);
            }
        }
        return "Error";
    }



    public static boolean isMathematicalEquation(String eqn){

        int i=0,cnt=0;
        StringBuilder sb = new StringBuilder(eqn);
        while(i<sb.length()){
            if(i<sb.length()-1 && (isOperator(sb.charAt(i)) && sb.charAt(i+1)==')') ){
                return false;
            }
            if(eqn.charAt(i)>47 && eqn.charAt(i)<58){
                cnt++;
            }
            i++;
        }
        return cnt!=0;
    }

    public static String makeParenthesized(String equation) {
        StringBuilder sb = new StringBuilder(equation);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }
        if(sb.charAt(sb.length()-1)=='('){
            sb.deleteCharAt(sb.length()-1);
            stack.pop();
        }

        while(!stack.isEmpty()){
            sb.append(')');
            stack.pop();
        }

        return sb.toString();
    }


    public static String makeMathematicalEqn(String eqn){

        if(isOperator(eqn.charAt(0))){
            eqn = 0 + eqn;
        }

        int i=1;
        StringBuilder sb = new StringBuilder(eqn);
        while(i<sb.length()){
            if((isOperator(sb.charAt(i-1)) && sb.charAt(i)==')') ){
                sb.deleteCharAt(i-1);
            }
            else if((sb.charAt(i)=='+' && sb.charAt(i-1)=='(') ){
                sb.deleteCharAt(i);
            }else if((sb.charAt(i)=='-' && sb.charAt(i-1)=='(') ){
                sb.insert(i,'0');
            }
            else if(sb.charAt(i)=='(' && !isOperator(sb.charAt(i-1))){
                sb.insert(i,'x');
                i++;
            }else if(sb.charAt(i-1)==')' && !isOperator(sb.charAt(i))){
                sb.insert(i,'x');
                i++;
            } else {
                i++;
            }
        }
        if(isOperator(sb.charAt(sb.length()-1))){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }


    public static double[] evaluate(String s) {
        double[] ans = new double[2];
        ans[0] = 1;

        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '.')) {
                    j++;
                }
                operands.push(Double.parseDouble(s.substring(i, j)));
                i = j;
            } else if (s.charAt(i) == '('  ) {
                operators.push(s.charAt(i));
                i++;

            } else if (s.charAt(i) == ')') {
                while (operators.peek() != '(') {
                    double b = operands.pop();
                    double a = operands.pop();
                    char op = operators.pop();
                    double res = applyOp(a, b, op);
                    operands.push(res);
                }
                operators.pop(); // pop the '('
                i++;
            } else if (isOperator(s.charAt(i))) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(s.charAt(i))) {
                    double b = operands.pop();
                    double a = operands.pop();
                    char op = operators.pop();
                    double res = applyOp(a, b, op);
                    operands.push(res);
                }
                operators.push(s.charAt(i));
                i++;
            } else {
                ans[0] = -1;
                return ans;
            }
        }
        while (!operators.isEmpty()) {
            double b = operands.pop();
            double a = operands.pop();
            char op = operators.pop();
            double res = applyOp(a, b, op);
            operands.push(res);
        }
        ans[1] = operands.pop();
        return ans;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == 'x' || c == '/';
    }

    private static int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == 'x' || c == '/') {
            return 2;
        } else {
            return -1;
        }
    }

    private static double applyOp(double a, double b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == 'x') {
            return a * b;
        } else {
            return a / b;
        }
    }

}