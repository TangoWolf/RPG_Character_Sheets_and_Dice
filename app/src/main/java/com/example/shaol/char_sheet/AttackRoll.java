package com.example.shaol.char_sheet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaol on 6/10/2018.
 */

public class AttackRoll extends AppCompatActivity {
    private static String[] names;
    private static String[] bonus;
    private static int[] damages;

    @BindView(R.id.first_weapon_button) Button mFirstWeaponButton;
    @BindView(R.id.first_damage_button) Button mFirstDamageButton;
    @BindView(R.id.second_weapon_button) Button mSecondWeaponButton;
    @BindView(R.id.second_damage_button) Button mSecondDamageButton;
    @BindView(R.id.third_weapon_button) Button mThirdWeaponButton;
    @BindView(R.id.third_damage_button) Button mThirdDamageButton;
    @BindView(R.id.first_weapon_roll) TextView mFirstWeapon;
    @BindView(R.id.second_weapon_roll) TextView mSecondWeapon;
    @BindView(R.id.third_weapon_roll) TextView mThirdWeapon;
    @BindView(R.id.first_damage_roll) TextView mFirstDamage;
    @BindView(R.id.second_damage_roll) TextView mSecondDamage;
    @BindView(R.id.third_damage_roll) TextView mThirdDamage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attack_roll);
        setTitle(R.string.attack_roll);

        Intent intent = getIntent();
        names = intent.getStringArrayExtra("Names");
        bonus = intent.getStringArrayExtra("Bonus");
        damages = intent.getIntArrayExtra("Damages");

        ButterKnife.bind(this);

        if (!names[0].equals("")) {
            mFirstWeaponButton.setText(names[0]);
            String firstDamage = getResources().getString(R.string.roll_damage) + " " + names[0];
            mFirstDamageButton.setText(firstDamage);
        }
        if (!names[1].equals("")) {
            mSecondWeaponButton.setText(names[1]);
            String secondDamage = getResources().getString(R.string.roll_damage) + " " + names[1];
            mSecondDamageButton.setText(secondDamage);
        }
        if (!names[2].equals("")) {
            mThirdWeaponButton.setText(names[2]);
            String thirdDamage = getResources().getString(R.string.roll_damage) + " " + names[2];
            mThirdDamageButton.setText(thirdDamage);
        }
    }

    public void firstWeaponRoll(View view) {
        int roll;
        if (!bonus[0].equals("")) {
            int mod = Integer.parseInt(bonus[0]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mFirstWeapon.setText(String.valueOf(roll));
    }

    public void secondWeaponRoll(View view) {
        int roll;
        if (!bonus[1].equals("")) {
            int mod = Integer.parseInt(bonus[1]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mSecondWeapon.setText(String.valueOf(roll));
    }

    public void thirdWeaponRoll(View view) {
        int roll;
        if (!bonus[2].equals("")) {
            int mod = Integer.parseInt(bonus[2]);
            roll = dTwenty() + mod;
        } else {
            roll = dTwenty();
        }
        mThirdWeapon.setText(String.valueOf(roll));
    }

    public void firstDamageRoll(View view) {
        int damage = damages[0];
        int roll = damageRoll(damage);

        if (roll != -1) {
            mFirstDamage.setText(String.valueOf(roll));
        }
    }

    public void secondDamageRoll(View view) {
        int damage = damages[1];
        int roll = damageRoll(damage);

        if (roll != -1) {
            mSecondDamage.setText(String.valueOf(roll));
        }
    }

    public void thirdDamageRoll(View view) {
        int damage = damages[2];
        int roll = damageRoll(damage);

        if (roll != -1) {
            mThirdDamage.setText(String.valueOf(roll));
        }
    }

    public int damageRoll(int id) {
        int roll;
        switch(id) {
            case 0:
                Toast.makeText(this, R.string.no_damage_dice, Toast.LENGTH_SHORT).show();
                roll = -1;
                break;
            case 1:
                roll = dFour();
                break;
            case 2:
                roll = dFour() + dFour();
                break;
            case 3:
                roll = dFour() + dFour() + dFour();
                break;
            case 4:
                roll = dSix();
                break;
            case 5:
                roll = dSix() + dSix();
                break;
            case 6:
                roll = dSix() + dSix() + dSix();
                break;
            case 7:
                roll = dEight();
                break;
            case 8:
                roll = dEight() + dEight();
                break;
            case 9:
                roll = dEight() + dEight() + dEight();
                break;
            case 10:
                roll = dTen();
                break;
            case 11:
                roll = dTen() + dTen();
                break;
            case 12:
                roll = dTen() + dTen() + dTen();
                break;
            case 13:
                roll = dTwelve();
                break;
            case 14:
                roll = dTwelve() + dTwelve();
                break;
            case 15:
                roll = dTwelve() + dTwelve() + dTwelve();
                break;
            default:
                Toast.makeText(this, R.string.no_damage_dice, Toast.LENGTH_SHORT).show();
                roll = -1;
                break;
        }
        return roll;
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
}
