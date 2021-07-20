package org.mycode.android_part_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView  contactsRecView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Duc Thai", "ducthai@gmail.com","https://vvduth.github.io/TAHwebsite/images/works/thaiducweb.jpg"));
        contacts.add(new Contact("Anh Tai", "anhtai@gmail.com","https://vvduth.github.io/TAHwebsite/images/works/anhtaiweb.png"));
        contacts.add(new Contact("Mai Manh", "maimanh@gmail.com","https://vvduth.github.io/TAHwebsite/images/works/maimanhweb.jpg"));
        contacts.add(new Contact("Que Hung", "quehung@gmail.com","https://vvduth.github.io/TAHwebsite/images/works/quehungweb.jpg"));
        contacts.add(new Contact("Dinh Duy", "duysop@gmail.com","https://vvduth.github.io/TAHwebsite/images/works/dinhduyweb.jpg"));
        contacts.add(new Contact("Huu Tai", "taibeo@gmail.com","https://vvduth.github.io/TAHwebsite/images/works/huutaiweb.png"));

        ContactRecViewAdapter adapter = new ContactRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));  //display our items on a linear fashion
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2 ));

    }
}