import java.util.Arrays;
import java.util.List;

public class Recipe {
    String name;
    static boolean dishFound = false;

    //public abstract void listOfIngredients(){};
    Grocery[] groceries;
    int[] amounts;

    Recipe(String name, int amountOfIngredients) {
        this.name = name;
        groceries = new Grocery[amountOfIngredients];
        this.amounts = new int[amountOfIngredients];
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

    public static void printRecipeList(List<Recipe> recipes, List<Grocery> groceries) {

        for (int i = 0; i < recipes.size(); i++) {
            System.out.println("For " + recipes.get(i).getName() + " you need:");
            for (Grocery grocery: recipes.get(i).groceries
                 ) {
                System.out.println(grocery.name + ": " /*+ recipes.get(i).amounts[i]*/);
                System.out.println(recipes.get(i).amounts[i]);
            }


/*            for (int j = 0; j < recipes.get(i).groceries.length; j++) {


            }*/
        }
    }

    public static void printUsableRecipes(List<Recipe> recipes) {
        for (int i = 0; i < recipes.size(); i++) {

/*            System.out.println(groceries[i].amount);
            System.out.println(recipes.get(i).amounts[i]);*/

            if (recipes.get(i).groceries[i].amount > recipes.get(i).amounts[i]) {
                System.out.println(recipes.get(i).name);
            }
        }
    }

    public static void cookADish(List<Recipe> recipes) throws InterruptedException {
        System.out.println("What would you like to cook?");
        String dishToCook = Scanner.readString();
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
        String customName = Scanner.readString();
        System.out.println("How many units of " + customName + " would you like to add?");
        int amount = Scanner.readNumber();
        Recipe customRecipe = new Recipe(customName, amount);

        System.out.println("New item added!");
        return customRecipe;
    }

    @Override
    public String toString() {
        return  Arrays.toString(groceries) + ": " +
                 Arrays.toString(amounts)
                ;
    }
}
