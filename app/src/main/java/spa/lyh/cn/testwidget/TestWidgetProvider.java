package spa.lyh.cn.testwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

public class TestWidgetProvider extends AppWidgetProvider {
    public static final String CLICK_ACTION = BuildConfig.APPLICATION_ID+".action.CLICKATTENDANCE"; // 点击事件的广播ACTION

    /**
     * 每次窗口小部件被更新都调用一次该方法
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.e("qwer","onUpdate");
        //获得小组件的view
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_test);
        Intent intent = new Intent(context,getClass());
        intent.setAction(CLICK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, R.id.doge_imageView, intent, PendingIntent.FLAG_IMMUTABLE);
        remoteViews.setOnClickPendingIntent(R.id.doge_imageView, pendingIntent);

        for (int appWidgetId : appWidgetIds) {
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
    }

    /**
     * 接收窗口小部件点击时发送的广播
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.e("qwer","onReceive");
        Log.e("qwer",intent.getAction());
        if (CLICK_ACTION.equals(intent.getAction())) {
            Toast.makeText(context, "Hello Doge~", Toast.LENGTH_SHORT).show();
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_test);
            remoteViews.setTextViewText(R.id.tv,System.currentTimeMillis()+"");

            AppWidgetManager manager = AppWidgetManager
                    .getInstance(context);
            ComponentName cName = new ComponentName(context,
                    TestWidgetProvider.class);
            manager.updateAppWidget(cName, remoteViews);
        }
    }


    /**
     * 每删除一次窗口小部件就调用一次
     */
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }


    /**
     * 当最后一个该窗口小部件删除时调用该方法
     */
    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }


    /**
     * 当该窗口小部件第一次添加到桌面时调用该方法
     */
    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }


    /**
     * 当小部件大小改变时
     */
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
    }


    /**
     * 当小部件从备份恢复时调用该方法
     */
    @Override
    public void onRestored(Context context, int[] oldWidgetIds, int[] newWidgetIds) {
        super.onRestored(context, oldWidgetIds, newWidgetIds);
    }



}
