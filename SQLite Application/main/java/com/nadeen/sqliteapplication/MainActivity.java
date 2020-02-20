package com.nadeen.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nadeen.sqliteapplication.adapter.AdapterItem;
import com.nadeen.sqliteapplication.sqllite.DBManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 DBManager dbManager;
 EditText UserNameET,PasswordET;
 Button SavaBU,LoadBU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    dbManager=new DBManager(this);
    UserNameET=findViewById(R.id.username);
    PasswordET=findViewById(R.id.pass);
    SavaBU=findViewById(R.id.save);
    LoadBU=findViewById(R.id.load);

       SavaBU.setOnClickListener(this);
       LoadBU.setOnClickListener(this);
    }
    ArrayList<AdapterItem>adapterItems=new ArrayList<>();
    MyCustomAdapter myCustomAdapter;
    @Override
    public void onClick(View v) {
         switch (v.getId()){
           case  R.id.save:
             {
                 ContentValues values=new ContentValues();
                 values.put("UserName",UserNameET.getText().toString());
                 values.put("Password",PasswordET.getText().toString());
                 long id=dbManager.InsertDate(values);
                if (id>0){
                    Toast.makeText(getApplicationContext(),"Data Is Inserted and User ID Is "+id,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Data Not Insert",Toast.LENGTH_LONG).show();
                }
             }
             break;
             case R.id.load:{
       LoadElE();
             }
             break;
         }
    }

    public void LoadElE(){
        // String[] Projection={"UserName","Password"};
        String []SelectionArgs={"%"+UserNameET.getText().toString()+"%"/*,PasswordET.getText().toString()*/};
        adapterItems.clear();
        //Cursor cursor=dbManager.QueryData(null,null,null,"Password");
        //and Password like ?
        Cursor cursor=dbManager.QueryData(null,"UserName like ?",SelectionArgs,"UserName");

        if(cursor.moveToFirst()){
            String TableData="";
            do {
                   /* TableData+=cursor.getString(cursor.getColumnIndex("UserName"))+","+
                           cursor.getString( cursor.getColumnIndex("Password"))+"::";*/
                adapterItems.add(new AdapterItem(cursor.getInt(cursor.getColumnIndex("ID"))/*must converter to string*/,cursor.getString(cursor.getColumnIndex("UserName")),cursor.getString( cursor.getColumnIndex("Password"))));

            }while (cursor.moveToNext());
            Toast.makeText(getApplicationContext(),TableData,Toast.LENGTH_LONG).show();
        }

        ListView listView=findViewById(R.id.listview);
        myCustomAdapter=new MyCustomAdapter(adapterItems);
        listView.setAdapter(myCustomAdapter);
    }

       //Create Class CustomAdapter
    int recordID;

    public void UpadteNow(View view) {
        ContentValues values=new ContentValues();
        values.put("ID",recordID);
        values.put("UserName",UserNameET.getText().toString());
        values.put("Password",PasswordET.getText().toString());
        String[]SelectionArgs={String.valueOf(recordID)};
        dbManager.Update(values,"ID=?",SelectionArgs);
    }

    private class MyCustomAdapter extends BaseAdapter{
          ArrayList<AdapterItem> adapterItems;

           public MyCustomAdapter(ArrayList<AdapterItem> adapterItems) {
               this.adapterItems = adapterItems;
           }

           @Override
           public int getCount() {
               return adapterItems.size();
           }

           @Override
           public Object getItem(int position) {
               return null;
           }

           @Override
           public long getItemId(int position) {
               return position;
           }

           @Override
           public View getView(int position, View convertView, ViewGroup parent) {
               LayoutInflater inflater=getLayoutInflater();
               View myView=inflater.inflate(R.layout.listview_adapter,null);
               final AdapterItem adapterItem=adapterItems.get(position);
               TextView id=myView.findViewById(R.id.ID);
               TextView username=myView.findViewById(R.id.usernameTV);
               TextView password=myView.findViewById(R.id.PasswordTV);
              Button deleteBU=myView.findViewById(R.id.delete);
              Button updateBU=myView.findViewById(R.id.update);
              deleteBU.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      String[]SelectionArgs={String.valueOf(adapterItem.ID)};
                     int id= dbManager.Delete("ID=?",SelectionArgs);
                        if (id>0){
                            LoadElE();
                        }
                  }
              });

              updateBU.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      UserNameET.setText(adapterItem.username);
                      PasswordET.setText(adapterItem.getPassword());
                  recordID=adapterItem.ID;
                  }
              });
               id.setText(String.valueOf(adapterItem.ID));
               username.setText(adapterItem.username);

               password.setText(adapterItem.getPassword());
               return myView;
           }
       }
}
