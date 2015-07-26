package com.zireck.projectk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.zireck.projectk.R;
import com.zireck.projectk.listener.OnAddFoodFinishedListener;

import butterknife.Bind;

/**
 * Created by Zireck on 24/07/2015.
 */
public class AddFoodActivity extends BaseActivity implements OnAddFoodFinishedListener {

    @Bind(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        initActionBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_add_food, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //onBackPressed();
                foodNotAdded();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void foodAdded() {
        navigateBack(RESULT_OK);
    }

    @Override
    public void foodNotAdded() {
        navigateBack(RESULT_CANCELED);
    }

    private void navigateBack(int result) {
        Intent intent = new Intent();
        setResult(result, intent);
        finish();
    }

    private void initActionBar() {
        mToolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);

        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}