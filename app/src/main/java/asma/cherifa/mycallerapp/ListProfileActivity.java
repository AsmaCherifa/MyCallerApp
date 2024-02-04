package asma.cherifa.mycallerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ListProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_profile);


        Button btnexit;
        btnexit = findViewById(R.id.btnexit_listprofile);

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListProfileActivity.this, Home.class);
                startActivity(i);
            }
        });

        DBHandler dbHandler = new DBHandler(ListProfileActivity.this);
        TableLayout tableLayout = findViewById(R.id.tableLayout);

        TableRow headerRow = createTableRow();
        addTextViewToRow("username", headerRow);
        addTextViewToRow("phone", headerRow);
        addTextViewToRow("mail", headerRow);
        tableLayout.addView(headerRow);

        SQLiteDatabase db = dbHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM profile", null);

        if (cursor.moveToFirst()) {
            do {
                // Get data from the cursor
                String username = cursor.getString(cursor.getColumnIndexOrThrow("username"));
                String phone = cursor.getString(cursor.getColumnIndexOrThrow("phone"));
                String mail = cursor.getString(cursor.getColumnIndexOrThrow("mail"));


                // Create a new row
                TableRow tableRow = createTableRow();
                addTextViewToRow(username, tableRow);
                addTextViewToRow(phone, tableRow);
                addTextViewToRow(mail, tableRow);
                tableLayout.addView(tableRow);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

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