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

public class SportsActivity extends AppCompatActivity {


    public static String[] SportsData = {
            "Glow Cricket",
            "Raftaar",
            "Sumo Wrestling",
            "Target Shooting",
            "Inter-Department Sports Day",
            "Snookball",
            "Amazing Race",
            "Rink Football",
            "Box Cricket",
            "Mini-Golf Course"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_sports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar_sports);
        toolbar.setTitle("Sports");
        toolbar.setBackgroundColor(Color.parseColor("#607D8B"));
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimarySports));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimarySports));
        }

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sports_recycler_view);
        recyclerView.setAdapter(new AttractionsAdapter(this, getSportsData()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainActivity.attractionsReturnFlag = true;

        StaticVariables.sFlag = true;
        StaticVariables.cFlag = false;
        StaticVariables.tFlag = false;
    }

    public List<AttractionsData> getSportsData() {
        List<AttractionsData> data = new ArrayList<>();
        for (int i = 0; i < SportsData.length; i++) {
            AttractionsData current = new AttractionsData();
            current.eventName = SportsData[i];
            data.add(current);
        }
        return data;
    }
}
