package space_funexp.github.com.funex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import org.osmdroid.DefaultResourceProxyImpl;
import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;

import java.util.ArrayList;
import java.util.Collection;

import space_funexp.github.com.funex.model.SignificantArea;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(13);
        GeoPoint startPoint = new GeoPoint(58.3738398, 15.6265607);
        mapController.setCenter(startPoint);

        Context context = getBaseContext();
        CompassOverlay compassOverlay = new CompassOverlay(context, new InternalCompassOrientationProvider(context), map);
        map.getOverlays().add(compassOverlay);

        //this.mLocationOverlay = new MyLocationNewOverlay(context, new GpsMyLocationProvider(context),mMapView);
        //mMapView.getOverlays().add(this.mLocationOverlay);
        addSignificantAreaOverlay(getBaseContext());
    }

    void addSignificantAreaOverlay(final Context context) {
        MapView map = (MapView) findViewById(R.id.map);

        ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();


        for (SignificantArea area : SignificantArea.getSamples()) {
            GeoPoint p = new GeoPoint(area.getLongitude(), area.getLatitude());
            OverlayItem item = new OverlayItem(area.getName(), area.getDescription(), p);
            items.add(item);
        }

        DefaultResourceProxyImpl proxy = new DefaultResourceProxyImpl(getApplicationContext());

        ItemizedOverlayWithFocus<OverlayItem> overlay = new ItemizedOverlayWithFocus<OverlayItem>(items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index, final OverlayItem item) {
                        //do something
                        return true;
                    }

                    @Override
                    public boolean onItemLongPress(final int index, final OverlayItem item) {
                        Intent intent = new Intent(context, SignificantAreaActivity.class);
                        startActivity(intent);
                        return true;
                    }
                }, proxy);

        overlay.setFocusItemsOnTap(true);
        map.getOverlays().add(overlay);
    }
}
