package com.lucas;

public class HelloMaven {
    public int add(int i,int j){
        return i+j;
    }

    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        helloMaven.add(23,43);
    }

}

