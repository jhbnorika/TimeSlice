
package com.android.norika.play.widget;

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
                    R.layout.view_widget_play);
            AppWidgetManager appManager = AppWidgetManager.getInstance(context);
            // ComponentName thisWidget = new ComponentName(context,
            // PlayAppWidget.class);
            views.setTextViewText(R.id.widget_tv, "Play ...");
            views.setImageViewResource(R.id.widget_iv, R.drawable.beauty);
            views.setTextViewText(R.id.widget_bt, "Kick");
            appManager.updateAppWidget(appWidgetId, views);
        }
    }

}
