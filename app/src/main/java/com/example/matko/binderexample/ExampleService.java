package com.example.matko.binderexample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by matko on 3/17/15.
 */
public class ExampleService extends Service {

    IBinder _binder = new ExampleServiceBinder();

    @Override
    public IBinder onBind(Intent intent) {

        return _binder;
    }

    public String getData(){
        return "Some data from Service";
    }

    public void showServiceMessage(String message){

        Log.i("tmsg", message);
    }

    public class ExampleServiceBinder extends Binder{

        public ExampleService getServiceInstatnce(){

            return ExampleService.this;
        }
    }
}
