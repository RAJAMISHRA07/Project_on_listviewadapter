package com.example.admin.project_on_listviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //declare all variable
    EditText editText;
    Button button;
    ListView listView;
    ArrayList<String>al;
    ArrayAdapter<String>aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.edittext1);
        button= (Button) findViewById(R.id.button1);
        listView= (ListView) findViewById(R.id.listview1);
        al=new ArrayList<String>();
       // aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        aa=new ArrayAdapter<String>(this,R.layout.row,al);
        //this=curent activity
        //above line extablish  connection between arraylist to array adapter.
        //adaptor functionality
        //1-read data from src,2--load xml and load view,3--fill data onto view,4--return xml to listview
        //establish connection between array adapter and listview
        listView.setAdapter(aa);
        //implement listview tiem click ion listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //3rd parameter is important-positon of element
               // Toast.makeText(MainActivity.this,"POSITION..."+position,Toast.LENGTH_LONG).show();

                Toast.makeText(MainActivity.this,"POSITION..."+al.get(position),Toast.LENGTH_LONG).show();
            }
        });
        //implement button click listener -to add elements to array list

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city=editText.getText().toString().trim();//read city
                if (city.isEmpty()){
                    return;
                }
                al.add(city);//add that city naame to source(arraylist)
                //in sorting order
                Collections.sort(al);
                aa.notifyDataSetChanged();//tell to adapter
                //noe clean edittexts
                editText.setText("");
                editText.requestFocus();
            }
        });
    }
}
