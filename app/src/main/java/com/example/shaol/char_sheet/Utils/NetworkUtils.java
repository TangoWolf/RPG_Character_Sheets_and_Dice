package com.example.shaol.char_sheet.Utils;

import android.net.Uri;

import com.example.shaol.char_sheet.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by shaol on 6/13/2018.
 */

public class NetworkUtils {

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch";
    private static final String API_KEY = "";

    public static URL buildUrl(double lat, double lng) {
        String mLat = String.valueOf(lat);
        String mLng = String.valueOf(lng);

        String SEARCH = "json?location=" + mLat + "," + mLng + "&radius=10000&name=comic+book+store&key=" + API_KEY;

        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendEncodedPath(SEARCH)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
