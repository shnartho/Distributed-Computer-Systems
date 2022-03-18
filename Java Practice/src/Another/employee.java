package Another;
import com.example.lab1.*;

public class employee extends student {
    public String companyName;

    public employee(String name, int age, String address, String companyName){
        super(name, age, address);
        this.companyName = companyName;
    }

    public static void main(String[] args) {
        employee Rasel = new employee("Rasel Ferdous", 39, "Dhaka", "MES");
        System.out.println("Hello "+ Rasel.name);
        System.out.println("Hello "+ Rasel.toString());
    }
}
