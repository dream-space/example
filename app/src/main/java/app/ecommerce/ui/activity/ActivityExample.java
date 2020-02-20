package app.ecommerce.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.ecommerce.ui.R;
import app.ecommerce.ui.adapter.ExampleAdapter;
import app.ecommerce.ui.data.DataGenerator;
import app.ecommerce.ui.model.ExampleProduct;
import app.ecommerce.ui.utils.Tools;

/**
 * Activity hanya extend ke AppCompatActivity
 */
public class ActivityExample extends AppCompatActivity {

    // nama variable view lowercase underscore
    RecyclerView recycler_view;
    ExampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);

        initToolbar();
        initComponent();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        //change menu button color
        Tools.changeNavigationIconColor(toolbar, getResources().getColor(R.color.grey_60));
        //change overflow menu button color
        Tools.changeOverflowMenuIconColor(toolbar, getResources().getColor(R.color.grey_60));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Products");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.grey_5);
        Tools.setSystemBarLight(this);
    }

    private void initComponent() {
        // define recycler view
        recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setHasFixedSize(true);
        recycler_view.setNestedScrollingEnabled(false);

        List<ExampleProduct> items = DataGenerator.getProducts(this);
        items.addAll(DataGenerator.getProducts(this));
        items.addAll(DataGenerator.getProducts(this));
        items.addAll(DataGenerator.getProducts(this));

        //set data and list adapter
        adapter = new ExampleAdapter(this, items);
        recycler_view.setAdapter(adapter);

        // on item list clicked
        adapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ExampleProduct obj, int position) {
                Toast.makeText(getApplicationContext(), "Item " + obj.title + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);
        Tools.changeMenuIconColor(menu, getResources().getColor(R.color.grey_60));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
