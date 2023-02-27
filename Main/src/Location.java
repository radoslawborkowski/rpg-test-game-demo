import java.util.Arrays;
public class Location {
    private String description;
    private String shortinfo;

    int hpChange;
    Location[] locations = new Location[0];

    public Location(String description, String shortinfo) {
        this.description = description;
        this.shortinfo = shortinfo;
    }
    public Location(String description, String shortinfo, int hpChange) {
        this.description = description;
        this.shortinfo = shortinfo;
        this.hpChange = hpChange;
    }

    void info(){
        System.out.println("\033[1;35m" + description);
    }

    void addLocation(Location location){
        locations = Arrays.copyOf(locations, locations.length+1);
        locations[locations.length-1] = location;
    }

    public void showChoice(){
        System.out.println("\033[0m" + "Możesz się udać do: ");
        int counter = 1;
        for (Location location : locations){
            System.out.println(counter + ":" + location.shortinfo);
            counter++;
        }
    }

    public Location goToLocation(int index) {
            if (index > 0 && index <= locations.length) {
                return locations[index - 1];
            }
            else {
                throw new IllegalArgumentException("Nie mogę przejść do lokacji: " + index);
            }
    }

    public boolean canGoToNewLocation(){
        return locations.length > 0;
    }

}
