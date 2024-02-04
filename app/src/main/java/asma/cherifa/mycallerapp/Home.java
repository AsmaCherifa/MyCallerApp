package asma.cherifa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    public static ArrayList<Profil> data =new ArrayList<>();
    Button btnaddProfile;
    Button btnlistProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home);

        String username = getIntent().getStringExtra("username");
        String welcomeMessage = "Welcome, " + username + "!";

        TextView welcomeTextView = findViewById(R.id.welcomeText_home);
        welcomeTextView.setText(welcomeMessage);

        btnaddProfile = findViewById(R.id.btnaddprofile_home);
        btnlistProfile = findViewById(R.id.btnlistprofile_home);

        btnaddProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, AddProfileActivity.class);
                startActivity(i);
            }
        });


        btnlistProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, ListProfileActivity.class);
                startActivity(i);
            }
        });
    }

}