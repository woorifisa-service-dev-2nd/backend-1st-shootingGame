
public class Soldier {

    private final String name;
    private final String gunType;
    private String hit;
    private int hitted;

    public Soldier(String name, String gunType, int count) {
        this.name = name;
        this.gunType = gunType;
        this.hit = "";
        this.hitted = 0;

        for (int i = 0; i < count; i++) {
            this.hit += "O";
        }
    }

    public String getName() {
        return name;
    }

    public String getGunType() {
        return gunType;
    }

    public String getHit() {
        return hit;
    }

    public int getHitted() {
        return hitted;
    }

    public void setShootingHit(String hit, int hitted) {
        this.hit = this.hit.substring(0, hitted) + 'X' + this.hit.substring(hitted + 1);
        this.hitted++;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

}
