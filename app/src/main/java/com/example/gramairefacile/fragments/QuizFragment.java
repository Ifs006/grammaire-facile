package com.example.gramairefacile.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.utils.Constants;
import com.example.gramairefacile.widgets.radiobutton.PresetRadioGroup;
import com.example.gramairefacile.widgets.radiobutton.PresetValueButton;

import java.util.List;

public class QuizFragment extends Fragment {

    private TextView titleQuestion;
    private PresetRadioGroup choiceRadioGroup;
    private PresetValueButton choiceA, choiceB, choiceC, choiceD;

    private String title;
    private String[] choices;
    private String answer = "";

    public static QuizFragment newInstance(String question, String choices) {
        Bundle args = new Bundle();
        args.putString(Constants.ARGS_QUESTION,question);
        args.putString(Constants.ARGS_CHOICES,choices);

        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        readArguments();
        initViews(view);
    }

    private void readArguments(){
        title = getArguments().getString(Constants.ARGS_QUESTION, "");
        choices = DatabaseHelper.toArray(getArguments().getString(Constants.ARGS_CHOICES, ""), String[].class);
    }

    private void initViews(View view){
        titleQuestion = view.findViewById(R.id.tv_question);
        choiceRadioGroup = view.findViewById(R.id.rdgroup_choice);
        choiceA = view.findViewById(R.id.rdbtn_choice_a);
        choiceB = view.findViewById(R.id.rdbtn_choice_b);
        choiceC = view.findViewById(R.id.rdbtn_choice_c);
        choiceD = view.findViewById(R.id.rdbtn_choice_d);

        titleQuestion.setText(title);
        choiceA.setValue(choices[0]);
        choiceB.setValue(choices[1]);
        choiceC.setValue(choices[2]);
        choiceD.setValue(choices[3]);

        choiceRadioGroup.setOnCheckedChangeListener(new PresetRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View radioGroup, View radioButton, boolean isChecked, int checkedId) {
                answer = ((PresetValueButton) radioButton).getValue();
            }
        });
    }

    public String getAnswer() {
        return answer;
    }
}
