package com.example.shaol.char_sheet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaol on 6/10/2018.
 */

public class SkillRoll extends AppCompatActivity {
    static String[] skillz;

    @BindView(R.id.acrobatics_button) Button bAcrobatics;
    @BindView(R.id.acrobatics_roll) TextView mAcrobatics;
    @BindView(R.id.animal_handling_button) Button bAnimalHandling;
    @BindView(R.id.animal_handling_roll) TextView mAnimalHandling;
    @BindView(R.id.arcana_button) Button bArcana;
    @BindView(R.id.arcana_roll) TextView mArcana;
    @BindView(R.id.athletics_button) Button bAthletics;
    @BindView(R.id.athletics_roll) TextView mAthletics;
    @BindView(R.id.deception_button) Button bDeception;
    @BindView(R.id.deception_roll) TextView mDeception;
    @BindView(R.id.history_button) Button bHistory;
    @BindView(R.id.history_roll) TextView mHistory;
    @BindView(R.id.insight_button) Button bInsight;
    @BindView(R.id.insight_roll) TextView mInsight;
    @BindView(R.id.intimidation_button) Button bIntimidation;
    @BindView(R.id.intimidation_roll) TextView mIntimidation;
    @BindView(R.id.investigation_button) Button bInvestigation;
    @BindView(R.id.investigation_roll) TextView mInvestigation;
    @BindView(R.id.medicine_button) Button bMedicine;
    @BindView(R.id.medicine_roll) TextView mMedicine;
    @BindView(R.id.nature_button) Button bNature;
    @BindView(R.id.nature_roll) TextView mNature;
    @BindView(R.id.perception_button) Button bPerception;
    @BindView(R.id.perception_roll) TextView mPerception;
    @BindView(R.id.performance_button) Button bPerformance;
    @BindView(R.id.performance_roll) TextView mPerformance;
    @BindView(R.id.persuasion_button) Button bPersuasion;
    @BindView(R.id.persuasion_roll) TextView mPersuasion;
    @BindView(R.id.religion_button) Button bReligion;
    @BindView(R.id.religion_roll) TextView mReligion;
    @BindView(R.id.sleight_of_hand_button) Button bSleightOfHand;
    @BindView(R.id.sleight_of_hand_roll) TextView mSleightOfHand;
    @BindView(R.id.stealth_button) Button bStealth;
    @BindView(R.id.stealth_roll) TextView mStealth;
    @BindView(R.id.survival_button) Button bSurvival;
    @BindView(R.id.survival_roll) TextView mSurvival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skill_roll);
        setTitle(R.string.skill_roll);

        Intent intent = getIntent();
        skillz = intent.getStringArrayExtra("Skills");

        ButterKnife.bind(this);
    }

    public void acrobaticsRoll(View view) {
        int roll;
        if (!skillz[0].equals("")) {
        int mod = Integer.parseInt(skillz[0]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mAcrobatics.setText(String.valueOf(roll));
    }

    public void animalHandlingRoll(View view) {
        int roll;
        if (!skillz[1].equals("")) {
            int mod = Integer.parseInt(skillz[1]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mAnimalHandling.setText(String.valueOf(roll));
    }

    public void arcanaRoll(View view) {
        int roll;
        if (!skillz[2].equals("")) {
            int mod = Integer.parseInt(skillz[2]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mArcana.setText(String.valueOf(roll));
    }

    public void athleticsRoll(View view) {
        int roll;
        if (!skillz[3].equals("")) {
            int mod = Integer.parseInt(skillz[3]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mAthletics.setText(String.valueOf(roll));
    }

    public void deceptionRoll(View view) {
        int roll;
        if (!skillz[4].equals("")) {
            int mod = Integer.parseInt(skillz[4]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mDeception.setText(String.valueOf(roll));
    }

    public void historyRoll(View view) {
        int roll;
        if (!skillz[5].equals("")) {
            int mod = Integer.parseInt(skillz[5]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mHistory.setText(String.valueOf(roll));
    }

    public void insightRoll(View view) {
        int roll;
        if (!skillz[6].equals("")) {
            int mod = Integer.parseInt(skillz[6]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mInsight.setText(String.valueOf(roll));
    }

    public void intimidationRoll(View view) {
        int roll;
        if (!skillz[7].equals("")) {
            int mod = Integer.parseInt(skillz[7]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mIntimidation.setText(String.valueOf(roll));
    }

    public void investigationRoll(View view) {
        int roll;
        if (!skillz[8].equals("")) {
            int mod = Integer.parseInt(skillz[8]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mInvestigation.setText(String.valueOf(roll));
    }

    public void medicineRoll(View view) {
        int roll;
        if (!skillz[9].equals("")) {
            int mod = Integer.parseInt(skillz[9]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mMedicine.setText(String.valueOf(roll));
    }

    public void natureRoll(View view) {
        int roll;
        if (!skillz[10].equals("")) {
            int mod = Integer.parseInt(skillz[10]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mNature.setText(String.valueOf(roll));
    }

    public void perceptionRoll(View view) {
        int roll;
        if (!skillz[11].equals("")) {
            int mod = Integer.parseInt(skillz[11]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mPerception.setText(String.valueOf(roll));
    }

    public void performanceRoll(View view) {
        int roll;
        if (!skillz[12].equals("")) {
            int mod = Integer.parseInt(skillz[12]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mPerformance.setText(String.valueOf(roll));
    }

    public void persuasionRoll(View view) {
        int roll;
        if (!skillz[13].equals("")) {
            int mod = Integer.parseInt(skillz[13]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mPersuasion.setText(String.valueOf(roll));
    }

    public void religionRoll(View view) {
        int roll;
        if (!skillz[14].equals("")) {
            int mod = Integer.parseInt(skillz[14]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mReligion.setText(String.valueOf(roll));
    }

    public void sleightOfHandRoll(View view) {
        int roll;
        if (!skillz[15].equals("")) {
            int mod = Integer.parseInt(skillz[15]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mSleightOfHand.setText(String.valueOf(roll));
    }

    public void stealthRoll(View view) {
        int roll;
        if (!skillz[16].equals("")) {
            int mod = Integer.parseInt(skillz[16]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mStealth.setText(String.valueOf(roll));
    }

    public void survivalRoll(View view) {
        int roll;
        if (!skillz[17].equals("")) {
            int mod = Integer.parseInt(skillz[17]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mSurvival.setText(String.valueOf(roll));
    }

    public int dTwenty(){
        Random r = new Random();
        return r.nextInt(20) + 1;
    }
}
