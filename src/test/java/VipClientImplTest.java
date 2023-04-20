import com.example.inherited.VipClientImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class VipClientImplTest {
    VipClientImpl cHighAmount;
    VipClientImpl cLowAmount;
    ArrayList<VipClientImpl> clientsList = new ArrayList<>();
    double badClientThreshold;
    int initialSizeOfClientsList;
    double changeBonusFrom;
    double changeBonusTo;

    @Before
    public void setUp() {
        cHighAmount = new VipClientImpl("001", 20, "EUR", 200, 2, 0.5);
        cLowAmount = new VipClientImpl("001", 21, "EUR", 99, 3, 0.6);
        Collections.addAll(clientsList, cHighAmount, cLowAmount);
        initialSizeOfClientsList = clientsList.size();
        double firstClientAmount = cHighAmount.getAmount();
        double secondClientAmount = cLowAmount.getAmount();
        badClientThreshold = 100;
        changeBonusFrom = 0.6;
        changeBonusTo = 0.8;

    }

    @Test
    public void changeAmountPositiveTest() {
        swapAmountsAndCompareObjectsPositive(clientsList);
    }

    @Test
    public void changesAmountNegativeTest() {
        swapAmountsAndCompareObjectsNegative(clientsList);
    }

    @Test
    public void removeClientsPositiveTest() {
        removeClientsAndCountObjectsPositive(clientsList);
    }

    @Test
    public void removeClientsNegativeTest() {
        removeClientsAndCountObjectsNegative(clientsList);
    }

    @Test
    public void swapBonusPositiveTest() {
        swapBonusAndCompareObjectsPositive(clientsList);
    }

    @Test
    public void swapBonusNegativeTest() {
        swapBonusAndCompareObjectsNegative(clientsList);
    }

    @After
    public void tearDown() {
    }

    private void swapAmountsAndCompareObjectsPositive(ArrayList<VipClientImpl> clients) {
        Main.swapHighestLowestAmounts(clients);
        Assert.assertTrue(cLowAmount.getAmount() > cHighAmount.getAmount());
    }

    private void swapAmountsAndCompareObjectsNegative(ArrayList<VipClientImpl> clients) {
        Main.swapHighestLowestAmounts(clients);
        Assert.assertFalse(cLowAmount.getAmount() < cHighAmount.getAmount());
    }

    private void removeClientsAndCountObjectsPositive(ArrayList<VipClientImpl> clients) {
        Main.deleteBadClients(clients, badClientThreshold);
        Assert.assertTrue(initialSizeOfClientsList > clients.size());
    }

    private void removeClientsAndCountObjectsNegative(ArrayList<VipClientImpl> clients) {
        Main.deleteBadClients(clients, badClientThreshold);
        Assert.assertFalse(initialSizeOfClientsList == clients.size());
    }

    public void swapBonusAndCompareObjectsPositive(ArrayList<VipClientImpl> clients) {
        Main.changeBonus(clients, changeBonusFrom, changeBonusTo);
        int totalWithInitialBonus = 0;
        for (VipClientImpl c : clients) {
            if (c.getBonus() == changeBonusFrom) {
                totalWithInitialBonus ++;
            }
        }
        Assert.assertEquals(0, totalWithInitialBonus);
    }

    public void swapBonusAndCompareObjectsNegative(ArrayList<VipClientImpl> clients) {
        Main.changeBonus(clients, changeBonusFrom, changeBonusTo);
        int totalWithInitialBonus = 0;
        for (VipClientImpl c : clients) {
            if (c.getBonus() == changeBonusFrom) {
                totalWithInitialBonus ++;
            }
        }
        Assert.assertFalse(totalWithInitialBonus != 0);
    }
}
