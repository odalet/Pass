package com.sopra.passport.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnexionTools {
	public static boolean isOnline(Context cntx) {
	    ConnectivityManager cm =
	        (ConnectivityManager) cntx.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    return netInfo != null && netInfo.isConnectedOrConnecting();
	}
}
