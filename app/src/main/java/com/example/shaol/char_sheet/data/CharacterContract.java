package com.example.shaol.char_sheet.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by shaol on 4/7/2018.
 */

public class CharacterContract {

    public static final String CONTENT_AUTHORITY = "com.example.shaol.char_sheet";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_CHARACTERS = "characters";

    public static final class CharacterEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_CHARACTERS);

        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CHARACTERS;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CHARACTERS;

        public static final String TABLE_NAME = "characters";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_CHARACTER_NAME = "Name";
        public static final String COLUMN_CHARACTER_CLASS = "Class";
        public static final String COLUMN_CHARACTER_LEVEL = "Level";
        public static final String COLUMN_CHARACTER_ALIGNMENT = "Alignment";
        public static final String COLUMN_CHARACTER_DEITY = "Deity";
        public static final String COLUMN_CHARACTER_HEIGHT = "Height";
        public static final String COLUMN_CHARACTER_WEIGHT = "Weight";
        public static final String COLUMN_CHARACTER_GENDER = "Gender";
        public static final String COLUMN_CHARACTER_HAIR = "Hair";
        public static final String COLUMN_CHARACTER_EYES = "Eyes";
        public static final String COLUMN_CHARACTER_SKIN = "Skin";
        public static final String COLUMN_CHARACTER_STRENGTH = "Strength";
        public static final String COLUMN_CHARACTER_DEXTERITY = "Dexterity";
        public static final String COLUMN_CHARACTER_CONSTITUTION = "Constitution";
        public static final String COLUMN_CHARACTER_INTELLIGENCE = "Intelligence";
        public static final String COLUMN_CHARACTER_WISDOM = "Wisdom";
        public static final String COLUMN_CHARACTER_CHARISMA = "Charisma";
        public static final String COLUMN_CHARACTER_FEATS = "Feats";
        public static final String COLUMN_CHARACTER_ACROBATICS = "Acrobatics";
        public static final String COLUMN_CHARACTER_ANIMALHANDLING = "AnimalHandling";
        public static final String COLUMN_CHARACTER_ARCANA = "Arcana";
        public static final String COLUMN_CHARACTER_ATHLETICS = "Athletics";
        public static final String COLUMN_CHARACTER_DECEPTION = "Deception";
        public static final String COLUMN_CHARACTER_HISTORY = "History";
        public static final String COLUMN_CHARACTER_INSIGHT = "Insight";
        public static final String COLUMN_CHARACTER_INTIMIDATION = "Intimidation";
        public static final String COLUMN_CHARACTER_INVESTIGATION = "Investigation";
        public static final String COLUMN_CHARACTER_MEDICINE = "Medicine";
        public static final String COLUMN_CHARACTER_NATURE = "Nature";
        public static final String COLUMN_CHARACTER_PERCEPTION = "Perception";
        public static final String COLUMN_CHARACTER_PERFORMANCE = "Performance";
        public static final String COLUMN_CHARACTER_PERSUASION = "Persuasion";
        public static final String COLUMN_CHARACTER_RELIGION = "Religion";
        public static final String COLUMN_CHARACTER_SLEIGHTOFHAND = "SleightOfHand";
        public static final String COLUMN_CHARACTER_STEALTH = "Stealth";
        public static final String COLUMN_CHARACTER_SURVIVAL = "Survival";
    }
}
