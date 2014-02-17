package com.example.mytestapp;
import com.loopj.android.http.*;

public class EbayClient {
	
	private static final String BASE_URL = "http://open.api.ebay.com/shopping";

	  private static AsyncHttpClient client = new AsyncHttpClient();
	  
	  public void search(String search_term, String category, JsonHttpResponseHandler responseHandler) {
		  RequestParams params = defaultParams();
		  params.add("QueryKeywords", search_term);
		  get("", params, responseHandler);
	  }

	  private static void get(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
	      client.get(getAbsoluteUrl(url), params, responseHandler);
	  }

	  private static void post(String url, RequestParams params, JsonHttpResponseHandler responseHandler) {
	      client.post(getAbsoluteUrl(url), params, responseHandler);
	  }

	  private static String getAbsoluteUrl(String relativeUrl) {
	      return BASE_URL + relativeUrl;
	  }
	  
	  private static RequestParams defaultParams()
	  {
		  RequestParams params = new RequestParams();
		  
		  params.add("callname", "FindPopularItems");
		  params.add("responseencoding", "JSON");
		  params.add("appid", "SpencerR-6c8e-4262-a2ab-2752c3f2e22a");
		  params.add("siteid", "0");
		  params.add("version", "713");
		  
		  return params;
	  }

}