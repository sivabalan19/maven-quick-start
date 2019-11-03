package com.wordpress.allaboutintegration;

import org.apache.commons.lang3.StringUtils ;

public class Application {

    public Application(){
        System.out.println("Application is starting...");
    }

    public int countWords(String words) {
        String[] seperatedWords = StringUtils.split(words, " ");
        return (seperatedWords == null) ? 0 : seperatedWords.length;
    }

    public static void main(String[] args) {
        System.out.println("Starting all the applications..");
        Application app1 = new Application();
        int count = app1.countWords("This is my first project in Maven.");
        System.out.println("Total words :" + count);
    }
}
