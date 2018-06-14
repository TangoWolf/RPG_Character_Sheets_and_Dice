package com.example.shaol.char_sheet.Utils;

import android.graphics.Movie;

import com.example.shaol.char_sheet.Model.Store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

/**
 * Created by shaol on 6/13/2018.
 */

public final class JsonUtils {

    private static final String RESULTS = "results";
    private static final String NAME = "name";
    private static final String GEOMETRY = "geometry";
    private static final String LOCATION = "location";
    private static final String LAT = "lat";
    private static final String LNG = "lng";

    private static final String MESSAGE_CODE = "cod";

    public static Store[] getStoreInfoFromJson(String JsonString) throws JSONException {
        Store[] parsedStoreInfo = null;

        JSONObject startString = new JSONObject(JsonString);

        if (startString.has(MESSAGE_CODE)) {
            int errorCode = startString.getInt(MESSAGE_CODE);

            switch(errorCode) {
                case HttpURLConnection.HTTP_OK:
                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:
                    return null;
                default:
                    return null;
            }
        }

        JSONArray results = startString.getJSONArray(RESULTS);
        parsedStoreInfo = new Store[results.length()];

        for (int i = 0; i < results.length(); i++) {
            JSONObject store = results.getJSONObject(i);

            String name = store.getString(NAME);

            JSONObject geo = store.getJSONObject(GEOMETRY);
            JSONObject location = geo.getJSONObject(LOCATION);

            String latitude = location.getString(LAT);
            double lat = Double.parseDouble(latitude);
            String longitude = location.getString(LNG);
            double lng = Double.parseDouble(longitude);

            Store aStore = new Store(name, lat, lng);
            parsedStoreInfo[i] = aStore;
        }
        return parsedStoreInfo;
    }
}
