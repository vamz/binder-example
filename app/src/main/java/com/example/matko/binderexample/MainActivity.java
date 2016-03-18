package com.example.matko.binderexample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    public ExampleService _exampleService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mIntent = new Intent(this, ExampleService.class);
        bindService(mIntent, new CustomServiceConnection(), BIND_AUTO_CREATE);
    }

    public void bt_a_onclick(View v){
        if (_exampleService != null) {
            showActivityMessage(_exampleService.getData());
        }
    }

    public void bt_b_onclick(View v){
        if (_exampleService != null) {
            _exampleService.showServiceMessage("Message from Activity to Service.");
        }
    }

    public class CustomServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            ExampleService.ExampleServiceBinder binder= (ExampleService.ExampleServiceBinder)service;
            _exampleService = binder.getServiceInstatnce();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    public void showActivityMessage(String message){
        Log.i("tmsg", message);
    }
}
