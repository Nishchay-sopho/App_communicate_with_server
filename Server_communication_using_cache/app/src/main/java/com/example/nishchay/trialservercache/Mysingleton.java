package com.example.nishchay.trialservercache;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Nishchay on 09-04-2017.
 */

public class Mysingleton {

    private  static Mysingleton mInstance;
    private static RequestQueue requestQueue;
    private Context mCtx;

    private Mysingleton(Context context)
    {
        mCtx=context;
        requestQueue=getRequestQue();
    }
    public RequestQueue getRequestQue(){

        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Mysingleton getInstance (Context context)
    {
        if(mInstance==null) {
            mInstance = new Mysingleton(context);

        }
        return mInstance;
    }

    public<T>  void addtoRequestque (Request<T> request)
    {
        requestQueue.add(request);
    }
}
