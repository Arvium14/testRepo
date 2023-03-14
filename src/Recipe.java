import java.util.Arrays;
import java.util.List;

public class Recipe {
    String name;
    Grocery[] groceries;
    int[] amounts;
    static boolean dishFound = false;

    Recipe(String name, Grocery[] groceries, int[] amounts) {
        this.name = name;
        this.groceries = groceries;
        this.amounts = amounts;
    }

    Recipe(String name, int amount) {
        this.name = name;
        groceries = new Grocery[amount];
        this.amounts = new int[amount];
    }

    public String getName() {
        return name;
    }

    private void cookIt() throws InterruptedException {

        for (int i = 0; i < groceries.length; i++) {
            if (groceries[i].amount < amounts[i]) {
                System.out.println("Insufficient ingredients!");
                break;
            }
            groceries[i].decreaseQuantity(amounts[i]);
        }
        System.out.println("Cooking...");
        Thread.sleep(1000);
        System.out.println("\nEnjoy your " + getName() + "!");
    }

    public static void printRecipeList(List<Recipe> recipes) {
        for (Recipe recipe : recipes
        ) {
            System.out.println(recipe.name);
            Grocery[] recipeGroceries = recipe.groceries;
            int[] groceryAmounts = recipe.amounts;

            for (int i = 0; i < groceryAmounts.length; i++) {
                System.out.println(recipeGroceries[i].name + ": " + groceryAmounts[i]);
            }
        }
    }

    public static void printUsableRecipes(List<Recipe> recipes) {
        for (int i = 0; i < recipes.size(); i++) {

            if (recipes.get(i).groceries[i].amount > recipes.get(i).amounts[i]) {
                System.out.println(recipes.get(i).name);
            }
        }
    }

    public static void cookADish(List<Recipe> recipes) throws InterruptedException {
        System.out.println("What would you like to cook?");
        String dishToCook = MyScanner.readString();
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(dishToCook)) {
                recipe.cookIt();
                dishFound = true;
            } else if (dishFound = false) {
                System.out.println("That dish is not available yet!");
            }
        }
    }

    public static Recipe addRecipe() {
        System.out.println("What would you like to add?");
        String customName = MyScanner.readString();
        System.out.println("How many units of " + customName + " would you like to add?");
        int amount = MyScanner.readNumber();
        Recipe customRecipe = new Recipe(customName, amount);

        System.out.println("New item added!");
        return customRecipe;
    }

    @Override
    public String toString() {
        return Arrays.toString(groceries) + ": " +
                Arrays.toString(amounts);
    }
}
