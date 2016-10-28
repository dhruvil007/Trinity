package in.djtrinity.www.trinity;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContactDetailsFragment extends Fragment {



    public ContactDetailsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_details, container, false);
        TextView textView = (TextView) view.findViewById(R.id.email);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gmail = new Intent(Intent.ACTION_VIEW);
                gmail.setType("plain/text");
                gmail.setData(Uri.parse("publicity.trinity@gmail.com"));
                gmail.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                gmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"publicity.trinity@gmail.com"});
                startActivity(gmail);
            }
        });

        Button button = (Button) view.findViewById(R.id.navigate_button);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(), "Thanks for downloading the app! DRR!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return view;
    }


    public void inst(View view) {
        Toast.makeText(getActivity(), "Hello", Toast.LENGTH_LONG).show();
    }

}
