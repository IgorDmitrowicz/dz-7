public enum SolarSystem {
    MERCURY(0, 1, 4879, null, null),
    VENUS(57910000, 2, 12104, MERCURY, null),
    EARTH(108200000, 3, 12742, VENUS, null),
    MARS(149600000, 4, 6779, EARTH, null),
    JUPITER(227940000, 5, 139820, MARS, null),
    SATURN(778330000, 6, 116460, JUPITER, null),
    URANUS(1429400000, 7, 50724, SATURN, null),
    NEPTUNE(2870990000L, 8, 49244, URANUS, null);

    private final int prevDistance;
    private final int order;
    private final int radius;
    private final long distanceFromSun;
    private final SolarSystem previous;
    private SolarSystem next;


    SolarSystem(long prevDistance, int order, int radius, SolarSystem previous, SolarSystem next) {
        this.prevDistance = (int) prevDistance;
        this.order = order;
        this.radius = radius;
        this.previous = previous;
        this.next = next;
        this.distanceFromSun = previous == null ? 0 : previous.distanceFromSun + prevDistance;


        if (previous != null) {
            previous.setNext(this);
        }
    }

    private void setNext(SolarSystem next) {
        this.next = next;
    }

    public int getPrevDistance() {
        return prevDistance;
    }

    public int getOrder() {
        return order;
    }

    public int getRadius() {
        return radius;
    }

    public long getDistanceFromSun() {
        return distanceFromSun;
    }

    public SolarSystem getPrevious() {
        return previous;
    }

    public SolarSystem getNext() {
        return next;
    }

    public void printInfo() {
        System.out.println("Planet: " + this.name());
        System.out.println("Order from Sun: " + order);
        System.out.println("Radius: " + radius + " km");
        System.out.println("Distance from previous planet: " + prevDistance + " km");
        System.out.println("Distance from Sun: " + distanceFromSun + " km");
        System.out.println("Previous planet: " + (previous != null ? previous.name() : "None"));
        System.out.println("Next planet: " + (next != null ? next.name() : "None"));
        System.out.println();
    }

    public static void main(String[] args) {
        for (SolarSystem planet : SolarSystem.values()) {
            planet.printInfo();
        }
    }
}