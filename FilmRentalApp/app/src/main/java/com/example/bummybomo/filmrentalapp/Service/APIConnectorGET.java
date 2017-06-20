
package com.example.bummybomo.filmrentalapp.Service;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.example.bummybomo.filmrentalapp.Domain.Film;
import com.example.bummybomo.filmrentalapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by omidleet on 18-6-2017.
 */


public class APIConnectorGET extends AsyncTask<String, Void, String> {

    // Call back
    private OnMovieAvailable listener = null;

    private String token;

    // Statics
    private static final String TAG = APIConnectorGET.class.getSimpleName();
    //private static final String urlString = "https://filmrentalserver.herokuapp.com/films";

    // Constructor, set listener
    public APIConnectorGET(OnMovieAvailable listener, String token) {
        this.listener = listener;
        this.token = token;
    }

    /**
     * doInBackground is de methode waarin de aanroep naar een service op het Internet gedaan wordt.
     *
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(String... params) {

        //url omzetten naar content
        InputStream inputStream = null;
        int responsCode = -1;
        // De URL die we via de .execute() meegeleverd krijgen
        String personUrl = params[0];
        // Het resultaat dat we gaan retourneren
        String response = "";

        //Logging tag
        Log.i(TAG, "doInBackground - " + personUrl);
        //Try-block to establish connection
        try {
            // Maak een URL object
            URL url = new URL(personUrl);
            // Open een connection op de URL
            URLConnection urlConnection = url.openConnection();
            //checken of er internet is zodat gegevens opgehaald kunnen worden
            if (!(urlConnection instanceof HttpURLConnection)) {
                return null;
            }

            // Initialiseer een HTTP connectie
            HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
            httpConnection.setAllowUserInteraction(false);
            httpConnection.setInstanceFollowRedirects(true);
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Authorization", "bearer "+token);
            Log.i(TAG, token);
            // Voer het request uit via de HTTP connectie op de URL
            httpConnection.connect();

            // Kijk of het gelukt is door de response code te checken
            responsCode = httpConnection.getResponseCode();
            if (responsCode == HttpURLConnection.HTTP_OK) {
                //inputStream = httpConnection.getInputStream();
                response = getStringFromInputStream(httpConnection.getInputStream());
                Log.i(TAG, "doInBackground response = " + response);
            } else {
                Log.e(TAG, "Error, invalid response");
            }

            //Exception catching and logging
        } catch (MalformedURLException e) {
            Log.e(TAG, "doInBackground MalformedURLEx " + e.getLocalizedMessage());
            return null;
        } catch (IOException e) {
            Log.e("TAG", "doInBackground IOException " + e.getLocalizedMessage());
            return null;
        }

        // Hier eindigt deze methode.
        // Het resultaat gaat naar de onPostExecute methode.
        //
        return response;
    }

    /**
     * onPostExecute verwerkt het resultaat uit de doInBackground methode.
     * Verwerkt dus de gegevens, van string naar json format.
     *
     * @param response
     */
    protected void onPostExecute(String response) {

        Log.i(TAG, "onPostExecute " + response);

        // Check of er een response is
        if (response == null || response == "") {
            Log.e(TAG, "onPostExecute kreeg een lege response!");
            return;
        }


        //declaratie van jsonObject
        JSONObject jsonObject;
        try {
            // Top level json object, heeft als parameter het response object van de doInBackground klasse
            jsonObject = new JSONObject(response);

            // Get all products/items from api and start looping
            JSONArray movies = jsonObject.getJSONArray("items");
            for (int idx = 0; idx < movies.length(); idx++) {
                // array level objects and get movie
                JSONObject movie = movies.getJSONObject(idx);

                String title;
                String filmId;
                String description;
                String status;

                if (movie.has("title")) {
                    title = movie.getString("title");
                } else {
                    title = "";
                }

                if (movie.has("description")) {
                    description = movie.getString("description");
                } else {
                    description = "";
                }

                if (movie.has("status")) {
                    status = movie.getString("status");
                } else {
                    status = "";
                }

                // Create new Product object
                Film f = new Film(title, description, status);
                f.setTitle(title);
                f.setDescription(description);
                f.setStatus(status);


                //
                // call back with new person data
                //
                listener.OnMovieAvailable(f);

            }
        } catch (JSONException ex) {
            Log.e(TAG, "onPostExecute JSONException " + ex.getLocalizedMessage());
        }
    }


    //
// convert InputStream to String
//
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    // Call back interface
    public interface OnMovieAvailable {
        void OnMovieAvailable(Film film);
    }
}
