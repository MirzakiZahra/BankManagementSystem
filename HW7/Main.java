import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DB_driver db_driver = new DB_driver();
        DB_passenger db_passenger = new DB_passenger();
        DB_trip db_trip = new DB_trip();
        Management management = new Management();
        Driver driver = new Driver();
        Trip trip = new Trip();
        boolean check = true;
        String name;
        String address;
        String name_of_car;
        String color_of_car;
        int width = 0;
        int length = 0;
        while (check == true) {
            try {
                Scanner scanner = new Scanner(System.in);
                Database database = new Database();
                int input = 0;
                do {
                    System.out.println("1.Add  a group of drivers\n2.add a group of passengers\n" +
                            "3.driver signup or login\n4.passenger signup or login\n" +
                            "5.show a list of driver\n6.show a list of passengers\n7.exit");
                    if (!scanner.hasNextInt()) {
                        String input1 = scanner.next();
                        check = true;
                        throw new InputMismatchException("Please Enter Integer");
                    } else {
                        input = scanner.nextInt();
                        check = false;
                    }


                    switch (input) {
                        case 1:
                            System.out.println("please enter a number of driver you want to add");
                            int number = 0;
                            if (!scanner.hasNextInt()) {
                                String number1 = scanner.next();
                                check = true;
                                throw new InputMismatchException("Please Enter Integer");
                            } else {
                                number = scanner.nextInt();
                                check = false;
                            }

                            int age, username, plaque;
                            for (int i = 0; i < number; i++) {
                                System.out.println("name,age,address,username,name_of_car," +
                                        "plaque,color_of_car,Width,Length");
                                driver = new Driver();
                                name = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String age1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    age = scanner.nextInt();
                                    check = false;
                                }
                                address = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String username1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    username = scanner.nextInt();
                                    check = false;
                                }
                                name_of_car = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String plaque1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    plaque = scanner.nextInt();
                                    check = false;
                                }
                                color_of_car = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String width1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    width = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String length1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    length = scanner.nextInt();
                                    check = false;
                                }
                                driver.setName(name);
                                driver.setAge(age);
                                driver.setAddress(address);
                                driver.setUsername(username);
                                driver.getCar().setName_of_car(name_of_car);
                                driver.getCar().setPlaque(plaque);
                                driver.getCar().setColor_of_car(color_of_car);
                                driver.setWidth(width);
                                driver.setLength(length);
                                db_driver.add_driver(driver);
                                management.drivers.add(driver);
                                check = false;
                            }
                            break;
                        case 2:
                            System.out.println("please enter a number of passenger you want t add");
                            int password, balance;
                            if (!scanner.hasNextInt()) {
                                String number1 = scanner.next();
                                check = true;
                                throw new InputMismatchException("PLEASE enter integer");
                            } else {
                                number = scanner.nextInt();
                                check = false;
                            }

                            for (int i = 0; i < number; i++) {
                                System.out.println("name,age,address,username,password,balance,Width,Length");
                                name = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String age2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    age = scanner.nextInt();
                                    check = false;
                                }
                                address = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String username2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    username = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String password2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    password = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String balance2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    balance = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String width1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    width = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String length1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    length = scanner.nextInt();
                                    check = false;
                                }
                                Passengers passengers = new Passengers();
                                passengers.setName(name);
                                passengers.setAge(age);
                                passengers.setAddress(address);
                                passengers.setUsername(username);
                                passengers.setPassword(password);
                                passengers.setBalance(balance);
                                db_passenger.add_passenger(passengers);
                                passengers.setLength(length);
                                passengers.setWidth(width);
                                management.passengers.add(passengers);
                                System.out.println(passengers.toString());
                                System.out.println(management.passengers.toString());
                                check = false;

                            }
                            break;
                        case 3:
                            System.out.println("please enter your username");
                            username = 0;
                            if (!scanner.hasNextInt()) {
                                check = true;
                                throw new InputMismatchException("PLEASE enter integer");
                            } else {
                                username = scanner.nextInt();
                                check = false;
                            }
                            int register;
                            driver = new Driver();
                            int existance = db_driver.check_exist_driver(username);
                            if (existance == 0) {
                                System.out.println("1.register\n2.Exit");
                                if (!scanner.hasNextInt()) {
                                    String register1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    register = scanner.nextInt();
                                    check = false;
                                }

                                if (register == 1) {
                                    System.out.println("name,age,address,username,name_of_car,plaque" +
                                            ",color_of_car, width,length");
                                    name = scanner.next();
                                    if (!scanner.hasNextInt()) {
                                        String age1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        age = scanner.nextInt();
                                        check = false;
                                    }
                                    address = scanner.next();
                                    if (!scanner.hasNextInt()) {
                                        String username1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        username = scanner.nextInt();
                                        check = false;
                                    }
                                    name_of_car = scanner.next();
                                    if (!scanner.hasNextInt()) {
                                        String plaque1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        plaque = scanner.nextInt();
                                        check = false;
                                    }
                                    if (!scanner.hasNextInt()) {
                                        String width1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        width = scanner.nextInt();
                                        check = false;
                                    }
                                    if (!scanner.hasNextInt()) {
                                        String length1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        length = scanner.nextInt();
                                        check = false;
                                    }
                                    color_of_car = scanner.next();
                                    driver.setName(name);
                                    driver.setAge(age);
                                    driver.setAddress(address);
                                    driver.setUsername(username);
                                    driver.getCar().setName_of_car(name_of_car);
                                    driver.getCar().setPlaque(plaque);
                                    driver.getCar().setColor_of_car(color_of_car);
                                    driver.setLength(length);
                                    driver.setWidth(width);
                                    management.drivers.add(driver);
                                    db_driver.add_driver(driver);
                                    check = false;
                                }
                                if (register == 2) {
                                    break;
                                }
                            } else {
                                String status = db_driver.getStatus(username);
                                if (status.toLowerCase().charAt(0) == 'o') {
                                    driver = management.findDriver(username);
                                    boolean getMoney = false;
                                    do {
                                        System.out.println("1.confirm a money\n" +
                                                "2.complete trip\n3.exit");
                                        number = scanner.nextInt();
                                        switch (number) {
                                            case 1:
                                                getMoney = true;
                                                break;
                                            case 2:
                                                if (driver.getPaymentType().getAbbr().equalsIgnoreCase("c")) {
                                                    if (getMoney == true) {
                                                        management.finishTrip(driver, width, length, db_driver, db_trip,
                                                                username, db_passenger);
                                                    } else {
                                                        System.out.println("Please Accept that you recieve money first");
                                                    }
                                                } else {
                                                    management.finishTrip(driver, width, length, db_driver, db_trip,
                                                            username, db_passenger);
                                                }
                                                break;
                                            case 3:
                                                break;
                                        }
                                    } while (number != 3);
                                }


                            }
                            break;
                        case 4:
                            System.out.println("please enter your username");

                            if (!scanner.hasNextInt()) {
                                check = true;
                                throw new InputMismatchException("PLEASE enter integer");
                            } else {
                                username = scanner.nextInt();
                                check = false;
                            }

                            Passengers passengers = new Passengers();
                            existance = db_passenger.check_exist_of_user(username);
                            if (existance == 0) {
                                System.out.println("name,age,address,username,password,balance,width,length");
                                name = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String age2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    age = scanner.nextInt();
                                    check = false;
                                }
                                address = scanner.next();
                                if (!scanner.hasNextInt()) {
                                    String username2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    username = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String password2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    password = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String balance2 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("PLEASE enter integer");
                                } else {
                                    balance = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String width1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    width = scanner.nextInt();
                                    check = false;
                                }
                                if (!scanner.hasNextInt()) {
                                    String length1 = scanner.next();
                                    check = true;
                                    throw new InputMismatchException("Please Enter Integer");
                                } else {
                                    length = scanner.nextInt();
                                    check = false;
                                }
                                passengers = new Passengers();
                                passengers.setName(name);
                                passengers.setAge(age);
                                passengers.setAddress(address);
                                passengers.setUsername(username);
                                passengers.setPassword(password);
                                passengers.setBalance(balance);
                                passengers.setLength(length);
                                passengers.setWidth(width);
                                db_passenger.add_passenger(passengers);
                                management.passengers.add(passengers);
                                check = false;
                            } else {
                                int choice = 0;

                                do {
                                    System.out.println("1.request trip with cash\n" +
                                            "2.request trip with online \n3.increase balance\n4.exit");
                                    if (!scanner.hasNextInt()) {
                                        String choice1 = scanner.next();
                                        check = true;
                                        throw new InputMismatchException("Please Enter Integer");
                                    } else {
                                        choice = scanner.nextInt();
                                        check = false;
                                    }
                                    switch (choice) {
                                        case 1:
                                            System.out.println("enter width & length of your origin & destination");
                                            System.out.println("Origin Width, origin Length," +
                                                    " destination Width, Destination Length");
                                            int originWidth = scanner.nextInt();
                                            int originLength = scanner.nextInt();
                                            int destinationWidth = scanner.nextInt();
                                            int DestinationLength = scanner.nextInt();
                                            passengers = management.findPassengerByUsername(username);
                                            trip = passengers.requestCash(trip, DestinationLength, destinationWidth,
                                                    originLength, originWidth);
                                            trip.setPassengers(passengers);
                                            driver = management.minDistance(originWidth, originLength);
                                            passengers.setDriver(driver);
                                            driver.setTripStatue(Trip_status.ONTRIP);
                                            driver.setPaymentType(PaymentType.CASH);
                                            db_driver.changeStatus(passengers.getDriver().getUsername());
                                            trip.setDriver(driver);
                                            trip.setPaymentType(PaymentType.CASH);
                                            trip.setTripStatus(Trip_status.ONTRIP);
                                            db_trip.addTrip(trip);
                                            System.out.println(" your request is successfully added ");
                                            break;
                                        case 2:
                                            System.out.println("enter width & length of your origin & destination");
                                            System.out.println("Origin Width, origin Length," +
                                                    " destination Width, Destination Length");
                                            originWidth = scanner.nextInt();
                                            originLength = scanner.nextInt();
                                            destinationWidth = scanner.nextInt();
                                            DestinationLength = scanner.nextInt();
                                            passengers = management.findPassengerByUsername(username);
                                            trip = passengers.requestOnline(trip, DestinationLength, destinationWidth,
                                                    originLength, originWidth, db_passenger, username);
                                            trip.setPassengers(passengers);
                                            driver = management.minDistance(originWidth, originLength);
                                            passengers.setDriver(driver);
                                            driver.setTripStatue(Trip_status.ONTRIP);
                                            driver.setPaymentType(PaymentType.ONLINE);
                                            db_driver.changeStatus(passengers.getDriver().getUsername());
                                            trip.setDriver(driver);
                                            trip.setPaymentType(PaymentType.ONLINE);
                                            trip.setTripStatus(Trip_status.ONTRIP);
                                            db_trip.addTrip(trip);
                                            db_passenger.decreaseBalance(username, trip.calculateCost());
                                            db_driver.increase(driver.getUsername(), trip.calculateCost());
                                            System.out.println(" your request is successfully added ");
                                            break;

                                        case 3:
                                            System.out.println("please enter fund");
                                            int fund = 0;
                                            if (!scanner.hasNextInt()) {
                                                String fund1 = scanner.next();
                                                check = true;
                                                throw new InputMismatchException("Please Enter Integer");
                                            } else {
                                                fund = scanner.nextInt();
                                                check = false;
                                            }
                                            db_passenger.increase_balance(username, fund);
                                            break;
                                        case 4:
                                            break;
                                    }


                                } while (choice != 4);
                            }
                            break;
                        case 5:
                            db_driver.show_driver();
                            break;
                        case 6:
                            db_passenger.show_passenger();
                            break;
                        case 7:
                            break;
                        default:
                            check = true;
                            throw new InputMismatchException("Please Enter Value Between 1-7");


                    }

                } while (input != 7);

            } catch (InputMismatchException inputMismatchException) {
                System.out.println(inputMismatchException.getMessage());
            }
        }
    }
}
