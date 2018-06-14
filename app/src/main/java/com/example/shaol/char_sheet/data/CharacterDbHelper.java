package com.example.shaol.char_sheet.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shaol.char_sheet.data.CharacterContract.CharacterEntry;

/**
 * Created by shaol on 4/7/2018.
 */

public class CharacterDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "characters.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CharacterEntry.TABLE_NAME + " (" +
                    CharacterEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CharacterEntry.COLUMN_CHARACTER_NAME + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_CLASS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_RACE + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_BACKGROUND + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_EXPERIENCE + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVEL + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_ALIGNMENT + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_DEITY + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_HEIGHT + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_WEIGHT + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_GENDER + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_HAIR + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_EYES + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SKIN + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_PROFICIENCY + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_HEALTHPOINTS + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_TEMPORARYHEALTHPOINTS + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_ARMORCLASS + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_SPELLCASTINGCLASS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SPEED + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_STRENGTH + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_DEXTERITY + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_CONSTITUTION + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_INTELLIGENCE + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_WISDOM + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_CHARISMA + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_FEATS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_ACROBATICS + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_ANIMALHANDLING + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_ARCANA + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_ATHLETICS + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_DECEPTION + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_HISTORY + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_INSIGHT + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_INTIMIDATION + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_INVESTIGATION + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_MEDICINE + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_NATURE + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_PERCEPTION + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_PERFORMANCE + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_PERSUASION + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_RELIGION + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_SLEIGHTOFHAND + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_STEALTH + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_SURVIVAL + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONNAME + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONBONUS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGE + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONDAMAGEID + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_FIRSTWEAPONTYPE + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONNAME + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONBONUS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGE + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONDAMAGEID + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_SECONDWEAPONTYPE + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONNAME + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONBONUS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGE + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONDAMAGEID + " INTEGER, " +
                    CharacterEntry.COLUMN_CHARACTER_THIRDWEAPONTYPE + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_PREPAREDSPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_EQUIPMENT + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LANGUAGES + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_PERSONALITY + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_IDEALS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_BONDS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_FLAWS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_ALLIES + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_BACKSTORY + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SPELLCASTINGABILITY + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SPELLSAVEDC + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_SPELLATTACKBONUS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELZEROSPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELONESPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELTWOSPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELTHREESPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELFOURSPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELFIVESPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELSIXSPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELSEVENSPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELEIGHTSPELLS + " TEXT, " +
                    CharacterEntry.COLUMN_CHARACTER_LEVELNINESPELLS + " TEXT);";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + CharacterEntry.TABLE_NAME;

    public CharacterDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
