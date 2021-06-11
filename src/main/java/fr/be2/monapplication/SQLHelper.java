package fr.be2.monapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static android.os.Build.ID;

public class SQLHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "GSB.db";
        private static final String DB_TABLE = "NoteDeForfait";
        public static final String KEY_ID = "ID";
        public static final String KEY_LIBELLE= "LIBELLE";
        public static final String KEY_MONTANT = "MONTANT";
        public static final String KEY_DATEDESAISIT = "DATEDESAISIT";
        public static final String KEY_DATEDEFRAIS = "DATEDEFRAIS";
        public static final String KEY_QUANTITE = "QUANTITE";
        public static final String KEY_TYPEDEFRAIS = "TYPEDEFRAIS";

        private static final String DB_TABLE1 = "FraisExceptionnels";
        public static final String KEY_ID2 = "ID";
        public static final String KEY_LIBELLE2= "LIBELLE";
        public static final String KEY_MONTANT2 = "MONTANT";
        public static final String KEY_DATEDESAISIE = "DATEDESAISIE";
        public static final String KEY_DATEDEFRAIS2 = "DATEDEFRAIS";
        public static final String KEY_DESCRIPTION = "DESCRIPTION";


        private static final String TAG = "SQLHelper";
        private SQLHelper dbHelper;
        private SQLiteDatabase db;

        // private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE +" ("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT" + ")";
        private static final String CREATE_TABLE = "CREATE TABLE NoteDeForfait (ID INTEGER PRIMARY KEY AUTOINCREMENT, TYPEDEFRAIS TEXT, LIBELLE TEXT, QUANTITE INTEGER, MONTANT FLOAT,DATEDEFRAIS TEXT, DATEDESAISIT DATETIME DEFAULT CURRENT_TIMESTAMP)";
        private static final String CREATE_TABLE1 = "CREATE TABLE FraisExceptionnels (ID INTEGER PRIMARY KEY AUTOINCREMENT, LIBELLE TEXT, MONTANT FLOAT,DATEDEFRAIS TEXT, DATEDESAISIT DATETIME DEFAULT CURRENT_TIMESTAMP, DESCRIPTION TEXT)";



    public SQLHelper(Context context){
            super(context,DB_NAME,null,1);
        }

        public SQLHelper open() throws SQLException {
           // mDbHelper = new SQLHelper(mCtx);
            SQLiteDatabase db = this.getReadableDatabase();
            return this;
        }


        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            sqLiteDatabase.execSQL(CREATE_TABLE1);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(sqLiteDatabase);
        }

        /*
        fonction permettant d'enregistrer les informations d'une fiche dans les tables concernees
         */
        public boolean insertData(String typefrais, String libelle, Integer quantite, Double montant, String date){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(KEY_TYPEDEFRAIS,typefrais);
            contentValues.put(KEY_LIBELLE, libelle);
            contentValues.put(KEY_QUANTITE, quantite);
            contentValues.put(KEY_MONTANT, montant);
            contentValues.put(KEY_DATEDEFRAIS, date);
            long result = db.insert(DB_TABLE, null, contentValues);
            return result != -1;

        }

        /*
        fonction interrogeant la bdd et retournant tous les frais enregistres dans la bdd
         */
        public Cursor fetchAllFrais() {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor mCursor = db.query(DB_TABLE, new String[] {"rowid _id",KEY_ID,
                            KEY_LIBELLE, KEY_MONTANT, KEY_DATEDESAISIT, KEY_DATEDEFRAIS, KEY_QUANTITE,KEY_TYPEDEFRAIS},
                    null, null, null, null, null);

            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }

        /*
        fonction interrogeant la BDD
         */
        public Cursor viewData() {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "select * from " + DB_TABLE;
            Cursor pointeur = db.rawQuery(query, null);
            return pointeur;

        }

        /*
        fonction permettant de supprimer un frais ayant pour ID, l'ID place en prametre
         */
        public boolean deleteData(Integer ID) {
            SQLiteDatabase db = this.getWritableDatabase();

            long result = db.delete(DB_TABLE, "ID=" + ID, null);

            return result != -1;

        }
    }
