import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Health  health = new Health();

        Location village = new Location("Trafiłeś na dziwną wioskę. Pełno tu podejrzliwie zerkających magów", "Wioska");
        Location deathByMagus = new Location("Mag razi Cię piorunem. Potrenuj trochę", "Zaczepiam jednego z nich", -100);
        Location tent = new Location("Tutaj znalazłbyś ekwipunek ale twórca jeszcze go nie zaimplementował :)", "Namiot");
        Location forestPath = new Location("Idziesz w stronę miasta ale po drodze zauważasz ślady w niestandardowym kierunku", "Leśna droga");
        Location abyss = new Location("Docierasz do przepaści i zauważasz linę prowadzącą w dół", "Urwisko");
        Location abyss2 = new Location("Odkrywasz nową lokację. To Kraina Orków!", "Polana Orków");
        Location orc1 = new Location("Walczysz z wojowniczym orkiem.", "Atakuj Orka!", -10);
        Location orc2 = new Location("Pokonałeś jednego z nich.", "Walczę z kolejnym", -10);
        Location deathByAbyss = new Location("Puściłeś linę i spadłeś z wysokości", "Schodzę!", -40);
        Location city = new Location("Jesteś w mieście", "Miasto");
        Location shop = new Location("Miałeś pecha. Wszedłeś do sklepu w trakcie napadu. Złodziej rzucił w ciebie ołowianym butem.", "Sklep", -100);
        Location medic = new Location("Odwiedzasz medyka", "Medyk", 100);

        village.addLocation(tent);
        village.addLocation(forestPath);
        village.addLocation(deathByMagus);

        tent.addLocation(village);

        forestPath.addLocation(village);
        forestPath.addLocation(abyss);
        forestPath.addLocation(city);


        abyss.addLocation(forestPath);
        abyss.addLocation(deathByAbyss);

        deathByAbyss.addLocation(abyss2);
        abyss2.addLocation(abyss);
        abyss2.addLocation(orc1);

        orc1.addLocation(orc2);
        orc1.addLocation(abyss2);

        orc2.addLocation(orc2);
        orc2.addLocation(abyss2);

        city.addLocation(shop);
        city.addLocation(medic);
        city.addLocation(forestPath);

        medic.addLocation(city);


        Location currentLocation = village;


        while (true){

            if (currentLocation.hpChange != 0){
                health.HpChange(currentLocation.hpChange);
            }


            System.out.println("\033[1;31m" + "| HP: " + health.hp + " |");
            currentLocation.info();
            if (health.hp<=0){
                System.out.println("Game Over");
                break;
            }
            if(currentLocation.canGoToNewLocation()){


                currentLocation.showChoice();
                System.out.print("\033[1;33m" + "Wybór: ");
                Scanner choice = new Scanner(System.in);
                try{
                    int index = choice.nextInt();
                    currentLocation = currentLocation.goToLocation(index);
                }catch (Exception e){
                    System.out.println("Nieprawidlowy wybór");
                }
            }
            else {
                System.out.println("Game Over");
                break;
            }
            System.out.println("_________________________________________________");
        }

    }
}
