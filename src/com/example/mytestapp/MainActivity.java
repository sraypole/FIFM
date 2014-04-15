package com.example.mytestapp;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.JsonHttpResponseHandler;

public class MainActivity extends Activity {
	
	public final static String ITEM_NAME = "com.example.mytestapp.ITEM_NAME";

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void sendMessage(View view) {
    	final Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString(); // call ebay api here
    	
	    EbayClient client = new EbayClient();
	    
	    client.search(message, "", new JsonHttpResponseHandler(){
	    	@Override
            public void onSuccess(JSONObject results) {
	    		try {
					String timestamp = (String) results.get("Timestamp");
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
	    		Log.w("RESULTS", results.toString());
//	    		EbayItemList items = new EbayItemList(results);
//	    		intent.putExtra(ITEM_NAME, items);
	    		intent.putExtra(ITEM_NAME, results.toString());
	            startActivity(intent);
	    	}
	    	
	    	@Override
	    	public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error)
	    	{
	    		Log.e("FUCK THIS", "SHIT BROKE");
	    	}
	    });
    }
}
