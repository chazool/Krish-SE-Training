package com.virtusa.builderPattern.entity;

public class MealPlan {


    private boolean isBreakfast;
    private boolean isLunch;
    private boolean isDinner;

    public boolean isBreakfast() {
        return isBreakfast;
    }

    public void setBreakfast(boolean breakfast) {
        isBreakfast = breakfast;
    }

    public boolean isLunch() {
        return isLunch;
    }

    public void setLunch(boolean lunch) {
        isLunch = lunch;
    }

    public boolean isDinner() {
        return isDinner;
    }

    public void setDinner(boolean dinner) {
        isDinner = dinner;
    }


    @Override
    public String toString() {
        return "MealPlan{" +
                "isBreakfast=" + isBreakfast +
                ", isLunch=" + isLunch +
                ", isDinner=" + isDinner +
                '}';
    }
}
