package com.example.onsite_task_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Result_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Result_fragment extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView display,result;
    View view;
    float[] value;
    int i=0;
    float answer=0;
    String displaytext ="",valueText="",resultText,Operator;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Result_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Result_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Result_fragment newInstance(String param1, String param2) {
        Result_fragment fragment = new Result_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_result_fragment, container, false);
        display=view.findViewById(R.id.displaytv);
        result=view.findViewById(R.id.resulttv);
        value=new float[100];

        return inflater.inflate(R.layout.fragment_result_fragment, container, false);
    }

    public void getDigit(String digit){
        displaytext +=digit;
        valueText+=digit;
        display = getView().findViewById(R.id.displaytv);
        display.setText(displaytext);
    }

    public void getOp(String operator){
        Operator=operator;
        if(!operator.equals("=")){
            displaytext+=operator;
            display = getView().findViewById(R.id.displaytv);
            display.setText(displaytext);}

        if(valueText.equals("")){
            Operator=operator;
            return;
        }


        value[i++]=Float.parseFloat(valueText);
        if(i>1){
            displayResult();
        }
        valueText="";

    }

    public void getResult(){
        value[i++]=Float.parseFloat(valueText);
        valueText="";
        displayResult();
    }

    public void displayResult(){
        if(answer==0){
            answer=value[i-2];
        }
        switch (Operator){
            case "+":
                answer+=value[i-1];
                break;
            case "-":
                answer-=value[i-1];
                break;
            case "*":
                answer*=value[i-1];
                break;
            case "/":
                answer/=value[i-1];
                break;
        }
        resultText=String.valueOf(answer);
        result=getView().findViewById(R.id.resulttv);
        result.setText(resultText);
    }


    public void clear(){
        displaytext="";
        resultText="";
        valueText="";
        value=new float[100];
        answer=0;
        i=0;
        result=getView().findViewById(R.id.resulttv);
        result.setText(resultText);
        display = getView().findViewById(R.id.displaytv);
        display.setText(displaytext);
    }



}