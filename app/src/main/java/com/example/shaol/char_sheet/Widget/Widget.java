package com.example.shaol.char_sheet.Widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.widget.RemoteViews;

import com.example.shaol.char_sheet.R;

/**
 * Implementation of App Widget functionality.
 */
public class Widget extends AppWidgetProvider {

    static String mName;

    public static final String UPDATE_ACTION = "com.example.shaol.char_sheet.Widget.action.UPDATE";
    public static final String CLEAR_ACTION = "com.example.shaol.char_sheet.Widget.action.CLEAR";

    public void onReceive(Context context, Intent intent) {
        AppWidgetManager manager = AppWidgetManager.getInstance(context);

        if (intent.getAction().equals(UPDATE_ACTION)){
            int[] appWidgetIds = manager.getAppWidgetIds(new ComponentName(context, Widget.class));

            String name = intent.getStringExtra("Name");
            mName = name;

            manager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.appwidget_text);

            onUpdate(context, manager, appWidgetIds);

        } else if (intent.getAction().equals(CLEAR_ACTION)) {
            int[] appWidgetIds = manager.getAppWidgetIds(new ComponentName(context, Widget.class));

            mName = null;

            manager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.appwidget_text);

            onUpdate(context, manager, appWidgetIds);
        }
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int i = 0; i < appWidgetIds.length; i++) {
            updateAppWidget(context, appWidgetManager, mName, i);
        }
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                String name, int appWidgetId) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);

        remoteViews.setTextViewText(R.id.appwidget_text, name);
        remoteViews.setEmptyView(R.id.appwidget_text, R.id.emptyWidgetView);

        appWidgetManager.updateAppWidget(new ComponentName(context, Widget.class), remoteViews);
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

