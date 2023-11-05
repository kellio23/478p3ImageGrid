package course.examples.UI.CS478Project2kellio23;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

// ImageViewActivity is responsible for creating a new scene where just the image that was clicked
// is displayed, by getting an intent and then retrieving the pictures id along with it, then
// setting an imageview to that picture id and displaying it
public class ImageViewActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		ImageView imageView = new ImageView(getApplicationContext());

		// where the id of the picture is stored
		String animalID = GridLayoutActivity.EXTRA_RES_ID;
		Log.i("Main", "in imageViewActivity, animalID: " + animalID + " after setting it to GLA.ERI");
		final int positionTest = intent.getIntExtra("position", 0);
		Log.i("Main", "in imageViewActivity, positionTEst: " + positionTest + " after setting it to getIntExtra");
		imageView.setImageResource(intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0));
		// this listener sends the id of the animal to the text view activity
		imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(ImageViewActivity.this, TestingActivity.class);

				intent.putExtra("id",positionTest);
				Log.i("Main", "in imageViewActivity, starting next activity");
				startActivity(intent);
			}
		});

		setContentView(imageView);
	}
}