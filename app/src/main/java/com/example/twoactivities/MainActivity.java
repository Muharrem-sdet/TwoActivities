package com.example.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_FOR_EXTRA_STRING = "com.example.twoactivities.messageFromMain";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int TEXT_REQUEST_CODE = 1;

    private Button sendButton;
    private EditText editText;
    private TextView textView;

    private String textMessageTotal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.button_send_on_main_activity);
        editText = findViewById(R.id.edit_text_on_main_activity);
        textView = findViewById(R.id.tv_on_main_activity);

        sendButton.setOnClickListener(view -> onSendButtonClick());

    }

    public void onSendButtonClick() {
        String messageSent = editText.getText().toString();
        Intent intentToSend = new Intent(this, SecondActivity.class);
        intentToSend.putExtra(KEY_FOR_EXTRA_STRING, messageSent);
        startActivityForResult(intentToSend, TEXT_REQUEST_CODE);
        editText.setText("");
        textMessageTotal = textMessageTotal + "\n\nMessage sent:\n" + messageSent;
        textView.setText(textMessageTotal);

//        Bundle bundle1 = new Bundle();
//        Bundle bundle2 = new Bundle();
//
//        intentToSend.putExtras(bundle1);
//        intentToSend.putExtras(bundle2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST_CODE) {
            if (resultCode == RESULT_OK && data != null) {
                String messageReceived = data.getStringExtra(SecondActivity.KEY_FOR_EXTRA_STRING);
                textView.setVisibility(View.VISIBLE);

                textMessageTotal = textMessageTotal + "\n\nMessage received:\n" + messageReceived;

                textView.setText(textMessageTotal);
            }
        }
    }

}


/////BU VERSIYONU SON HALI  ////////////////