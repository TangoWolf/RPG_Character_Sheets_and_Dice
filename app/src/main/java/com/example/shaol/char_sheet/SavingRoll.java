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

public class SavingRoll extends AppCompatActivity {
    static String[] attributes;

    @BindView(R.id.strength_roll) TextView mStrength;
    @BindView(R.id.dexterity_roll) TextView mDexterity;
    @BindView(R.id.constitution_roll) TextView mConstitution;
    @BindView(R.id.intelligence_roll) TextView mIntelligence;
    @BindView(R.id.wisdom_roll) TextView mWisdom;
    @BindView(R.id.charisma_roll) TextView mCharisma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saving_roll);
        setTitle(R.string.attribute_roll);

        Intent intent = getIntent();
        attributes = intent.getStringArrayExtra("Attributes");

        ButterKnife.bind(this);
    }

    public void strengthRoll(View view) {
        int roll;
        if (!attributes[0].equals("")) {
            int mod = Integer.parseInt(attributes[0]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mStrength.setText(String.valueOf(roll));
    }

    public void dexterityRoll(View view) {
        int roll;
        if (!attributes[1].equals("")) {
            int mod = Integer.parseInt(attributes[1]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mDexterity.setText(String.valueOf(roll));
    }

    public void constitutionRoll(View view) {
        int roll;
        if (!attributes[2].equals("")) {
            int mod = Integer.parseInt(attributes[2]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mConstitution.setText(String.valueOf(roll));
    }

    public void intelligenceRoll(View view) {
        int roll;
        if (!attributes[3].equals("")) {
            int mod = Integer.parseInt(attributes[3]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mIntelligence.setText(String.valueOf(roll));
    }

    public void wisdomRoll(View view) {
        int roll;
        if (!attributes[4].equals("")) {
            int mod = Integer.parseInt(attributes[4]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mWisdom.setText(String.valueOf(roll));
    }

    public void charismaRoll(View view) {
        int roll;
        if (!attributes[5].equals("")) {
            int mod = Integer.parseInt(attributes[5]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mCharisma.setText(String.valueOf(roll));
    }

    public int dTwenty(){
        Random r = new Random();
        return r.nextInt(20) + 1;
    }
}
