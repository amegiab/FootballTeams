package com.isanalva.footballteams.http;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by amegia on 03/12/2016.
 */

public class VolleyGetRequest<T> extends Request<T> {

    private static final String TAG = "VolleyGetRequest";

    private final Gson gson = new Gson();
    private final Class<T> clazz;
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;

    public VolleyGetRequest(String url, Class<T> clazz, Map<String, String> headers,
                                Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.clazz = clazz;
        this.headers = headers;
        this.listener = listener;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return headers != null ? headers : super.getHeaders();
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
            /*String responseStr = new String(response.data);
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(responseStr).getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonArray("teams");
            //String json = jsonArray.getAsString();
            return Response.success(
                    gson.fromJson(jsonArray, clazz),
                    HttpHeaderParser.parseCacheHeaders(response));*/
        }catch (UnsupportedEncodingException e) {
            Log.e(TAG, e.getMessage());
            return Response.error(new ParseError(e));
        }
        /*try {
            *//*String responseStr = new String(response.data);
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(responseStr).getAsJsonObject();
            FootballTeam footballTeam = gson.fromJson(jsonObject.get("teams"), FootballTeam.class);
            T data = gson.fromJson(jsonObject.get("data"), clazz);
            if(ResultCode.fromInt(result.getStatus_code()) != ResultCode.SUCCESS)
                return Response.error(new VolleyFailWrapper(result));
            return Response.success(data,HttpHeaderParser.parseCacheHeaders(response));*//*
            String responseStr = new String(response.data);
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(responseStr).getAsJsonObject();
            JsonArray jsonArray = jsonObject.getAsJsonArray("teams");
            List<FootballTeam> data = new Gson().fromJson(jsonArray, FootballTeamListWrapper.class);
            return Response.success(data, HttpHeaderParser.parseCacheHeaders(response));
        } catch (JsonSyntaxException e) {
            return Response.error(new ParseError(e));
        }*/

        /*String responseStr = new String(response.data);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(responseStr).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("teams");
        List<FootballTeam> data = new Gson().fromJson(jsonArray, FootballTeamListWrapper.class);
        return Response.success(data, HttpHeaderParser.parseCacheHeaders(response));*/
    }

}
