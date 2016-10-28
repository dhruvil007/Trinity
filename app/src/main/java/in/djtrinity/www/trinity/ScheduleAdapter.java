package in.djtrinity.www.trinity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private Context context;
    private List<ScheduleData> data;
    public static int positionSelected;
    private static String[] dataSub = {
            "Place: DJ Sanghvi\n" +
                    "Date: 26th-27th-28th February",
            "Place:  JRM Grounds\n" +
                    "Date: 12th-13th March",
            "Place:  JRM Grounds\n" +
                    "Date: 12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 2nd October 2015",
            "Place:  JRM Grounds\n" +
                    "Date: 12th-13th March",
            "Place:  JRM Grounds\n" +
                    "Date: 23rd January",
            "Place: DJ Sanghvi\n" +
                    "Date: 12th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th March",
            "Place: Dj Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place:  JRM Grounds\n" +
                    "Date: 13th March",
            "Place: BJ Hall\n" +
                    "Date: 12th January",
            "Place: DJ Sanghvi\n" +
                    "Date: 13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 9th October 2015",
            "Place: DJ Sanghvi\n" +
                    "Date: 13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: Ongoing. Finals on 11th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 12th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: Ongoing." +
                    " Winning photographs are displayed in the college throughout the festival.",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 17th January",
            "Place: DJ Sanghvi\n" +
                    "Date: 2nd March",
            "Place: DJ Sanghvi\n" +
                    "Date: 7th January",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place:  JRM Grounds\n" +
                    "Date: 25th January",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 26th February",
            "Place: DJ Sanghvi\n" +
                    "Date: 26th February",
            "Place: DJ Sanghvi\n" +
                    "Date: 12th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March",
            "Place: DJ Sanghvi\n" +
                    "Date: 11th-12th-13th March"
    };
    private LayoutInflater layoutInflater;


    public ScheduleAdapter(Context c, List<ScheduleData> d) {
        context = c;
        data = d;
        layoutInflater = LayoutInflater.from(c);
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ScheduleViewHolder holder, int position) {
        ScheduleData current = data.get(position);
        holder.textviewMain.setText(current.entry);
        holder.textViewSub.setText(dataSub[position]);
    }

    @Override
    public ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item_for_schedule, parent, false);
        return (new ScheduleViewHolder(view));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class ScheduleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textviewMain, textViewSub;

        public ScheduleViewHolder(View view) {
            super(view);
            textviewMain = (TextView) view.findViewById(R.id.schedule_list_text_view_main);
            textViewSub = (TextView) view.findViewById(R.id.schedule_list_text_view_sub);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, EventDetailsActivity.class);
            positionSelected = getAdapterPosition();
            intent.putExtra("toolbarTitle", ScheduleFragment.entries[getAdapterPosition()]);
            context.startActivity(intent);

        }
    }
}
