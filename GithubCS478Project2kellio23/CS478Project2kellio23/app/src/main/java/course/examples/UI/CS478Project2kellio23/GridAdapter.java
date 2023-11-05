package course.examples.UI.CS478Project2kellio23;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

// GridAdapter takes in an arrayList of aItems which hold the id and the name. Then it inflates
// the view and adds the relevant name and picture for each animal in the arrayList
public class GridAdapter extends ArrayAdapter {

    ArrayList aList = new ArrayList<>();
    private static final int PADDING = 8; // 8
    private static final int WIDTH = 400; // 400
    private static final int HEIGHT = 400; // 400
    private Context mContext;

    public GridAdapter(Context context, int text, ArrayList animals) {

        super(context, text, animals);
        aList = animals;
    }

    @Override
    public int getCount() {
        return aList.size();
    }

    @Override
    public Object getItem(int position) {
        return aList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (((aItem)aList.get(position)).getAnimalImage());
    }

    // responsible for setting up both the picture and the text under it
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_items, null);

            TextView textView = (TextView) view.findViewById(R.id.textView);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

            textView.setText(((aItem) aList.get(position)).getAnimalName());
            imageView.setImageResource(((aItem) aList.get(position)).getAnimalImage());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        }
        return view;
    }
}
