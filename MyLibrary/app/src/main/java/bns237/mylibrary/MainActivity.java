/*
* Main sınıfımız
* */

package bns237.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_bookName , et_authorName , et_publisherName ;
    Button save , list ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getContentView();
        setClickForView();
    }

    private void getContentView() {

        et_bookName = (EditText) findViewById(R.id.et_bookName);
        et_authorName = (EditText) findViewById(R.id.et_authorName);
        et_publisherName = (EditText) findViewById(R.id.et_publisherName);
        save = (Button) findViewById(R.id.btn_save);
        list = (Button) findViewById(R.id.btn_list);



    }



    private void setClickForView(){

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String bookName = et_bookName.getText().toString();
                String author = et_authorName.getText().toString();
                String publisher = et_publisherName.getText().toString();
                Book book = new Book(bookName ,author ,publisher);
                DataBase dataBase = new DataBase(MainActivity.this);
                long id = dataBase.addBook(book);

                if (id == -1){
                    Toast.makeText(MainActivity.this, "Hay Aksi ! Kayıt işleminde bir hata oluştu ..", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Kayıt işlemi başarılı.", Toast.LENGTH_SHORT).show();

                }

                et_bookName.setText("");
                et_authorName.setText("");
                et_publisherName.setText("");



            }
        });


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , List.class);
                startActivity(intent);
            }
        });




    }
}
