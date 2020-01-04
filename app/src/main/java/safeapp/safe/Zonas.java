package safeapp.safe;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.Toast;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.FillRule;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.layer.overlay.Polygon;
import org.mapsforge.map.layer.overlay.Polyline;

import java.util.List;

import safeapp.safe.LocationOverlayMapViewer;

import safeapp.safe.Zonas;
/**
 * Created by Luis on 18-08-2016.
 */
public class Zonas extends DownloadLayerViewer{

    //        ****************************PERIMETRO ZONA INSEGURA************************************
    protected LatLong latLong1 = new LatLong(-33.049299,-71.603015); protected LatLong latLong2 = new LatLong(-33.049033,-71.602098);
    protected LatLong latLong3 = new LatLong(-33.048589,-71.602613); protected LatLong latLong4 = new LatLong(-33.048135,-71.602802);
    protected LatLong latLong5 = new LatLong(-33.04681,-71.603028); protected LatLong latLong6 = new LatLong(-33.046425,-71.603091);
    protected LatLong latLong7 = new LatLong(-33.046067,-71.603154); protected LatLong latLong8 = new LatLong(-33.045696,-71.603209);
    protected LatLong latLong9 = new LatLong(-33.044759,-71.603613); protected LatLong latLong10 = new LatLong(-33.04213,-71.604781);

    protected LatLong latLong11 = new LatLong(-33.043186,-71.605248); protected LatLong latLong12 = new LatLong(-33.040288,-71.606583);
    protected LatLong latLong13 = new LatLong(-33.04104,-71.609225); protected LatLong latLong14 = new LatLong(-33.041338,-71.619519);
    protected LatLong latLong15 = new LatLong(-33.037651,-71.624261); protected LatLong latLong16 = new LatLong(-33.032938,-71.625527);
    protected LatLong latLong17 = new LatLong(-33.033874,-71.62979); protected LatLong latLong18 = new LatLong(-33.034218,-71.630351);
    protected LatLong latLong19 = new LatLong(-33.035296,-71.630429); protected LatLong latLong20 = new LatLong(-33.035656,-71.630378);

    protected LatLong latLong21 = new LatLong(-33.03619,-71.630187); protected LatLong latLong22 = new LatLong(-33.036516,-71.630015);
    protected LatLong latLong23 = new LatLong(-33.036836,-71.629878); protected LatLong latLong24 = new LatLong(-33.037179,-71.629703);
    protected LatLong latLong25 = new LatLong(-33.037564,-71.629547); protected LatLong latLong26 = new LatLong(-33.036834,-71.629102);
    protected LatLong latLong27 = new LatLong(-33.03854,-71.629468); protected LatLong latLong28 = new LatLong(-33.039083,-71.629136);
    protected LatLong latLong29 = new LatLong(-33.039216,-71.629059); protected LatLong latLong30 = new LatLong(-33.039689,-71.628324);

    protected LatLong latLong31 = new LatLong(-33.04021,-71.627464); protected LatLong latLong32 = new LatLong(-33.040671,-71.626351);
    protected LatLong latLong33 = new LatLong(-33.040723,-71.626092); protected LatLong latLong34 = new LatLong(-33.041198,-71.625467);
    protected LatLong latLong35 = new LatLong(-33.041295,-71.625354); protected LatLong latLong36 = new LatLong(-33.042087,-71.624787);
    protected LatLong latLong37 = new LatLong(-33.043145,-71.624766); protected LatLong latLong38 = new LatLong(-33.043503,-71.624515);
    protected LatLong latLong39 = new LatLong(-33.043259,-71.624205); protected LatLong latLong40 = new LatLong(-33.044083,-71.623111);

    protected LatLong latLong41 = new LatLong(-33.044437,-71.622176); protected LatLong latLong42 = new LatLong(-33.044885,-71.62089);
    protected LatLong latLong43 = new LatLong(-33.04502,-71.620245); protected LatLong latLong44 = new LatLong(-33.045086,-71.619911);
    protected LatLong latLong45 = new LatLong(-33.045207,-71.61896); protected LatLong latLong46 = new LatLong(-33.045362,-71.617941);
    protected LatLong latLong47 = new LatLong(-33.046014,-71.618047); protected LatLong latLong48 = new LatLong(-33.046036,-71.616966);
    protected LatLong latLong49 = new LatLong(-33.046053,-71.616017); protected LatLong latLong50 = new LatLong(-33.046109,-71.614639);

    protected LatLong latLong51 = new LatLong(-33.046155,-71.61315); protected LatLong latLong52 = new LatLong(-33.046206,-71.612455);
    protected LatLong latLong53 = new LatLong(-33.047374,-71.611025); protected LatLong latLong54 = new LatLong(-33.047406,-71.609831);
    protected LatLong latLong55 = new LatLong(-33.047418,-71.609054); protected LatLong latLong56 = new LatLong(-33.047453,-71.608202);
    protected LatLong latLong57 = new LatLong(-33.047396,-71.606836); protected LatLong latLong58 = new LatLong(-33.048828,-71.606586);
    protected LatLong latLong59 = new LatLong(-33.049134,-71.605196); protected LatLong latLong60 = new LatLong(-33.049629,-71.604397);

    protected LatLong latLong61 = new LatLong(-33.049208,-71.603549); protected LatLong latLong62 = new LatLong(-33.049087,-71.60313);
    protected LatLong latLong63 = new LatLong(-33.049299,-71.603015);


    //        ****************************PERIMETRO ZONA INSEGURA************************************

    //        ****************************PERIMETRO ZONA SEGURA************************************
    protected LatLong latLongS1 = new LatLong(-33.0519,-71.602389);//colon/arg
    protected LatLong latLongS2 = new LatLong(-33.051673,-71.603647);//colon/canciani
    protected LatLong latLongS3 = new LatLong(-33.051574,-71.603956);//colon/rondizzoni
    protected LatLong latLongS4 = new LatLong(-33.051555,-71.604019);//colon/yelcho
    protected LatLong latLongS5 = new LatLong(-33.051279,-71.605245);//colon rancagua
    protected LatLong latLongS6 = new LatLong(-33.051112,-71.605587);///colon juana ross
    protected LatLong latLongS7 = new LatLong(-33.050999,-71.606294);//colon/chacon
    protected LatLong latLongS8 = new LatLong(-33.050913,-71.606692);//colon/barroso
    protected LatLong latLongS9 = new LatLong(-33.050751,-71.607367);//colon/retamo
    protected LatLong latLongS10 = new LatLong(-33.050528,-71.608523);//colon/uruguay

    protected LatLong latLongS11 = new LatLong(-33.050397,-71.609193);  //colon/morris
    protected LatLong latLongS12 = new LatLong(-33.050223,-71.610141);  //colon/simon bolivar
    protected LatLong latLongS13 = new LatLong(-33.050038,-71.6113);    //colon////san ignacio
    protected LatLong latLongS14 = new LatLong(-33.049736,-71.612953);  //colon/francia
    protected LatLong latLongS15 = new LatLong(-33.049515,-71.613901);  //colon/gral cruz
    protected LatLong latLongS16 = new LatLong(-33.049419,-71.614535);  //colon/fco vergara
    protected LatLong latLongS17 = new LatLong(-33.049321,-71.615086);  //colon/freire
    protected LatLong latLongS18 = new LatLong(-33.049053,-71.61644);   //colon/rodriguez
    protected LatLong latLongS19 = new LatLong(-33.048757,-71.617454); //colon/aguada
    protected LatLong latLongS20 = new LatLong(-33.048684,-71.617672);  //colon/Las heras

    protected LatLong latLongS21 = new LatLong(-33.04848,-71.618342);   //COLON/BUENOS AIRES
    protected LatLong latLongS22 = new LatLong(-33.048298,-71.619012);  //COLON/CARRERA
    protected LatLong latLongS23 = new LatLong(-33.047725,-71.619961);  //COLON/EdWARdS
    protected LatLong latLongS24 = new LatLong(-33.047521,-71.620374);  //COLON/LIRA
    protected LatLong latLongS25 = new LatLong(-33.047425,-71.620626);  //aldunate/molina
    protected LatLong latLongS26 = new LatLong(-33.047124,-71.621417); //ALUNate/HUITO
    protected LatLong latLongS27 = new LatLong(-33.046406,-71.620927); //condell/huito
    protected LatLong latLongS28 = new LatLong(-33.046068,-71.621685);   //condell/eleuterio ramirez
    protected LatLong latLongS29 = new LatLong(-33.045258,-71.622829);  //condell/pudeto
    protected LatLong latLongS30 = new LatLong(-33.04486,-71.623665);   //CONELL/BELLAVISTA

    protected LatLong latLongS31 = new LatLong(-33.043278,-71.625135);  //alte mont/cumming
    protected LatLong latLongS32 = new LatLong(-33.041214,-71.625491);  //esmeralda/subida concepcion
    protected LatLong latLongS33 = new LatLong(-33.040247,-71.62749);   //urriola/prat
    protected LatLong latLongS34 = new LatLong(-33.039342,-71.629345);  //tomas ramos/prat
    protected LatLong latLongS35 = new LatLong(-33.038531,-71.629478);  //serrano/sotomayor
    protected LatLong latLongS36 = new LatLong(-33.037763,-71.629962);  //serrano/cienfuegos
    protected LatLong latLongS37 = new LatLong(-33.037684,-71.629989);  //serrano/almte muñoz
    protected LatLong latLongS38 = new LatLong(-33.037315,-71.630184);  //serrano/goñi
    protected LatLong latLongS39 = new LatLong(-33.036962,-71.630337);  //serrano/alte perez gacitua
    protected LatLong latLongS40 = new LatLong(-33.036686,-71.630493);  //serrano/clave

    protected LatLong latLongS41 = new LatLong(-33.036362,-71.630634);  //bustamante/san martin
    protected LatLong latLongS42 = new LatLong(-33.03604,-71.630746);   //bustamante/matriz
    protected LatLong latLongS43 = new LatLong(-33.035751,-71.63075);   //bustamante valdivia
    protected LatLong latLongS44 = new LatLong(-33.035352,-71.630781);  //bustamante/marquez
    protected LatLong latLongS45 = new LatLong(-33.034168,-71.630624);  //bustamante/CArampamgue
    protected LatLong latLongS46 = new LatLong(-33.031915,-71.629988);  //salida camiones
    protected LatLong latLongS47 = new LatLong(-33.030571,-71.629239);  //subida taqueadero
    protected LatLong latLongS48 = new LatLong(-33.0225523,-71.633493); //guillermo lawrence
    protected LatLong latLongS49 = new LatLong(-33.021983,-71.634283);  //parque
    protected LatLong latLongS50 = new LatLong(-33.019064,-71.640713);  //subida leopoldo carvallo

    protected LatLong latLongS51 = new LatLong(-33.023005,-71.642894);  //subida torpederas
    protected LatLong latLongS52 = new LatLong(-33.024286,-71.643704);  //subida cementerio
    protected LatLong latLongS53 = new LatLong(-33.046219,-71.654905);  //camino la polvore/las animas
    protected LatLong latLongS54 = new LatLong(-33.056957,-71.589537);  //hospital edo pereira
    protected LatLong latLongS55 = new LatLong(-33.037899,-71.598504);  //portales/yolanda
    protected LatLong latLongS56 = new LatLong(-33.044281,-71.603772);  //portales/petrarca
    protected LatLong latLongS57 = new LatLong(-33.045669,-71.603071);  //lillo/////alfaro
    protected LatLong latLongS58 = new LatLong(-33.046416,-71.603);     //lillo/reyna
    protected LatLong latLongS59 = new LatLong(-33.048118,-71.602696);  //lillo/san jose
    protected LatLong latLongS60 = new LatLong(-33.048554,-71.60245);   //lillo/zenteno

    protected LatLong latLongS61 = new LatLong(-33.049013,-71.602057);  //progreso/sarmientro
    protected LatLong latLongS62 = new LatLong(-33.05115,-71.602257);  //arg/alte simpson
    protected LatLong latLongS63 = new LatLong(-33.053083,-71.601285);  //copec arg
    protected LatLong latLongS64 = new LatLong(-33.052609,-71.601853);  //arg/sta elena
    protected LatLong latLongS65 = new LatLong(-33.05181,-71.602464);   //colon/arg


    //        ****************************PERIMETRO ZONA SEGURA************************************


    //        **************************** INTERIOR ZONA INSEGURA************************************

    //        **************************** PLAN VALPO************************************
    protected LatLong latLongPlan1 = new LatLong(-33.04348,-71.605707);   //errazuriz/arg
    protected LatLong latLongPlan2 = new LatLong(-33.043991,-71.605589);   //errazuriz/arg
    protected LatLong latLongPlan3 = new LatLong(-33.044249,-71.605482);   //errazuriz/arg
    protected LatLong latLongPlan4 = new LatLong(-33.051237,-71.602644);   //indep/arg
    protected LatLong latLongPlan5 = new LatLong(-33.050942,-71.603943);   //errazuriz/arg
    protected LatLong latLongPlan6 = new LatLong(-33.050688,-71.605035);   //indep/rgua
    protected LatLong latLongPlan7 = new LatLong(-33.050542,-71.605692);   //indep/juana ross
    protected LatLong latLongPlan8 = new LatLong(-33.05032,-71.606588);   //indep/barroso
    protected LatLong latLongPlan9 = new LatLong(-33.050162,-71.607232);   //indep/retamo
    protected LatLong latLongPlan10 = new LatLong(-33.049859,-71.608439);   //indep/uruguay

    protected LatLong latLongPlan11 = new LatLong(-33.049688,-71.609166);   //indep/morris
    protected LatLong latLongPlan12 = new LatLong(-33.049513,-71.609903);   //indep/simonbolivar
    protected LatLong latLongPlan13 = new LatLong(-33.049178,-71.611236);   //indep/sanignacio
    protected LatLong latLongPlan14 = new LatLong(-33.048789,-71.612875);   //indep/francia
    protected LatLong latLongPlan15 = new LatLong(-33.048598,-71.613677);   //indep/gral cruz
    protected LatLong latLongPlan16 = new LatLong(-33.048454,-71.614337);   //indep/fco vergara valdes
    protected LatLong latLongPlan17 = new LatLong(-33.048272,-71.614935);   //indep/freire
    protected LatLong latLongPlan18 = new LatLong(-33.047922,-71.616255);   //indep/rodriguez
    protected LatLong latLongPlan19 = new LatLong(-33.047616,-71.617244);   //indep/lasheras
    protected LatLong latLongPlan20 = new LatLong(-33.047434,-71.617778);   //indep/buenos aires

    protected LatLong latLongPlan21 = new LatLong(-33.047209,-71.618594);   //indep/carrera
    protected LatLong latLongPlan22 = new LatLong(-33.046797,-71.619586);   //indep/edwards
    protected LatLong latLongPlan23 = new LatLong(-33.04666,-71.620074);   //condell/lira
    protected LatLong latLongPlan24 = new LatLong(-33.046584,-71.620353);   //condell/molina
    protected LatLong latLongPlan25 = new LatLong(-33.046393,-71.620914);   //condell/huito
    protected LatLong latLongPlan26 = new LatLong(-33.046064,-71.621678);   //condell/eleuterio ramirez
    protected LatLong latLongPlan27 = new LatLong(-33.045266,-71.622826);   //condell/pudeto
    protected LatLong latLongPlan28 = new LatLong(-33.044866,-71.623663);   //condell/ecuador
    protected LatLong latLongPlan29 = new LatLong(-33.050734,-71.602844);   //victoria/arg
    protected LatLong latLongPlan30 = new LatLong(-33.049628,-71.604394);   //victoria/rgua

    protected LatLong latLongPlan31 = new LatLong(-33.049138,-71.605201);   //victoria/juana ross
    protected LatLong latLongPlan32 = new LatLong(-33.04883,-71.606572);   //victoria/rawson
    protected LatLong latLongPlan33 = new LatLong(-33.04878,-71.606945);   //victoria/retamo
    protected LatLong latLongPlan34 = new LatLong(-33.048704,-71.608342);   //victoria/uruguay
    protected LatLong latLongPlan35 = new LatLong(-33.048637,-71.609112);   //victoria/morris
    protected LatLong latLongPlan36 = new LatLong(-33.048569,-71.609828);   //victoria/simonbolivar
    protected LatLong latLongPlan37 = new LatLong(-33.048268,-71.611124);   //victoria/sanignacio
    protected LatLong latLongPlan38 = new LatLong(-33.047712,-71.612803);   //victoria/francia
    protected LatLong latLongPlan39 = new LatLong(-33.047492,-71.613417);   //victoria/gralcruz
    protected LatLong latLongPlan40 = new LatLong(-33.0047175,-71.61401);   //victoria/pedromontt

    protected LatLong latLongPlan41 = new LatLong(-33.046868,-71.603532);   //pmontt/prieto
    protected LatLong latLongPlan42 = new LatLong(-33.046952,-71.604276);   //pmontt/arg
    protected LatLong latLongPlan43 = new LatLong(-33.047073,-71.604802);   //pmontt/12febr
    protected LatLong latLongPlan44 = new LatLong(-33.04739,-71.606835);   //pmontt/rawson
    protected LatLong latLongPlan45 = new LatLong(-33.047462,-71.608197);   //pmontt/uruguay
    protected LatLong latLongPlan46 = new LatLong(-33.047433,-71.609056);   //pmontt/morris
    protected LatLong latLongPlan47 = new LatLong(-33.047404,-71.609828);   //simonbolivar
    protected LatLong latLongPlan48 = new LatLong(-33.047381,-71.611016);   //pmontt/sanignacio
    protected LatLong latLongPlan49 = new LatLong(-33.047289,-71.612752);   //pmontt/francia
    protected LatLong latLongPlan50 = new LatLong(-33.047221,-71.613371);   //pmontt/gralcruz

    protected LatLong latLongPlan51 = new LatLong(-33.047087,-71.614793);   //pmontt/freire
    protected LatLong latLongPlan52 = new LatLong(-33.046988,-71.616139);   //pmontt/rodriguez
    protected LatLong latLongPlan53 = new LatLong(-33.046862,-71.617086);   //pmontt/lasheras
    protected LatLong latLongPlan54 = new LatLong(-33.046747,-71.618425);   //pmontt/carrera
    protected LatLong latLongPlan55 = new LatLong(-33.046516,-71.619473);   //pmontt/edwards
    protected LatLong latLongPlan56 = new LatLong(-33.045987,-71.604662);   //chacabuco/arg
    protected LatLong latLongPlan57 = new LatLong(-33.046172,-71.605427);   //chacabuco/12febrero
    protected LatLong latLongPlan58 = new LatLong(-33.04636,-71.607031);   //chacabuco/rawson
    protected LatLong latLongPlan59 = new LatLong(-33.04632,-71.608114);   //chacabuco/uruguay
    protected LatLong latLongPlan60 = new LatLong(-33.046313,-71.608991);   //chacabuco/morris

    protected LatLong latLongPlan61 = new LatLong(-33.046284,-71.609866);   //chacabuco/simonbolivar
    protected LatLong latLongPlan62 = new LatLong(-33.046203,-71.61085);   //chacabuco/saniganacio
    protected LatLong latLongPlan63 = new LatLong(-33.046212,-71.612441);   //chacabuco/francia
    protected LatLong latLongPlan64 = new LatLong(-33.046154,-71.613143);   //chacabuco/gralcruz
    protected LatLong latLongPlan65 = new LatLong(-33.046111,-71.614624);   //chacabuco/freire
    protected LatLong latLongPlan66 = new LatLong(-33.046061,-71.616021);   //chacabuco/rodriguez
    protected LatLong latLongPlan67 = new LatLong(-33.046032,-71.61696);   //chacabuco/lasheras
    protected LatLong latLongPlan68 = new LatLong(-33.046014,-71.618057);   //chacabuco/carrera
    protected LatLong latLongPlan69 = new LatLong(-33.045992,-71.619337);   //chacabuco/edwards
    protected LatLong latLongPlan70 = new LatLong(-33.04581,-71.620187);   //chacabuco/molina

    protected LatLong latLongPlan71 = new LatLong(-33.045187,-71.604912);   //yungay/quillota
    protected LatLong latLongPlan72 = new LatLong(-33.045508,-71.60581);   //yungay/12febrero
    protected LatLong latLongPlan73 = new LatLong(-33.04565,-71.607122);   //yungay/rawson
    protected LatLong latLongPlan74 = new LatLong(-33.045668,-71.608066);   //yungay/uruguay
    protected LatLong latLongPlan75 = new LatLong(-33.045695,-71.608916);   //yungay/morris
    protected LatLong latLongPlan76 = new LatLong(-33.045688,-71.609842);   //yungay/simonbolivar
    protected LatLong latLongPlan77 = new LatLong(-33.045652,-71.610807);   //yungay/sanignacio
    protected LatLong latLongPlan78 = new LatLong(-33.045605,-71.612266);   //yungay/francia
    protected LatLong latLongPlan79 = new LatLong(-33.045598,-71.613023);   //yungay/gralcruz
    protected LatLong latLongPlan80 = new LatLong(-33.045551,-71.61457);   //yungay/freire

    protected LatLong latLongPlan81 = new LatLong(-33.045472,-71.616874);   //yungay/lasheras
    protected LatLong latLongPlan82 = new LatLong(-33.045355,-71.617939);   //yungay/carrera
    protected LatLong latLongPlan83 = new LatLong(-33.045214,-71.618966);   //yungay/edwards
    protected LatLong latLongPlan84 = new LatLong(-33.045088,-71.619905);   //yungay/molina
    protected LatLong latLongPlan85 = new LatLong(-33.045023,-71.620259);   //yungay/huito
    protected LatLong latLongPlan86 = new LatLong(-33.044937,-71.620683);   //yungay/brasil
    protected LatLong latLongPlan87 = new LatLong(-33.044247,-71.605923);   //brasil/manterola
    protected LatLong latLongPlan88 = new LatLong(-33.044413,-71.606339);   //brasil/12febrero
    protected LatLong latLongPlan89 = new LatLong(-33.044548,-71.606701);   //brasil/drmontt
    protected LatLong latLongPlan90 = new LatLong(-33.044692,-71.607167);   //brasil/rawson

    protected LatLong latLongPlan91 = new LatLong(-33.044249,-71.605482);   //errazuriz/arg
    protected LatLong latLongPlan92 = new LatLong(-33.044249,-71.605482);   //errazuriz/arg
}
