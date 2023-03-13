import java.util.List;

public class Grocery{
    String name;
    int amount;
    //TODO this is a keyword you can use to make an easy todo list in your IDE
    //FIXME this is a keyword that you can use to mark errors in your code to later fix
    Grocery(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public void increaseQuantity(int amount) {
        this.amount = this.amount + amount;
        System.out.println("\nA total of " + amount + " units have been added to " + this.name);

    }
    public void decreaseQuantity(int amount) {
        this.amount = this.amount - amount;
    }

    public String toString() {
        return
                "product: " + name + '\t' +
                "amount:" + amount;
    }
    public static void printCabinetContents(List<Grocery> cabinet) {
        for (Grocery grocery : cabinet
        ) {
            System.out.println(grocery.toString());
        }
        System.out.println("\n");
    }
    public static void addToTheCabinet(List<Grocery> cabinet) {
        System.out.println("What grocery would you like to add to?");
        String chosen = Scanner.readString();
        System.out.println("How much units of " + chosen + " would you like to add?");
        int amount = Scanner.readNumber();

        for (Grocery grocery : cabinet
        ) {
            if (grocery.getName().equalsIgnoreCase(chosen)) {
                grocery.increaseQuantity(amount);
            }
        }
    }
    public static Grocery addGrocery(){
        System.out.println("What would you like to add?");
        String customName = Scanner.readString();
        System.out.println("How many units of " + customName + " would you like to add?");
        int amount = Scanner.readNumber();
        Grocery customGrocery = new Grocery(customName, amount);

        System.out.println("New item added!");
        return  customGrocery;
    }
}
