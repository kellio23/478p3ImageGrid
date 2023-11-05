//package course.examples.UI.GridLayout;
// CS 478 Project 2 Prof Ugo Buy
// Kevin Elliott kellio23
// Animal Grid
// This project is based off of the grid starter code provided by professor Buy
// On startup, the user will see 8 animals displayed in a grid along with their names. Upon clicking
// any animals image, a second screen appears that shows a larger resolution of that image. If that
// larger image is clicked then a new screen showing animals facts is displayed. The user can also
// tap and hold on any grid image and choose to either see the larger image, go straight to animal
// facts, or view the wikipedia article on that animal

package course.examples.UI.CS478Project2kellio23;
import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

// GridLayoutActivity is responsible for setting up the grid, along with its listeners. Each of the
// arrays needed for animal data is also included here. The context menu is also defined here.
public class GridLayoutActivity extends Activity {

	protected static final String EXTRA_RES_ID = "POS";
	protected static final String POSITION = "position";

	int gridCell; // changed on grid cell long press and sent through menu options
	int animalID; // same as above but is the photo id for animal

	// holds images in arraylist, from starter code
	private ArrayList<Integer> mThumbIdsFlowers = new ArrayList<Integer>(
			Arrays.asList(R.drawable.bigfloppa, R.drawable.bingus,
					R.drawable.capy, R.drawable.kira, R.drawable.panda,
					R.drawable.krab, R.drawable.sponge, R.drawable.star));

	// used for display under grid
	String[] animalName = {"Caracal", "Sphynx", "Capybara", "Leopard Gecko","Giant Panda",
			"Ghost Crab", "Sea Sponge", "Starfish"};


	String[] animalInfo = {"Caracal", "Sphynx", "Capybara", "Leopard Gecko","Giant Panda","Ghost Crab", "Sea Sponge", "Starfish"};

	// used in context menu third option to show wiki page
	String[] wikiLinks = {
			"https://en.wikipedia.org/wiki/Caracal",
			"https://en.wikipedia.org/wiki/Sphynx_cat",
			"https://en.wikipedia.org/wiki/Capybara",
			"https://en.wikipedia.org/wiki/Leopard_gecko",
			"https://en.wikipedia.org/wiki/Giant_panda",
			"https://en.wikipedia.org/wiki/Ghost_crab",
			"https://en.wikipedia.org/wiki/Sponge",
			"https://en.wikipedia.org/wiki/Starfish"};

	ArrayList aList = new ArrayList<>();
	GridView grid;

	// onCreate populates the animal item arrayList with each animal and its pic/name
	// then it sets the grid adapter and sends the arraylist with it. both short and long click
	// listeners for the grid are defined here.
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		grid = (GridView) findViewById(R.id.gridview);

		aList.add(new aItem("Caracal", R.drawable.bigfloppa));
		aList.add(new aItem("Sphynx",R.drawable.bingus));
		aList.add(new aItem("Capybara",R.drawable.capy));
		aList.add(new aItem("Leopard Gecko",R.drawable.kira));
		aList.add(new aItem("Giant Panda",R.drawable.panda));
		aList.add(new aItem("Ghost Crab",R.drawable.krab));
		aList.add(new aItem("Sea Sponge",R.drawable.sponge));
		aList.add(new aItem("Starfish",R.drawable.star));

		GridAdapter gridAdapter = new GridAdapter(this,R.layout.grid_items,aList);

		grid.setAdapter(gridAdapter);

		// Short click functionality: send picture ID
		grid.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
									int position, long id) {

				Intent intent = new Intent(GridLayoutActivity.this,
						ImageViewActivity.class);
				intent.putExtra(EXTRA_RES_ID, (int) id);
				intent.putExtra("position", position);
				Log.i("Main", "in GridLayoutActivity, id: " + (int)id + " after putting it to extra");
				Log.i("Main", "in GridLayoutActivity, position: " + position + " after putting it to extra");
				// Start the ImageViewActivity
				startActivity(intent);
			}
		});
		// long click brings up context menu which shows three options, show image, show facts, show wiki page
		// all that is needed is an update to the variables defined above in this listener
		registerForContextMenu(grid);
		grid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

				gridCell = position;
				animalID = (int)id;

				return false;
			}


		});
	} // end on create

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.grid_menu,menu);
	}

	@Override
	public boolean onContextItemSelected(@NonNull MenuItem item) {
		// cases are view picture like a short click, view facts like two clicks on image, view wiki
		switch(item.getItemId()){
			case R.id.firstOption:
				Toast.makeText(this,"View Picture",Toast.LENGTH_SHORT).show();

				Intent intent = new Intent(GridLayoutActivity.this,
						ImageViewActivity.class);
				intent.putExtra(EXTRA_RES_ID, animalID);
				startActivity(intent);
				return true;
			case R.id.secondOption:
				Toast.makeText(this,"View Facts",Toast.LENGTH_SHORT).show();

				Intent intent2 = new Intent(GridLayoutActivity.this,
						TestingActivity.class);
				intent2.putExtra("id", gridCell);
				startActivity(intent2);
				return true;
			case R.id.thirdOption:
				Toast.makeText(this,"View Wiki",Toast.LENGTH_SHORT).show();
				// create an action view intent which takes the wiki url from the array wikilinks
				Intent wikiPage = new Intent( Intent.ACTION_VIEW , Uri.parse(wikiLinks[gridCell]) );
				startActivity(wikiPage);

				return true;
			default:
				return super.onContextItemSelected(item);
		}
	} // end onConItemSelect
} // end grid layout activity