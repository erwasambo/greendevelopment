
package com.green.development;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class ActionBarActivity extends SherlockActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Used to put dark icons on light action bar
        boolean isLight = SampleList.THEME == R.style.Theme_Sherlock_Light;

        menu.add("Submit")
            .setIcon(isLight ? R.drawable.cloud : R.drawable.cloud)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        menu.add("Delete")
            .setIcon(isLight ? R.drawable.delete : R.drawable.delete)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //This uses the imported MenuItem from ActionBarSherlock
        Toast.makeText(this, "Got click: " + item.toString(), Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(SampleList.THEME); //Used for theme switching in samples
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menus);
        registerForContextMenu(findViewById(R.id.show_context_menu));
    }
}
