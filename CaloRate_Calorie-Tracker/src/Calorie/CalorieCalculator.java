package Calorie;

public class CalorieCalculator {

    public double calculateCalories(String mealType, double BMR, double activityLevelFactor) {
        double mealTypeFactor = getMealTypeFactor(mealType);
        return BMR * activityLevelFactor * mealTypeFactor;
    }

    private double getMealTypeFactor(String mealType) {
        return switch (mealType.toUpperCase()) {
            case "BREAKFAST", "DINNER" -> 0.3;
            case "LUNCH" -> 0.4;
            default -> throw new IllegalArgumentException("Invalid meal type");
        };
    }
}