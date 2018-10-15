package com.android.act.livetv.Activity;


import android.content.Context;
import android.os.Bundle;
import android.print.PrinterId;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.act.livetv.Interface.IFragmentUpdater;
import com.android.act.livetv.R;

public class HomeScreenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener,IFragmentUpdater  {

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    //private Button mNavigationButton;
    private static final String TAG = HomeScreenActivity.class.getSimpleName();
    public static Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        setupStatusBar();
        setupToolbar();
        setupNavigationDrawer();
        setupFilterMenu();
        setupSearchBar();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home_screen, menu);
//        return true;
        return false;
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            displayToastMsg("Drawer Item 1");
        } else if (id == R.id.nav_gallery) {
            displayToastMsg("Drawer Item 2");
        } else if (id == R.id.nav_slideshow) {
            displayToastMsg("Drawer Item 3");
        } else if (id == R.id.nav_manage) {
            displayToastMsg("Drawer Item 4");
        } else if (id == R.id.nav_share) {
            displayToastMsg("Drawer Item 5");
        } else if (id == R.id.nav_send) {
            displayToastMsg("Drawer Item 6");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupStatusBar(){

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION /*SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_FULLSCREEN*/;
        decorView.setSystemUiVisibility(uiOptions);

        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    private void setupToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView filter = (ImageView) mToolbar.findViewById(R.id.home_screen_toolbar_filter_image);
        filter.setOnClickListener(this);
        ImageView search = (ImageView) mToolbar.findViewById(R.id.home_screen_toolbar_search_image);
        search.setOnClickListener(this);
        ImageView navigation = (ImageView) mToolbar.findViewById(R.id.home_screen_toolbar_navigation_image);
        navigation.setOnClickListener(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setupNavigationDrawer(){
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //D//toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.toolbar_drawer_arrow_color));
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupFilterMenu(){

        TextView filterMenuItem01 = (TextView) findViewById(R.id.toolbar_filter_window_menu_item_01);
        TextView filterMenuItem02 = (TextView) findViewById(R.id.toolbar_filter_window_menu_item_02);
        ImageView filterMenuItem03 = (ImageView) findViewById(R.id.toolbar_filter_window_menu_item_03);
        TextView filterMenuItem06 = (TextView) findViewById(R.id.toolbar_filter_window_menu_item_06);

        filterMenuItem01.setOnClickListener(filterMenuItemClickListener);
        filterMenuItem02.setOnClickListener(filterMenuItemClickListener);
        filterMenuItem03.setOnClickListener(filterMenuItemClickListener);
        filterMenuItem06.setOnClickListener(filterMenuItemClickListener);

    }

    View.OnClickListener filterMenuItemClickListener = new  View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Log.d(TAG, "Filter Menu onClick");
            switch (v.getId()){
                case R.id.toolbar_filter_window_menu_item_01:
                    Log.d(TAG, "onClick() Filter Menu item 01 ");
                    displayToastMsg("Filter Menu item 01");
                    break;
                case R.id.toolbar_filter_window_menu_item_02:
                    Log.d(TAG, "onClick() Filter Menu item 02 ");
                    displayToastMsg("Filter Menu item 02");
                    break;
                case R.id.toolbar_filter_window_menu_item_03:
                    Log.d(TAG, "onClick() Filter Menu item 03 ");
                    displayToastMsg("Filter Menu item 03");
                    break;
                case R.id.toolbar_filter_window_menu_item_06:
                    Log.d(TAG, "onClick() Filter Menu item 06 ");
                    displayToastMsg("Filter Menu item 06");
                    break;

                default:
                    Log.d(TAG, "onClick() Invalid Menu Item ");
                    displayToastMsg("Filter Menu Invalid Item ");
                    break;
            }
        }
    };

    private void setupSearchBar(){
        final EditText searchView = (EditText) findViewById(R.id.toolbar_search_window_search_text_view);
        ImageView clearSearchText = (ImageView )findViewById(R.id.toolbar_search_window_search_text_cancel_icon);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Start for searching the text
                Log.d(TAG, "onTextChanged() text: "+s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        clearSearchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Cancel Button clicked for search text");
                //displayToastMsg("Cancel Button clicked");
                searchView.setText("");
            }
        });
    }


    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() "+v.getId() );
        switch (v.getId()){
            case R.id.home_screen_toolbar_filter_image:
                Log.d(TAG, "onClick() Filter clicked");
                toggleToolbarFilterWindow();
                //displayToastMsg("Filter clicked");
                break;
            case R.id.home_screen_toolbar_search_image:
                Log.d(TAG, "onClick() Search clicked");
                toggleToolbarSearchWindow();
                //displayToastMsg("Search clicked");
                break;
            case R.id.home_screen_toolbar_navigation_image:
                Log.d(TAG, "onClick() Navigation clicked");
                //displayToastMsg("Navigation clicked");
                toggleDrawer();
                break;

                default:
                    Log.d(TAG, "onClick() invalid ID");
                    displayToastMsg("invalid ID clicked");
                    break;

        }


    }

    private void toggleDrawer(){

        if (mDrawerLayout.isDrawerVisible(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    private void displayToastMsg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateFragment(Fragment fragment, int layout) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(layout, fragment);
        fragmentTransaction.commit();
        mCurrentFragment = fragment;
    }

    private void toggleToolbarSearchWindow(){
        //RelativeLayout utilityParentLayout = (RelativeLayout)findViewById(R.id.toolbar_utility_window_parent_layout);
        RelativeLayout searchParentLayout = (RelativeLayout)findViewById(R.id.toolbar_search_window_parent_layout);
        RelativeLayout filterParentLayout = (RelativeLayout)findViewById(R.id.toolbar_filter_window_parent_layout);
        //int visStatus = utilityParentLayout.getVisibility();
        int searchVisStatus = searchParentLayout.getVisibility();
        int filterVisStatus = filterParentLayout.getVisibility();

        if(filterVisStatus == View.VISIBLE){
            filterParentLayout.setVisibility(View.GONE);
        }
        if(searchVisStatus == View.VISIBLE){
            searchParentLayout.setVisibility(View.GONE);
        }else{
            searchParentLayout.setVisibility(View.VISIBLE);
        }
    }

    private void toggleToolbarFilterWindow(){
        //RelativeLayout utilityParentLayout = (RelativeLayout)findViewById(R.id.toolbar_utility_window_parent_layout);

        RelativeLayout searchParentLayout = (RelativeLayout)findViewById(R.id.toolbar_search_window_parent_layout);
        RelativeLayout filterParentLayout = (RelativeLayout)findViewById(R.id.toolbar_filter_window_parent_layout);
        int searchVisStatus = searchParentLayout.getVisibility();
        int filterVisStatus = filterParentLayout.getVisibility();

        if(searchVisStatus  == View.VISIBLE){
            searchParentLayout.setVisibility(View.GONE);
            hideKeyBoard();
        }
        if(filterVisStatus == View.VISIBLE){
            filterParentLayout.setVisibility(View.GONE);
        }else{
            filterParentLayout.setVisibility(View.VISIBLE);
        }
    }

    private void hideKeyBoard(){
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if(imm.isActive()){
            View view = getCurrentFocus();
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = new View(this);
            }
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            Log.d(TAG, "hideKeyBoard() hide the IME");
            //displayToastMsg("Hide IME");
        }
    }

    private void toggleKeyBoard(){
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if(imm.isActive()){
            imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }else {
            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
        }
    }
}
