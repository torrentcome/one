package com.comeworld.app.model;

/**
 * Created by come on 24/06/14.
 */
public class Recette {
    private String name;
    private String origin;
    private String step;

    public Recette() {
    }

    public Recette(String name, String origin, String step) {
        this.name = name;
        this.origin = origin;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public static class FeedEntry {
        public static String table = "recette";
        public static String name = "name";
        public static String origin = "origin";
        public static String step = "step";
    }
}
