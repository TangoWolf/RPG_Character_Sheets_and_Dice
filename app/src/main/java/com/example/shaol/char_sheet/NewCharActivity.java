package com.example.shaol.char_sheet;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaol.char_sheet.data.CharacterContract.CharacterEntry;
import com.example.shaol.char_sheet.data.CharacterProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaol on 4/8/2018.
 */

public class NewCharActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private boolean mCharacterHasChanged = false;
    private static final int EXISTING_CHARACTER_LOADER = 0;

    @BindView(R.id.editNameView) EditText mCharacterName;
    @BindView(R.id.editClassView) EditText mCharacterClass;
    @BindView(R.id.editLevelView) EditText mCharacterLevel;
    @BindView(R.id.editAlignmentView) EditText mCharacterAlignment;
    @BindView(R.id.editDeityView) EditText mCharacterDeity;
    @BindView(R.id.editHeightView) EditText mCharacterHeight;
    @BindView(R.id.editWeightView) EditText mCharacterWeight;
    @BindView(R.id.editGenderView) EditText mCharacterGender;
    @BindView(R.id.editHairView) EditText mCharacterHair;
    @BindView(R.id.editEyesView) EditText mCharacterEyes;
    @BindView(R.id.editSkinView) EditText mCharacterSkin;
    @BindView(R.id.strStat) EditText mCharacterStr;
    @BindView(R.id.dexStat) EditText mCharacterDex;
    @BindView(R.id.conStat) EditText mCharacterCon;
    @BindView(R.id.intStat) EditText mCharacterInt;
    @BindView(R.id.wisStat) EditText mCharacterWis;
    @BindView(R.id.chaStat) EditText mCharacterCha;
    @BindView(R.id.editFeatsView) EditText mCharacterFeats;
    @BindView(R.id.editAcrobatics) EditText mCharacterAcrobatics;
    @BindView(R.id.editAnimalHandling) EditText mCharacterAnimalHandling;
    @BindView(R.id.editArcana) EditText mCharacterArcana;
    @BindView(R.id.editAthletics) EditText mCharacterAthletics;
    @BindView(R.id.editDeception) EditText mCharacterDeception;
    @BindView(R.id.editHistory) EditText mCharacterHistory;
    @BindView(R.id.editInsight) EditText mCharacterInsight;
    @BindView(R.id.editIntimidation) EditText mCharacterIntimidation;
    @BindView(R.id.editInvestigation) EditText mCharacterInvestigation;
    @BindView(R.id.editMedicine) EditText mCharacterMedicine;
    @BindView(R.id.editNature) EditText mCharacterNature;
    @BindView(R.id.editPerception) EditText mCharacterPerception;
    @BindView(R.id.editPerformance) EditText mCharacterPerformance;
    @BindView(R.id.editPersuasion) EditText mCharacterPersuasion;
    @BindView(R.id.editReligion) EditText mCharacterReligion;
    @BindView(R.id.editSleightOfHand) EditText mCharacterSleightOfHand;
    @BindView(R.id.editStealth) EditText mCharacterStealth;
    @BindView(R.id.editSurvival) EditText mCharacterSurvival;

    @Override
    protected void onCreate (Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_newchar);
        setTitle(R.string.new_character);

        ButterKnife.bind(this);

        getSupportLoaderManager().initLoader(EXISTING_CHARACTER_LOADER, null, this);

        mCharacterName.setOnTouchListener(mTouchListener);
        mCharacterClass.setOnTouchListener(mTouchListener);
        mCharacterLevel.setOnTouchListener(mTouchListener);
        mCharacterAlignment.setOnTouchListener(mTouchListener);
        mCharacterDeity.setOnTouchListener(mTouchListener);
        mCharacterHeight.setOnTouchListener(mTouchListener);
        mCharacterWeight.setOnTouchListener(mTouchListener);
        mCharacterGender.setOnTouchListener(mTouchListener);
        mCharacterHair.setOnTouchListener(mTouchListener);
        mCharacterEyes.setOnTouchListener(mTouchListener);
        mCharacterSkin.setOnTouchListener(mTouchListener);
        mCharacterStr.setOnTouchListener(mTouchListener);
        mCharacterDex.setOnTouchListener(mTouchListener);
        mCharacterCon.setOnTouchListener(mTouchListener);
        mCharacterInt.setOnTouchListener(mTouchListener);
        mCharacterWis.setOnTouchListener(mTouchListener);
        mCharacterCha.setOnTouchListener(mTouchListener);
        mCharacterFeats.setOnTouchListener(mTouchListener);
        mCharacterAcrobatics.setOnTouchListener(mTouchListener);
        mCharacterAnimalHandling.setOnTouchListener(mTouchListener);
        mCharacterArcana.setOnTouchListener(mTouchListener);
        mCharacterAthletics.setOnTouchListener(mTouchListener);
        mCharacterDeception.setOnTouchListener(mTouchListener);
        mCharacterHistory.setOnTouchListener(mTouchListener);
        mCharacterInsight.setOnTouchListener(mTouchListener);
        mCharacterIntimidation.setOnTouchListener(mTouchListener);
        mCharacterInvestigation.setOnTouchListener(mTouchListener);
        mCharacterMedicine.setOnTouchListener(mTouchListener);
        mCharacterNature.setOnTouchListener(mTouchListener);
        mCharacterPerception.setOnTouchListener(mTouchListener);
        mCharacterPerformance.setOnTouchListener(mTouchListener);
        mCharacterPersuasion.setOnTouchListener(mTouchListener);
        mCharacterReligion.setOnTouchListener(mTouchListener);
        mCharacterSleightOfHand.setOnTouchListener(mTouchListener);
        mCharacterStealth.setOnTouchListener(mTouchListener);
        mCharacterSurvival.setOnTouchListener(mTouchListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_character:
                saveCharacter();
                finish();
                return true;
            case R.id.discard_changes:
                if (!mCharacterHasChanged) {
                    NavUtils.navigateUpFromSameTask(NewCharActivity.this);
                    return true;
                }
                DialogInterface.OnClickListener discardButtonClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        NavUtils.navigateUpFromSameTask(NewCharActivity.this);
                    }
                };
                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mCharacterHasChanged) {
            super.onBackPressed();
            return;
        }

        DialogInterface.OnClickListener discardButtonClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        };

        showUnsavedChangesDialog(discardButtonClickListener);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                CharacterEntry._ID,
                CharacterEntry.COLUMN_CHARACTER_NAME,
                CharacterEntry.COLUMN_CHARACTER_CLASS,
                CharacterEntry.COLUMN_CHARACTER_LEVEL,
                CharacterEntry.COLUMN_CHARACTER_ALIGNMENT,
                CharacterEntry.COLUMN_CHARACTER_DEITY,
                CharacterEntry.COLUMN_CHARACTER_HEIGHT,
                CharacterEntry.COLUMN_CHARACTER_WEIGHT,
                CharacterEntry.COLUMN_CHARACTER_GENDER,
                CharacterEntry.COLUMN_CHARACTER_HAIR,
                CharacterEntry.COLUMN_CHARACTER_EYES,
                CharacterEntry.COLUMN_CHARACTER_SKIN,
                CharacterEntry.COLUMN_CHARACTER_STRENGTH,
                CharacterEntry.COLUMN_CHARACTER_DEXTERITY,
                CharacterEntry.COLUMN_CHARACTER_CONSTITUTION,
                CharacterEntry.COLUMN_CHARACTER_INTELLIGENCE,
                CharacterEntry.COLUMN_CHARACTER_WISDOM,
                CharacterEntry.COLUMN_CHARACTER_CHARISMA,
                CharacterEntry.COLUMN_CHARACTER_FEATS,
                CharacterEntry.COLUMN_CHARACTER_ACROBATICS,
                CharacterEntry.COLUMN_CHARACTER_ANIMALHANDLING,
                CharacterEntry.COLUMN_CHARACTER_ARCANA,
                CharacterEntry.COLUMN_CHARACTER_ATHLETICS,
                CharacterEntry.COLUMN_CHARACTER_DECEPTION,
                CharacterEntry.COLUMN_CHARACTER_HISTORY,
                CharacterEntry.COLUMN_CHARACTER_INSIGHT,
                CharacterEntry.COLUMN_CHARACTER_INTIMIDATION,
                CharacterEntry.COLUMN_CHARACTER_INVESTIGATION,
                CharacterEntry.COLUMN_CHARACTER_MEDICINE,
                CharacterEntry.COLUMN_CHARACTER_NATURE,
                CharacterEntry.COLUMN_CHARACTER_PERCEPTION,
                CharacterEntry.COLUMN_CHARACTER_PERFORMANCE,
                CharacterEntry.COLUMN_CHARACTER_PERSUASION,
                CharacterEntry.COLUMN_CHARACTER_RELIGION,
                CharacterEntry.COLUMN_CHARACTER_SLEIGHTOFHAND,
                CharacterEntry.COLUMN_CHARACTER_STEALTH,
                CharacterEntry.COLUMN_CHARACTER_SURVIVAL
        };

        return new CursorLoader(this, CharacterEntry.CONTENT_URI, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void saveCharacter() {
        String name = mCharacterName.getText().toString().trim();
        String charClass = mCharacterClass.getText().toString().trim();
        String level = mCharacterLevel.getText().toString().trim();
        String alignment = mCharacterAlignment.getText().toString().trim();
        String deity = mCharacterDeity.getText().toString().trim();
        String height = mCharacterHeight.getText().toString().trim();
        String weight = mCharacterWeight.getText().toString().trim();
        String gender = mCharacterGender.getText().toString().trim();
        String hair = mCharacterHair.getText().toString().trim();
        String eyes = mCharacterEyes.getText().toString().trim();
        String skin = mCharacterSkin.getText().toString().trim();
        String strength = mCharacterStr.getText().toString().trim();
        String dexterity = mCharacterDex.getText().toString().trim();
        String constitution = mCharacterCon.getText().toString().trim();
        String intelligence = mCharacterInt.getText().toString().trim();
        String wisdom = mCharacterWis.getText().toString().trim();
        String charisma = mCharacterCha.getText().toString().trim();
        String feats = mCharacterFeats.getText().toString().trim();
        String acrobatics = mCharacterAcrobatics.getText().toString().trim();
        String animalHandling = mCharacterAnimalHandling.getText().toString().trim();
        String arcana = mCharacterArcana.getText().toString().trim();
        String athletics = mCharacterAthletics.getText().toString().trim();
        String deception = mCharacterDeception.getText().toString().trim();
        String history = mCharacterHistory.getText().toString().trim();
        String insight = mCharacterInsight.getText().toString().trim();
        String intimidation = mCharacterIntimidation.getText().toString().trim();
        String investigation = mCharacterInvestigation.getText().toString().trim();
        String medicine = mCharacterMedicine.getText().toString().trim();
        String nature = mCharacterNature.getText().toString().trim();
        String perception = mCharacterPerception.getText().toString().trim();
        String performance = mCharacterPerformance.getText().toString().trim();
        String persuasion = mCharacterPersuasion.getText().toString().trim();
        String religion = mCharacterReligion.getText().toString().trim();
        String sleightOfHand = mCharacterSleightOfHand.getText().toString().trim();
        String stealth = mCharacterStealth.getText().toString().trim();
        String survival = mCharacterSurvival.getText().toString().trim();

        if (TextUtils.isEmpty(name) &&
                TextUtils.isEmpty(charClass) &&
                TextUtils.isEmpty(level) &&
                TextUtils.isEmpty(alignment) &&
                TextUtils.isEmpty(deity) &&
                TextUtils.isEmpty(height) &&
                TextUtils.isEmpty(weight) &&
                TextUtils.isEmpty(gender) &&
                TextUtils.isEmpty(hair) &&
                TextUtils.isEmpty(eyes) &&
                TextUtils.isEmpty(skin) &&
                TextUtils.isEmpty(strength) &&
                TextUtils.isEmpty(dexterity) &&
                TextUtils.isEmpty(constitution) &&
                TextUtils.isEmpty(intelligence) &&
                TextUtils.isEmpty(wisdom) &&
                TextUtils.isEmpty(charisma) &&
                TextUtils.isEmpty(feats) &&
                TextUtils.isEmpty(acrobatics) &&
                TextUtils.isEmpty(animalHandling) &&
                TextUtils.isEmpty(arcana) &&
                TextUtils.isEmpty(athletics) &&
                TextUtils.isEmpty(deception) &&
                TextUtils.isEmpty(history) &&
                TextUtils.isEmpty(insight) &&
                TextUtils.isEmpty(intimidation) &&
                TextUtils.isEmpty(investigation) &&
                TextUtils.isEmpty(medicine) &&
                TextUtils.isEmpty(nature) &&
                TextUtils.isEmpty(perception) &&
                TextUtils.isEmpty(performance) &&
                TextUtils.isEmpty(persuasion) &&
                TextUtils.isEmpty(religion) &&
                TextUtils.isEmpty(sleightOfHand) &&
                TextUtils.isEmpty(stealth) &&
                TextUtils.isEmpty(survival)) {
            return;
        }

        ContentValues values = new ContentValues();
        values.put(CharacterEntry.COLUMN_CHARACTER_NAME, name);
        values.put(CharacterEntry.COLUMN_CHARACTER_CLASS, charClass);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVEL,level);
        values.put(CharacterEntry.COLUMN_CHARACTER_ALIGNMENT, alignment);
        values.put(CharacterEntry.COLUMN_CHARACTER_DEITY, deity);
        values.put(CharacterEntry.COLUMN_CHARACTER_HEIGHT, height);
        values.put(CharacterEntry.COLUMN_CHARACTER_WEIGHT, weight);
        values.put(CharacterEntry.COLUMN_CHARACTER_GENDER, gender);
        values.put(CharacterEntry.COLUMN_CHARACTER_HAIR, hair);
        values.put(CharacterEntry.COLUMN_CHARACTER_EYES, eyes);
        values.put(CharacterEntry.COLUMN_CHARACTER_SKIN, skin);
        values.put(CharacterEntry.COLUMN_CHARACTER_STRENGTH, strength);
        values.put(CharacterEntry.COLUMN_CHARACTER_DEXTERITY, dexterity);
        values.put(CharacterEntry.COLUMN_CHARACTER_CONSTITUTION, constitution);
        values.put(CharacterEntry.COLUMN_CHARACTER_INTELLIGENCE, intelligence);
        values.put(CharacterEntry.COLUMN_CHARACTER_WISDOM, wisdom);
        values.put(CharacterEntry.COLUMN_CHARACTER_CHARISMA, charisma);
        values.put(CharacterEntry.COLUMN_CHARACTER_FEATS, feats);
        values.put(CharacterEntry.COLUMN_CHARACTER_ACROBATICS, acrobatics);
        values.put(CharacterEntry.COLUMN_CHARACTER_ANIMALHANDLING, animalHandling);
        values.put(CharacterEntry.COLUMN_CHARACTER_ARCANA, arcana);
        values.put(CharacterEntry.COLUMN_CHARACTER_ATHLETICS, athletics);
        values.put(CharacterEntry.COLUMN_CHARACTER_DECEPTION, deception);
        values.put(CharacterEntry.COLUMN_CHARACTER_HISTORY, history);
        values.put(CharacterEntry.COLUMN_CHARACTER_INSIGHT, insight);
        values.put(CharacterEntry.COLUMN_CHARACTER_INTIMIDATION, intimidation);
        values.put(CharacterEntry.COLUMN_CHARACTER_INVESTIGATION, investigation);
        values.put(CharacterEntry.COLUMN_CHARACTER_MEDICINE, medicine);
        values.put(CharacterEntry.COLUMN_CHARACTER_NATURE, nature);
        values.put(CharacterEntry.COLUMN_CHARACTER_PERCEPTION, perception);
        values.put(CharacterEntry.COLUMN_CHARACTER_PERFORMANCE, performance);
        values.put(CharacterEntry.COLUMN_CHARACTER_PERSUASION, persuasion);
        values.put(CharacterEntry.COLUMN_CHARACTER_RELIGION, religion);
        values.put(CharacterEntry.COLUMN_CHARACTER_SLEIGHTOFHAND, sleightOfHand);
        values.put(CharacterEntry.COLUMN_CHARACTER_STEALTH, stealth);
        values.put(CharacterEntry.COLUMN_CHARACTER_SURVIVAL, survival);

        Uri newUri = getContentResolver().insert(CharacterEntry.CONTENT_URI, values);

        if (newUri == null) {
            Toast.makeText(this, "Failed to create character", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Character created!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showUnsavedChangesDialog(DialogInterface.OnClickListener discardButtonClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Discard your changes and quit editing?");
        builder.setPositiveButton("Discard", discardButtonClickListener);
        builder.setNegativeButton("Keep editing", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mCharacterHasChanged = true;
            return false;
        }
    };
}
