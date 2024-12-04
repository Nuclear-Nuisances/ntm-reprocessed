package com.nuclearnuisances.ntm.util;

@FunctionalInterface
public interface SupplierBiInput<I1, I2, O> {
    O get(I1 input1, I2 input2);
}
