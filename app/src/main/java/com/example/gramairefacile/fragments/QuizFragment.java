package com.example.gramairefacile.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gramairefacile.R;
import com.example.gramairefacile.database.DatabaseHelper;
import com.example.gramairefacile.utils.Constants;
import com.example.gramairefacile.widgets.radiobutton.PresetRadioGroup;
import com.example.gramairefacile.widgets.radiobutton.PresetValueButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizFragment extends Fragment {

    private TextView titleQuestion, labelAlert;
    private PresetRadioGroup choiceRadioGroup;
    private PresetValueButton choiceA, choiceB, choiceC, choiceD;

    private String title;
    private List<String> choices;
    private List<PresetValueButton> presetValueButtons;
    private int correctIndexofChoices;

    private String answer = "";
    private boolean answerSelected = false;
    private int numberOfTap = 0;

    public static QuizFragment newInstance(String question, String choices, int index) {
        Bundle args = new Bundle();
        args.putString(Constants.ARGS_QUESTION, question);
        args.putString(Constants.ARGS_CHOICES, choices);
        args.putInt(Constants.ARGS_CORRECT_INDEX_OF_CHOICES, index);

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

    private void readArguments() {
        title = getArguments().getString(Constants.ARGS_QUESTION, "");
        choices = Arrays.asList(DatabaseHelper.toArray(getArguments().getString(Constants.ARGS_CHOICES, ""), String[].class));
        correctIndexofChoices = getArguments().getInt(Constants.ARGS_CORRECT_INDEX_OF_CHOICES, 0);
    }

    private void initViews(View view) {
        titleQuestion = view.findViewById(R.id.tv_question);
        labelAlert = view.findViewById(R.id.tv_alert_answer);
        choiceRadioGroup = view.findViewById(R.id.rdgroup_choice);
        choiceA = view.findViewById(R.id.rdbtn_choice_a);
        choiceB = view.findViewById(R.id.rdbtn_choice_b);
        choiceC = view.findViewById(R.id.rdbtn_choice_c);
        choiceD = view.findViewById(R.id.rdbtn_choice_d);

        titleQuestion.setText(title);

        presetValueButtons = new ArrayList<>();
        presetValueButtons.add(choiceA);
        presetValueButtons.add(choiceB);
        presetValueButtons.add(choiceC);
        presetValueButtons.add(choiceD);

        choiceA.setValue(choices.get(0));
        choiceB.setValue(choices.get(1));
        choiceC.setValue(choices.get(2));
        if (choices.size() > 3) {
            choiceD.setValue(choices.get(3));
        } else {
            choiceD.setVisibility(View.GONE);
        }

        choiceRadioGroup.setOnCheckedChangeListener(new PresetRadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View radioGroup, View radioButton, boolean isChecked, int checkedId) {
                answer = ((PresetValueButton) radioButton).getValue();
                answerSelected = true;
            }
        });
    }

    public boolean isAnswerSelected() {
        return answerSelected;
    }

    public boolean isAlreadyChecked() {
        return numberOfTap == 2;
    }

    public boolean isCorrectAnswer() {
        boolean correct = answer.equals(choices.get(correctIndexofChoices));
        if (!correct) {
            numberOfTap += 1;

            presetValueButtons.get(choices.indexOf(answer)).setErrorState();
            labelAlert.setVisibility(View.VISIBLE);

            String label = getString(R.string.alert_incorrect_answer, choices.get(correctIndexofChoices));
            Spannable wordtoSpan = new SpannableString(label);
            wordtoSpan.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.selectedButton)),
                    label.length() - choices.get(correctIndexofChoices).length() - 5, label.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            labelAlert.setText(wordtoSpan);

            disableChoices();
        }
        return correct;
    }

    private void disableChoices() {
        choiceA.setEnabled(false);
        choiceB.setEnabled(false);
        choiceC.setEnabled(false);
        choiceD.setEnabled(false);
    }
}
