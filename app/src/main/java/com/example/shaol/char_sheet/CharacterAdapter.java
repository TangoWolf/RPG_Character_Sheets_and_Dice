package com.example.shaol.char_sheet;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.shaol.char_sheet.data.CharacterContract.CharacterEntry.COLUMN_CHARACTER_NAME;

/**
 * Created by shaol on 4/5/2018.
 */

public class CharacterAdapter extends CursorAdapter {
    public CharacterAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView characterName = (TextView) view.findViewById(R.id.lv_item);
        String name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHARACTER_NAME));
        characterName.setText(name);
    }
}
