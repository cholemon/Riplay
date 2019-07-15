package controller;

import android.os.Handler;
import com.check.time.MainActivity;
import java.util.ArrayList;
import api.CallApi;
import helper.Global;
import model.Ciudad;
import model.DB;

public class ControlMainActivity {

    private Handler handler;
    private MainActivity vista;
    private DB db;

    public ControlMainActivity(MainActivity vista){
        this.vista   = vista;
        this.db      = new DB(vista);
        this.handler = new Handler();
        call();
        handler.post(runnable);
    }

    private void call(){
        CL();
        CH();
        NZ();
        AU();
        UK();
        USA();
    }

    private void CL(){
        try{
            Global.chekError();

            ArrayList<Ciudad> cl = db.getDataCiudad("CL");
            String nombre_cl     = cl.get(0).getNombre_ciudad();
            String data          = cl.get(0).getLatitud()+","+cl.get(0).getLongitud();
            new CallApi(vista, "CL", nombre_cl).execute(Global.URL_API+data);
        }
        catch(Error e){
            db.logError(Global.getTime(), e.getMessage(), "CL");
        }
    }

    private void CH(){
        try{
            Global.chekError();

            ArrayList<Ciudad> ch = db.getDataCiudad("CH");
            String nombre_ch     = ch.get(0).getNombre_ciudad();
            String data          = ch.get(0).getLatitud()+","+ch.get(0).getLongitud();
            new CallApi(vista, "CH", nombre_ch).execute(Global.URL_API+data);
        }
        catch(Error e){
            db.logError(Global.getTime(), e.getMessage(), "CH");
        }
    }

    private void NZ(){
        try{
            Global.chekError();

            ArrayList<Ciudad> nz = db.getDataCiudad("NZ");
            String nombre_nz     = nz.get(0).getNombre_ciudad();
            String data          = nz.get(0).getLatitud()+","+nz.get(0).getLongitud();
            new CallApi(vista, "NZ", nombre_nz).execute(Global.URL_API+data);
        }
        catch(Error e){
            db.logError(Global.getTime(), e.getMessage(), "NZ");
        }
    }

    private void AU(){
        try{
            Global.chekError();

            ArrayList<Ciudad> au = db.getDataCiudad("AU");
            String nombre_au     = au.get(0).getNombre_ciudad();
            String data          = au.get(0).getLatitud()+","+au.get(0).getLongitud();
            new CallApi(vista, "AU", nombre_au).execute(Global.URL_API+data);
        }
        catch(Error e){
            db.logError(Global.getTime(), e.getMessage(), "AU");
        }
    }

    private void UK(){
        try{
            Global.chekError();

            ArrayList<Ciudad> uk = db.getDataCiudad("UK");
            String nombre_uk     = uk.get(0).getNombre_ciudad();
            String data          = uk.get(0).getLatitud()+","+uk.get(0).getLongitud();
            new CallApi(vista, "UK", nombre_uk).execute(Global.URL_API+data);
        }catch(Error e){
            db.logError(Global.getTime(), e.getMessage(), "UK");
        }
    }

    private void USA(){
        try{
            Global.chekError();

            ArrayList<Ciudad> usa = db.getDataCiudad("USA");
            String nombre_usa     = usa.get(0).getNombre_ciudad();
            String data           = usa.get(0).getLatitud()+","+usa.get(0).getLongitud();
            new CallApi(vista, "USA", nombre_usa).execute(Global.URL_API+data);
        }catch(Error e){
            db.logError(Global.getTime(), e.getMessage(), "USA");
        }
    }

    private Runnable runnable = new Runnable() {
        public void run() {
            call();
            handler.postDelayed(this, 10000);
        }
    };

}