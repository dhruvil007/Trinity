package in.djtrinity.www.trinity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class CulturalActivity extends AppCompatActivity {

    public static String[] CulturalData = {
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
            "Silent Disco",
            "Brain N Brawn",
            "Stand-Up Comedy",
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
            "Concert Night"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_cultural);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar_cultural);
        toolbar.setTitle("Cultural Events");
        toolbar.setBackgroundColor(Color.parseColor("#00BCD4"));
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryCultural));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryCultural));
        }

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cultural_recycler_view);
        recyclerView.setAdapter(new AttractionsAdapter(this, getCulturalData()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainActivity.attractionsReturnFlag = true;

        StaticVariables.cFlag = true;
        StaticVariables.tFlag = false;
        StaticVariables.sFlag = false;
    }

    public List<AttractionsData> getCulturalData() {
        List<AttractionsData> data = new ArrayList<>();
        for (int i = 0; i < CulturalData.length; i++) {
            AttractionsData current = new AttractionsData();
            current.eventName = CulturalData[i];
            data.add(current);
        }
        return data;
    }

}
