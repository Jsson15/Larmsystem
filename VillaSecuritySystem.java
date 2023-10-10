import java.util.Random;
import java.util.Scanner;

// Gränssnitt för detektorer (dörrar, fönster, rök)
interface Detector {
    boolean isTriggered();
    String getLocation();
}

// Konkret klass för fönsterdetektor
class WindowDetector implements Detector {
    private String location;
    private boolean triggered;

    public WindowDetector(String location) {
        this.location = location;
        this.triggered = false;
    }

    @Override
    public boolean isTriggered() {
        return triggered;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public void breakWindow() {
        triggered = true;
    }
}

// Konkret klass för dörrdetektor
class DoorDetector implements Detector {
    private String location;
    private boolean triggered;

    public DoorDetector(String location) {
        this.location = location;
        this.triggered = false;
    }

    @Override
    public boolean isTriggered() {
        return triggered;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public void openDoor() {
        triggered = true;
    }
}

// Konkret klass för rökdetektor
class SmokeDetector implements Detector {
    private String location;
    private boolean triggered;

    public SmokeDetector(String location) {
        this.location = location;
        this.triggered = false;
    }

    @Override
    public boolean isTriggered() {
        return triggered;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public void detectSmoke() {
        triggered = true;
    }
}

// Klass för larmsystem
class AlarmSystem {
    private boolean active;
    private boolean alarmTriggered;
    private Random random;

    public AlarmSystem() {
        active = false;
        alarmTriggered = false;
        random = new Random();
    }

    public void activate() {
        active = true;
        System.out.println("Larmsystemet är aktiverat.");
    }

    public void deactivate() {
        active = false;
        alarmTriggered = false;
        System.out.println("Larmsystemet är avaktiverat.");
    }

    public void triggerAlarm(String eventType, String location) {
        alarmTriggered = true;
        System.out.println("Larm utlöst: " + eventType + " i " + location);
        // Här kan du lägga till åtgärder som att ringa polisen eller brandkåren.
    }

    public boolean isAlarmTriggered() {
        return alarmTriggered;
    }

    public boolean isActive() {
        return active;
    }

    public void simulateEvent() {
        if (active) {
            int eventType = random.nextInt(3); // Slumpa ett event: 0 = brand, 1 = inbrott, 2 = rörelse i poolområdet

            switch (eventType) {
                case 0:
                    triggerAlarm("Brand", "Kök");
                    break;
                case 1:
                    triggerAlarm("Inbrott", "Vardagsrum");
                    break;
                case 2:
                    triggerAlarm("Rörelse i poolområdet", "Trädgård");
                    break;
            }
        }
    }
}

public class VillaSecuritySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlarmSystem alarmSystem = new AlarmSystem();

        while (true) {
            System.out.println("Välkommen till Erlich Bachmans Villa Security System");
            System.out.println("1. Aktivera larmsystemet");
            System.out.println("2. Avaktivera larmsystemet");
            System.out.println("3. Simulera händelse");
            System.out.println("4. Avsluta");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    alarmSystem.activate();
                    break;
                case 2:
                    alarmSystem.deactivate();
                    break;
                case 3:
                    alarmSystem.simulateEvent();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }

            // Kontrollera om larmet är utlöst
            if (alarmSystem.isAlarmTriggered()) {
                System.out.println("Larmet är utlöst. Åtgärder vidtas.");
            }
        }
    }
}
