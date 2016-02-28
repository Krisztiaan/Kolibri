package hu.beernotfoundexception.kolibri;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import hu.beernotfoundexception.kolibri.data.MediaElement;
import hu.beernotfoundexception.kolibri.data.SimpleImageElement;

public class FakeDataProvider {

    private static Context mContext;

    public static void init(Context c) {
        mContext = c;
    }

    public static Collection<MediaElement> getSomeMediaElements(final int howmany) {
        return new ArrayList<MediaElement>() {
            {
                for (int i = 0; i < howmany; i++) {
                    add(getRandomMediaElement());
                }
            }
        };
    }

    public static MediaElement getRandomMediaElement() {
        return new SimpleImageElement(getRandomBitmap(), getRandomAwesomeString());
    }

    public static Bitmap getRandomBitmap() {
        return BitmapFactory.decodeResource(mContext.getResources(),
                R.drawable.background_hungary);
    }

    public static String getRandomAwesomeString() {
        switch (new Random().nextInt(4)) {
            case 0:
                return "I love you";
            case 1:
                return "Bee gooood";
            case 2:
                return "You me gusta!";
            case 3:
                return "Give me more :)";
            default:
                return "I'm an Droid!";
        }
    }
}
