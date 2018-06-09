package com.example.shaol.char_sheet;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionBarContextView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shaol.char_sheet.data.CharacterContract.CharacterEntry;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private TextView mEmptyView;
    private static final int CHARACTER_LOADER = 0;
    CharacterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.available_characters);

        ListView characterListView = (ListView) findViewById(R.id.listView);

        mEmptyView = (TextView) findViewById(R.id.emptyView);
        characterListView.setEmptyView(mEmptyView);

        mAdapter = new CharacterAdapter(this, null);
        characterListView.setAdapter(mAdapter);

        characterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ViewCharActivity.class);

                Uri currentCharacterUri = ContentUris.withAppendedId(CharacterEntry.CONTENT_URI, id);

                intent.setData(currentCharacterUri);

                startActivity(intent);
            }
        });

        getSupportLoaderManager().initLoader(CHARACTER_LOADER, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, NewCharActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                CharacterEntry._ID,
                CharacterEntry.COLUMN_CHARACTER_NAME
        };

        return new CursorLoader(this,CharacterEntry.CONTENT_URI, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
