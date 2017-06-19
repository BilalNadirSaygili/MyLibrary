/*
* Kitapları listelediğimiz sınıf
* */

package bns237.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    TextView tv_list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        try {


            tv_list = (TextView) findViewById(R.id.tv_list);

            DataBase dataBase = new DataBase(getApplicationContext());
        //Kitaplistemizi tanımladık
            java.util.List<Book> bookList = new ArrayList<Book>();

            bookList = dataBase.listAllBook();

            StringBuilder stringBuilder = new StringBuilder();
            for (Book book : bookList) {


                stringBuilder.append("Kitap : "+ book.getBookName() + "\n" + "Yazar : " + book.getAuthorName() + "\n"+"Yayınevi : " + book.getPublisherName() + "\n\n");


            }
            tv_list.setText(stringBuilder);

        }catch (Exception e){

            tv_list.setText("Herhangi bir kayıt bulunamadı .");
        }
        }
}
