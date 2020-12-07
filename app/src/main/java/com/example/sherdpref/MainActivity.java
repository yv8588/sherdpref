/**
 * exercise for albert our beautiful teacher
 * @author yoad
 * @version 1.0
 */
package com.example.sherdpref;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int count=0;
TextView counter;
EditText Name;
String name;
SharedPreferences settings=getSharedPreferences("MY_PREF",MODE_PRIVATE);
SharedPreferences.Editor editor=settings.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=(TextView)findViewById(R.id.counter);
        Name=(EditText)findViewById(R.id.Name);
        count=settings.getInt("count",999999);
        name=settings.getString("name","a");
        if(name.equals("a")){
            count=0;
            name="";
        }
        counter.setText(count);
        Name.setText(name);
    }
    /**
     * saves the name of the user ant the counter in shared preferences file.
     * <p>
     * @param view the button that got clicked.
     */
    public void exit(View view) {
        name=Name.getText().toString();
        if(name.equals(null))
            Toast.makeText(MainActivity.this,"enter a name",Toast.LENGTH_SHORT).show();
        editor.putString("name",name);
        editor.putInt("count",count);
        editor.commit();
    }

    /**
     * resets the click counter.
     * <p>
     * @param view the button that got clicked.
     */
    public void reset(View view) {
        count=0;
    }

    /**
     * adding one to the counter on button click.
     * <p>
     * * @param view the button that got clicked.
     */
    public void count(View view) {
        count++;

    }
    /**
     * creates the xml general option menu
     * <p>
     * @param menu the xml general menu
     * @return true if the menu was created
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    /**
     * when item got clicked in the option menu goes to the activity that was chosen
     * <p>
     * @param item the item in the menu that got clicked
     * @return true if was operated successfully
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String s=item.getTitle().toString();
        if(s.equals("credits screen")) {
            Intent si = new Intent(this,credits.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }
}