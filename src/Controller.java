public class Controller {
    public static Recipe addRecipe(){
        System.out.println("What is the name of the recipe you want to add?");
        String answer = MyScanner.readString();
        System.out.println("How many ingredients does the recipe consist of?");
        int numberOfIngredients = MyScanner.readNumber();

        Grocery[] groceries = new Grocery[numberOfIngredients];
        int[] amounts = new int[numberOfIngredients];

        for (int i = 0; i < numberOfIngredients; i++) {
            groceries[i] = askForIngredient();
            System.out.println("How many of those do you need?");
            amounts[i] = MyScanner.readNumber();
        }

        return new Recipe(answer, groceries, amounts);
    }
    public static Grocery checkForGrocery(String name){
        for (Grocery checked: Main.cabinet
        ) {
            if (checked.name.equalsIgnoreCase(name)){
                return checked;
            }
        }
        return null;
    }
    public static Grocery askForIngredient(){
        System.out.println("What is the name of the ingredient?");
        String myIngredient = MyScanner.readString();
        Grocery maybeGrocery = checkForGrocery(myIngredient);
        if (maybeGrocery == null){
            System.out.println("This grocery doesn't exist in our cabinet!");
            return askForIngredient();
        }
        return maybeGrocery;
    }
}
