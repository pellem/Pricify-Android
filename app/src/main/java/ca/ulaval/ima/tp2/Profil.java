package ca.ulaval.ima.tp2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Profil implements Parcelable {

    public String nom;
    public String prenom;
    public String dateNaissance;
    public String sexe;
    public String departement;

    public Profil(String nom, String prenom,
                  String dateNaissance, String sexe, String departement) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.departement = departement;
    }

    protected Profil(Parcel in) {
        nom = in.readString();
        prenom = in.readString();
        dateNaissance = in.readString();
        sexe = in.readString();
        departement = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(dateNaissance);
        dest.writeString(sexe);
        dest.writeString(departement);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Profil> CREATOR = new Parcelable.Creator<Profil>() {
        @Override
        public Profil createFromParcel(Parcel in) {
            return new Profil(in);
        }

        @Override
        public Profil[] newArray(int size) {
            return new Profil[size];
        }
    };
}