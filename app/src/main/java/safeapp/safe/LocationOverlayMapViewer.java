/*
 * Copyright 2010, 2011, 2012, 2013 mapsforge.org
 * Copyright 2013-2014 Ludwig M Brinckmann
 * Copyright 2015 devemux86
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package safeapp.safe;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.example.luis.safe.R;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.FillRule;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.util.LatLongUtils;
import org.mapsforge.core.model.Point;
import org.mapsforge.core.util.LatLongUtils;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.layer.overlay.Polygon;
import org.mapsforge.map.layer.overlay.Polyline;
import org.mapsforge.map.model.DisplayModel;
import org.mapsforge.map.model.MapViewPosition;

import org.mapsforge.core.model.BoundingBox;
import org.mapsforge.core.model.Dimension;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import safeapp.safe.location.MyLocationOverlay;

import safeapp.safe.Zonas;

/**
 * MapViewer that shows current position. In the data directory of the Samples
 * project is the file berlin.gpx that can be loaded in the Android Monitor to
 * simulate location data in the center of Berlin.
 */
public class LocationOverlayMapViewer extends DownloadLayerViewer implements LocationListener {

    private MyLocationOverlay myLocationOverlay;
    private static final String TAG = LocationOverlayMapViewer.class.getSimpleName();//para el log
    //Log.d(TAG,String.format("*******distancia******** = %f", distancia));
    Zonas zone = new Zonas();

    private Location lastLocation;

    private final DisplayModel displayModel = new DisplayModel();

    MapViewPosition mapViewPosition = new MapViewPosition(displayModel);


    // *******Poligono Zona Insegura*******
    Paint paintFillInsecure = Utils.createPaint(
            AndroidGraphicFactory.INSTANCE.createColor(32,254,0,0), 2,
            Style.FILL);
    Paint paintStrokeInsecure = Utils.createPaint(
            AndroidGraphicFactory.INSTANCE.createColor(Color.RED), 2,
            Style.STROKE);
    Polygon polygonInsecure = new Polygon(paintFillInsecure, paintStrokeInsecure,
            AndroidGraphicFactory.INSTANCE);
    List<LatLong> latLongsI = polygonInsecure.getLatLongs();



    // *******Poligono Zona Segura*******
    Paint paintFillSecure = Utils.createPaint(
            AndroidGraphicFactory.INSTANCE.createColor(32,0,254,0), 2,
            Style.FILL);
    Paint paintStrokeSecure = Utils.createPaint(
            AndroidGraphicFactory.INSTANCE.createColor(Color.GREEN), 2,
            Style.STROKE);
    Polygon polygonSecure = new Polygon(paintFillSecure, paintStrokeSecure,
            AndroidGraphicFactory.INSTANCE);
    List<LatLong> latLongsS = polygonSecure.getLatLongs();



    // ******Coordenadas Plan********
    Polyline plan = new Polyline(Utils.createPaint(
            AndroidGraphicFactory.INSTANCE.createColor(Color.BLUE), 8,
            Style.STROKE), AndroidGraphicFactory.INSTANCE);
    List<LatLong> latLongsP = plan.getLatLongs();



    // ******Polilinea Ruta********Este se dibujara
    Polyline polylineRuta = new Polyline(Utils.createPaint(
            AndroidGraphicFactory.INSTANCE.createColor(Color.BLUE), 8,
            Style.STROKE), AndroidGraphicFactory.INSTANCE);
    List<LatLong> latLongsRuta = polylineRuta.getLatLongs();



    // ******Coordenadas Plan********
    Polyline planDummy = new Polyline(Utils.createPaint(
            AndroidGraphicFactory.INSTANCE.createColor(Color.BLUE), 8,
            Style.STROKE), AndroidGraphicFactory.INSTANCE);
    List<LatLong> latLongsDummy = planDummy.getLatLongs();

    public LocationOverlayMapViewer(){}

    @SuppressWarnings("deprecation")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    @Override
    public void createLayers() {
        super.createLayers();

        // a marker to show at the position
        Drawable drawable = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? getDrawable(R.drawable.point_red) : getResources().getDrawable(R.drawable.point_red);
        Bitmap bitmap = AndroidGraphicFactory.convertToBitmap(drawable);

        // create the overlay and tell it to follow the location
        this.myLocationOverlay = new MyLocationOverlay(this,
                this.mapView.getModel().mapViewPosition, bitmap);
        this.myLocationOverlay.setSnapToLocationEnabled(true);

        // ***********************************Zona Insegura******************************
        latLongsI.add(zone.latLong1);        latLongsI.add(zone.latLong2);        latLongsI.add(zone.latLong3);
        latLongsI.add(zone.latLong4);        latLongsI.add(zone.latLong5);        latLongsI.add(zone.latLong6);
        latLongsI.add(zone.latLong7);        latLongsI.add(zone.latLong8);        latLongsI.add(zone.latLong9);
        latLongsI.add(zone.latLong10);       latLongsI.add(zone.latLong11);       latLongsI.add(zone.latLong12);
        latLongsI.add(zone.latLong13);        latLongsI.add(zone.latLong14);        latLongsI.add(zone.latLong15);
        latLongsI.add(zone.latLong16);        latLongsI.add(zone.latLong17);        latLongsI.add(zone.latLong18);

        latLongsI.add(zone.latLong19);        latLongsI.add(zone.latLong20);
        latLongsI.add(zone.latLong21);        latLongsI.add(zone.latLong22);        latLongsI.add(zone.latLong23);
        latLongsI.add(zone.latLong24);        latLongsI.add(zone.latLong25);        latLongsI.add(zone.latLong26);
        latLongsI.add(zone.latLong27);        latLongsI.add(zone.latLong28);        latLongsI.add(zone.latLong29);
        latLongsI.add(zone.latLong30);        latLongsI.add(zone.latLong31);        latLongsI.add(zone.latLong32);
        latLongsI.add(zone.latLong33);        latLongsI.add(zone.latLong30);        latLongsI.add(zone.latLong34);
        latLongsI.add(zone.latLong35);        latLongsI.add(zone.latLong36);        latLongsI.add(zone.latLong37);
        latLongsI.add(zone.latLong38);        latLongsI.add(zone.latLong39);        latLongsI.add(zone.latLong40);

        latLongsI.add(zone.latLong41);        latLongsI.add(zone.latLong42);        latLongsI.add(zone.latLong43);
        latLongsI.add(zone.latLong44);        latLongsI.add(zone.latLong45);        latLongsI.add(zone.latLong46);
        latLongsI.add(zone.latLong47);        latLongsI.add(zone.latLong48);        latLongsI.add(zone.latLong49);
        latLongsI.add(zone.latLong50);

        latLongsI.add(zone.latLong51);        latLongsI.add(zone.latLong52);        latLongsI.add(zone.latLong53);
        latLongsI.add(zone.latLong54);        latLongsI.add(zone.latLong55);        latLongsI.add(zone.latLong56);
        latLongsI.add(zone.latLong57);        latLongsI.add(zone.latLong58);        latLongsI.add(zone.latLong59);
        latLongsI.add(zone.latLong60);

        latLongsI.add(zone.latLong61);        latLongsI.add(zone.latLong62);        latLongsI.add(zone.latLong63);
        // ***********************************Zona Insegura******************************

        // ***********************************Zona Segura********************************
        latLongsS.add(zone.latLongS1);        latLongsS.add(zone.latLongS2);        latLongsS.add(zone.latLongS3);
        latLongsS.add(zone.latLongS4);        latLongsS.add(zone.latLongS5);        latLongsS.add(zone.latLongS6);
        latLongsS.add(zone.latLongS7);        latLongsS.add(zone.latLongS8);        latLongsS.add(zone.latLongS4);
        latLongsS.add(zone.latLongS9);        latLongsS.add(zone.latLongS10);

        latLongsS.add(zone.latLongS11);        latLongsS.add(zone.latLongS12);        latLongsS.add(zone.latLongS13);
        latLongsS.add(zone.latLongS14);        latLongsS.add(zone.latLongS15);        latLongsS.add(zone.latLongS16);
        latLongsS.add(zone.latLongS17);        latLongsS.add(zone.latLongS18);        latLongsS.add(zone.latLongS19);
        latLongsS.add(zone.latLongS20);

        latLongsS.add(zone.latLongS20);        latLongsS.add(zone.latLongS21);        latLongsS.add(zone.latLongS22);
        latLongsS.add(zone.latLongS23);        latLongsS.add(zone.latLongS24);        latLongsS.add(zone.latLongS25);
        latLongsS.add(zone.latLongS26);        latLongsS.add(zone.latLongS27);        latLongsS.add(zone.latLongS28);
        latLongsS.add(zone.latLongS29);        latLongsS.add(zone.latLongS30);

        latLongsS.add(zone.latLongS31);        latLongsS.add(zone.latLongS32);        latLongsS.add(zone.latLongS33);
        latLongsS.add(zone.latLongS34);        latLongsS.add(zone.latLongS35);        latLongsS.add(zone.latLongS36);
        latLongsS.add(zone.latLongS37);        latLongsS.add(zone.latLongS38);        latLongsS.add(zone.latLongS39);
        latLongsS.add(zone.latLongS40);

        latLongsS.add(zone.latLongS40);        latLongsS.add(zone.latLongS41);        latLongsS.add(zone.latLongS42);
        latLongsS.add(zone.latLongS43);        latLongsS.add(zone.latLongS44);        latLongsS.add(zone.latLongS45);
        latLongsS.add(zone.latLongS46);        latLongsS.add(zone.latLongS47);        latLongsS.add(zone.latLongS48);
        latLongsS.add(zone.latLongS49);        latLongsS.add(zone.latLongS50);

        latLongsS.add(zone.latLongS51);        latLongsS.add(zone.latLongS52);        latLongsS.add(zone.latLongS53);
        latLongsS.add(zone.latLongS54);        latLongsS.add(zone.latLongS55);        latLongsS.add(zone.latLongS56);
        latLongsS.add(zone.latLongS57);        latLongsS.add(zone.latLongS58);        latLongsS.add(zone.latLongS59);
        latLongsS.add(zone.latLongS60);

        latLongsS.add(zone.latLongS60);        latLongsS.add(zone.latLongS61);        latLongsS.add(zone.latLongS62);
        latLongsS.add(zone.latLongS63);        latLongsS.add(zone.latLongS64);        latLongsS.add(zone.latLongS65);
        // ***********************************Zona Segura********************************

        // ***********************************Plan Valpo********************************
        latLongsP.add(zone.latLongPlan1);   latLongsP.add(zone.latLongPlan2);   latLongsP.add(zone.latLongPlan3);
        latLongsP.add(zone.latLongPlan4);   latLongsP.add(zone.latLongPlan5);   latLongsP.add(zone.latLongPlan6);
        latLongsP.add(zone.latLongPlan7);   latLongsP.add(zone.latLongPlan8);   latLongsP.add(zone.latLongPlan9);
        latLongsP.add(zone.latLongPlan10);   latLongsP.add(zone.latLongPlan11);   latLongsP.add(zone.latLongPlan12);
        latLongsP.add(zone.latLongPlan13);   latLongsP.add(zone.latLongPlan14);   latLongsP.add(zone.latLongPlan15);

        latLongsP.add(zone.latLongPlan16);   latLongsP.add(zone.latLongPlan17);   latLongsP.add(zone.latLongPlan18);
        latLongsP.add(zone.latLongPlan19);   latLongsP.add(zone.latLongPlan20);   latLongsP.add(zone.latLongPlan21);
        latLongsP.add(zone.latLongPlan22);   latLongsP.add(zone.latLongPlan23);   latLongsP.add(zone.latLongPlan24);
        latLongsP.add(zone.latLongPlan25);   latLongsP.add(zone.latLongPlan26);   latLongsP.add(zone.latLongPlan27);
        latLongsP.add(zone.latLongPlan28);   latLongsP.add(zone.latLongPlan29);   latLongsP.add(zone.latLongPlan30);

        latLongsP.add(zone.latLongPlan31);   latLongsP.add(zone.latLongPlan32);   latLongsP.add(zone.latLongPlan33);
        latLongsP.add(zone.latLongPlan34);   latLongsP.add(zone.latLongPlan35);   latLongsP.add(zone.latLongPlan36);
        latLongsP.add(zone.latLongPlan37);   latLongsP.add(zone.latLongPlan38);   latLongsP.add(zone.latLongPlan39);
        latLongsP.add(zone.latLongPlan40);   latLongsP.add(zone.latLongPlan41);   latLongsP.add(zone.latLongPlan42);
        latLongsP.add(zone.latLongPlan43);   latLongsP.add(zone.latLongPlan44);   latLongsP.add(zone.latLongPlan45);

        latLongsP.add(zone.latLongPlan46);   latLongsP.add(zone.latLongPlan47);   latLongsP.add(zone.latLongPlan48);
        latLongsP.add(zone.latLongPlan49);   latLongsP.add(zone.latLongPlan50);   latLongsP.add(zone.latLongPlan51);
        latLongsP.add(zone.latLongPlan52);   latLongsP.add(zone.latLongPlan53);   latLongsP.add(zone.latLongPlan54);
        latLongsP.add(zone.latLongPlan55);   latLongsP.add(zone.latLongPlan56);   latLongsP.add(zone.latLongPlan57);
        latLongsP.add(zone.latLongPlan58);   latLongsP.add(zone.latLongPlan59);   latLongsP.add(zone.latLongPlan60);

        latLongsP.add(zone.latLongPlan61);   latLongsP.add(zone.latLongPlan62);   latLongsP.add(zone.latLongPlan63);
        latLongsP.add(zone.latLongPlan64);   latLongsP.add(zone.latLongPlan65);   latLongsP.add(zone.latLongPlan66);
        latLongsP.add(zone.latLongPlan67);   latLongsP.add(zone.latLongPlan68);   latLongsP.add(zone.latLongPlan69);
        latLongsP.add(zone.latLongPlan70);   latLongsP.add(zone.latLongPlan71);   latLongsP.add(zone.latLongPlan72);
        latLongsP.add(zone.latLongPlan73);   latLongsP.add(zone.latLongPlan74);   latLongsP.add(zone.latLongPlan75);

        latLongsP.add(zone.latLongPlan76);   latLongsP.add(zone.latLongPlan77);   latLongsP.add(zone.latLongPlan78);
        latLongsP.add(zone.latLongPlan79);   latLongsP.add(zone.latLongPlan80);   latLongsP.add(zone.latLongPlan81);
        latLongsP.add(zone.latLongPlan82);   latLongsP.add(zone.latLongPlan83);   latLongsP.add(zone.latLongPlan84);
        latLongsP.add(zone.latLongPlan85);   latLongsP.add(zone.latLongPlan86);   latLongsP.add(zone.latLongPlan87);
        latLongsP.add(zone.latLongPlan88);   latLongsP.add(zone.latLongPlan89);   latLongsP.add(zone.latLongPlan90);
        // ***********************************Plan Valpo********************************

        //latLongsRuta.add(zone.latLongPlan64);latLongsRuta.add(zone.latLongPlan50);latLongsRuta.add(zone.latLongPlan39);
        //latLongsRuta.add(zone.latLongPlan15);latLongsRuta.add(zone.latLongS15);

        Log.d(TAG,String.format("*******prueba1******** = %f", prueba));
        retornoRuta = ruta();

        prueba = distancia(zone.latLongS64, zone.latLongS65);
        Log.d(TAG,String.format("*******prueba2 distancia******** = %f", prueba));

        //System.out.println("latlongP = " + latLongP.get(1));

        //se agregan las capas
        mapView.getLayerManager().getLayers().add(this.myLocationOverlay);
        mapView.getLayerManager().getLayers().add(polylineRuta);
        mapView.getLayerManager().getLayers().add(polygonInsecure);
        mapView.getLayerManager().getLayers().add(polygonSecure);


        //mapView.getLayerManager().redrawLayers()
        //mapView.getLayerManager().getLayers().remove(polyline);

    }

    int posPlanCercana;
    int posPlan2Cercana;
    int posPlan3Cercana;
    int posPlan4Cercana;
    int posSeguraCercana;
    int retornoRuta = 0;
    double prueba = 0.0;

    LatLong latLongDummy;

    double min = 0.0;
    double dist = 0.0;

    protected LatLong latLongCenter = mapViewPosition.getCenter(); //this.mapView.getModel().mapViewPosition.getCenter(); //mapViewPosition.getCenter();


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        myLocationOverlay.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.myLocationOverlay.setMinDistance(2.0f);
        //this.myLocationOverlay.setMinTime(1);
        this.myLocationOverlay.enableMyLocation(true);
    }

    @Override
    protected void onStop() {
        myLocationOverlay.disableMyLocation();
        super.onStop();
    }

    public synchronized Location getLastLocation() {
        Log.d(TAG,"***********entro en LocationOverlayMapviewer getlastlocation************");
        lastLocation = myLocationOverlay.getLastLocation();
        //this.locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

        Log.d(TAG,"***********retorno de Mylocationoverlay getLastLocation************");
        System.out.println(lastLocation);
        return lastLocation;
    }

    public synchronized void getCentro(){
        Log.d(TAG,"***********entro en LocationOverlayMapviewer getCenter************");
        latLongCenter = this.mapView.getModel().mapViewPosition.getCenter();
        System.out.println("******* LatLongCenter********"+latLongCenter);

        Log.d(TAG,"***********retorno de Mapviewposition getCenter************");
        //return latLongCenter;
    }

    public int ruta(){

        getCentro();

        min = 0.0;
        dist = 0.0;
        //se obtiene la posicion latLongsP mas cercana a la posicion del usuario
        for (int i=0;i<latLongsP.size();i++) {
            Log.d(TAG,String.format("*******drawing for1******** = %f", latLongsP.get(i).longitude));

            dist = distancia(latLongCenter, latLongsP.get(i));
            if(min==0.0)min=dist;
            if(dist<min){
                min=dist;
                posPlanCercana = i;
            }
        }

        min = 0.0;
        dist = 0.0;
        //busca la posicion segura mas cercana a la posicion más cercana del usuario
        for (int j=0;j<latLongsS.size();j++){
            dist = distancia(latLongsP.get(posPlanCercana), latLongsS.get(j));
            if(min==0.0)min=dist;
            if(dist<min) {
                min = dist;
                posSeguraCercana = j;
            }
        }
        latLongDummy = latLongsS.get(posSeguraCercana);
        //latLongsRuta.add(latLongDummy);

        // latLongsRuta.add(zone.latLongPlan64)
        latLongsRuta.add(latLongCenter);
        latLongsRuta.add(latLongsP.get(posPlanCercana));

        latLongsRuta.add(latLongsS.get(posSeguraCercana));

        //buscaPosiciones();

        Log.d(TAG,String.format("*******drawing2******** = %f", dist));
        return 1;
    }

    public void buscaPosiciones(){

        min = 0.0;
        dist = 0.0;
        //while(latLongDummy!=latLongsP.get(posPlanCercana)) {
            //busca la posicion del plan mas cercana a la posicion dummy
            for (int k = 0; k < latLongsP.size(); k++) {
                dist = distancia(latLongDummy, latLongsP.get(k));
                if (min == 0) min = dist;
                if (dist < min) {
                    min = dist;
                    posPlan2Cercana = k;
                }
            }

            min = 0.0;
            dist = 0.0;
            //busca la 2da posicion mas cercana del plan a la posicion dummy
            for (int l = 0; l < latLongsP.size(); l++) {
                if (l != posPlan2Cercana) {
                    dist = distancia(latLongDummy, latLongsP.get(l));
                    if (min == 0) min = dist;
                    if (dist < min) {
                        min = dist;
                        posPlan3Cercana = l;
                    }
                }
            }

            min = 0.0;
            dist = 0.0;
            //busca la 3ra posicion mas cercana del plan a la posicion dummy
            for (int m = 0; m < latLongsP.size(); m++) {
                if (m != posPlan2Cercana && m != posSeguraCercana) {
                    dist = distancia(latLongDummy, latLongsP.get(m));
                    if (min == 0) min = dist;
                    if (dist < min) {
                        min = dist;
                        posPlan4Cercana = m;
                    }
                }
            }

            //determina entre las 3 posiciones encontradas, la mas cercacana a la posPlanCercana
            min = 0.0;
            dist = 0.0;
            dist = distancia(latLongsP.get(posPlanCercana), latLongsP.get(posPlan2Cercana));
            if (min == 0) min = dist;
            if (dist < min) {
                min = dist;
                latLongDummy = latLongsP.get(posPlan2Cercana);
            }
            dist = distancia(latLongsP.get(posPlanCercana), latLongsP.get(posPlan3Cercana));
            if (min == 0) min = dist;
            if (dist < min) {
                min = dist;
                latLongDummy = latLongsP.get(posPlan3Cercana);
            }
            dist = distancia(latLongsP.get(posPlanCercana), latLongsP.get(posPlan3Cercana));
            if (min == 0) min = dist;
            if (dist < min) {
                min = dist;
                latLongDummy = latLongsP.get(posPlan4Cercana);
            }

            //latLongsRuta.add(latLongDummy);

        //}
        //latLongsRuta.add(latLongsS.get(posPlanCercana));
        //latLongsRuta.add(latLongCenter);

    }

    public double distancia(LatLong pActual, LatLong pos){
        double distancia = 0.0;
        distancia = Math.hypot((-pActual.longitude) - (-pos.longitude), (-pActual.latitude) - (-pos.latitude));
//        Log.d(TAG, + Double.toString(latlong3));
        Log.d(TAG,String.format("*******distancia******** = %f", distancia));
        return distancia;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
