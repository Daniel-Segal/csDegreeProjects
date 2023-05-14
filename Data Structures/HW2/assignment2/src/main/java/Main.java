// ************************ //
// Submission by:
// Gilad Amos I.D 208250969 & Daniel Segal I.D 208256636
// ************************ //


/**
 * This class simulates a hospital manager system.
 * it generates patients and adds them to a manager object which manages the order in which patients are served.
 * patients are being served according to their priority or their arrival time to the hospital.
 */
public class Main {

    /**
     * The main method runs the 3 functions below.
     */
    public static void main(String[] args) {
        Manager amos = new Manager<Patient>();

        timedPatientsGenerator(amos);
        
        simulateOnlyByCreationTime(amos);
        
        simulateOnlyByPriority(amos);
    }

    /**
     * Generates 7 patients and adds them to a manager object.
     * @param woman the manager object to which patients will be added.
     */
    public static void timedPatientsGenerator(Manager woman) {
        for(int i = 1; i <= 7; i++) {
            woman.add(new Patient(i, isVip()));
            sleep();

        }
    }
    /**
     * Generates a random boolean value to determine wheather a patinet is VIP or not.
     * @return A boolean value.
     */
    public static boolean isVip() {
        int num = (int) (Math.random() * 2);
        if(num == 1) return false;
        return true;
    }
    
    public static void sleep() {
        try {
            Thread.sleep(300);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
    }

    /**
     * Simulates serving patients only by their priority, removing the highest priorty paitent first,
     * and print his infortmation.
     * @param woman The manager object containing the patients to be served.
     */
    public static void simulateOnlyByPriority(Manager woman) {
        int amount = woman.getSize();
        for(int i = 1; i <= amount; i++)
        {
            System.out.println(woman.getByPriority());
        }
    }
    /**
     * Simulates serving patients only by arrival time, removing patient who arrived first,
     * and print his information.
     * @param woman The manager object containing the patients to be served.
     */
    public static void simulateOnlyByCreationTime(Manager woman) {
        int amount = woman.getSize();
        for(int i = 1; i <= amount; i++)
        {
            System.out.println(woman.getByCreationTime());
        }
    }
}
