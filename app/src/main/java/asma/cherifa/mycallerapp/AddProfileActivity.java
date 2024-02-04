package asma.cherifa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProfileActivity extends AppCompatActivity {

     EditText firstname ;
     EditText lastname;
     EditText phone;

    Button btnaddprofile;
    Button btnexit;

    //private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        firstname = findViewById(R.id.etfirstname_profile);
        lastname= findViewById(R.id.etlastname_profile);
        phone = findViewById(R.id.etphone_profile);

        //dbHandler = new DBHandler(AddProfileActivity.this);


        //btnaddprofile_profile
        btnaddprofile = findViewById(R.id.btnaddprofile_profile);

        btnaddprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name_user = firstname.getText().toString();
                String lastname_user = lastname.getText().toString();
                String phone_user = phone.getText().toString();

                if (name_user.equals("") || lastname_user.equals("") || phone_user.equals("") )
                {
                    Toast.makeText(AddProfileActivity.this, "Complete your profile, please ! ", Toast.LENGTH_SHORT).show();
                    firstname.setText("");
                    lastname.setText("");
                    phone.setText("");
                }else{
                    Toast.makeText(AddProfileActivity.this, "profile has been added.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddProfileActivity.this, ListProfileActivity.class);
                    startActivity(intent);
                }
                /*
                intent.putExtra("USERNAME", username);
                intent.putExtra("PHONE_NUMBER", phone);
                intent.putExtra("ADDRESS", mail);
                */
                //dbHandler.addNewProfile(username,phone,mail);
            }
        });

        //Exit
        btnexit = findViewById(R.id.btnexit_profile);
        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddProfileActivity.this, Home.class);
                startActivity(i);
            }
        });



    }
}