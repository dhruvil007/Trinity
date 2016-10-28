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

public class SponsorsFragment extends Fragment {


    public Integer[] sponsorImageId = {
            //R.drawable.title,
            //R.drawable.toyota1,
            R.drawable.power,
            R.drawable.furtados,
            R.drawable.dhl,
            R.drawable.jivraj,
            R.drawable.cd,
            R.drawable.iccg,

            R.drawable.ninex,
            R.drawable.ninex2,
            /*R.drawable.hitachi,
            R.drawable.education,
            R.drawable.imfs,
            R.drawable.imperial,
            R.drawable.collegepond,
            R.drawable.cplclogo,
            R.drawable.fitness,
            R.drawable.glanbia,
            R.drawable.isopure,
            R.drawable.jerai,*/
            R.drawable.media,
            /*R.drawable.askme,
            R.drawable.ee,
            R.drawable.enlighten_india,
            R.drawable.hook2events,
            R.drawable.knowafest,*/
            R.drawable.logovn,
            /*R.drawable.mmfest,
            R.drawable.red_fm1,
            R.drawable.savepocketmoney,
            R.drawable.springtide_logo2,
            R.drawable.twenty,
            R.drawable.other,
            R.drawable.apr,
            R.drawable.bigsandwich,
            R.drawable.bodal,
            R.drawable.brijeel,
            R.drawable.bseipf,
            R.drawable.buckaroo,
            R.drawable.daulat,
            R.drawable.ddest,
            R.drawable.ebay,
            R.drawable.engage,
            R.drawable.esselworld,
            R.drawable.faber,
            R.drawable.fact,
            R.drawable.fb_profile_pic,
            R.drawable.fourfountains,
            R.drawable.furtados,
            R.drawable.giftshop,*/
            R.drawable.himalaya,
            /*R.drawable.io,
            R.drawable.jazzup,
            R.drawable.kcil,
            R.drawable.line,
            R.drawable.maruti,
            R.drawable.metroholiday,
            R.drawable.mtv1,
            R.drawable.nationalply,
            R.drawable.oa,
            R.drawable.ramanlal,
            R.drawable.restless,
            R.drawable.smash,
            R.drawable.sundaram,
            R.drawable.tennex,
            R.drawable.wtfun,
            R.drawable.ww*/
    };

    public SponsorsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);

        RecyclerView sponsorRecyclerView = (RecyclerView) view.findViewById(R.id.sponsor_recycler_view);
        SponsorsImageAdapter sponsorsImageAdapter = new SponsorsImageAdapter(getActivity(), getSponsorData());
        sponsorRecyclerView.setAdapter(sponsorsImageAdapter);
        sponsorRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    public List<SponsorsData> getSponsorData() {
        List<SponsorsData> data = new ArrayList<>();
        for (int id: sponsorImageId) {
            SponsorsData current = new SponsorsData();
            current.id = id;
            data.add(current);
        }
        return data;
    }
}
