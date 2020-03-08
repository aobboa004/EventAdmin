package com.learning.eventadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class check extends AppCompatActivity {

    ListView listViewC;
    FirebaseDatabase database;
    DatabaseReference ref;
    List<Clients> clientsList;
    String ide;
    //List<fetchEventID> fetchEventIDList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        listViewC=(ListView)findViewById(R.id.listViewC);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("client");
        clientsList=new ArrayList<>();
        //fetchEventIDList=new ArrayList<>();

        Intent intent =getIntent();
        ide=intent.getStringExtra(Display.EVENT_ID);

    }


    @Override
    protected void onStart() {
        super.onStart();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //fetchEventIDList.clear();
                clientsList.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    //fetchEventID fe=ds.getValue(fetchEventID.class);
                    //String s=fe.getEventoID();

                    Clients client=ds.getValue(Clients.class);

                    if(ide.equals(client.getEventIDj()))
                    {
                        clientsList.add(client);
                       int a=10;

                    }
                  //fetchEventIDList.add(fe);


                }

                ClientsAdapter adapter= new ClientsAdapter(check.this,clientsList);

               // ClientsAdapter adapter= new ClientsAdapter(check.this,clientsList);
                listViewC.setAdapter(adapter);






            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
