package com.lmh.o1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) throws IOException {
        FileUtils.copyURLToFile(new URL("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3711112867,1921429424&fm=26&gp=0.jpg"),new File("1.jpg"));
    }
}

class person{
    private int age;
    private int id;
    private String name;
}