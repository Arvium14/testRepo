public class Toast extends Recipe {

    public Toast(String name, int amountOfIngredients, Grocery ingredient1, int amount1, Grocery ingredient2, int amount2) {
        super(name, amountOfIngredients);
        groceries[0] = ingredient1;
        groceries[1] = ingredient2;
        amounts[0] = amount1;
        amounts[1] = amount2;
    }

    public void listOfIngredients() {
        System.out.println("For toast, you need:\nBread: 2 \nButter: 1\n");
    }
    @Override
    public String toString() {
        return
                name + '\n' +
                        groceries[0] + ": " + amounts[0] + '\n' + groceries[1] + ": " + amounts[1];
    }
}
