package com.example.bddopenhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase bdd;

    OpenHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new OpenHelper(this);
        bdd=helper.getWritableDatabase();
        TableTypes.drop(bdd);
        TableTypes.create(bdd);
        Table tx=new Table(12,"kk","ooo",12F);
        TableTypes.insert(bdd,tx);
        ContentValues C=new ContentValues();
        C.putNull("id");
        C.put("nom","kouka");
        C.put("prenom","haythep");
        C.put("moyenne",18F);
bdd.insert("Etudiant",null,C);
          Cursor resultSet=TableTypes.getALL(bdd);
        String s="";
        try {
            if(resultSet.moveToFirst()){
                while (!resultSet.isAfterLast()){
                    s=s+resultSet.getString(0)+" "+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+"\n";
                    resultSet.moveToNext();
                }
            }
        }
        finally {
            resultSet.close();
        }
        TextView t=(TextView) findViewById(R.id.i1);
        t.setText(s.toString());
        Button bAdd=(Button) findViewById(R.id.Add);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e=(EditText) findViewById(R.id.nomE);
                EditText e2=(EditText) findViewById(R.id.pnomE);
                EditText e3=(EditText) findViewById(R.id.moyenneE);
              Table tx=  new Table(null,e.getText().toString(),e2.getText().toString(),Float.parseFloat(e3.getText().toString()));
                ContentValues C=new ContentValues();
                TableTypes.insert(bdd,tx);
                Cursor resultSet=TableTypes.getALL(bdd);
                String s="";
                try {
                    if(resultSet.moveToFirst()){
                        while (!resultSet.isAfterLast()){
                            s=s+resultSet.getString(0)+" "+resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+"\n";
                            resultSet.moveToNext();
                        }
                    }
                }
                finally {
                    resultSet.close();
                }
                TextView t=(TextView) findViewById(R.id.i1);
                t.setText(s.toString());
                e3.setText("");
                e2.setText("");
                e.setText("");
            }
        });
    }
}