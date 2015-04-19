package andreacornaglia.net.foodpyramid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;


public class DashboardActivity extends ActionBarActivity {

    android.support.v7.widget.CardView cardPyramid;
    android.support.v7.widget.CardView cardStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cardPyramid = (android.support.v7.widget.CardView) findViewById(R.id.cardPyramid);
        cardPyramid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, AddFoodActivity.class);
                startActivity(intent);
            }
        });

        cardStats = (android.support.v7.widget.CardView) findViewById(R.id.cardStats);
        cardStats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                barGraphHandler(view);
            }
        });
    }

    public void barGraphHandler(View v){
        BarGraph bargraph = new BarGraph();
        Intent barintent = bargraph.getIntent(this);
        startActivity(barintent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
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
