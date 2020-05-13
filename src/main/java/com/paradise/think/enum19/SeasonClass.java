package com.paradise.think.enum19;

/**
 * @author Paradise
 */
public class SeasonClass {
    private Season season = Season.Spring;

    private void change() {
        switch (season) {
            case Spring:
                this.season = Season.Summer;
                break;
            case Summer:
                this.season = Season.Fall;
                break;
            case Fall:
                this.season = Season.Winter;
                break;
            case Winter:
                this.season = Season.Spring;
                break;
            default:
        }
    }

    @Override
    public String toString() {
        return "SeasonClass{" +
                "season=" + season +
                '}';
    }

    public static void main(String[] args) {
        SeasonClass seasonClass = new SeasonClass();
        for (int i = 0; i < 9; i++) {
            System.out.println(seasonClass);
            seasonClass.change();
        }
    }
}
