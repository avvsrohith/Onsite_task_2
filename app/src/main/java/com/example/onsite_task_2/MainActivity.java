package com.example.onsite_task_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Operation_fragment.Clicked {
    Operation_fragment operation_fragment;
    Result_fragment result_fragment;
    private static final String OPERATION_TAG = "operation";
    private static final String RESULT_TAG = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();

        operation_fragment=(Operation_fragment) fragmentManager.findFragmentByTag(OPERATION_TAG);
        if(operation_fragment==null){
            operation_fragment=new Operation_fragment();
            fragmentManager.beginTransaction().add(R.id.operationfgcontainer,operation_fragment,OPERATION_TAG).commit();
        }

        result_fragment=(Result_fragment) fragmentManager.findFragmentByTag(RESULT_TAG);
        if(result_fragment==null){
            result_fragment=new Result_fragment();
            fragmentManager.beginTransaction().add(R.id.resultfgContainer,result_fragment,RESULT_TAG).commit();
        }
    }


    @Override
    public void send(String digit) {
        result_fragment.getDigit(digit);
    }

    @Override
    public void sendOp(String operator) {
        result_fragment.getOp(operator);
    }

    @Override
    public void getResult() {
        result_fragment.getResult();
    }

    @Override
    public void clear() {
        result_fragment.clear();
    }
}