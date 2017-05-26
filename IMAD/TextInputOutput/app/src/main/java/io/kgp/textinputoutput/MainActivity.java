package io.kgp.textinputoutput;

import android.content.DialogInterface;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;

    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
//        //setting the text
//        //todo: string resource file
//        textView.setText("New Text");

        editText =(EditText) findViewById(R.id.edittext);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //gets called each time button is clicked

//                Toast.makeText(MainActivity.this,"Button Clicked!!",Toast.LENGTH_LONG).show();

                String enteredtext=editText.getText().toString().trim();
                if(enteredtext.isEmpty()){
                    //show alert
                    showAlert();
                } else {
                    //Replace the text in the text view
                    replaceText(enteredtext);
                }
            }
        });
        Log.i(TAG,"Inside Oncreate");
    }

    @Override
    protected void onResume(){
        super.onResume();
//        Log.i(TAG,"Resume");
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    private void replaceText(String newText){
        textView.setText(newText);
        editText.setText("");

    }

    private void showAlert(){
        // build the dialog
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Empty!!");
        builder.setMessage("No String to replace!!");
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        //show the dialog
        builder.show();
    }
}
