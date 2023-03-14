public class ScrambledEggs extends Recipe {

    public ScrambledEggs(String name, int amountOfIngredients, Grocery ingredient1, int amount1, Grocery ingredient2, int amount2) {
        super(name, amountOfIngredients);
        groceries[0] = ingredient1;
        groceries[1] = ingredient2;
        amounts[0] = amount1;
        amounts[1] = amount2;
    }

    @Deprecated
    public void listOfIngredients() {
        System.out.println("For scrambled eggs, you need: \nEggs: 2 \nButter: 1\n");
    }

    @Override
    public String toString() {
        return
                name + '\n' +
                        groceries[0] + ": " + amounts[0] + '\n' + groceries[1] + ": " + amounts[1];
    }
}


