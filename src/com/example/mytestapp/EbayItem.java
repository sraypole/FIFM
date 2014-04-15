package com.example.mytestapp;

import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class EbayItem implements Parcelable {
	//TODO: add all of the properties from the api response below
	private String prop1;
	private String prop2;
	
	public EbayItem(Parcel in) {
		String[] data = new String[3];
		
		in.readStringArray(data);
		this.prop1 = data[0];
		this.prop2 = data[1];
	}
	
	public EbayItem(JSONObject results) {
		
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {
        		//TODO: add all of the properties from the api response below
        		this.prop1,
                this.prop2
        });
    }
	
	public static final Parcelable.Creator<EbayItem> CREATOR = new Parcelable.Creator<EbayItem>() {
		public EbayItem createFromParcel(Parcel in) {
			return new EbayItem(in);
		}
		
		public EbayItem[] newArray(int size) {
			return new EbayItem[size];
		}
	};
}
