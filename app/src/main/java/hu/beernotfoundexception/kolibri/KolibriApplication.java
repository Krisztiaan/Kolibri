package hu.beernotfoundexception.kolibri;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import com.parrot.freeflight.settings.ApplicationSettings;

/**
 * Created by krisz on 2/28/2016.
 */
public class KolibriApplication extends Application {

    private static final String TAG = KolibriApplication.class.getSimpleName();

    private ApplicationSettings settings;

    static {
        System.loadLibrary("avutil");
        System.loadLibrary("swscale");
        System.loadLibrary("avcodec");
        System.loadLibrary("avfilter");
        System.loadLibrary("avformat");
        System.loadLibrary("avdevice");
        System.loadLibrary("adfreeflight");
    }

    @SuppressLint("NewApi")
    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d(TAG, "OnCreate");

        settings = new ApplicationSettings(this);
    }


    @Override
    public void onTerminate()
    {
        Log.d(TAG, "OnTerminate");
        super.onTerminate();
    }


    public ApplicationSettings getAppSettings()
    {
        return settings;
    }
}
