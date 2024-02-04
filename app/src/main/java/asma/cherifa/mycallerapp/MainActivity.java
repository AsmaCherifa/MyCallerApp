package asma.cherifa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText  mail;
    EditText  pass;
    Button btnExit;
    Button  btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super : class mere (AppCompatActivity)
        // AppCompatActivity contient le code de base (comme les 3 buttons a l'inferieur..)
        super.onCreate(savedInstanceState);



        // mettre un xml interface sur l'ecran
        setContentView(R.layout.activity_main);

        // Recuperation

         btnExit = findViewById(R.id.btnexit_auth);

         btnLogin = findViewById(R.id.btnlogin_auth);



          mail = findViewById(R.id.edemail_auth);
          pass = findViewById(R.id.edpwd_auth);

        //Events

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mail.getText().toString();
                String password = pass.getText().toString();
                if (email.equals("asma")&& password.equals("123"))
                {
                    /*
                    intent : intentation de lancer qq chose
                    params : activite courante (this)
                     */
                    /*
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData((Uri.parse("2222222")));
                    startActivity(i);

                     */

                    Intent i = new Intent(MainActivity.this, Home.class);
                    i.putExtra("username", email);
                    startActivity(i);

                }
                else {
                    //Toa
                    Toast.makeText(MainActivity.this, "Error , Please Verify", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}