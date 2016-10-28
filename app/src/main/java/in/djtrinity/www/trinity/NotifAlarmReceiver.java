package in.djtrinity.www.trinity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;

import java.util.GregorianCalendar;

public class NotifAlarmReceiver extends BroadcastReceiver {

    private String currentDay;
    private String currentMonth;
    private Context context;
    private int counterForEventsForNotif;
    private int counterForCurrentEventsForNotif;
    private String[] eventsForNotif = new String[MainActivity.eventList.length];
    private EventData[] events = new EventData[MainActivity.eventList.length];
    private String[] currentEventsForNotif = new String[MainActivity.eventList.length];

    @Override
    public void onReceive(Context context, Intent intent) {
        setEventData();

        getCurrentDate();
        this.context = context;
        counterForEventsForNotif = 0;
        counterForCurrentEventsForNotif = 0;
        boolean notif;
        SharedPreferences preferences = context.getApplicationContext().getSharedPreferences("NotifPref", 0);
        for (int i = 0; i < MainActivity.eventList.length; i++) {
            notif = preferences.getBoolean(MainActivity.eventList[i], false);
            if (notif) {
                eventsForNotif[counterForEventsForNotif] = MainActivity.eventList[i];
                counterForEventsForNotif++;
            }
        }
        if (counterForEventsForNotif != 0) {
            for (int i = 0; i < counterForEventsForNotif; i++) {
                for (int j = 0; j < MainActivity.eventList.length; j++) {
                    if (eventsForNotif[i].equals(events[j].getEventName())) {
                        if (events[j].getEventMonth().equals(currentMonth)) {
                            if (events[j].getEventDay().equals(currentDay)) {
                                currentEventsForNotif[i] = eventsForNotif[i];
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putBoolean(eventsForNotif[i], false);
                                editor.apply();
                                createNotif();
                                counterForCurrentEventsForNotif++;
                            }
                        }
                    }
                }
            }
        }
    }

    public void setEventData() {
        for (int i = 0; i < MainActivity.eventList.length; i++) {
            events[i] = new EventData();
            events[i].setEventName(MainActivity.eventList[i]);
            events[i].setEventMonth(MainActivity.eventListMonth[i]);
            events[i].setEventDay(MainActivity.eventListDay[i]);
        }
    }

    public void getCurrentDate() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        currentDay = String.valueOf(gregorianCalendar.get(GregorianCalendar.DAY_OF_MONTH));
        currentMonth = String.valueOf(gregorianCalendar.get(GregorianCalendar.MONTH) + 1);
    }

    public void createNotif() {
        Intent intent = new Intent(context, MainActivity
                .class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        String eventName = eventsForNotif[0];
        if (counterForCurrentEventsForNotif > 1) {
            for (int i = 1; i < counterForEventsForNotif; i++) {
                if (i == counterForCurrentEventsForNotif - 1)
                    eventName = eventName + " and " + currentEventsForNotif[i];
                else
                    eventName = eventName + ", " + currentEventsForNotif[i];
            }
        }

        Uri notifRing = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone ringtone =RingtoneManager.getRingtone(context, notifRing);
        ringtone.play();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(500);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_calendar)
                .setContentTitle("Trinity")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentText(eventName + " scheduled for today.");
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        int mNotifId = 1;
        manager.notify(mNotifId, builder.build());
    }
}
