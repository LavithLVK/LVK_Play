package com.example.lvk.lvkplay.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lavith.edam on 7/24/2017.
 */

public class PlayerDBHelper extends SQLiteOpenHelper {

    private static final String table_album="Album";
    private static final String table_artist="Artist";
    private static final String table_song="Song";
    private static final String id_album="AlbumId";
    private static final String id_artist="ArtistId";
    private static final String id_song="SongId";
    private static final String name_album ="AlbumName";
    private static final String name_artist ="ArtistName";
    private static final String name_song ="SongName";
    private static final String album_art_path ="AlbumArtPath";
    private static final String dob="DOB";
    private static final String crime="Crime";
    private static final String isSentenced="IsSentenced";
    private static final String created_at ="Created_at";
    private static final String updated_at ="Updated_at";

    public PlayerDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String create_table ="CREATE TABLE " + table_users + "("
//                + id + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + name + " TEXT,"
//                + email +" TEXT,"+mobile_No +" TEXT,"+dob+ " DATE,"+ profile_Photo_local +" BLOB,"
//                + profile_Photo_online + " TEXT," + crime+" TEXT,"+ isSentenced +" BOOLEAN, "
//                +created_at +" DATETIME DEFAULT CURRENT_TIMESTAMP," +updated_at+" DATETIME"
//                + ")";
//        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
