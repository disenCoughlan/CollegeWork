package vendingMachine.DataAccess.Writers;

import vendingMachine.DataAccess.DataHandler;
import vendingMachine.Models.Balance;

public class BalanceWriter {
    public static void AddBalance (Balance balance){
        try {
            DataHandler.WriteBalanceToFile(balance);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void  RemoveBalance (Balance balance){
        try {
            DataHandler.RemoveBalance(balance);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
