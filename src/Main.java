import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        User user = service.createUser("zahra", "mirzaki", 123
                , User.UserType.GOODDEALLER);
        service.createAccount(user, 12333, 6554, Account.AccountType.CURRENT
                , 1000000, 3305, new Date(2022 / 2 / 3));
        service.createAccount(user, 1111111, 222222, Account.AccountType.INTERESTFREE,
                200000, 3450, new Date(2024, 10, 0));
        System.out.println(service.findByFirstName("zahra"));
        System.out.println(service.findByLastName("mirzaki"));
        service.close();
    }
}
