package com.shoppingapp.app.service.core.domain.service.generater;

public interface IdGenerator {
    /**
     * @param sequenceName 
     * @return
     */
    String generate(String sequenceName);
}