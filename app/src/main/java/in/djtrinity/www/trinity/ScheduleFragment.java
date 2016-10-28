package in.djtrinity.www.trinity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    public static String[] entries = {
            "Trinity Sports",
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
            "Amazing Race",
            "Silent Disco",
            "Brain N Brawn"
    };

    public ScheduleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.schedule_recycler_view);
        ScheduleAdapter adapter = new ScheduleAdapter(getActivity(), getScheduleData());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        if (MainActivity.scheduleReturnFlag)
            linearLayoutManager.scrollToPosition(ScheduleAdapter.positionSelected);
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }

    public static List<ScheduleData> getScheduleData() {
        List<ScheduleData> data = new ArrayList<>();
        for (int i = 0; i < entries.length; i++) {
            ScheduleData current = new ScheduleData();
            current.entry = entries[i];
            data.add(current);
        }
        return data;
    }

}
