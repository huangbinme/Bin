package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
    int getLocation = 0;
    int inputRowNum;
    boolean ifAddFlag = true;

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        inputRowNum = numRows;
        StringBuffer resultStr = new StringBuffer();
        List<List> result = new ArrayList<List>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<String>());
        }

        String[] strArray = s.split("");

        for (int i = 0; i < strArray.length; i++) {
            result.get(getLocation).add(strArray[i]);
            initLocation();
        }

        for (List<String> ls : result) {
            for (String str : ls) {
                resultStr.append(str);
            }
        }

        return resultStr.toString();

    }

    public void initLocation() {
        if (ifAddFlag) {
            getLocation++;
            if (getLocation == inputRowNum - 1) {
                ifAddFlag = false;
            }
        } else {
            getLocation--;
            if (getLocation == 0) {
                ifAddFlag = true;
            }
        }
    }
}
