package swd.fhj.at.minder;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import swd.fhj.at.minder.db.TaskContract;
import swd.fhj.at.minder.db.TaskDBHelper;

public class EditItemActivity extends AppCompatActivity {
    private TaskDBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edititem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHelper = new TaskDBHelper(this);

        Intent intent = getIntent();
        final Bundle extras = intent.getExtras();
        final String data = extras.getString("ItemName");
        //load text into text view
        TextView textView = (TextView) findViewById(R.id.editTextView);
        textView.setText(data);

        // Save changes
        Button save = (Button) findViewById(R.id.savebtn);
        Button cancel = (Button) findViewById(R.id.cancelbtn);
        Button mark = (Button) findViewById(R.id.donebtn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = mHelper.getWritableDatabase();
                String taskupdate = String.valueOf(((TextView) findViewById(R.id.editTextView)).getText());

                ContentValues values = new ContentValues();
                values.put(TaskContract.TaskEntry.COL_TASK_TITLE, taskupdate);
                //db.update(TaskContract.TaskEntry.TABLE, values,
                  //      TaskContract.TaskEntry.COL_TASK_TITLE + " = ?", args);
                db.update(TaskContract.TaskEntry.TABLE, values,"title = ?",new String[] { data });
                db.close();

                Snackbar.make(view, "Saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent1 = new Intent(EditItemActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Cancelled", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent1 = new Intent(EditItemActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set state to done here
            }
        });

    }

}
