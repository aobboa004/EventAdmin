package com.learning.eventadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button createEvent;
    Button viewEvents;
    EditText eventStartingDate;
    EditText eventEndingDate;
    EditText eventName;
    EditText eventVenue;
    EditText eventOrganisedBy;
    EditText eventTime;
    EditText contactInfo;
    EditText ticketp;
    FirebaseDatabase database;
    DatabaseReference ref;
    FirebaseAuth mAuth;
    Button btnLogout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createEvent=findViewById(R.id.createEvent);
        viewEvents=findViewById(R.id.viewEvents);
        eventStartingDate=findViewById((R.id.eventDateFrom));
        eventEndingDate=findViewById(R.id.eventDateTo);
        eventName=findViewById(R.id.eventName);
        eventVenue=findViewById(R.id.eventVenue);
        eventOrganisedBy=findViewById(R.id.eventOrganisedBy);
        eventTime=findViewById(R.id.eventStartingTime);
        contactInfo=findViewById(R.id.eventContactInfo);
        ticketp=findViewById(R.id.eventPrice);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Events");
        mAuth = FirebaseAuth.getInstance();
        btnLogout=(Button)findViewById(R.id.log);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(MainActivity.this, Login.class);
                startActivity(intToMain);
            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();
            }
        });


    }

    private void addEvent() {
        String name=eventName.getText().toString();
        String venue=eventVenue.getText().toString();
        String organisedby=eventOrganisedBy.getText().toString();
        String startdate=eventStartingDate.getText().toString();
        String enddate=eventEndingDate.getText().toString();
        String starttime=eventTime.getText().toString();
        String contactinfo=contactInfo.getText().toString();
        String ticketprice= ticketp.getText().toString();

        if(name.isEmpty())
        {
            eventName.setError("Name is required");
            eventName.requestFocus();
            return;
        }

        if(venue.isEmpty())
        {
            eventVenue.setError("Venue is required");
            eventVenue.requestFocus();
            return;
        }

        if(organisedby.isEmpty())
        {
            eventOrganisedBy.setError("Organiser Name is required");
            eventOrganisedBy.requestFocus();
            return;
        }

        if(startdate.isEmpty())
        {
            eventStartingDate.setError("Start date is required");
            eventStartingDate.requestFocus();
            return;
        }

        if(enddate.isEmpty())
        {
            eventEndingDate.setError("End date is required");
            eventEndingDate.requestFocus();
            return;
        }

        if(starttime.isEmpty())
        {
            eventTime.setError("Start Time is required");
            eventTime.requestFocus();
            return;
        }

        if(contactinfo.isEmpty())
        {
            contactInfo.setError("Contact Info is required");
            contactInfo.requestFocus();
            return;
        }

        if(ticketprice.isEmpty())
        {
            ticketp.setError("price is required");
            ticketp.requestFocus();
            return;
        }

        String id=ref.push().getKey();
        Toast toast=Toast.makeText(MainActivity.this,"Request Sent",Toast.LENGTH_SHORT);
        toast.show();

        Events event=new Events(name,id,organisedby,startdate,enddate,starttime,contactinfo,venue,ticketprice);
        ref.child(id).setValue(event);
    }





    public void btnDisplay(View view) {
        Intent intent=new Intent(MainActivity.this,Display.class);
        startActivity(intent);
    }
}

