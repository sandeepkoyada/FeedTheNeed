package com.example.feedtheneed21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Food_Details extends AppCompatActivity {
    CheckBox veg,nonveg;
    EditText text;
    Button send;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__details);


        reference= FirebaseDatabase.getInstance().getReference("details");
        veg=findViewById(R.id.checkBox1);
        nonveg=findViewById(R.id.checkBox2);
        text=findViewById(R.id.Edit);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action();
            }
        });

        /*below lines are for my satisfaction*/
        /*Button bz=findViewById(R.id.next);
        bz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Food_Details.this,.class);
                startActivity(intent);
            }
        });*/

    }
    private void action() {
        String etext=text.getText().toString();
        boolean b1=veg.isChecked();
        boolean b2=nonveg.isChecked();
        String s=" ";
        if(b1) s+="veg ";
        if(b2) s+="nonveg ";
        /*if(s.length()!=1)
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"please give details",Toast.LENGTH_LONG).show();*/

        if(s.length()!=1||!TextUtils.isEmpty(etext)){
            String id=reference.push().getKey();
            Detail detail=new Detail(id,etext,s);
            reference.child(id).setValue(detail);
            Toast.makeText(this,"successfully entered into databse",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,"please give details",Toast.LENGTH_LONG).show();



    }


    public void btnCurrentLocation(View view) {

        startActivity(new Intent(this,MapsActivity.class));
    }
}
