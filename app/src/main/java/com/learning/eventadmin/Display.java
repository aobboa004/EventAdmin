package com.learning.eventadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Display extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    List<Events> eventsList;
    Button button;
    List<String> primaryKeyList;
    public static final String EVENT_ID="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView=(ListView)findViewById(R.id.listView);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Events");
        eventsList=new ArrayList<>();

        primaryKeyList=new ArrayList<>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Events event=eventsList.get(position);
                Intent intent=new Intent(Display.this,check.class);
                intent.putExtra(EVENT_ID,event.getId());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                eventsList.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Events event=ds.getValue(Events.class);

                    String m=event.getStatus();
                    if(m.equals("Approved"))
                    {
                        eventsList.add(event);
                    }
                    if(m.equals("Pending"))
                    {
                        eventsList.add(event);
                    }

                }

                EventsAdapter adapter= new EventsAdapter(Display.this,eventsList);
                listView.setAdapter(adapter);






            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

