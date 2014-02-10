package com.example.mytestapp;
import com.loopj.android.http.*;
import org.json.*;


public class EbayClientHandler {

	public void getPublicTimeline() {
        EbayClient.get("statuses/public_timeline.json", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray timeline) {
                // Pull out the first event on the public timeline
                //JSONObject firstEvent = timeline.get(0);
                //String tweetText = firstEvent.getString("text");

                // Do something with the response
                //System.out.println(tweetText);
            }
        });
    }
}
