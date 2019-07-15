package api;

import android.os.AsyncTask;
import androidx.annotation.Nullable;
import com.check.time.MainActivity;
import com.google.android.material.snackbar.Snackbar;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import helper.Global;
import helper.JSONParser;

public class CallApi extends AsyncTask<String, Void, Void> {

    private MainActivity vista;
    private String ciudad;
    private String nombre_ciudad;
    private String timezone;
    private int time;
    private double temperature;

    private boolean band;

    public CallApi(MainActivity vista , String ciudad, String nombre_ciudad){
        this.vista         = vista;
        this.ciudad        = ciudad;
        this.nombre_ciudad = nombre_ciudad;
        this.band          = true;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Nullable
    @Override
    protected Void doInBackground(String... params) {

        try {
            JSONObject json   = JSONParser.getDataFromWeb(params[0]);

            if(!json.has("error")){
                JSONObject nested = json.getJSONObject("currently");
                timezone      = json.getString("timezone");
                time          = nested.getInt("time");
                temperature   = nested.getDouble("temperature");
                band          = false;
            }
        } catch (JSONException je) {
            Log.i("Tarea Asincrona Fallida", "" + je.getLocalizedMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if(band) {
            Snackbar.make(vista.container, "Se ha alcanzado el máximo de peticiones.!", Snackbar.LENGTH_SHORT).show();
        }else{
            switch(ciudad){
                case "CL":
                    vista.nombre_cl.setText(nombre_ciudad.toUpperCase());
                    vista.time_cl.setText(Global.getFecha(time, timezone));
                    vista.temperature_cl.setText(Global.getGrades(temperature));
                    break;

                case "CH":
                    vista.nombre_ch.setText(nombre_ciudad.toUpperCase());
                    vista.time_ch.setText(Global.getFecha(time, timezone));
                    vista.temperature_ch.setText(Global.getGrades(temperature));
                    break;

                case "NZ":
                    vista.nombre_nz.setText(nombre_ciudad.toUpperCase());
                    vista.time_nz.setText(Global.getFecha(time, timezone));
                    vista.temperature_nz.setText(Global.getGrades(temperature));
                    break;

                case "AU":
                    vista.nombre_au.setText(nombre_ciudad.toUpperCase());
                    vista.time_au.setText(Global.getFecha(time, timezone));
                    vista.temperature_au.setText(Global.getGrades(temperature));
                    break;

                case "UK":
                    vista.nombre_uk.setText(nombre_ciudad.toUpperCase());
                    vista.time_uk.setText(Global.getFecha(time, timezone));
                    vista.temperature_uk.setText(Global.getGrades(temperature));
                    break;

                case "USA":
                    vista.nombre_usa.setText(nombre_ciudad.toUpperCase());
                    vista.time_usa.setText(Global.getFecha(time, timezone));
                    vista.temperature_usa.setText(Global.getGrades(temperature));
                    break;

                default: break;
            }
        }
    }
}