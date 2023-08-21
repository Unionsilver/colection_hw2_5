package com.example.colection_hw2_5.util;

import com.example.colection_hw2_5.exception.IllegalNameException;
import org.apache.commons.lang3.StringUtils;

public class EmployeeNameValidator {
    public static void checkName (String...names) {
        for (String name : names) {
            if (!StringUtils.isAlpha(name)){
                throw new IllegalNameException();
            }
        }
    }
}
