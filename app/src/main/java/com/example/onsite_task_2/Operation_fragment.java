package com.example.onsite_task_2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Operation_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Operation_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Clicked callback;

    public interface Clicked{
        void send(int digit);
    }

    public Operation_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Operation_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Operation_fragment newInstance(String param1, String param2) {
        Operation_fragment fragment = new Operation_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button[] numbers;

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
        View view=inflater.inflate(R.layout.fragment_operation_fragment, container, false);
        numbers =new Button[10];
        numbers[0]=view.findViewById(R.id.btn_0);
        numbers[1]=view.findViewById(R.id.btn_1);
        numbers[2]=view.findViewById(R.id.btn_2);
        numbers[3]=view.findViewById(R.id.btn_3);
        numbers[4]=view.findViewById(R.id.btn_4);
        numbers[5]=view.findViewById(R.id.btn_5);
        numbers[6]=view.findViewById(R.id.btn_6);
        numbers[7]=view.findViewById(R.id.btn_7);
        numbers[8]=view.findViewById(R.id.btn_8);
        numbers[9]=view.findViewById(R.id.btn_9);

        numbers[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(0);
            }
        });
        numbers[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(1);
            }
        });
        numbers[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(2);
            }
        });
        numbers[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(3);
            }
        });
        numbers[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(4);
            }
        });
        numbers[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(5);
            }
        });
        numbers[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(6);
            }
        });
        numbers[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(7);
            }
        });
        numbers[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(8);
            }
        });
        numbers[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.send(9);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Clicked){
            callback=(Clicked) context;
        }
        else{
            throw new RuntimeException(context.toString()+"Listener not implemented");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback=null;
    }
}