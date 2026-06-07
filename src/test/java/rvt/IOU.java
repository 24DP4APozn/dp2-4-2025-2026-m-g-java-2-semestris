package rvt;

import java.util.HashMap;

public class IOU {
    private HashMap<String, Double> debts;

    public IOU() {
        debts = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        debts.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        if (debts.containsKey(toWhom)) {
            return debts.get(toWhom);
        }

        return 0;
    }
}