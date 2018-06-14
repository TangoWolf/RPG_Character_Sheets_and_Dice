package com.example.shaol.char_sheet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaol on 6/10/2018.
 */

public class CustomRoll extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.d_four_spinner) Spinner sDFour;
    @BindView(R.id.d_six_spinner) Spinner sDSix;
    @BindView(R.id.d_eight_spinner) Spinner sDEight;
    @BindView(R.id.d_ten_spinner) Spinner sDTen;
    @BindView(R.id.d_twelve_spinner) Spinner sDTwelve;
    @BindView(R.id.d_twenty_spinner) Spinner sDTwenty;
    @BindView(R.id.d_hundred_spinner) Spinner sDHundred;
    @BindView(R.id.d_four_roll) TextView mDFour;
    @BindView(R.id.d_six_roll) TextView mDSix;
    @BindView(R.id.d_eight_roll) TextView mDEight;
    @BindView(R.id.d_ten_roll) TextView mDTen;
    @BindView(R.id.d_twelve_roll) TextView mDTwelve;
    @BindView(R.id.d_twenty_roll) TextView mDTwenty;
    @BindView(R.id.d_hundred_roll) TextView mDHundred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_roll);
        setTitle(R.string.custom_roll);

        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.custom_roll_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sDFour.setAdapter(adapter);
        sDSix.setAdapter(adapter);
        sDEight.setAdapter(adapter);
        sDTen.setAdapter(adapter);
        sDTwelve.setAdapter(adapter);
        sDTwenty.setAdapter(adapter);
        sDHundred.setAdapter(adapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void dFourRoll(View view) {
        int dice = sDFour.getSelectedItemPosition();
        if (dice == 0) {
            Toast.makeText(this, R.string.no_dice, Toast.LENGTH_SHORT).show();
        } else if (dice == 1) {
            mDFour.setText((String.valueOf(dFour())));
        } else {
            String roll = String.valueOf(dFour());
            for (int i = 1; i < dice; i++) {
                roll = roll + ", " + dFour();
            }
            mDFour.setText(roll);
        }
    }

    public void dSixRoll(View view) {
        int dice = sDSix.getSelectedItemPosition();
        if (dice == 0) {
            Toast.makeText(this, R.string.no_dice, Toast.LENGTH_SHORT).show();
        } else if (dice == 1) {
            mDSix.setText((String.valueOf(dSix())));
        } else {
            String roll = String.valueOf(dSix());
            for (int i = 1; i < dice; i++) {
                roll = roll + ", " + dSix();
            }
            mDSix.setText(roll);
        }
    }

    public void dEightRoll(View view) {
        int dice = sDEight.getSelectedItemPosition();
        if (dice == 0) {
            Toast.makeText(this, R.string.no_dice, Toast.LENGTH_SHORT).show();
        } else if (dice == 1) {
            mDEight.setText((String.valueOf(dEight())));
        } else {
            String roll = String.valueOf(dEight());
            for (int i = 1; i < dice; i++) {
                roll = roll + ", " + dEight();
            }
            mDEight.setText(roll);
        }
    }

    public void dTenRoll(View view) {
        int dice = sDTen.getSelectedItemPosition();
        if (dice == 0) {
            Toast.makeText(this, R.string.no_dice, Toast.LENGTH_SHORT).show();
        } else if (dice == 1) {
            mDTen.setText((String.valueOf(dTen())));
        } else {
            String roll = String.valueOf(dTen());
            for (int i = 1; i < dice; i++) {
                roll = roll + ", " + dTen();
            }
            mDTen.setText(roll);
        }
    }

    public void dTwelveRoll(View view) {
        int dice = sDTwelve.getSelectedItemPosition();
        if (dice == 0) {
            Toast.makeText(this, R.string.no_dice, Toast.LENGTH_SHORT).show();
        } else if (dice == 1) {
            mDTwelve.setText((String.valueOf(dTwelve())));
        } else {
            String roll = String.valueOf(dTwelve());
            for (int i = 1; i < dice; i++) {
                roll = roll + ", " + dTwelve();
            }
            mDTwelve.setText(roll);
        }
    }

    public void dTwentyRoll(View view) {
        int dice = sDTwenty.getSelectedItemPosition();
        if (dice == 0) {
            Toast.makeText(this, R.string.no_dice, Toast.LENGTH_SHORT).show();
        } else if (dice == 1) {
            mDTwenty.setText((String.valueOf(dTwenty())));
        } else {
            String roll = String.valueOf(dTwenty());
            for (int i = 1; i < dice; i++) {
                roll = roll + ", " + dTwenty();
            }
            mDTwenty.setText(roll);
        }
    }

    public void dHundredRoll(View view) {
        int dice = sDHundred.getSelectedItemPosition();
        if (dice == 0) {
            Toast.makeText(this, R.string.no_dice, Toast.LENGTH_SHORT).show();
        } else if (dice == 1) {
            mDHundred.setText((String.valueOf(dHundred())));
        } else {
            String roll = String.valueOf(dHundred());
            for (int i = 1; i < dice; i++) {
                roll = roll + ", " + dHundred();
            }
            mDHundred.setText(roll);
        }
    }

    public int dFour(){
        Random r = new Random();
        return r.nextInt(4) + 1;
    }

    public int dSix(){
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    public int dEight(){
        Random r = new Random();
        return r.nextInt(8) + 1;
    }

    public int dTen(){
        Random r = new Random();
        return r.nextInt(10) + 1;
    }

    public int dTwelve(){
        Random r = new Random();
        return r.nextInt(12) + 1;
    }

    public int dTwenty(){
        Random r = new Random();
        return r.nextInt(20) + 1;
    }

    public int dHundred(){
        Random r = new Random();
        return r.nextInt(100) + 1;
    }
}
