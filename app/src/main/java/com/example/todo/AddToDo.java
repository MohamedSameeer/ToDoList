package com.example.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.todo.Model.Item;
import com.example.todo.Model.RepositoryImp1;

public class AddToDo extends AppCompatActivity {


    EditText etitle,ebody;
    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        etitle=findViewById(R.id.eTitle);
        ebody=findViewById(R.id.eBody);
        click=findViewById(R.id.add);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RepositoryImp1.getInstance().addItem(new Item(etitle.getText().toString(),ebody.getText().toString()));
                etitle.setText("");
                ebody.setText("");
                finish();
            }
        });


    }
}
