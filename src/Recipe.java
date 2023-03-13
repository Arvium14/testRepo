import java.util.List;

public abstract class Recipe {

    String name;

    static boolean dishFound = false;

    public abstract void listOfIngredients();
    Grocery[] groceries;
    int[] amounts;
    Recipe(String name, int amountOfIngredients) {
        this.name = name;
        this.groceries = new Grocery[amountOfIngredients];
        this.amounts = new int[amountOfIngredients];
    }

    public String getName() {
        return name;
    }

    public void cookIt() throws InterruptedException {

        for (int i = 0; i < groceries.length; i++) {
            if (groceries[i].amount < amounts[i]){
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
            recipe.listOfIngredients();
        }
    }
    public static void cookADish(List<Recipe> recipes) throws InterruptedException {
        System.out.println("What would you like to cook?");
        String dishToCook = Scanner.readString();
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(dishToCook)) {
                recipe.cookIt();
                dishFound = true;
            }
            else if(dishFound = false) {
                System.out.println("That dish is not available yet!");
            }
        }
    }
}
