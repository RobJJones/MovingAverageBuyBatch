package com.tradeapp.movingAverageBuy.model;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

public class BigDecimalNaNConverter extends AbstractBeanField {

    @Override
    protected BigDecimal convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return NumberUtils.isCreatable(s) ? new BigDecimal(s) : BigDecimal.ZERO;
    }
}
