package com.example.francisco.layoutsandviews;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    EditText etName;
    EditText etName2;
    Button btnName;
    TextView tvName;

    //Binding person views
    EditText etPersonName, etPersonGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etName2 = (EditText) findViewById(R.id.etName2);
        btnName = (Button) findViewById(R.id.btnName);
        tvName = (TextView) findViewById(R.id.tvName);

        etPersonName = (EditText) findViewById(R.id.etPersonName);
        etPersonGender = (EditText) findViewById(R.id.etPersonGender);

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int etValue = Integer.parseInt(etName.getText().toString());
                int etValue2 = Integer.parseInt(etName2.getText().toString());
                tvName.setText("Result "+(etValue+etValue2));
            }
        });
        //tvName.setText("Some tv Text different of xml");
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: ");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    public void goToSecond(View view) {

        String value = etName.getText().toString();

        Intent intent = new Intent(this,SecondActivity.class);
        intent.setAction("FirstIntent");
        intent.putExtra(getString(R.string.KEY_VALUE1),value);
        startActivity(intent);
    }

    public void passPersonToSecond(View view) {
        String personName = etPersonName.getText().toString();
        String personGender = etPersonGender.getText().toString();

        Person person = new Person(personName,personGender);

        Intent intent = new Intent(this,SecondActivity.class);
        intent.setAction("sendingPerson");
        intent.putExtra(getString(R.string.KEY2), person);
        startActivity(intent);
    }
}
