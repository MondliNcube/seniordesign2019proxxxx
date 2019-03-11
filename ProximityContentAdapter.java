package com.estimote.proximity.estimote;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.estimote.proximity.MainActivity;
import com.estimote.proximity.R;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

public class ProximityContentAdapter extends BaseAdapter {




    private Context context;

    public ProximityContentAdapter(Context context) {
        this.context = context;
    }



    private List<ProximityContent> nearbyContent = new ArrayList<>();

    public void setNearbyContent(List<ProximityContent> nearbyContent) {
        this.nearbyContent = nearbyContent;
    }

    @Override
    public int getCount() {
        return nearbyContent.size();
    }

    @Override
    public Object getItem(int position) {
        return nearbyContent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;

            convertView = inflater.inflate(R.layout.content_view, parent, false);
        }




        ProximityContent content = nearbyContent.get(position);

        TextView title = convertView.findViewById(R.id.title);
        TextView subtitle = convertView.findViewById(R.id.subtitle);

        title.setText(content.getTitle());
        subtitle.setText(content.getSubtitle());

        convertView.setBackgroundColor(Utils.getEstimoteColor(content.getTitle()));

        TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);

        /// For Show Time
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        // textView is the TextView view that should display it
        textView2.setText("Entry Time: " + currentTimeString);

        Button button = (Button) convertView.findViewById(R.id.button);

        final TextView textView5 = (TextView) convertView.findViewById(R.id.textView5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// For Show Time
                String currentTimeString = DateFormat.getTimeInstance().format(new Date());
                // textView is the TextView view that should display it
                textView5.setText("Exit Time: " + currentTimeString);
            }
        });
        
        final TextView textView7 = (TextView) convertView.findViewById(R.id.textView7);
        String date_n = new SimpleDateFormat("MMM. dd, yyyy.", Locale.getDefault()).format(new Date());
        textView7.setText(date_n);


        return convertView;
    }
}
