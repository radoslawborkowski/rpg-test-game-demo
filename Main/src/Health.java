public class Health {
    public int hp = 30;
    public final int hpMax = 100;

    public void HpChange(int hpChange){
        hp += hpChange;
        if (hp >100) hp = hpMax;

        if(hpChange>0) System.out.println("Dodano: " + hpChange + " HP");
        else if(hpChange < 0) System.out.println("Zadano: " + Math.abs(hpChange) + " obrażeń");
    }



}
