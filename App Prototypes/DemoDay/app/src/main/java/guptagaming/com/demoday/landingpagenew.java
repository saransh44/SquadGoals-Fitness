package guptagaming.com.demoday;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import com.parse.PushService;

public class landingpagenew extends ActionBarActivity {

    ImageButton imageb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpagenew);
        PushService.setDefaultPushCallback(this, landingpagenew.class);
        imageb = (ImageButton) findViewById(R.id.imageB);

        imageb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prog();

            }
        });
    }
    public void prog() {
        Intent i = new Intent(this, progress.class);
        //goalsI(i);
        //i.putExtra("user", (Serializable) user);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_landingpagenew, menu);
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
