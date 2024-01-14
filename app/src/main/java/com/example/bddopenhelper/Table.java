package com.example.bddopenhelper;

public class Table {
    public   Integer Id ;
    public   String Nom  ;
    public Table(){
        super();
    }
    public Table(Integer id, String nom, String prenom, Float moyenne) {
        Id = id;
        Nom = nom;
        Prenom = prenom;
        Moyenne = moyenne;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Float getMoyenne() {
        return Moyenne;
    }

    public void setMoyenne(Float moyenne) {
        Moyenne = moyenne;
    }

    @Override
    public String toString() {
        return "Table{" +
                "Id=" + Id +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Moyenne=" + Moyenne +
                '}';
    }

    public   String Prenom  ;
    public   Float Moyenne  ;
}
