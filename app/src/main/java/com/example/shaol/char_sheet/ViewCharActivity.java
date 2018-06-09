package com.example.shaol.char_sheet;

import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaol.char_sheet.data.CharacterContract.CharacterEntry;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaol on 4/7/2018.
 */

public class ViewCharActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private Uri mCurrentCharacterUri;
    private static String[] attributez;

    @BindView(R.id.viewNameView) TextView mCharacterName;
    @BindView(R.id.viewClassView) TextView mCharacterClass;
    @BindView(R.id.viewLevelView) TextView mCharacterLevel;
    @BindView(R.id.viewAlignmentView) TextView mCharacterAlignment;
    @BindView(R.id.viewDeityView) TextView mCharacterDeity;
    @BindView(R.id.viewHeightView) TextView mCharacterHeight;
    @BindView(R.id.viewWeightView) TextView mCharacterWeight;
    @BindView(R.id.viewGenderView) TextView mCharacterGender;
    @BindView(R.id.viewHairView) TextView mCharacterHair;
    @BindView(R.id.viewEyesView) TextView mCharacterEyes;
    @BindView(R.id.viewSkinView) TextView mCharacterSkin;
    @BindView(R.id.viewStrStat) TextView mCharacterStr;
    @BindView(R.id.viewStrStatMod) TextView mCharacterStrMod;
    @BindView(R.id.viewDexStat) TextView mCharacterDex;
    @BindView(R.id.viewDexStatMod) TextView mCharacterDexMod;
    @BindView(R.id.viewConStat) TextView mCharacterCon;
    @BindView(R.id.viewConStatMod) TextView mCharacterConMod;
    @BindView(R.id.viewIntStat) TextView mCharacterInt;
    @BindView(R.id.viewIntStatMod) TextView mCharacterIntMod;
    @BindView(R.id.viewWisStat) TextView mCharacterWis;
    @BindView(R.id.viewWisStatMod) TextView mCharacterWisMod;
    @BindView(R.id.viewChaStat) TextView mCharacterCha;
    @BindView(R.id.viewChaStatMod) TextView mCharacterChaMod;
    @BindView(R.id.viewFeatsView) TextView mCharacterFeats;
    @BindView(R.id.viewAcrobatics) TextView mCharacterAcrobatics;
    @BindView(R.id.viewAnimalHandling) TextView mCharacterAnimalHandling;
    @BindView(R.id.viewArcana) TextView mCharacterArcana;
    @BindView(R.id.viewAthletics) TextView mCharacterAthletics;
    @BindView(R.id.viewDeception) TextView mCharacterDeception;
    @BindView(R.id.viewHistory) TextView mCharacterHistory;
    @BindView(R.id.viewInsight) TextView mCharacterInsight;
    @BindView(R.id.viewIntimidation) TextView mCharacterIntimidation;
    @BindView(R.id.viewInvestigation) TextView mCharacterInvestigation;
    @BindView(R.id.viewMedicine) TextView mCharacterMedicine;
    @BindView(R.id.viewNature) TextView mCharacterNature;
    @BindView(R.id.viewPerception) TextView mCharacterPerception;
    @BindView(R.id.viewPerformance) TextView mCharacterPerformance;
    @BindView(R.id.viewPersuasion) TextView mCharacterPersuasion;
    @BindView(R.id.viewReligion) TextView mCharacterReligion;
    @BindView(R.id.viewSleightOfHand) TextView mCharacterSleightOfHand;
    @BindView(R.id.viewStealth) TextView mCharacterStealth;
    @BindView(R.id.viewSurvival) TextView mCharacterSurvival;

    private static final int EXISTING_CHARACTER_LOADER = 0;

    @Override
    protected void onCreate (Bundle onSavedInstance) {
        super.onCreate(onSavedInstance);
        setContentView(R.layout.activity_viewchar);
        setTitle(R.string.view_character);

        Intent intent = getIntent();
        mCurrentCharacterUri = intent.getData();

        ButterKnife.bind(this);

        getSupportLoaderManager().initLoader(EXISTING_CHARACTER_LOADER, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_character:
                editCharacter();
                finish();
                return true;
            case R.id.delete_character:
                showDeleteConfirmationDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void editCharacter() {
        Intent intent = new Intent(ViewCharActivity.this, EditCharActivity.class);
        intent.setData(mCurrentCharacterUri);
        startActivity(intent);
    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                deleteCharacter();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void deleteCharacter() {
        if (mCurrentCharacterUri != null) {
            int rowsDeleted = getContentResolver().delete(mCurrentCharacterUri, null, null);

            if (rowsDeleted == 0) {
                Toast.makeText(this, "Error with deleteing character", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Character deleted", Toast.LENGTH_SHORT).show();
            }
        }
        finish();
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
        if ( cursor != null && cursor.moveToFirst()) {
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

            attributez = new String[6];
            attributez[0] = strength;
            attributez[1] = dexterity;
            attributez[2] = constitution;
            attributez[3] = intelligence;
            attributez[4] = wisdom;
            attributez[5] = charisma;

            String[] attributeModifierz = FetchAttributeModifiers(attributez);

            mCharacterStrMod.setText(attributeModifierz[0]);
            mCharacterDexMod.setText(attributeModifierz[1]);
            mCharacterConMod.setText(attributeModifierz[2]);
            mCharacterIntMod.setText(attributeModifierz[3]);
            mCharacterWisMod.setText(attributeModifierz[4]);
            mCharacterChaMod.setText(attributeModifierz[5]);

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

        return;
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private String[] FetchAttributeModifiers(String[] attributes) {
        String[] modifiers = new String[6];

        String modifier;

        for (int i = 0; i < attributes.length; i++) {
            String attribute = attributes[i];
            switch(attribute) {
                case "1":
                    modifier = "-5";
                    break;
                case "2":
                case "3":
                    modifier = "-4";
                    break;
                case "4":
                case "5":
                    modifier = "-3";
                    break;
                case "6":
                case "7":
                    modifier = "-2";
                    break;
                case "8":
                case "9":
                    modifier = "-1";
                    break;
                case "10":
                case "11":
                    modifier = "0";
                    break;
                case "12":
                case "13":
                    modifier = "1";
                    break;
                case "14":
                case "15":
                    modifier = "2";
                    break;
                case "16":
                case "17":
                    modifier = "3";
                    break;
                case "18":
                case "19":
                    modifier = "4";
                    break;
                case "20":
                case "21":
                    modifier = "5";
                    break;
                case "22":
                case "23":
                    modifier = "6";
                    break;
                case "24":
                case "25":
                    modifier = "7";
                    break;
                case "26":
                case "27":
                    modifier = "8";
                    break;
                case "28":
                case "29":
                    modifier = "9";
                    break;
                case "30":
                    modifier = "10";
                    break;
                default:
                    modifier = "";
                    break;
            }

            modifiers[i] = modifier;
        }

        return modifiers;
    }
}
