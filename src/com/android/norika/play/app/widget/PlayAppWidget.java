
package com.android.norika.play.app.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import com.android.norika.play.R;


public class PlayAppWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.view_widget_timeslice);
            AppWidgetManager appManager = AppWidgetManager.getInstance(context);
            // ComponentName thisWidget = new ComponentName(context,
            // PlayAppWidget.class);
            appManager.updateAppWidget(appWidgetId, views);
        }
    }

}
