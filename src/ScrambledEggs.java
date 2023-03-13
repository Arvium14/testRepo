public class ScrambledEggs extends Recipe {

    public ScrambledEggs(String name, int amountOfIngredients, Grocery ingredient1, int twoNeeded, Grocery ingredient2, int oneNeeded) {
        super(name, amountOfIngredients);
        groceries[0] = ingredient1;
        groceries[1] = ingredient2;
        amounts[0] = twoNeeded;
        amounts[1] = oneNeeded;
    }
    @Override
    public void listOfIngredients() {
        System.out.println("For scrambled eggs, you need: \nEggs: 2 \nButter: 1\n");
    }
}


