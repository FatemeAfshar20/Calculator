package com.example.calculator.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculator.R;

import java.lang.reflect.Field;

public class CalculatorActivity extends AppCompatActivity {
    private Calculator mCalculator = new Calculator();
    private Button[] mBtnNumbers = new Button[10];
    private Button mBtnDelete,mBtnMul,mBtnDiv,mBtnAdd,mBtnSub,mBtnEqual;
    private EditText mText;
    private int[] recurseIds = createId(mBtnNumbers, "btn_");
    private double number=0;
    private double anotherNum=0;
    private boolean mIsSymbol=false;
    private String mInputSymbol="";
    private String mInputNum="";
   private double mResult =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findElem();
        setListener();
    }

    public void findElem() {
        for (int i = 0; i < mBtnNumbers.length; i++) {
            mBtnNumbers[i] = findViewById(recurseIds[i]);
        }
        mText = findViewById(R.id.edit);
        mBtnDelete=findViewById(R.id.btn_delete);
        mBtnAdd=findViewById(R.id.btn_add);
        mBtnEqual=findViewById(R.id.brn_equal);
        mBtnSub=findViewById(R.id.btn_sub);
        mBtnDiv=findViewById(R.id.btn_div);
        mBtnMul=findViewById(R.id.btn_mul);
    }

    public void setListener() {

        for (int i = 0; i < mBtnNumbers.length; i++) {
            final int finalI = i;
            mBtnNumbers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mInputNum="" + getResources().getText(getId("num_" + finalI, R.string.class));
                    mText.setText(mText.getText() +mInputNum);
                    number=Double.parseDouble(mInputNum);
                    if (!mIsSymbol)
                        mResult = number;
                    else {
                        anotherNum = number;
                        mResult=calculator();
                        mIsSymbol=false;
                    }
                }
            });
        }

        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText("");
                mResult=0;
            }
        });

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText(mText.getText()+" + ");
                mInputSymbol="+";
                mIsSymbol=true;
            }
        });
        mBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText(mText.getText()+" - ");
                mInputSymbol="-";
                mIsSymbol=true;
            }
        });
        mBtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText(mText.getText()+" ÷ ");
                mInputSymbol="÷";
                mIsSymbol=true;
            }
        });
        mBtnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText(mText.getText()+" * ");
                mInputSymbol="*";
                mIsSymbol=true;
            }
        });

        mBtnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText(mResult+"");
                mIsSymbol=false;
            }
        });

    }

    private <T extends View> int[] createId(T[] views, String commonPartOfId) {
        int[] IDs = new int[views.length];
        for (int i = 0; i < views.length; i++) {
            int tempt = getId(commonPartOfId + i, R.id.class);
            IDs[i] = tempt;
        }
        return IDs;
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }

    public double putNum(double number){
        return number;
    }

    public double calculator(){
        double result = 0;
        // ----* input a mathematical symbol *---
       // String str = input.next();

                switch (mInputSymbol) {
                    case "+":
                        if (mResult== 0) {
                            result = mCalculator.add(number);
                        }else
                            result = mCalculator.add(mResult,anotherNum);
                        break;
                    case "-":
                        if (number == 0) {
                            result = mCalculator.subtract(anotherNum);
                        } else {
                            result = mCalculator.subtract(mResult,anotherNum);
                        }
                        break;
                    case "*":
                        if (number == 0) {
                            result = mCalculator.multiply(anotherNum);
                        } else {
                            result = mCalculator.multiply(mResult,anotherNum);
                        }
                        break;
                    case "÷":
                        if (number == 0) {
                            result = mCalculator.division(anotherNum);
                        } else {
                            result = mCalculator.division(mResult,anotherNum);
                        }
                        break;
                    default:
                        break;
                }

        return result;
    }

}