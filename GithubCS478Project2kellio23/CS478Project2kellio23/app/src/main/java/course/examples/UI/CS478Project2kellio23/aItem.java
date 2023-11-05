package course.examples.UI.CS478Project2kellio23;

// aItem creates an animal object that can hold the name of the animal and the id of the animal
// image. the string is used for the name under the picture and the id goes to the id of the
// related picture
public class aItem {

    String animalName;
    int animalImage;

    public aItem(String aName, int aImage){
        animalImage = aImage;
        animalName = aName;
    }

    public int getAnimalImage() {
        return animalImage;
    }

    public String getAnimalName() {
        return animalName;
    }
}
