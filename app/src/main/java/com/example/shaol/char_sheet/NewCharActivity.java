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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shaol.char_sheet.data.CharacterContract.CharacterEntry;
import com.example.shaol.char_sheet.data.CharacterProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaol on 4/8/2018.
 */

public class NewCharActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemSelectedListener {

    private boolean mCharacterHasChanged = false;
    private static final int EXISTING_CHARACTER_LOADER = 0;

    @BindView(R.id.editNameView) EditText mCharacterName;
    @BindView(R.id.editClassView) EditText mCharacterClass;
    @BindView(R.id.editRaceView) EditText mCharacterRace;
    @BindView(R.id.editBackgroundView) EditText mCharacterBackground;
    @BindView(R.id.editXPView) EditText mCharacterXP;
    @BindView(R.id.editLevelView) EditText mCharacterLevel;
    @BindView(R.id.editAlignmentView) EditText mCharacterAlignment;
    @BindView(R.id.editDeityView) EditText mCharacterDeity;
    @BindView(R.id.editHeightView) EditText mCharacterHeight;
    @BindView(R.id.editWeightView) EditText mCharacterWeight;
    @BindView(R.id.editGenderView) EditText mCharacterGender;
    @BindView(R.id.editHairView) EditText mCharacterHair;
    @BindView(R.id.editEyesView) EditText mCharacterEyes;
    @BindView(R.id.editSkinView) EditText mCharacterSkin;
    @BindView(R.id.editProficiencyView) EditText mCharacterProficiency;
    @BindView(R.id.editHealthPointsView) EditText mCharacterHealthPoints;
    @BindView(R.id.editTempHealthPointsView) EditText mCharacterTemporaryHealthPoints;
    @BindView(R.id.editArmorClassView) EditText mCharacterArmorClass;
    @BindView(R.id.editSpellcastingClassView) EditText mCharacterSpellcastingClass;
    @BindView(R.id.editSpeedView) EditText mCharacterSpeed;
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
    @BindView(R.id.editFirstNameView) EditText mFirstWeaponName;
    @BindView(R.id.editFirstBonusView) EditText mFirstWeaponBonus;
    @BindView(R.id.editFirstDamageView) Spinner sFirstWeaponDamage;
    @BindView(R.id.editFirstTypeView) EditText mFirstWeaponType;
    @BindView(R.id.editSecondNameView) EditText mSecondWeaponName;
    @BindView(R.id.editSecondBonusView) EditText mSecondWeaponBonus;
    @BindView(R.id.editSecondDamageView) Spinner sSecondWeaponDamage;
    @BindView(R.id.editSecondTypeView) EditText mSecondWeaponType;
    @BindView(R.id.editThirdNameView) EditText mThirdWeaponName;
    @BindView(R.id.editThirdBonusView) EditText mThirdWeaponBonus;
    @BindView(R.id.editThirdDamageView) Spinner sThirdWeaponDamage;
    @BindView(R.id.editThirdTypeView) EditText mThirdWeaponType;
    @BindView(R.id.editPreparedSpellsView) EditText mPreparedSpells;
    @BindView(R.id.editEquipmentView) EditText mEquipment;
    @BindView(R.id.editLanguagesView) EditText mLanguages;
    @BindView(R.id.editPersonalityView) EditText mPersonality;
    @BindView(R.id.editIdealsView) EditText mIdeals;
    @BindView(R.id.editBondsView) EditText mBonds;
    @BindView(R.id.editFlawsView) EditText mFlaws;
    @BindView(R.id.editAlliesView) EditText mAllies;
    @BindView(R.id.editBackstoryView) EditText mBackstory;
    @BindView(R.id.editSpellcastingAbilityView) EditText mSpellcastingAbility;
    @BindView(R.id.editSpellSaveDCView) EditText mSpellSaveDC;
    @BindView(R.id.editSpellAttackBonusView) EditText mSpellAttackBonus;
    @BindView(R.id.editLevelZeroSpellsView) EditText mLevelZeroSpells;
    @BindView(R.id.editLevelOneSpellsView) EditText mLevelOneSpells;
    @BindView(R.id.editLevelTwoSpellsView) EditText mLevelTwoSpells;
    @BindView(R.id.editLevelThreeSpellsView) EditText mLevelThreeSpells;
    @BindView(R.id.editLevelFourSpellsView) EditText mLevelFourSpells;
    @BindView(R.id.editLevelFiveSpellsView) EditText mLevelFiveSpells;
    @BindView(R.id.editLevelSixSpellsView) EditText mLevelSixSpells;
    @BindView(R.id.editLevelSevenSpellsView) EditText mLevelSevenSpells;
    @BindView(R.id.editLevelEightSpellsView) EditText mLevelEightSpells;
    @BindView(R.id.editLevelNineSpellsView) EditText mLevelNineSpells;

    @Override
    protected void onCreate (Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_newchar);
        setTitle(R.string.new_character);

        ButterKnife.bind(this);

        getSupportLoaderManager().initLoader(EXISTING_CHARACTER_LOADER, null, this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weapons_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sFirstWeaponDamage.setAdapter(adapter);
        sSecondWeaponDamage.setAdapter(adapter);
        sThirdWeaponDamage.setAdapter(adapter);

        mCharacterName.setOnTouchListener(mTouchListener);
        mCharacterClass.setOnTouchListener(mTouchListener);
        mCharacterRace.setOnTouchListener(mTouchListener);
        mCharacterBackground.setOnTouchListener(mTouchListener);
        mCharacterXP.setOnTouchListener(mTouchListener);
        mCharacterLevel.setOnTouchListener(mTouchListener);
        mCharacterAlignment.setOnTouchListener(mTouchListener);
        mCharacterDeity.setOnTouchListener(mTouchListener);
        mCharacterHeight.setOnTouchListener(mTouchListener);
        mCharacterWeight.setOnTouchListener(mTouchListener);
        mCharacterGender.setOnTouchListener(mTouchListener);
        mCharacterHair.setOnTouchListener(mTouchListener);
        mCharacterEyes.setOnTouchListener(mTouchListener);
        mCharacterSkin.setOnTouchListener(mTouchListener);
        mCharacterProficiency.setOnTouchListener(mTouchListener);
        mCharacterHealthPoints.setOnTouchListener(mTouchListener);
        mCharacterTemporaryHealthPoints.setOnTouchListener(mTouchListener);
        mCharacterArmorClass.setOnTouchListener(mTouchListener);
        mCharacterSpellcastingClass.setOnTouchListener(mTouchListener);
        mCharacterSpeed.setOnTouchListener(mTouchListener);
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
        mFirstWeaponName.setOnTouchListener(mTouchListener);
        mFirstWeaponBonus.setOnTouchListener(mTouchListener);
        sFirstWeaponDamage.setOnItemSelectedListener(this);
        mFirstWeaponType.setOnTouchListener(mTouchListener);
        mSecondWeaponName.setOnTouchListener(mTouchListener);
        mSecondWeaponBonus.setOnTouchListener(mTouchListener);
        sSecondWeaponDamage.setOnItemSelectedListener(this);
        mSecondWeaponType.setOnTouchListener(mTouchListener);
        mThirdWeaponName.setOnTouchListener(mTouchListener);
        mThirdWeaponBonus.setOnTouchListener(mTouchListener);
        sThirdWeaponDamage.setOnItemSelectedListener(this);
        mThirdWeaponType.setOnTouchListener(mTouchListener);
        mPreparedSpells.setOnTouchListener(mTouchListener);
        mEquipment.setOnTouchListener(mTouchListener);
        mLanguages.setOnTouchListener(mTouchListener);
        mPersonality.setOnTouchListener(mTouchListener);
        mIdeals.setOnTouchListener(mTouchListener);
        mBonds.setOnTouchListener(mTouchListener);
        mFlaws.setOnTouchListener(mTouchListener);
        mAllies.setOnTouchListener(mTouchListener);
        mBackstory.setOnTouchListener(mTouchListener);
        mSpellcastingAbility.setOnTouchListener(mTouchListener);
        mSpellSaveDC.setOnTouchListener(mTouchListener);
        mSpellAttackBonus.setOnTouchListener(mTouchListener);
        mLevelZeroSpells.setOnTouchListener(mTouchListener);
        mLevelOneSpells.setOnTouchListener(mTouchListener);
        mLevelTwoSpells.setOnTouchListener(mTouchListener);
        mLevelThreeSpells.setOnTouchListener(mTouchListener);
        mLevelFourSpells.setOnTouchListener(mTouchListener);
        mLevelFiveSpells.setOnTouchListener(mTouchListener);
        mLevelSixSpells.setOnTouchListener(mTouchListener);
        mLevelSevenSpells.setOnTouchListener(mTouchListener);
        mLevelEightSpells.setOnTouchListener(mTouchListener);
        mLevelNineSpells.setOnTouchListener(mTouchListener);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {

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
                CharacterEntry.COLUMN_CHARACTER_RACE,
                CharacterEntry.COLUMN_CHARACTER_BACKGROUND,
                CharacterEntry.COLUMN_CHARACTER_EXPERIENCE,
                CharacterEntry.COLUMN_CHARACTER_LEVEL,
                CharacterEntry.COLUMN_CHARACTER_ALIGNMENT,
                CharacterEntry.COLUMN_CHARACTER_DEITY,
                CharacterEntry.COLUMN_CHARACTER_HEIGHT,
                CharacterEntry.COLUMN_CHARACTER_WEIGHT,
                CharacterEntry.COLUMN_CHARACTER_GENDER,
                CharacterEntry.COLUMN_CHARACTER_HAIR,
                CharacterEntry.COLUMN_CHARACTER_EYES,
                CharacterEntry.COLUMN_CHARACTER_SKIN,
                CharacterEntry.COLUMN_CHARACTER_PROFICIENCY,
                CharacterEntry.COLUMN_CHARACTER_HEALTHPOINTS,
                CharacterEntry.COLUMN_CHARACTER_TEMPORARYHEALTHPOINTS,
                CharacterEntry.COLUMN_CHARACTER_ARMORCLASS,
                CharacterEntry.COLUMN_CHARACTER_SPELLCASTINGCLASS,
                CharacterEntry.COLUMN_CHARACTER_SPEED,
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
                CharacterEntry.COLUMN_CHARACTER_SURVIVAL,
                CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONNAME,
                CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONBONUS,
                CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGEID,
                CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONTYPE,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONNAME,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONBONUS,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGEID,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONTYPE,
                CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONNAME,
                CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONBONUS,
                CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGEID,
                CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONTYPE,
                CharacterEntry.COLUMN_CHARACTER_PREPAREDSPELLS,
                CharacterEntry.COLUMN_CHARACTER_EQUIPMENT,
                CharacterEntry.COLUMN_CHARACTER_LANGUAGES,
                CharacterEntry.COLUMN_CHARACTER_PERSONALITY,
                CharacterEntry.COLUMN_CHARACTER_IDEALS,
                CharacterEntry.COLUMN_CHARACTER_BONDS,
                CharacterEntry.COLUMN_CHARACTER_FLAWS,
                CharacterEntry.COLUMN_CHARACTER_ALLIES,
                CharacterEntry.COLUMN_CHARACTER_BACKSTORY,
                CharacterEntry.COLUMN_CHARACTER_SPELLCASTINGABILITY,
                CharacterEntry.COLUMN_CHARACTER_SPELLSAVEDC,
                CharacterEntry.COLUMN_CHARACTER_SPELLATTACKBONUS,
                CharacterEntry.COLUMN_CHARACTER_LEVELZEROSPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELONESPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELTWOSPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELTHREESPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELFOURSPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELFIVESPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELSIXSPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELSEVENSPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELEIGHTSPELLS,
                CharacterEntry.COLUMN_CHARACTER_LEVELNINESPELLS
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
        String race = mCharacterRace.getText().toString().trim();
        String background = mCharacterBackground.getText().toString().trim();
        String experience = mCharacterXP.getText().toString().trim();
        String level = mCharacterLevel.getText().toString().trim();
        String alignment = mCharacterAlignment.getText().toString().trim();
        String deity = mCharacterDeity.getText().toString().trim();
        String height = mCharacterHeight.getText().toString().trim();
        String weight = mCharacterWeight.getText().toString().trim();
        String gender = mCharacterGender.getText().toString().trim();
        String hair = mCharacterHair.getText().toString().trim();
        String eyes = mCharacterEyes.getText().toString().trim();
        String skin = mCharacterSkin.getText().toString().trim();
        String proficiency = mCharacterProficiency.getText().toString().trim();
        String healthPoints = mCharacterHealthPoints.getText().toString().trim();
        String temporaryHealthPoints = mCharacterTemporaryHealthPoints.getText().toString().trim();
        String armorClass = mCharacterArmorClass.getText().toString().trim();
        String spellcastingClass = mCharacterSpellcastingClass.getText().toString().trim();
        String speed = mCharacterSpeed.getText().toString().trim();
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
        String firstWeaponName = mFirstWeaponName.getText().toString().trim();
        String firstWeaponBonus = mFirstWeaponBonus.getText().toString().trim();
        String firstWeaponDamage = sFirstWeaponDamage.getSelectedItem().toString().trim();
        int firstWeaponDamageID = sFirstWeaponDamage.getSelectedItemPosition();
        String firstWeaponType = mFirstWeaponType.getText().toString().trim();
        String secondWeaponName = mSecondWeaponName.getText().toString().trim();
        String secondWeaponBonus = mSecondWeaponBonus.getText().toString().trim();
        String secondWeaponDamage = sSecondWeaponDamage.getSelectedItem().toString().trim();
        int secondWeaponDamageID = sSecondWeaponDamage.getSelectedItemPosition();
        String secondWeaponType = mSecondWeaponType.getText().toString().trim();
        String thirdWeaponName = mThirdWeaponName.getText().toString().trim();
        String thirdWeaponBonus = mThirdWeaponBonus.getText().toString().trim();
        String thirdWeaponDamage = sThirdWeaponDamage.getSelectedItem().toString().trim();
        int thirdWeaponDamageID = sThirdWeaponDamage.getSelectedItemPosition();
        String thirdWeaponType = mThirdWeaponType.getText().toString().trim();
        String preparedSpells = mPreparedSpells.getText().toString().trim();
        String equipment = mEquipment.getText().toString().trim();
        String languages = mLanguages.getText().toString().trim();
        String personality = mPersonality.getText().toString().trim();
        String ideals = mIdeals.getText().toString().trim();
        String bonds = mBonds.getText().toString().trim();
        String flaws = mFlaws.getText().toString().trim();
        String allies = mAllies.getText().toString().trim();
        String backstory = mBackstory.getText().toString().trim();
        String spellcastingAbility = mSpellcastingAbility.getText().toString().trim();
        String spellSaveDC = mSpellSaveDC.getText().toString().trim();
        String spellAttackBonus = mSpellAttackBonus.getText().toString().trim();
        String levelZeroSpells = mLevelZeroSpells.getText().toString().trim();
        String levelOneSpells = mLevelOneSpells.getText().toString().trim();
        String levelTwoSpells = mLevelTwoSpells.getText().toString().trim();
        String levelThreeSpells = mLevelThreeSpells.getText().toString().trim();
        String levelFourSpells = mLevelFourSpells.getText().toString().trim();
        String levelFiveSpells = mLevelFiveSpells.getText().toString().trim();
        String levelSixSpells = mLevelSixSpells.getText().toString().trim();
        String levelSevenSpells = mLevelSevenSpells.getText().toString().trim();
        String levelEightSpells = mLevelEightSpells.getText().toString().trim();
        String levelNineSpells = mLevelNineSpells.getText().toString().trim();

        if (TextUtils.isEmpty(name) &&
                TextUtils.isEmpty(charClass) &&
                TextUtils.isEmpty(race) &&
                TextUtils.isEmpty(background) &&
                TextUtils.isEmpty(experience) &&
                TextUtils.isEmpty(level) &&
                TextUtils.isEmpty(alignment) &&
                TextUtils.isEmpty(deity) &&
                TextUtils.isEmpty(height) &&
                TextUtils.isEmpty(weight) &&
                TextUtils.isEmpty(gender) &&
                TextUtils.isEmpty(hair) &&
                TextUtils.isEmpty(eyes) &&
                TextUtils.isEmpty(skin) &&
                TextUtils.isEmpty(proficiency) &&
                TextUtils.isEmpty(healthPoints) &&
                TextUtils.isEmpty(temporaryHealthPoints) &&
                TextUtils.isEmpty(armorClass) &&
                TextUtils.isEmpty(spellcastingClass) &&
                TextUtils.isEmpty(speed) &&
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
                TextUtils.isEmpty(survival) &&
                TextUtils.isEmpty(firstWeaponName) &&
                TextUtils.isEmpty(firstWeaponBonus) &&
                TextUtils.isEmpty(firstWeaponDamage) &&
                TextUtils.isEmpty(firstWeaponType) &&
                TextUtils.isEmpty(secondWeaponName) &&
                TextUtils.isEmpty(secondWeaponBonus) &&
                TextUtils.isEmpty(secondWeaponDamage) &&
                TextUtils.isEmpty(secondWeaponType) &&
                TextUtils.isEmpty(thirdWeaponName) &&
                TextUtils.isEmpty(thirdWeaponBonus) &&
                TextUtils.isEmpty(thirdWeaponDamage) &&
                TextUtils.isEmpty(thirdWeaponType) &&
                TextUtils.isEmpty(preparedSpells) &&
                TextUtils.isEmpty(equipment) &&
                TextUtils.isEmpty(languages) &&
                TextUtils.isEmpty(personality) &&
                TextUtils.isEmpty(ideals) &&
                TextUtils.isEmpty(bonds) &&
                TextUtils.isEmpty(flaws) &&
                TextUtils.isEmpty(allies) &&
                TextUtils.isEmpty(backstory) &&
                TextUtils.isEmpty(spellcastingAbility) &&
                TextUtils.isEmpty(spellSaveDC) &&
                TextUtils.isEmpty(spellAttackBonus) &&
                TextUtils.isEmpty(levelZeroSpells) &&
                TextUtils.isEmpty(levelOneSpells) &&
                TextUtils.isEmpty(levelTwoSpells) &&
                TextUtils.isEmpty(levelThreeSpells) &&
                TextUtils.isEmpty(levelFourSpells) &&
                TextUtils.isEmpty(levelFiveSpells) &&
                TextUtils.isEmpty(levelSixSpells) &&
                TextUtils.isEmpty(levelSevenSpells) &&
                TextUtils.isEmpty(levelEightSpells) &&
                TextUtils.isEmpty(levelNineSpells)) {
            return;
        }

        ContentValues values = new ContentValues();
        values.put(CharacterEntry.COLUMN_CHARACTER_NAME, name);
        values.put(CharacterEntry.COLUMN_CHARACTER_CLASS, charClass);
        values.put(CharacterEntry.COLUMN_CHARACTER_RACE, race);
        values.put(CharacterEntry.COLUMN_CHARACTER_BACKGROUND, background);
        values.put(CharacterEntry.COLUMN_CHARACTER_EXPERIENCE, experience);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVEL,level);
        values.put(CharacterEntry.COLUMN_CHARACTER_ALIGNMENT, alignment);
        values.put(CharacterEntry.COLUMN_CHARACTER_DEITY, deity);
        values.put(CharacterEntry.COLUMN_CHARACTER_HEIGHT, height);
        values.put(CharacterEntry.COLUMN_CHARACTER_WEIGHT, weight);
        values.put(CharacterEntry.COLUMN_CHARACTER_GENDER, gender);
        values.put(CharacterEntry.COLUMN_CHARACTER_HAIR, hair);
        values.put(CharacterEntry.COLUMN_CHARACTER_EYES, eyes);
        values.put(CharacterEntry.COLUMN_CHARACTER_SKIN, skin);
        values.put(CharacterEntry.COLUMN_CHARACTER_PROFICIENCY, proficiency);
        values.put(CharacterEntry.COLUMN_CHARACTER_HEALTHPOINTS, healthPoints);
        values.put(CharacterEntry.COLUMN_CHARACTER_TEMPORARYHEALTHPOINTS, temporaryHealthPoints);
        values.put(CharacterEntry.COLUMN_CHARACTER_ARMORCLASS, armorClass);
        values.put(CharacterEntry.COLUMN_CHARACTER_SPELLCASTINGCLASS, spellcastingClass);
        values.put(CharacterEntry.COLUMN_CHARACTER_SPEED, speed);
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
        values.put(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONNAME, firstWeaponName);
        values.put(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONBONUS, firstWeaponBonus);
        values.put(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGE, firstWeaponDamage);
        values.put(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGEID, firstWeaponDamageID);
        values.put(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONTYPE, firstWeaponType);
        values.put(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONNAME, secondWeaponName);
        values.put(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONBONUS, secondWeaponBonus);
        values.put(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGE, secondWeaponDamage);
        values.put(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGEID, secondWeaponDamageID);
        values.put(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONTYPE, secondWeaponType);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONNAME, thirdWeaponName);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONBONUS, thirdWeaponBonus);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGE, thirdWeaponDamage);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGEID, thirdWeaponDamageID);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONTYPE, thirdWeaponType);
        values.put(CharacterEntry.COLUMN_CHARACTER_PREPAREDSPELLS, preparedSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONBONUS, secondWeaponBonus);
        values.put(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGE, secondWeaponDamage);
        values.put(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONTYPE, secondWeaponType);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONNAME, thirdWeaponName);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONBONUS, thirdWeaponBonus);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGE, thirdWeaponDamage);
        values.put(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONTYPE, thirdWeaponType);
        values.put(CharacterEntry.COLUMN_CHARACTER_PREPAREDSPELLS, preparedSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_EQUIPMENT, equipment);
        values.put(CharacterEntry.COLUMN_CHARACTER_LANGUAGES, languages);
        values.put(CharacterEntry.COLUMN_CHARACTER_PERSONALITY, personality);
        values.put(CharacterEntry.COLUMN_CHARACTER_IDEALS, ideals);
        values.put(CharacterEntry.COLUMN_CHARACTER_BONDS, bonds);
        values.put(CharacterEntry.COLUMN_CHARACTER_FLAWS, flaws);
        values.put(CharacterEntry.COLUMN_CHARACTER_ALLIES, allies);
        values.put(CharacterEntry.COLUMN_CHARACTER_BACKSTORY, backstory);
        values.put(CharacterEntry.COLUMN_CHARACTER_SPELLCASTINGABILITY, spellcastingAbility);
        values.put(CharacterEntry.COLUMN_CHARACTER_SPELLSAVEDC, spellSaveDC);
        values.put(CharacterEntry.COLUMN_CHARACTER_SPELLATTACKBONUS, spellAttackBonus);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELZEROSPELLS, levelZeroSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELONESPELLS, levelOneSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELTWOSPELLS, levelTwoSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELTHREESPELLS, levelThreeSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELFOURSPELLS, levelFourSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELFIVESPELLS, levelFiveSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELSIXSPELLS, levelSixSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELSEVENSPELLS, levelSevenSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELEIGHTSPELLS, levelEightSpells);
        values.put(CharacterEntry.COLUMN_CHARACTER_LEVELNINESPELLS, levelNineSpells);

        Uri newUri = getContentResolver().insert(CharacterEntry.CONTENT_URI, values);

        if (newUri == null) {
            Toast.makeText(this, R.string.failed_to_create_character, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.character_created, Toast.LENGTH_SHORT).show();
        }
    }

    private void showUnsavedChangesDialog(DialogInterface.OnClickListener discardButtonClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.discard_changes_quit_editing);
        builder.setPositiveButton(R.string.discard_changes, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
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
