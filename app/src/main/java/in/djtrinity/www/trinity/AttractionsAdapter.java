package in.djtrinity.www.trinity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class AttractionsAdapter extends RecyclerView.Adapter<AttractionsAdapter.AttractionsViewHolder> {

    private Context context;
    private List<AttractionsData> data = Collections.emptyList();
    private LayoutInflater inflater;

    public AttractionsAdapter(Context c, List<AttractionsData> d) {
        context = c;
        data = d;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public AttractionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_for_attractions, parent, false);
        return new AttractionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AttractionsViewHolder holder, int position) {
        AttractionsData current = data.get(position);
        holder.textView.setBackgroundResource(R.drawable.custom_bg);
        holder.textView.setText(current.eventName);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class AttractionsViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public AttractionsViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.attractions_text_view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EventDetailsActivity.class);
                    String name;
                    if (StaticVariables.sFlag)
                        name = SportsActivity.SportsData[getAdapterPosition()];
                    else if (StaticVariables.cFlag)
                        name = CulturalActivity.CulturalData[getAdapterPosition()];
                    else if (StaticVariables.tFlag)
                        name = TechActivity.TechData[getAdapterPosition()];
                    else
                        name = "Error";
                    intent.putExtra("toolbarTitle", name);
                    context.startActivity(intent);
                }
            });
        }
    }
}
