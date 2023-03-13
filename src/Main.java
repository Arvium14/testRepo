import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean cookingOrShopping = true;

        Grocery bread = new Bread("bread", 12);
        Grocery butter = new Butter("butter", 3);
        Grocery eggs = new Eggs("eggs", 24);

        Recipe scrambledEggs = new ScrambledEggs("scrambled eggs", 2, eggs, 2, butter, 1);
        Recipe toast = new Toast("toast", 2, bread, 2, butter, 2);

        List<Grocery> cabinet = new ArrayList<>();
        List<Recipe> recipes = new ArrayList<>();

        cabinet.add(bread);
        cabinet.add(butter);
        cabinet.add(eggs);

        recipes.add(scrambledEggs);
        recipes.add(toast);


        while (cookingOrShopping) {

            System.out.println("""

                    What would you like to do?
                    Press 1 for a list of saved recipes
                    Press 2 to see the contents of the cupboard
                    Press 3 to add to the cupboard
                    Press 4 to start cooking
                    Press 5 to add grocery types
                    Press 6 to add recipes
                    Press 7 for a list of cookable recipes
                    Press 8 to exit""");

            int answer = Scanner.readNumber();

            switch (answer) {
                case 1 -> Recipe.printRecipeList(recipes);
                case 2 -> Grocery.printCabinetContents(cabinet);
                case 3 -> Grocery.addToTheCabinet(cabinet);
                case 4 -> Recipe.cookADish(recipes);
                case 5 -> cabinet.add(Grocery.addGrocery());
//                case 6 -> AddRecipes
                case 7 -> Recipe.printUsableRecipes(recipes);
                case 8 -> cookingOrShopping = false;
            }
        }
    }
}


