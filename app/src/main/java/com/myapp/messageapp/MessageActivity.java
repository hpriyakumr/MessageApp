package com.myapp.messageapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MessageActivity extends AppCompatActivity {
    private EditText editTextMessage;
    private Button buttonSend;
    private RecyclerView rv_message_view;
    private MessageAdapter adapter;
    ArrayList<MessageList> list = new ArrayList<>();




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity);

        rv_message_view = findViewById(R.id.rv_message_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_message_view.setLayoutManager(mLayoutManager);


        adapter = new MessageAdapter(list);
        rv_message_view.setAdapter(adapter);

        editTextMessage = findViewById(R.id.et_typing_msg);
        buttonSend = findViewById(R.id.bt_send);

        buttonSend.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View view) {

            String messages = String.valueOf(editTextMessage.getText());
            if(messages.isEmpty()){
                Toast.makeText(getApplicationContext(), "Please enter Message", LENGTH_SHORT).show();
            } else{
                list.add(0, new MessageList(messages));
                adapter.setData(list);
                Toast.makeText(getApplicationContext(), "Message added", LENGTH_SHORT).show();
            }

         }
       });
    }


}
