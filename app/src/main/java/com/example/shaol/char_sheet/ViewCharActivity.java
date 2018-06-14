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
import android.widget.Spinner;
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

    private static int firstDamage;
    private static int secondDamage;
    private static int thirdDamage;

    @BindView(R.id.viewNameView) TextView mCharacterName;
    @BindView(R.id.viewClassView) TextView mCharacterClass;
    @BindView(R.id.viewRaceView) TextView mCharacterRace;
    @BindView(R.id.viewBackgroundView) TextView mCharacterBackground;
    @BindView(R.id.viewXPView) TextView mCharacterXP;
    @BindView(R.id.viewLevelView) TextView mCharacterLevel;
    @BindView(R.id.viewAlignmentView) TextView mCharacterAlignment;
    @BindView(R.id.viewDeityView) TextView mCharacterDeity;
    @BindView(R.id.viewHeightView) TextView mCharacterHeight;
    @BindView(R.id.viewWeightView) TextView mCharacterWeight;
    @BindView(R.id.viewGenderView) TextView mCharacterGender;
    @BindView(R.id.viewHairView) TextView mCharacterHair;
    @BindView(R.id.viewEyesView) TextView mCharacterEyes;
    @BindView(R.id.viewSkinView) TextView mCharacterSkin;
    @BindView(R.id.viewProficiencyView) TextView mCharacterProficiency;
    @BindView(R.id.viewHealthPointsView) TextView mCharacterHealthPoints;
    @BindView(R.id.viewTemporaryHealthPointsView) TextView mCharacterTemporaryHealthPoints;
    @BindView(R.id.viewArmorClassView) TextView mCharacterArmorClass;
    @BindView(R.id.viewSpellcastingClassView) TextView mCharacterSpellcastingClass;
    @BindView(R.id.viewSpeedView) TextView mCharacterSpeed;
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
    @BindView(R.id.viewFirstNameView) TextView mFirstWeaponName;
    @BindView(R.id.viewFirstBonusView) TextView mFirstWeaponBonus;
    @BindView(R.id.viewFirstDamageView) TextView mFirstWeaponDamage;
    @BindView(R.id.viewFirstTypeView) TextView mFirstWeaponType;
    @BindView(R.id.viewSecondNameView) TextView mSecondWeaponName;
    @BindView(R.id.viewSecondBonusView) TextView mSecondWeaponBonus;
    @BindView(R.id.viewSecondDamageView) TextView mSecondWeaponDamage;
    @BindView(R.id.viewSecondTypeView) TextView mSecondWeaponType;
    @BindView(R.id.viewThirdNameView) TextView mThirdWeaponName;
    @BindView(R.id.viewThirdBonusView) TextView mThirdWeaponBonus;
    @BindView(R.id.viewThirdDamageView) TextView mThirdWeaponDamage;
    @BindView(R.id.viewThirdTypeView) TextView mThirdWeaponType;
    @BindView(R.id.viewPreparedSpellsView) TextView mPreparedSpells;
    @BindView(R.id.viewEquipmentView) TextView mEquipment;
    @BindView(R.id.viewLanguagesView) TextView mLanguages;
    @BindView(R.id.viewPersonalityView) TextView mPersonality;
    @BindView(R.id.viewIdealsView) TextView mIdeals;
    @BindView(R.id.viewBondsView) TextView mBonds;
    @BindView(R.id.viewFlawsView) TextView mFlaws;
    @BindView(R.id.viewAlliesView) TextView mAllies;
    @BindView(R.id.viewBackstoryView) TextView mBackstory;
    @BindView(R.id.viewSpellcastingAbilityView) TextView mSpellcastingAbility;
    @BindView(R.id.viewSpellSaveDCView) TextView mSpellSaveDC;
    @BindView(R.id.viewSpellAttackBonusView) TextView mSpellAttackBonus;
    @BindView(R.id.viewLevelZeroSpellsView) TextView mLevelZeroSpells;
    @BindView(R.id.viewLevelOneSpellsView) TextView mLevelOneSpells;
    @BindView(R.id.viewLevelTwoSpellsView) TextView mLevelTwoSpells;
    @BindView(R.id.viewLevelThreeSpellsView) TextView mLevelThreeSpells;
    @BindView(R.id.viewLevelFourSpellsView) TextView mLevelFourSpells;
    @BindView(R.id.viewLevelFiveSpellsView) TextView mLevelFiveSpells;
    @BindView(R.id.viewLevelSixSpellsView) TextView mLevelSixSpells;
    @BindView(R.id.viewLevelSevenSpellsView) TextView mLevelSevenSpells;
    @BindView(R.id.viewLevelEightSpellsView) TextView mLevelEightSpells;
    @BindView(R.id.viewLevelNineSpellsView) TextView mLevelNineSpells;

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
            case R.id.make_skill_rolls:
                String[] skillz = new String[18];
                skillz[0] = mCharacterAcrobatics.getText().toString();
                skillz[1] = mCharacterAnimalHandling.getText().toString();
                skillz[2] = mCharacterArcana.getText().toString();
                skillz[3] = mCharacterAthletics.getText().toString();
                skillz[4] = mCharacterDeception.getText().toString();
                skillz[5] = mCharacterHistory.getText().toString();
                skillz[6] = mCharacterInsight.getText().toString();
                skillz[7] = mCharacterIntimidation.getText().toString();
                skillz[8] = mCharacterInvestigation.getText().toString();
                skillz[9] = mCharacterMedicine.getText().toString();
                skillz[10] = mCharacterNature.getText().toString();
                skillz[11] = mCharacterPerception.getText().toString();
                skillz[12] = mCharacterPerformance.getText().toString();
                skillz[13] = mCharacterPersuasion.getText().toString();
                skillz[14] = mCharacterReligion.getText().toString();
                skillz[15] = mCharacterSleightOfHand.getText().toString();
                skillz[16] = mCharacterStealth.getText().toString();
                skillz[17] = mCharacterSurvival.getText().toString();

                Intent skillsIntent = new Intent(ViewCharActivity.this, SkillRoll.class);
                skillsIntent.putExtra("Skills", skillz);
                startActivity(skillsIntent);
                return true;

            case R.id.make_saving_rolls:
                String[] attributes = new String[6];
                attributes[0] = mCharacterStrMod.getText().toString();
                attributes[1] = mCharacterDexMod.getText().toString();
                attributes[2] = mCharacterConMod.getText().toString();
                attributes[3] = mCharacterIntMod.getText().toString();
                attributes[4] = mCharacterWisMod.getText().toString();
                attributes[5] = mCharacterChaMod.getText().toString();

                Intent attributesIntent = new Intent(ViewCharActivity.this, SavingRoll.class);
                attributesIntent.putExtra("Attributes", attributes);
                startActivity(attributesIntent);
                return true;

            case R.id.make_attack_rolls:
                String[] names = new String[3];
                names[0] = mFirstWeaponName.getText().toString();
                names[1] = mSecondWeaponName.getText().toString();
                names[2] = mThirdWeaponName.getText().toString();

                String[] bonus = new String[3];
                bonus[0] = mFirstWeaponBonus.getText().toString();
                bonus[1] = mSecondWeaponBonus.getText().toString();
                bonus[2] = mThirdWeaponBonus.getText().toString();

                int[] damages = new int[3];
                damages[0] = firstDamage;
                damages[1] = secondDamage;
                damages[2] = thirdDamage;


                Intent attacksIntent = new Intent(ViewCharActivity.this, AttackRoll.class);
                attacksIntent.putExtra("Names", names);
                attacksIntent.putExtra("Bonus", bonus);
                attacksIntent.putExtra("Damages", damages);
                startActivity(attacksIntent);
                return true;

            case R.id.make_custom_rolls:
                Intent customIntent = new Intent(ViewCharActivity.this, CustomRoll.class);
                startActivity(customIntent);
                return true;

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
                CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGE,
                CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGEID,
                CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONTYPE,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONNAME,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONBONUS,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGE,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGEID,
                CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONTYPE,
                CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONNAME,
                CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONBONUS,
                CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGE,
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

        return new CursorLoader(this, mCurrentCharacterUri, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if ( cursor != null && cursor.moveToFirst()) {
            int nameCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_NAME);
            int classCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_CLASS);
            int raceCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_RACE);
            int backgroundCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_BACKGROUND);
            int experienceCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_EXPERIENCE);
            int levelCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVEL);
            int alignmentCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_ALIGNMENT);
            int deityCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_DEITY);
            int heightCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_HEIGHT);
            int weightCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_WEIGHT);
            int genderCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_GENDER);
            int hairCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_HAIR);
            int eyesCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_EYES);
            int skinCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SKIN);
            int proficiencyCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_PROFICIENCY);
            int healthPointsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_HEALTHPOINTS);
            int temporaryHealthPointsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_TEMPORARYHEALTHPOINTS);
            int armorClassCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_ARMORCLASS);
            int spellcastingClassCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SPELLCASTINGCLASS);
            int speedCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SPEED);
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
            int firstWeaponNameCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONNAME);
            int firstWeaponBonusCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONBONUS);
            int firstWeaponDamageCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGE);
            int firstWeaponDamageIdCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGEID);
            int firstWeaponTypeCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONTYPE);
            int secondWeaponNameCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONNAME);
            int secondWeaponBonusCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONBONUS);
            int secondWeaponDamageCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGE);
            int secondWeaponDamageIdCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGEID);
            int secondWeaponTypeCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONTYPE);
            int thirdWeaponNameCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONNAME);
            int thirdWeaponBonusCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONBONUS);
            int thirdWeaponDamageCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGE);
            int thirdWeaponDamageIdCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGEID);
            int thirdWeaponTypeCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONTYPE);
            int preparedSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_PREPAREDSPELLS);
            int equipmentCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_EQUIPMENT);
            int languagesCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LANGUAGES);
            int personalityCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_PERSONALITY);
            int idealsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_IDEALS);
            int bondsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_BONDS);
            int flawsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_FLAWS);
            int alliesCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_ALLIES);
            int backstoryCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_BACKSTORY);
            int spellcastingAbilityCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SPELLCASTINGABILITY);
            int spellSaveDCCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SPELLSAVEDC);
            int spellAttackBonusCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_SPELLATTACKBONUS);
            int levelZeroSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELZEROSPELLS);
            int levelOneSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELONESPELLS);
            int levelTwoSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELTWOSPELLS);
            int levelThreeSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELTHREESPELLS);
            int levelFourSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELFOURSPELLS);
            int levelFiveSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELFIVESPELLS);
            int levelSixSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELSIXSPELLS);
            int levelSevenSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELSEVENSPELLS);
            int levelEightSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELEIGHTSPELLS);
            int levelNineSpellsCI = cursor.getColumnIndex(CharacterEntry.COLUMN_CHARACTER_LEVELNINESPELLS);

            String name = cursor.getString(nameCI);
            String charClass = cursor.getString(classCI);
            String race = cursor.getString(raceCI);
            String background = cursor.getString(backgroundCI);
            String experience = cursor.getString(experienceCI);
            String level = cursor.getString(levelCI);
            String alignment = cursor.getString(alignmentCI);
            String deity = cursor.getString(deityCI);
            String height = cursor.getString(heightCI);
            String weight = cursor.getString(weightCI);
            String gender = cursor.getString(genderCI);
            String hair = cursor.getString(hairCI);
            String eyes = cursor.getString(eyesCI);
            String skin = cursor.getString(skinCI);
            String proficiency = cursor.getString(proficiencyCI);
            String healthPoints = cursor.getString(healthPointsCI);
            String temporaryHealthPoints = cursor.getString(temporaryHealthPointsCI);
            String armorClass = cursor.getString(armorClassCI);
            String spellcasting = cursor.getString(spellcastingClassCI);
            String speed = cursor.getString(speedCI);
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
            String firstWeaponName = cursor.getString(firstWeaponNameCI);
            String firstWeaponBonus = cursor.getString(firstWeaponBonusCI);
            String firstWeaponDamage = cursor.getString(firstWeaponDamageCI);
            firstDamage = cursor.getInt(firstWeaponDamageIdCI);
            String firstWeaponType = cursor.getString(firstWeaponTypeCI);
            String secondWeaponName = cursor.getString(secondWeaponNameCI);
            String secondWeaponBonus = cursor.getString(secondWeaponBonusCI);
            String secondWeaponDamage = cursor.getString(secondWeaponDamageCI);
            secondDamage = cursor.getInt(secondWeaponDamageIdCI);
            String secondWeaponType = cursor.getString(secondWeaponTypeCI);
            String thirdWeaponName = cursor.getString(thirdWeaponNameCI);
            String thirdWeaponBonus = cursor.getString(thirdWeaponBonusCI);
            String thirdWeaponDamage = cursor.getString(thirdWeaponDamageCI);
            thirdDamage = cursor.getInt(thirdWeaponDamageIdCI);
            String thirdWeaponType = cursor.getString(thirdWeaponTypeCI);
            String preparedSpells = cursor.getString(preparedSpellsCI);
            String equipment = cursor.getString(equipmentCI);
            String languages = cursor.getString(languagesCI);
            String personality = cursor.getString(personalityCI);
            String ideals = cursor.getString(idealsCI);
            String bonds = cursor.getString(bondsCI);
            String flaws = cursor.getString(flawsCI);
            String allies = cursor.getString(alliesCI);
            String backstory = cursor.getString(backstoryCI);
            String spellcastingAbility = cursor.getString(spellcastingAbilityCI);
            String spellSaveDC = cursor.getString(spellSaveDCCI);
            String spellAttackBonus = cursor.getString(spellAttackBonusCI);
            String levelZeroSpells = cursor.getString(levelZeroSpellsCI);
            String levelOneSpells = cursor.getString(levelOneSpellsCI);
            String levelTwoSpells = cursor.getString(levelTwoSpellsCI);
            String levelThreeSpells = cursor.getString(levelThreeSpellsCI);
            String levelFourSpells = cursor.getString(levelFourSpellsCI);
            String levelFiveSpells = cursor.getString(levelFiveSpellsCI);
            String levelSixSpells = cursor.getString(levelSixSpellsCI);
            String levelSevenSpells = cursor.getString(levelSevenSpellsCI);
            String levelEightSpells = cursor.getString(levelEightSpellsCI);
            String levelNineSpells = cursor.getString(levelNineSpellsCI);

            mCharacterName.setText(name);
            mCharacterClass.setText(charClass);
            mCharacterRace.setText(race);
            mCharacterBackground.setText(background);
            mCharacterXP.setText(experience);
            mCharacterLevel.setText(level);
            mCharacterAlignment.setText(alignment);
            mCharacterDeity.setText(deity);
            mCharacterHeight.setText(height);
            mCharacterWeight.setText(weight);
            mCharacterGender.setText(gender);
            mCharacterHair.setText(hair);
            mCharacterEyes.setText(eyes);
            mCharacterSkin.setText(skin);
            mCharacterProficiency.setText(proficiency);
            mCharacterHealthPoints.setText(healthPoints);
            mCharacterTemporaryHealthPoints.setText(temporaryHealthPoints);
            mCharacterArmorClass.setText(armorClass);
            mCharacterSpellcastingClass.setText(spellcasting);
            mCharacterSpeed.setText(speed);
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
            mFirstWeaponName.setText(firstWeaponName);
            mFirstWeaponBonus.setText(firstWeaponBonus);
            mFirstWeaponDamage.setText(firstWeaponDamage);
            mFirstWeaponType.setText(firstWeaponType);
            mSecondWeaponName.setText(secondWeaponName);
            mSecondWeaponBonus.setText(secondWeaponBonus);
            mSecondWeaponDamage.setText(secondWeaponDamage);
            mSecondWeaponType.setText(secondWeaponType);
            mThirdWeaponName.setText(thirdWeaponName);
            mThirdWeaponBonus.setText(thirdWeaponBonus);
            mThirdWeaponDamage.setText(thirdWeaponDamage);
            mThirdWeaponType.setText(thirdWeaponType);
            mPreparedSpells.setText(preparedSpells);
            mEquipment.setText(equipment);
            mLanguages.setText(languages);
            mPersonality.setText(personality);
            mIdeals.setText(ideals);
            mBonds.setText(bonds);
            mFlaws.setText(flaws);
            mAllies.setText(allies);
            mBackstory.setText(backstory);
            mSpellcastingAbility.setText(spellcastingAbility);
            mSpellSaveDC.setText(spellSaveDC);
            mSpellAttackBonus.setText(spellAttackBonus);
            mLevelZeroSpells.setText(levelZeroSpells);
            mLevelOneSpells.setText(levelOneSpells);
            mLevelTwoSpells.setText(levelTwoSpells);
            mLevelThreeSpells.setText(levelThreeSpells);
            mLevelFourSpells.setText(levelFourSpells);
            mLevelFiveSpells.setText(levelFiveSpells);
            mLevelSixSpells.setText(levelSixSpells);
            mLevelSevenSpells.setText(levelSevenSpells);
            mLevelEightSpells.setText(levelEightSpells);
            mLevelNineSpells.setText(levelNineSpells);
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
