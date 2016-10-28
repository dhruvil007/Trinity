package in.djtrinity.www.trinity;

import android.app.AlarmManager;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavDrawerAdapter.ClickListener {

    public static String[] eventList = {
            "Robowars",
            "Roborace",
            "Robotics Workshop",
            "Robo-Football",
            "IC Engine Car Race",
            "Stock Market",
            "Laser Tag",
            "LAN Gaming",
            "Technical Paper Presentation",
            "TechExpo",
            "Flex and Mascot",
            "Junkyard Wars",
            "Trial By Combat",
            "Chain Reaction",
            "Code Uncode",
            "Fresher's Party",
            "Street Play",
            "DJGT",
            "Musician's War",
            "Escape The Room",
            "Debate",
            "Quiz",
            "Mr & Ms Trinity",
            "Short Film Fest",
            "Photography",
            "MasterChef",
            "Just A Minute (JAM)",
            "Battleship",
            "Graffiti",
            "Stand-Up Comedy",
            "Mini-Golf Course",
            "Beg Borrow Steal",
            "DJ MUN",
            "Mad Ad",
            "Karaoke",
            "Fine Arts",
            "Angry Birds",
            "Outhouse Treasure Hunt",
            "Inter-Department Dance",
            "VCJA",
            "Murder Mystery",
            "Haunted House",
            "Concert Night",
            "Glow Cricket",
            "Raftaar",
            "Sumo Wrestling",
            "Target Shooting",
            "Inter-Department Sports Day",
            "Snookball",
            "Rink Football",
            "Box Cricket",
            "Trinity Sports",
            "Amazing Race",
            "Silent Disco",
            "Brain N Brawn"
    };

    public static String[] eventListMonth = {
            "2",//robowars
            "3",//roborace
            "3",//robotics ws
            "3",//robofootball
            "13",//ic engine
            "3",//stock market
            "3",//laser tag
            "3",//lan gaming
            "3",//tpp
            "3",//techexpo
            "1",//flex mascot
            "3",//junkyard
            "3",//tbc
            "3",//chain reaction
            "3",//code uncode
            "13",//freshers party
            "3",//street play
            "3",//djgt
            "3",//musicians war
            "3",//escape the room
            "3",//debate
            "3",//quiz
            "3",//mmt
            "3",//short film fest
            "3",//photography
            "3",//masterchef
            "3",//jam
            "3",//battleship
            "3",//graffiti
            "3",//stand up comedy
            "3",//mini golf
            "3",//beg borrow steal
            "3",//mun
            "3",//mad ad
            "3",//karaoke
            "3",//fine arts
            "3",//angry birds
            "13",//oth
            "3",//idpt dance
            "13",//vcja
            "3",//murder mystery
            "3",//haunted house
            "3",//concert night
            "3",//glow cricket
            "3",//raftaar
            "3",//sumo wrestling
            "2",//target shooting
            "1",//idpt sports
            "3",//snookball
            "2",//rink football
            "2",//box cricket
            "2",//trinity sports
            "3",//amazing race
            "3",//silent disco
            "3",//brainbrawn
    };

    public static String[] eventListDay = {
            "26",//robowars
            "11",//roborace
            "11",//robotics ws
            "12",//robofootball
            "9",//ic engine
            "11",//stock market
            "11",//laser tag
            "11",//lan gaming
            "11",//tpp
            "11",//techexpo
            "10",//flex mascot
            "11",//junkyard
            "11",//tbc
            "11",//chain reaction
            "11",//code uncode
            "9",//freshers party
            "13",//street play
            "13",//djgt
            "11",//musicians war
            "11",//escape the room
            "11",//debate
            "11",//quiz
            "11",//mmt
            "13",//short film fest
            "11",//photography
            "11",//masterchef
            "11",//jam
            "11",//battleship
            "11",//graffiti
            "11",//stand up comedy
            "11",//mini golf
            "11",//beg borrow steal
            "11",//mun
            "11",//mad ad
            "11",//karaoke
            "11",//fine arts
            "11",//angry birds
            "9",//oth
            "2",//idpt dance
            "9",//vcja
            "11",//murder mystery
            "11",//haunted house
            "11",//concert night
            "11",//glow cricket
            "11",//raftaar
            "11",//sumo wrestling
            "11",//target shooting
            "25",//idpt sports
            "11",//snookball
            "26",//rink football
            "26",//box cricket
            "26",//trinity sports
            "12",//amazing race
            "11",//silent disco
            "11"//brainbrawn
    };

    public static String[] elementName = {
            "Home",
            "Attractions",
            "IDPT",
            "Schedule",
            "Gallery",
            "The Team",
            "About",
            "Sponsors",
            "Contact Us",
            "Scan a Code",
            "Blog"
    };

    public static Integer iconIds[] = {
            R.drawable.ic_home_black_18dp,
            R.drawable.ic_stars_black_18dp,
            R.drawable.ic_trophy_outline_black_18dp,
            R.drawable.ic_calendar,
            R.drawable.ic_insert_photo_black_18dp,
            R.drawable.ic_people_black_18dp,
            R.drawable.ic_info_outline_black_18dp,
            R.drawable.ic_account_balance_black_18dp,
            R.drawable.ic_phone_black_18dp,
            R.drawable.ic_qrcode_scan_black_18dp,
            R.drawable.ic_library_books_black_18dp
    };

    public static boolean scheduleReturnFlag = false;
    public static boolean attractionsReturnFlag = false;
    public static boolean backPressed = false;

    public RecyclerView recyclerView;

    public static int selected_item_number;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.    setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        setSupportActionBar(toolbar);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");

        NavDrawerFragment navDrawerFragment = (NavDrawerFragment) getFragmentManager()
                .findFragmentById(R.id.nav_drawer_fragment);
        navDrawerFragment.setup(R.id.nav_drawer_fragment, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.nav_drawer_recycler_view);
        NavDrawerAdapter navDrawerAdapter = new NavDrawerAdapter(this, getData());
        navDrawerAdapter.setClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(navDrawerAdapter);

        scheduleNotifAlarm();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.frame_for_fragments, new HomeFragment()).commit();

        //checkEventsForNotif();
    }

    public static List<NavDrawerElements> getData() {
        List<NavDrawerElements> data = new ArrayList<>();
        for (int i = 0; i < elementName.length; i++) {
            NavDrawerElements current = new NavDrawerElements();
            current.elementName = elementName[i];
            current.iconId = iconIds[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            if (selected_item_number != 0) {
                toolbar.setTitle("Home");
                getFragmentManager().beginTransaction().setCustomAnimations(R.animator.gla_back_gone, R.animator.gla_back_come)
                        .replace(R.id.frame_for_fragments, new HomeFragment()).commit();
                selected_item_number = 0;
                backPressed = true;
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case 0:
                toolbar.setTitle("Home");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new HomeFragment()).commit();
                selected_item_number = 0;
                break;
            case 1:
                toolbar.setTitle("Attractions");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new AttractionsFragment()).commit();
                selected_item_number = 1;
                break;
            case 2:
                toolbar.setTitle("IDPT");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new IDPTFragment()).commit();
                selected_item_number = 2;
                break;
            case 3:
                toolbar.setTitle("Schedule");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new ScheduleFragment()).commit();
                selected_item_number = 3;
                break;
            case 4:
                toolbar.setTitle("Gallery");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new GalleryFragment()).commit();
                selected_item_number = 4;
                break;
            case 5:
                toolbar.setTitle("The Team");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new TeamFragment()).commit();
                selected_item_number = 5;
                break;
            case 6:
                toolbar.setTitle("About");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new AboutFragment()).commit();
                selected_item_number = 6;
                break;
            case 7:
                toolbar.setTitle("Sponsors");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new SponsorsFragment()).commit();
                selected_item_number = 7;
                break;
            case 8:
                toolbar.setTitle("Contact Us");
                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_for_fragments, new ContactDetailsFragment()).commit();
                selected_item_number = 8;
                break;
            case 9:
                if (selected_item_number == 9)
                    break;
                toolbar.setTitle("Scan for a Hint");
                getFragmentManager().beginTransaction().replace(R.id.frame_for_fragments, new HintFragment()).commit();
                selected_item_number = 9;
                break;
            case 10:
                toolbar.setTitle("Blog");
                getFragmentManager().beginTransaction().replace(R.id.frame_for_fragments, new BlogFragment()).commit();
                selected_item_number = 10;
                break;
        }
        drawerLayout.closeDrawers();
    }

    public void openInstagram(View view) {
        Uri uri = Uri.parse("https://instagram.com/trinity.djsce/");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://instagram.com/trinity.djsce/")));
        }
    }

    public void openFacebook(View view) {
        Uri uri = Uri.parse("https://www.facebook.com/djscetrinity/");
        Intent facebook = new Intent(Intent.ACTION_VIEW, uri);
        facebook.setPackage("com.facebook.android");

        if (isIntentAvailable(this, facebook)) {
            startActivity(facebook);
        } else {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/djscetrinity/")));
        }
    }

    public void openTwitter(View view) {
        Uri uri = Uri
                .parse("https://twitter.com/djscetrinity?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor");
        Intent twitter = new Intent(Intent.ACTION_VIEW, uri);
        twitter.setPackage("com.twitter.android");

        if (isIntentAvailable(this, twitter)) {
            startActivity(twitter);
        } else {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://twitter.com/djscetrinity?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor")));
        }
    }

    public void openTrinity(View view) {
        Uri uri = Uri.parse("http://www.djtrinity.in/home.php");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void culture(View view) {
        Intent i = new Intent(getApplicationContext(), CulturalActivity.class);
        startActivity(i);
    }

    public void tech(View view) {
        Intent i = new Intent(getApplicationContext(), TechActivity.class);
        startActivity(i);
    }

    public void sport(View view) {
        Intent i = new Intent(getApplicationContext(), SportsActivity.class);
        startActivity(i);
    }

    public void navigateToDJ(View view) {
        Uri uri = Uri.parse("google.navigation:q=19.107556, 72.837472");
        Intent navi = new Intent(Intent.ACTION_VIEW, uri);
        navi.setPackage("com.google.android.apps.maps");
        startActivity(navi);
    }

    private boolean isIntentAvailable(Context context, Intent intent) {
        final PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

/*    public void returnFlagChecker() {
        if (scheduleReturnFlag) {
            toolbar.setTitle("Schedule");
            getFragmentManager().beginTransaction()
                    .replace(R.id.frame_for_fragments, new ScheduleFragment()).commit();
            selected_item_number = 4;
            scheduleReturnFlag = false;
        }

        if (attractionsReturnFlag) {
            toolbar.setTitle("Attractions");
            getFragmentManager().beginTransaction()
                    .replace(R.id.frame_for_fragments, new AttractionsFragment()).commit();
            selected_item_number = 1;
            attractionsReturnFlag = false;
        }
    }*/

    public void openSnap(View view) {
        Intent intent = new Intent(this, SnapActivity.class);
        startActivity(intent);
    }

    public void scheduleNotifAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent  = new Intent(this, NotifAlarmReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(System.currentTimeMillis());
        calendar1.set(Calendar.HOUR_OF_DAY, 12);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
    }
}
