package ismek.grevsepeti;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {

    public static final String VT_ADI="ismek";

    public static final String TABLO_ADI="gorevler";

    public Veritabani(Context context) {


        super(context, VT_ADI, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCumlesi = "CREATE TABLE "+TABLO_ADI+" (id INTEGER PRIMARY KEY AUTOINCREMENT, baslik TEXT, aciklama TEXT, durum TEXT" + ")";
        db.execSQL(sqlCumlesi);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Gorev> gorevleriGetir (String durum) {

        List<Gorev> gorevler = new ArrayList<Gorev>();

        SQLiteDatabase vt = this.getWritableDatabase();

        String sqlCumlesi="";
        if(durum.equals("Hepsi")) {
            sqlCumlesi ="SELECT * FROM " +TABLO_ADI;
        }

        else if (durum.equals("Devam")) {
            sqlCumlesi ="SELECT * FROM " +TABLO_ADI + " WHERE durum='Devam'";
        }

        else if(durum.equals("Tamam")) {
            sqlCumlesi ="SELECT * FROM " +TABLO_ADI + " WHERE durum='Tamam'";
        }

        Cursor cursor = vt.rawQuery(sqlCumlesi,null);

        while (cursor.moveToNext()) {

            Gorev gorev = new Gorev();
            gorev.setId(cursor.getInt(0));
            gorev.setBaslik(cursor.getString(1));
            gorev.setAciklama(cursor.getString(2));
            gorev.setDurum(cursor.getString(3));

            gorevler.add(gorev);
        }

        return gorevler;
    }



    public void gorevEkle (Gorev gorev) {

        SQLiteDatabase vt = this.getWritableDatabase();

        ContentValues veriler = new ContentValues();
        veriler.put("baslik",gorev.getBaslik());
        veriler.put("aciklama",gorev.getAciklama());
        veriler.put("durum",gorev.getDurum());

        vt.insert(TABLO_ADI,null,veriler);
        vt.close();

    }

    public void gorevGuncelle (int gorevID) {

        SQLiteDatabase vt = this.getWritableDatabase();

        String sqlCumlesi ="UPDATE "+ TABLO_ADI+ " SET durum='Tamam' WHERE id='"+gorevID+"'";
        vt.execSQL(sqlCumlesi);
        vt.close();

    }

    public void gorevSil(int gorevID) {
        SQLiteDatabase vt = this.getWritableDatabase();
        String sqlCumlesi ="DELETE FROM "+TABLO_ADI+" WHERE id="+gorevID;
        vt.execSQL(sqlCumlesi);
        vt.close();
    }
}
