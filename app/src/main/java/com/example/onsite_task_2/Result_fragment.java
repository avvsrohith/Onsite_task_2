package com.example.onsite_task_2;

import android.graphics.Path;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

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
    ArrayList<Float> value;
    int i=0,j=0;
    float answer=0;
    String displaytext ="",valueText="",resultText;
    ArrayList<String> Operator;
    int c=0;

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
        value=new ArrayList<>();
        Operator=new ArrayList<>();

        return inflater.inflate(R.layout.fragment_result_fragment, container, false);
    }

    public void getDigit(String digit){
        displaytext +=digit;
        valueText+=digit;
        display = getView().findViewById(R.id.displaytv);
        display.setText(displaytext);
    }

    public void getOp(String operator){
        Operator.add(operator);
            displaytext+=operator;
            display = getView().findViewById(R.id.displaytv);
            display.setText(displaytext);

        if(valueText.equals("")){
            return;
        }


        value.add(Float.parseFloat(valueText));

        valueText="";

    }

    public void getResult(){
        value.add(Float.parseFloat(valueText));
        valueText="";
        displayResult();
    }

    public void displayResult(){

        for(int m=0;m<Operator.size();m++){
            if(Operator.get(m).equals("/")){
                value.set(m,value.get(m)/value.get(m+1));
                value.remove(value.get(m+1));
                Operator.remove(Operator.get(m));
                m--;
            }
        }

        for(int m=0;m<Operator.size();m++){
            if(Operator.get(m).equals("*")){
                value.set(m,value.get(m)*value.get(m+1));
                value.remove(value.get(m+1));
                Operator.remove(Operator.get(m));
                m--;
            }
        }
        for(int m=0;m<Operator.size();m++){
            if(Operator.get(m).equals("+")){
                value.set(m,value.get(m)+value.get(m+1));
                value.remove(value.get(m+1));
                Operator.remove(Operator.get(m));
                m--;
            }
        }
        for(int m=0;m<Operator.size();m++){
            if(Operator.get(m).equals("-")){
                value.set(m,value.get(m)-value.get(m+1));
                value.remove(value.get(m+1));
                Operator.remove(Operator.get(m));
                m--;
            }
        }
        answer=value.get(0);
        resultText=String.valueOf(answer);
        result=getView().findViewById(R.id.resulttv);
        result.setText(resultText);
    }



    public void backspace(){
        displaytext=removeLastChar(displaytext);
        if(valueText!="")
        valueText=removeLastChar(valueText);
        if(valueText==""){
            Operator.remove(Operator.size()-1);
        }
        display = getView().findViewById(R.id.displaytv);
        display.setText(displaytext);

    }


    public void clear(){
        displaytext="";
        resultText="";
        valueText="";
        value.clear();
        answer=0;
        i=0;
        result=getView().findViewById(R.id.resulttv);
        result.setText(resultText);
        display = getView().findViewById(R.id.displaytv);
        display.setText(displaytext);
    }

    String removeLastChar(String string){
        return string.substring(0,string.length()-1);
    }



}