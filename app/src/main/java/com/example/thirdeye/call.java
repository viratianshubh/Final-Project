package com.example.thirdeye;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class call extends AppCompatActivity {
    String[] Names= {"Shubh","Mayur","Sailee"};
    String[] Numbers = {"9049042774", "7709484449","7798003778"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        ListView listView = (ListView) findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String phone = ((TextView)view.findViewById(R.id.numbers)).getText().toString();
                Toast.makeText(getBaseContext(),phone,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phone));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                startActivity(intent);
            }
        });

    }//onCreate
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return Names.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= getLayoutInflater().inflate(R.layout.custom_listview, null);
            final TextView textView1 = (TextView) view.findViewById(R.id.names);
            final TextView textView2 = (TextView) view.findViewById(R.id.numbers);

            textView1.setText(Names[i]);
            textView2.setText(Numbers[i]);

            /*LinearLayout linearLayout = view.findViewById(R.id.llayout);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getBaseContext(),""+textView1.getText().toString(),Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:9049042774"));
                    if (ActivityCompat.checkSelfPermission(getBaseContext(),Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED)
                    {
                        return;
                    }
                    startActivity(intent1);
                }
            });*/

            return view;
        }//getView
    }//CustomAdapter

}//Class
