package com.example.bddopenhelper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TableTypes {

    public static void create(SQLiteDatabase bdd) {
        bdd.execSQL("CREATE TABLE IF NOT EXISTS etudiant (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , nom text(30) NOT NULL,prenom text(30) NOT NULL,moyenne float(11) NOT NULL);");    }

    public static void drop(SQLiteDatabase bdd) {
        bdd.execSQL("DROP TABLE IF EXISTS etudiant"  );
    }
    public  static void insert(SQLiteDatabase bdd, Table t){
        bdd.execSQL("INSERT INTO etudiant ( 'Prenom', 'Nom', 'Moyenne')  VALUES ('"+t.getNom()+"','"+t.getPrenom()+"',"+t.getMoyenne()+")");   }
    public  static Cursor getALL(SQLiteDatabase bdd){
       return bdd.rawQuery("select * from  etudiant",null);}
}
