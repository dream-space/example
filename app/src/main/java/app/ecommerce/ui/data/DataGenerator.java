package app.ecommerce.ui.data;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import app.ecommerce.ui.R;
import app.ecommerce.ui.model.ExampleProduct;

@SuppressWarnings("ResourceType")
public class DataGenerator {

    /**
     * Generate dummy data shopping product
     *
     * @param ctx android context
     * @return list of object
     */
    public static List<ExampleProduct> getProducts(Context ctx) {
        List<ExampleProduct> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.product_image);
        String title_arr[] = ctx.getResources().getStringArray(R.array.product_title);
        String price_arr[] = ctx.getResources().getStringArray(R.array.product_price);
        for (int i = 0; i < drw_arr.length(); i++) {
            ExampleProduct obj = new ExampleProduct();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.title = title_arr[i];
            obj.price = price_arr[i];
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        return items;
    }
}
