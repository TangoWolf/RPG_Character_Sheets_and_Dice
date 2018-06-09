package com.example.shaol.char_sheet;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shaol.char_sheet.data.CharacterContract.CharacterEntry;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by shaol on 4/8/2018.
 */

public class EditCharActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private boolean mCharacterHasChanged = false;
    private static final int EXISTING_CHARACTER_LOADER = 0;
    private Uri mCurrentCharacterUri;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editchar);
        setTitle(getString(R.string.edit_character));

        Intent intent = getIntent();
        mCurrentCharacterUri = intent.getData();

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
        DialogInterface.OnClickListener discardButtonClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                NavUtils.navigateUpFromSameTask(EditCharActivity.this);
            }
        };

        switch (item.getItemId()) {
            case R.id.save_character:
                saveCharacter();
                finish();
                return true;
            case R.id.discard_changes:
                if (!mCharacterHasChanged) {
                    NavUtils.navigateUpFromSameTask(EditCharActivity.this);
                    return true;
                }

                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
            case android.R.id.home:
                if (!mCharacterHasChanged) {
                    NavUtils.navigateUpFromSameTask(EditCharActivity.this);
                    return true;
                }

                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
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

        return new CursorLoader(this, mCurrentCharacterUri, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor.moveToFirst()) {
            int nameCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_NAME);
            int classCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_CLASS);
            int levelCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVEL);
            int alignmentCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_ALIGNMENT);
            int deityCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_DEITY);
            int heightCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_HEIGHT);
            int weightCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_WEIGHT);
            int genderCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_GENDER);
            int hairCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_HAIR);
            int eyesCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_EYES);
            int skinCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SKIN);
            int strCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_STRENGTH);
            int dexCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_DEXTERITY);
            int conCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_CONSTITUTION);
            int intCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_INTELLIGENCE);
            int wisCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_WISDOM);
            int chaCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_CHARISMA);
            int featsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_FEATS);
            int acrobaticsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_ACROBATICS);
            int animalHandlingCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_ANIMALHANDLING);
            int arcanaCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_ARCANA);
            int athleticsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_ATHLETICS);
            int deceptionCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_DECEPTION);
            int historyCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_HISTORY);
            int insightCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_INSIGHT);
            int intimidationCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_INTIMIDATION);
            int investigationCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_INVESTIGATION);
            int medicineCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_MEDICINE);
            int natureCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_NATURE);
            int perceptionCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_PERCEPTION);
            int performanceCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_PERFORMANCE);
            int persuasionCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_PERSUASION);
            int religionCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_RELIGION);
            int sleightOfHandCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SLEIGHTOFHAND);
            int stealthCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_STEALTH);
            int survivalCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SURVIVAL);

            String name = cursor.getString(nameCI);
            String charClass = cursor.getString(classCI);
            String level = cursor.getString(levelCI);
            String alignment = cursor.getString(alignmentCI);
            String deity = cursor.getString(deityCI);
            String height = cursor.getString(heightCI);
            String weight = cursor.getString(weightCI);
            String gender = cursor.getString(genderCI);
            String hair = cursor.getString(hairCI);
            String eyes = cursor.getString(eyesCI);
            String skin = cursor.getString(skinCI);
            String strength = cursor.getString(strCI);
            String dexterity = cursor.getString(dexCI);
            String constitution = cursor.getString(conCI);
            String intelligence = cursor.getString(intCI);
            String wisdom = cursor.getString(wisCI);
            String charisma = cursor.getString(chaCI);
            String feats = cursor.getString(featsCI);
            String acrobatics = cursor.getString(acrobaticsCI);
            String animalHandling = cursor.getString(animalHandlingCI);
            String arcana = cursor.getString(arcanaCI);
            String athletics = cursor.getString(athleticsCI);
            String deception = cursor.getString(deceptionCI);
            String history = cursor.getString(historyCI);
            String insight = cursor.getString(insightCI);
            String intimidation = cursor.getString(intimidationCI);
            String investigation = cursor.getString(investigationCI);
            String medicine = cursor.getString(medicineCI);
            String nature = cursor.getString(natureCI);
            String perception = cursor.getString(perceptionCI);
            String performance = cursor.getString(performanceCI);
            String persuasion = cursor.getString(persuasionCI);
            String religion = cursor.getString(religionCI);
            String sleightOfHand = cursor.getString(sleightOfHandCI);
            String stealth = cursor.getString(stealthCI);
            String survival = cursor.getString(survivalCI);

            mCharacterName.setText(name);
            mCharacterClass.setText(charClass);
            mCharacterLevel.setText(level);
            mCharacterAlignment.setText(alignment);
            mCharacterDeity.setText(deity);
            mCharacterHeight.setText(height);
            mCharacterWeight.setText(weight);
            mCharacterGender.setText(gender);
            mCharacterHair.setText(hair);
            mCharacterEyes.setText(eyes);
            mCharacterSkin.setText(skin);
            mCharacterStr.setText(strength);
            mCharacterDex.setText(dexterity);
            mCharacterCon.setText(constitution);
            mCharacterInt.setText(intelligence);
            mCharacterWis.setText(wisdom);
            mCharacterCha.setText(charisma);
            mCharacterFeats.setText(feats);
            mCharacterAcrobatics.setText(acrobatics);
            mCharacterAnimalHandling.setText(animalHandling);
            mCharacterArcana.setText(arcana);
            mCharacterAthletics.setText(athletics);
            mCharacterDeception.setText(deception);
            mCharacterHistory.setText(history);
            mCharacterInsight.setText(insight);
            mCharacterIntimidation.setText(intimidation);
            mCharacterInvestigation.setText(investigation);
            mCharacterMedicine.setText(medicine);
            mCharacterNature.setText(nature);
            mCharacterPerception.setText(perception);
            mCharacterPerformance.setText(performance);
            mCharacterPersuasion.setText(persuasion);
            mCharacterReligion.setText(religion);
            mCharacterSleightOfHand.setText(sleightOfHand);
            mCharacterStealth.setText(stealth);
            mCharacterSurvival.setText(survival);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

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

    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mCharacterHasChanged = true;
            return false;
        }
    };

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

        int rowsAffected = getContentResolver().update(mCurrentCharacterUri, values, null, null);
        if (rowsAffected == 0) {
            Toast.makeText(this, "Failed to update character", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Character updated!", Toast.LENGTH_SHORT).show();
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
}
