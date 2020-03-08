package com.learning.eventadmin;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ClientsAdapter extends ArrayAdapter<Clients> {

    private Activity context;
    private List<Clients> listC;
    private DatabaseReference ref= FirebaseDatabase.getInstance().getReference("client");

    public ClientsAdapter(Activity context,List<Clients> listC)
    {   super(context,R.layout.single_client_info_layout,listC);
        this.context=context;
        this.listC=listC;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View listviewitem=layoutInflater.inflate(R.layout.single_client_info_layout,null,true);
        TextView NameC=(TextView)listviewitem.findViewById(R.id.NameC);
        TextView displayCollegeNameC=(TextView)listviewitem.findViewById(R.id.displayCollegeNameC);
        TextView displayCollegeStudentIDC=(TextView)listviewitem.findViewById(R.id.displayCollegeStudentIDC);
        TextView displayEmailC=(TextView)listviewitem.findViewById(R.id.displayEmailC);
        TextView displayPhoneC=(TextView)listviewitem.findViewById(R.id.displayPhoneC);




        final Clients client=listC.get(position);

        NameC.setText(client.getClientName());
        displayCollegeNameC.setText(client.getClientCollege());
        displayCollegeStudentIDC.setText(client.getClientCollegeStudentID());
        displayEmailC.setText(client.getClientEmail());
        displayPhoneC.setText(client.getClientPhoneNumber());






        return listviewitem;
    }
}
