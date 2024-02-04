package asma.cherifa.mycallerapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyprofileAdapter extends BaseAdapter {
    Context con ;
    ArrayList<Profil> data;
    MyprofileAdapter (Context con, ArrayList<Profil> data )
    {
        this.con =con;
        this.data = data;
    }
    // Adapter --> to create the views
    @Override
    public int getCount() {
        // return nb of views to create
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // return the  created view
        LayoutInflater inf = LayoutInflater.from(con);
        View v =inf.inflate(R.layout.view_profil,null);

        //holders
        TextView tvfirstname = v.findViewById(R.id.tvfirstname_profil);
        TextView tvlastname = v.findViewById(R.id.tvlastname_profil);
        TextView tvphone = v.findViewById(R.id.tvphone_profil);

        ImageView imgdelete =v.findViewById(R.id.imageViewdelete_profil);
        ImageView imgedit =v.findViewById(R.id.imageViewedit_profil);
        ImageView imgcall =v.findViewById(R.id.imageViewcall_profil);

        Profil p = data.get(position);
        tvfirstname.setText(p.firstname);
        tvlastname.setText(p.lastname);
        tvphone.setText(p.phone);

        // actions
        imgdelete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AlertDialog.Builder alert = new AlertDialog.Builder(con);
                 alert.setTitle("Confirmation");
                 alert.setMessage("sure ?");
                 alert.setPositiveButton("delete", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         // delete the element
                         data.remove(position);
                         notifyDataSetChanged(); // refresh
                     }
                 });
                 alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                     }
                 });
                 alert.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                     }
                 });
                 alert.show();
             }
            }

        );
        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+p.getPhone()));
                con.startActivity(i);
            }
        });
        return v;
    }
}
