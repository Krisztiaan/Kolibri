package hu.beernotfoundexception.kolibri.data;

import android.graphics.Bitmap;

/**
 * Created by krisz on 2/28/2016.
 */
public class SimpleImageElement extends MediaElement {

    public final Bitmap picture;

    public final String text;

    public SimpleImageElement(Bitmap picture, String text) {
        this.picture = picture;
        this.text = text;
    }
}
