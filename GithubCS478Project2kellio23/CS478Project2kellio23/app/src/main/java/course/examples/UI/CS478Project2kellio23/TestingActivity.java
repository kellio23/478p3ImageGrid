package course.examples.UI.CS478Project2kellio23;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

// Testing activity is responsible for displaying animal information after that image is tapped on
// it operates similarly to ImageViewActivity but with a textview instead
public class TestingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        String[] animalInfo = {"Caracal \nLifespan: 16 years \nAverage Weight: 18-42 pounds \nPreferred Habitat: Savanna, semideserts \nFeeding habits: Carnivore  \nEndangered Level: Least Concern"
                , "Sphynx \nLifespan: 8-14 years \nAverage Weight: 6-12 pounds \nPreferred Habitat: Urban \nFeeding habits: Omnivore  \nEndangered Level: Least Concern"
                , "Capybara \nLifespan: 8-10 years \nAverage Weight: 77-146 pounds \nPreferred Habitat: Amazon Rainforest, Savanna \nFeeding habits: Herbivore  \nEndangered Level: Least Concern"
                , "Leopard Gecko \nLifespan: 15 years \nAverage Weight: 60-80 grams \nPreferred Habitat: Desert, Arid Grasslands \nFeeding habits: Omnivore  \nEndangered Level: Least Concern"
                ,"Giant Panda \nLifespan: 20-30 years \nAverage Weight: 220-350 pounds \nPreferred Habitat: Bamboo Forests \nFeeding habits: Omnivore, Though 99% is bamboo  \nEndangered Level: Vulnerable"
                ,"Ghost Crab \nLifespan: 3 years \nAverage Weight: .5-2.5 ounces \nPreferred Habitat: Tropical Beach, Shallow Ocean \nFeeding habits: Carnivore  \nEndangered Level: Least Concern"
                , "Sea Sponge \nLifespan: 200 years \nAverage Weight: Up to 20 pounds \nPreferred Habitat: Deep Ocean, Coral Reef \nFeeding habits: Filter Feeder  \nEndangered Level: Least Concern"
                , "Starfish \nLifespan: 35 years \nAverage Weight: 1-10 pounds \nPreferred Habitat: Shallow Ocean, Coral Reef \nFeeding habits: Omnivore  \nEndangered Level: Least Concern"};

        Intent intent = getIntent();

        TextView textView = new TextView(getApplicationContext());

        textView = (TextView) findViewById(R.id.textView);

        int position = intent.getIntExtra("id", 0);

        Log.i("Main", "in TestingActivity, ID: " + position + " after setting it to getIntExtra");
        Log.i("Main", "in TestingActivity, setting textView to: " + animalInfo[position]);
        textView.setText(animalInfo[position]);

    }
}