package hu.beernotfoundexception.kolibri;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.beernotfoundexception.kolibri.adapter.MediaRecyclerAdapter;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.imgCamera)
    protected ImageView imgCamera;

    @Bind(R.id.recDashboardList)
    protected RecyclerView recDashboardList;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    @OnClick(R.id.imgCamera)
    protected void onCameraClick() {
        showIntro();
    }

    MediaRecyclerAdapter mMediaRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences settings = this.getSharedPreferences("appInfo", MODE_PRIVATE);
        boolean loggedIn = settings.getBoolean("logged_in", false);
        if (!loggedIn) {
            showIntro();
        }

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        FakeDataProvider.init(this);

        // TODO: 2/28/2016 replace with real data
        mMediaRecyclerAdapter = new MediaRecyclerAdapter(FakeDataProvider.getSomeMediaElements(5));

        recDashboardList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recDashboardList.setAdapter(mMediaRecyclerAdapter);

        mMediaRecyclerAdapter.notifyDataSetChanged();
    }

    private void showIntro() {
        startActivity(new Intent(this, IntroActivity.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
