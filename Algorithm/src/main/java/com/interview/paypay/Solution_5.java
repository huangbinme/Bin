package com.interview.paypay;

import java.util.ArrayList;
import java.util.List;

public class Solution_5 {
    public String calculateChange(float pp, float cash) {
        // write your code here
        BillReturn[] billReturns = {
                new BillReturn(100.0F, "One Hundred"),
                new BillReturn(50.0F, "Fifty"),
                new BillReturn(20.0F, "Twenty"),
                new BillReturn(10.0F, "Ten"),
                new BillReturn(5.0F, "Five"),
                new BillReturn(2.0F, "Two"),
                new BillReturn(1.0F, "One"),
                new BillReturn(0.5F, "Half Dollar"),
                new BillReturn(0.25F, "Quarter"),
                new BillReturn(0.10F, "Dime"),
                new BillReturn(0.05F, "Nickel"),
                new BillReturn(0.01F, "Penny")
        };
        List<String> ans = new ArrayList<>();
        float returnValue = cash - pp;
        for (int i = 0; i < billReturns.length; i++) {
            BillReturn billReturn = billReturns[i];
            int c = (int) (returnValue / billReturn.value);
            returnValue -= (c * billReturn.value);
            for (int j = 0; j < c; j++) {
                ans.add(billReturn.alias);
            }
        }
        ans.sort(String::compareTo);
        return String.join(",", ans);
    }

    static class BillReturn {
        float value;
        String alias;

        BillReturn(float value, String alias) {
            this.value = value;
            this.alias = alias;
        }
    }
}
