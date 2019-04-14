package amelia.jasmine.appwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import io.paperdb.Paper;

/**
 * Implementation of App Widget functionality.
 */
public class HomeWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        Paper.init(context);

        String nama = Paper.book().read("nama");
        String ttl = Paper.book().read("ttl");
        String nohp = Paper.book().read("nohp");
        String hobi = Paper.book().read("hobi");

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.home_widget);
        views.setTextViewText(R.id.appwidget_nama, nama);
        views.setTextViewText(R.id.appwidget_ttl, ttl);
        views.setTextViewText(R.id.appwidget_nohp, nohp);
        views.setTextViewText(R.id.appwidget_hobi, hobi);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
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

