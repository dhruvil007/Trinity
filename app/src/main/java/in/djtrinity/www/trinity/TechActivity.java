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

public class TechActivity extends AppCompatActivity {

    public static String[] TechData = {
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
            "Code Uncode"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_tech);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryTechnical));
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryTechnical));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar_tech);
        toolbar.setTitle("Technical Events");
        toolbar.setBackgroundColor(Color.parseColor("#3F51B5"));
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.tech_recycler_view);
        recyclerView.setAdapter(new AttractionsAdapter(this, getTechData()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainActivity.attractionsReturnFlag = true;

        StaticVariables.cFlag = false;
        StaticVariables.tFlag = true;
        StaticVariables.sFlag = false;
    }

    public List<AttractionsData> getTechData() {
        List<AttractionsData> data = new ArrayList<>();
        for (String name : TechData) {
            AttractionsData current = new AttractionsData();
            current.eventName = name;
            data.add(current);
        }
        return data;
    }
}
