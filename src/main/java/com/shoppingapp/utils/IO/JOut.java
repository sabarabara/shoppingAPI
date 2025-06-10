package com.shoppingapp.utils.IO;

public class JOut {
    public JOut p(Object obj) {
        System.out.print(obj);
        return this;
    }
    public JOut e() {
        System.out.println();
        return this;
    }
}
