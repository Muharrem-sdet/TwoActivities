package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    public static final String KEY_FOR_EXTRA_STRING = "com.example.twoactivities.messageFromSecond";
    private Button sendButton;
    private EditText editText;
    private TextView textView;

    private String textMessageTotal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sendButton = findViewById(R.id.button_send_on_second_activity);
        editText = findViewById(R.id.edit_text_on_second_activity);
        textView = findViewById(R.id.tv_on_second_activity);

        Intent intentToGet = getIntent();
        String messageReceived = intentToGet.getStringExtra(MainActivity.KEY_FOR_EXTRA_STRING);

//        Bundle bundle = new Bundle();
//        bundle = getIntent().getBundleExtra("????????????????");


        textMessageTotal = textMessageTotal + "\n\nMessage received:\n" + messageReceived;

        textView.setText(textMessageTotal);
        textView.setVisibility(View.VISIBLE);

        sendButton.setOnClickListener(view -> onSendButtonClick());

    }

    public void onSendButtonClick() {
        String message = editText.getText().toString();
        Intent intentToSend = new Intent();
        intentToSend.putExtra(KEY_FOR_EXTRA_STRING, message);
        setResult(RESULT_OK, intentToSend);
        textMessageTotal = textMessageTotal + "\n\nMessage sent:\n" + message;
        finish();
    }

}




/////BU VERSIYONU SON HALI  ////////////////