package ca.kklee.libraryproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ca.kklee.libraryproject.ImageViewPlatform.ImageViewPlatform;
import ca.kklee.libraryproject.LoggerPlatform.LoggerPlatform;

public class HomeActivity extends ActionBarActivity {

    private String[] platformList = {"ImageViewPlatform", "Logging"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        InitPlatformListView();
    }

    private void InitPlatformListView() {
        ListView drawerList = (ListView) findViewById(R.id.platform_list_view);
        drawerList.setAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, platformList));
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;
                switch(i){
                    case 0:
                        intent = new Intent(getBaseContext(), ImageViewPlatform.class);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(), LoggerPlatform.class);
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
