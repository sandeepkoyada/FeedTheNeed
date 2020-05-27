package com.example.feedtheneed21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Volunteer_SignIn extends AppCompatActivity {

    EditText vname;
    EditText vphone_number ;
    EditText vaddress;
    Button join;
    DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer__sign_in);


        vname = findViewById(R.id.vname);
        vphone_number = findViewById(R.id.vphone_number);
        vaddress = findViewById(R.id.vaddress);
        join = findViewById(R.id.join);
        reference = FirebaseDatabase.getInstance().getReference("Volunteer_details");
        ;
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = vname.getText().toString();
                final String phone = vphone_number.getText().toString();
                final String address = vaddress.getText().toString();
                if(name.length()!=0&&phone.length()!=0&&address.length()!=0){
                    String id = reference.push().getKey();
                    VolunterDetails detail = new VolunterDetails(id, name, phone, address);
                    reference.child(id).setValue(detail);
                    Toast.makeText(Volunteer_SignIn.this, "successfully entered into databse", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(Volunteer_SignIn.this, "check detailes", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void action() {

        final String name = vname.getText().toString();
        final String phone = vphone_number.getText().toString();
        final String address = vaddress.getText().toString();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(address)) {
            /*reference.child(name).child(phone).child(address).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.exists()) {
                        Toast.makeText(Volunteer_SignIn.this, "the Details already exists", Toast.LENGTH_LONG);
                    } else {
                        String id = reference.push().getKey();
                        VolunterDetails detail = new VolunterDetails(id, name, phone, address);
                        reference.child(id).setValue(detail);
                        Toast.makeText(Volunteer_SignIn.this, "successfully entered into databse", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });*/

            String id = reference.push().getKey();
            VolunterDetails detail = new VolunterDetails(id, name, phone, address);
            reference.child(id).setValue(detail);
            Toast.makeText(Volunteer_SignIn.this, "successfully entered into databse", Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(this,"please give details",Toast.LENGTH_LONG).show();


    }
}

/*




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer__sign_in);
        reference= FirebaseDatabase.getInstance().getReference("Volunteer_details");


        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action();
            }
        });

    }
    private void action()
    {

        final String name=vname.getText().toString();
        final String phone=vphone_number.getText().toString();
        final String address=vaddress.getText().toString();
        if(!TextUtils.isEmpty(name.trim())&&!TextUtils.isEmpty(phone.trim())&&!TextUtils.isEmpty(address.trim())){


         */
/*   reference.child(name).child(phone).child(address).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                      if(dataSnapshot.exists()) {
                        Toast.makeText(Volunteer_SignIn.this,"the Details already exists", Toast.LENGTH_LONG);
                    }
                    else{
                        String id=reference.push().getKey();
                        VolunterDetails detail=new VolunterDetails(id,name,phone,address);
                        reference.child(id).setValue(detail);
                        Toast.makeText(Volunteer_SignIn.this,"successfully entered into databse",Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });*//*


            //remove below code
            String id=reference.push().getKey();
            VolunterDetails detail=new VolunterDetails(id,name,phone,address);
            reference.child(id).setValue(detail);
            Toast.makeText(Volunteer_SignIn.this,"successfully entered into databse",Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,"please give details",Toast.LENGTH_LONG).show();

    }

  */
/*  private boolean ifUserExist(String name, String phone, String address) {
        final boolean b;

    }*//*


 */

