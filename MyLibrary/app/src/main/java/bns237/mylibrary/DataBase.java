/*
* Veritabanımız
*
* */
package bns237.mylibrary;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.*;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

//Veritabanımız oluşturduk
    private static final String DATABASE_NAME = "book_database";
    private static final String TABLE_NAME = "book_table";
    private static final int DATABASE_VERSION = 1;

    private static final String NAME ="name_lastname";
    private static final String AUTHOR ="mail";
    private static final String PUBLISHER ="address";
    private static final String ID ="_id";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String createTable="CREATE TABLE "+TABLE_NAME+
                " ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                NAME+" TEXT, "+
                AUTHOR+" TEXT, "+
                PUBLISHER+" TEXT);";

        db.execSQL(createTable);


    }
//Veritabanımızı güncelledik
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);

    }
//Veritabanına kitap ekledik
    public  long addBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME , book.getBookName());
        cv.put(AUTHOR ,book.getAuthorName());
        cv.put(PUBLISHER ,book.getPublisherName());
        long id =  db.insert(TABLE_NAME ,null ,cv);
        db.close();
        return id;


    }
//Veritabanından Kitap listemizi okuduk
    public List<Book> listAllBook() {
        SQLiteDatabase db  = this.getReadableDatabase();
        String [] columns = new String[]{NAME,AUTHOR,PUBLISHER};
        Cursor cursor = db.query(TABLE_NAME ,columns,null ,null ,null,null,null);
        int bookNameArrayNumber = cursor.getColumnIndex(NAME);
        int authorArrayNumber = cursor.getColumnIndex(AUTHOR);
        int publisherArrayNumber = cursor.getColumnIndex(PUBLISHER);

        List<Book> bookList = new ArrayList<Book>();

        for (cursor.moveToFirst() ;!cursor.isAfterLast();cursor.moveToNext()){
            Book book = new Book();
            book.setBookName(cursor.getString(bookNameArrayNumber));
            book.setAuthorName(cursor.getString(authorArrayNumber));
            book.setPublisherName(cursor.getString(publisherArrayNumber));

            bookList.add(book);



        }
        db.close();
        return bookList;

    }

}
