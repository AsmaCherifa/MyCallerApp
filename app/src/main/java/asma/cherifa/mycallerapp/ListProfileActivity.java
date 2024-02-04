package asma.cherifa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListProfileActivity extends AppCompatActivity {
ListView lv_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_profile);
        lv_list = findViewById(R.id.lv_list);
        //ArrayAdapter ad = new ArrayAdapter<>(ListProfileActivity.this, android.R.layout.simple_list_item_1,Home.data);
        //lv_list.setAdapter(ad);

        //ArrayList<Profil> profiles = Home.data;


        //ProfileAdapter adapter = new ProfileAdapter(this, profiles);

        MyprofileAdapter ad = new MyprofileAdapter(ListProfileActivity.this,Home.data);
        lv_list.setAdapter(ad);

        Button btnexit;
        btnexit = findViewById(R.id.btnexit_listprofile);

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListProfileActivity.this, Home.class);
                startActivity(i);
            }
        });

    }

    private TableRow createTableRow() {
        TableRow tableRow = new TableRow(this);
        tableRow.setBackground(getDrawable(R.drawable.table_row_border)); // Set border
        return tableRow;
    }

    private void addTextViewToRow(String text, TableRow tableRow) {
        TextView textView = new TextView(this);
        textView.setText(text);
        tableRow.addView(textView);
    }


}