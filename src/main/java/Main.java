import com.example.inherited.VipClientImpl;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // create 10 VIP clients
        VipClientImpl c1 = new VipClientImpl("001", 20, "EUR", 200, 2, 0.5);
        VipClientImpl c2 = new VipClientImpl("002", 21, "USD", 99, 3, 0.6);
        VipClientImpl c3 = new VipClientImpl("003", 22, "JPY", 5000, 4, 0.7);
        VipClientImpl c4 = new VipClientImpl("004", 23, "EUR", 200, 5, 0.8);
        VipClientImpl c5 = new VipClientImpl("005", 24, "EUR", 400, 1, 0.9);
        VipClientImpl c6 = new VipClientImpl("006", 25, "CAD", 12, 6, 0.1);
        VipClientImpl c7 = new VipClientImpl("007", 26, "NOK", 654, 1, 0.2);
        VipClientImpl c8 = new VipClientImpl("008", 27, "AUD", 17, 21, 0.3);
        VipClientImpl c9 = new VipClientImpl("009", 28, "USD", 99.99, 2, 0.4);
        VipClientImpl c10 = new VipClientImpl("010", 29, "EUR", 100, 4, 0.5);

        ArrayList<VipClientImpl> clients = new ArrayList<>();
        Collections.addAll(clients, c1, c2, c3, c4, c5, c6, c7, c8 , c9, c10);

        // print each object
        printClients(clients);


        // change bonus from 0.6 to 0.8
        System.out.println("Changing bonus:");
        changeBonus(clients, 0.6, 0.8);
        printClients(clients);


        // Sort clients
        System.out.println("Sorting clients by amount and age:");
        Collections.sort(clients);
        printClients(clients);

        // Find client by personal code
        System.out.println("Find client by it's personal code (only numbers are allowed in search):");
        findCLientByCode(clients);


        // Swap highest and lowest amount
        System.out.println("Swapping highest and lowest amounts:");
        swapHighestLowestAmounts(clients);
        printClients(clients);

        // Delete clients with less than 100 amount
        int threshold = 100;
        System.out.println("Deleting clients with amount of " + threshold + " or less:");
        deleteBadClients(clients, 100);
        printClients(clients);

    }

    /**
     * Removes clients from a list that has less amount than specified in the threshold parameter
     * @param clients ArrayList of ClientImpl type objects
     * @param threshold amount which will determine which clients will be deleted
     */
    public static void deleteBadClients(ArrayList<VipClientImpl> clients, double threshold) {
        Iterator<VipClientImpl> i = clients.iterator();
        while (i.hasNext()) {
            VipClientImpl c = i.next();
            if (c.getAmount() <= threshold) {
                i.remove();
            }
        }
    }

    /**
     * Swaps highest and lowest amounts for clients
     * @param clients Array list of VipClientImpl type objects
     */
    public static void swapHighestLowestAmounts(ArrayList<VipClientImpl> clients) {
        VipClientImpl max = clients.stream().max(Comparator.comparing(VipClientImpl::getAmount)).get();
        VipClientImpl min = clients.stream().min(Comparator.comparing(VipClientImpl::getAmount)).get();
        double temp;
        temp = max.getAmount();
        max.setAmount(min.getAmount());
        min.setAmount(temp);
    }

    /**
     * Helper function to check if string contains only numbers
     * @param strNum string that we want to check
     * @return true if string contains only numbers, false if not
     */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Finds and prints clients by a code (or part of a code)
     * @param clients ArrayList of VipClientImpl type objects
     */
    public static void findCLientByCode(ArrayList<VipClientImpl> clients) {
        String search = null;
        Scanner sc = new Scanner(System.in);
        search = sc.nextLine();
        if (!isNumeric(search)) {
            System.out.println("ERROR: only numbers can be used in search.");
            System.exit(1);
        } else {
            System.out.println("Clients found:");
            for (VipClientImpl c : clients) {
                if (c.getPersonalCode().contains(search)) {
                    System.out.println(c);
                }
            }
        }
        System.out.println("--------------------");
    }


    /**
     * Function iterates over an array list of VipClientImpl type objects and changes bonus specified in the parameters
     * @param clients an ArrayList of VipClientImpl type Objects
     * @param currentBonus Current bonus that we want to change
     * @param newBonus New bonus that we want to change to
     */
    public static void changeBonus(ArrayList<VipClientImpl> clients, double currentBonus, double newBonus) {
        for (VipClientImpl c : clients) {
        if (c.getBonus() == currentBonus) {
            c.setBonus(newBonus);
        }
        }
    }

    /**
     * Function prints each object in arraylist of VipClientImpl type objects
     * @param clients Array list of VipClientImpl type objects
     */
    public static void printClients(ArrayList<VipClientImpl> clients) {
        System.out.println("--------------------");
        for (VipClientImpl c : clients) {
            System.out.println(c);
        }
        System.out.println("--------------------");
    }

}