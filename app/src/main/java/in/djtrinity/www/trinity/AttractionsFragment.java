package in.djtrinity.www.trinity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity.attractionsReturnFlag = false;
        return inflater.inflate(R.layout.fragment_attractions, container, false);
    }
}

