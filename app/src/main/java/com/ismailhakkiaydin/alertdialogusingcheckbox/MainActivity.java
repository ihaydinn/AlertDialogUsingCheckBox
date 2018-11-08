package com.ismailhakkiaydin.alertdialogusingcheckbox;


import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String string = "Your Choices : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Choice your operating system");

        final CharSequence items[] = {"Windows", "Pardus", "Ubuntu", "MacOS"};

        final boolean checkedItems[] = {true, false, true, false};

        DialogInterface.OnMultiChoiceClickListener listener = new DialogInterface.OnMultiChoiceClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked){
                if (isChecked){
                    string += items[which]+ "\n\r";

                    Toast.makeText(MainActivity.this, items[which],Toast.LENGTH_LONG).show();
                }
            }
        };

        dlg.setMultiChoiceItems(items,checkedItems,listener);

        dlg.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, string,Toast.LENGTH_LONG).show();
            }
        });
        dlg.show();

    }
}
