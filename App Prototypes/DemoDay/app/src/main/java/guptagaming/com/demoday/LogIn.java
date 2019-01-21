package guptagaming.com.demoday;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

import static com.parse.ParseUser.logInInBackground;


public class LogIn extends ActionBarActivity {

    Button but;
    EditText mNameField;
    EditText mPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        but = (Button) findViewById(R.id.loginbutton);
        mNameField = (EditText) findViewById(R.id.name);
        mPassword = (EditText) findViewById(R.id.password);

        //final ParseUser user = new ParseUser();
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mNameField.getText().toString();
                String password = mPassword.getText().toString();
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    public void done(ParseUser user, com.parse.ParseException e) {
                        if (user != null) {
                            Toast.makeText(LogIn.this, "Signed In.", Toast.LENGTH_LONG).show();
                            landing();
                        } else {
                            Toast.makeText(LogIn.this, "Signing in failed", Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });
    }

    public void progress() {
        Intent intent = new Intent(this, progress.class);
        startActivity(intent);
    }
    public void landing() {
        Intent intent = new Intent(this, landingpagenew.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
