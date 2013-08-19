package tw.edu.cksh.tp.hexclock;
import android.appwidget.*;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;
import java.util.Calendar;


public class ClockWidgetProvider extends AppWidgetProvider {

	public void onUpdate(Context context, 
						AppWidgetManager appWidgetManager, 
						int[] appWidgetIds) {
		// 更新小工具的 View
		RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_view);
		
		Calendar c = Calendar.getInstance();
		String hour_str = String.format("%1$X", c.get(Calendar.HOUR_OF_DAY));
		String min_str = String.format("%1$X", c.get(Calendar.MINUTE));
		 
		rv.setTextViewText(R.id.hour_label, hour_str);
		rv.setTextViewText(R.id.minute_label, min_str);
		
		appWidgetManager.updateAppWidget(
				new ComponentName(context, this.getClass()), 
				rv);
	}
}
