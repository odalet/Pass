package com.sopra.passport.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * This class provide connection informations 
 *
 * @author Mohammed EL GADI
 * @author Corentin CHEMINAUD 
 */
public class ConnectionTools {
	
	/**
	 * return the connection status
	 * @param cntx
	 * @return boolean
	 */
	public static boolean isOnline(Context cntx) {
	    ConnectivityManager cm =
	        (ConnectivityManager) cntx.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    return netInfo != null && netInfo.isConnectedOrConnecting();
	}
	
}
