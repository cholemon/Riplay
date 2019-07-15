package helper;

import android.app.Application;
import model.Ciudad;
import model.DB;

public class App extends Application {

    private DB db;

    @Override
    public void onCreate() {
        super.onCreate();

        db = new DB(getApplicationContext());
        setup();
    }

    private void setup(){
        if(!db.existe_ciudad("CL")){
            Ciudad cl = new Ciudad();
            cl.setNombre_ciudad("Santiago");
            cl.setLatitud("-33.4489");
            cl.setLongitud("-70.6693");
            cl.setCodigo("CL");
            db.guardar_ciudad(cl);
        }

        if(!db.existe_ciudad("CH")){
            Ciudad ch = new Ciudad();
            ch.setNombre_ciudad("Zurich");
            ch.setLatitud("47.3769");
            ch.setLongitud("8.5417");
            ch.setCodigo("CH");
            db.guardar_ciudad(ch);
        }

        if(!db.existe_ciudad("NZ")){
            Ciudad nz = new Ciudad();
            nz.setNombre_ciudad("Auckland");
            nz.setLatitud("-36.848144");
            nz.setLongitud("174.763331");
            nz.setCodigo("NZ");
            db.guardar_ciudad(nz);
        }

        if(!db.existe_ciudad("AU")){
            Ciudad au = new Ciudad();
            au.setNombre_ciudad("Sydney");
            au.setLatitud("-33.847927");
            au.setLongitud("150.6517799");
            au.setCodigo("AU");
            db.guardar_ciudad(au);
        }

        if(!db.existe_ciudad("UK")){
            Ciudad uk = new Ciudad();
            uk.setNombre_ciudad("Londres");
            uk.setLatitud("51.528308");
            uk.setLongitud("-0.3817816");
            uk.setCodigo("UK");
            db.guardar_ciudad(uk);
        }

        if(!db.existe_ciudad("USA")){
            Ciudad usa = new Ciudad();
            usa.setNombre_ciudad("Georgia");
            usa.setLatitud("32.674684");
            usa.setLongitud("-83.25066");
            usa.setCodigo("USA");
            db.guardar_ciudad(usa);
        }
    }

}
