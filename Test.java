package Project_5;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        int userCh;

        //ask user for rail conditions
        double maxLoadConditions;
        System.out.println("What is the maximum weight the rails can handle?: ");
        maxLoadConditions = scan.nextDouble();

        //construct initial train
        System.out.println("\t--Construct a train--");
        Train train = buildTrain();

        do {
            //main program
            System.out.println("\n1). Add a car\n2). Review detailed train info" +
                    "\n3). Review car info\n4). Review basic train info\n5). Construct" +
                    " a new train\n6). Exit program");
            userCh = scan.nextInt();

            switch (userCh) {
                //add a car
                case 1:
                    addCar(train);
                    break;
                //detailed train info
                case 2:
                    System.out.println(train.displayFullSummary());
                    checkPullingConditions(train.getTotalWeight(), train.getEngine().getPullingCapacity());
                    break;
                //detailed car info
                case 3:
                    System.out.println(train.displayCarsSummary());
                    break;
                //basic train info
                case 4:
                    System.out.println(train.displayBriefSummary());
                    //warning user if the train is too heavy for current rail conditions
                    double totalWeight = train.getTotalWeight();
                    checkRailConditions(totalWeight, maxLoadConditions);
                    break;
                //make a new train
                case 5:
                    train = buildTrain();
                    break;
                //exit program
                default:
                    System.out.println("\n\n\tProgram ended");
                    loop = false;
                    break;
            }
        } while(loop);

    }



    public static Train buildTrain() {
        Scanner scan = new Scanner(System.in);
        Train train;
        String owner;
        double weight;
        double pullingCapacity;
        String engineer;
        System.out.println("Engine info:");
        System.out.println("\towner (company): ");
        owner = scan.next();
        System.out.println("\tweight: ");
        weight = scan.nextDouble();
        System.out.println("\tmaximum pulling capacity: ");
        pullingCapacity = scan.nextDouble();
        Engine engine1 = new Engine(owner, 0, weight, pullingCapacity);

        System.out.println("Train info: ");
        System.out.println("\tengineer: ");
        engineer = scan.next();
        train = new Train(engineer, engine1);

        System.out.println("Would you like to add a car to this train? (y/n): ");
        String userAns = scan.next();
        if(userAns.equalsIgnoreCase("y"))
            addCar(train);

        return train;
    }

    //runs through process of adding a car to the train
    public static void addCar(Train t) {
        Scanner scan = new Scanner(System.in);
        Car add;
        String owner;
        double weight;
        String contentsName;
        Contents contents;
        double loadFactor;
        String containerName;
        Container container;

        System.out.println("--Enter some information about the car--");
        System.out.println("owner of the car: ");
        owner = scan.nextLine();
        System.out.println("weight: ");
        weight = scan.nextDouble();
        System.out.println("contents: ");
        contentsName = scan.next();
        contents = pickContents(contentsName);
        System.out.println("load factor: ");
        loadFactor = scan.nextDouble();
        System.out.println("container type: ");
        containerName = scan.next();
        container = pickContainer(containerName);

        add = new Car(owner, t.getNumOfCars(), weight, contents, container, loadFactor);
        t.addCar(add);
        System.out.println("Car added successfully.\n");
    }

    //returns the content of the parameter's name
    public static Contents pickContents(String sample) {

        //predefined contents
        Contents oil = new Contents("oil", 55, 516.73);
        Contents coal = new Contents("coal", 69, 0.017);
        Contents soybeans = new Contents("soybeans", 47, 0.153);
        Contents meal = new Contents("meal", 32, 1.30);
        Contents oats = new Contents("oats", 27, 0.08);

        switch(sample){
            case "coal":
                return coal;
            case "soybeans":
                return soybeans;
            case "meal":
                return meal;
            case "oats:":
                return oats;
            default:
                return oil;
        }
    }

    //runs through process of creating a new container (trap or cyl)
    public static Container pickContainer(String sample) {
        Scanner scan = new Scanner(System.in);
        Container container;

        if(sample.equalsIgnoreCase("cylindrical")) {
            double radius;
            double height;
            System.out.println("container radius: ");
            radius = scan.nextDouble();
            System.out.println("container height: ");
            height = scan.nextDouble();
            double wallThick;
            double wallDens;
            System.out.println("wall thickness: ");
            wallThick = scan.nextDouble();
            System.out.println("wall density: ");
            wallDens = scan.nextDouble();
            container = new Cylindrical(wallThick, wallDens, radius, height);
        }

        else {
            double upLen;
            double lowLen;
            System.out.println("upper length of container: ");
            upLen = scan.nextDouble();
            System.out.println("lower length of container: ");
            lowLen = scan.nextDouble();
            double width;
            double height;
            System.out.println("container width: ");
            width = scan.nextDouble();
            System.out.println("container height: ");
            height = scan.nextDouble();
            double wallThick;
            double wallDens;
            System.out.println("wall thickness: ");
            wallThick = scan.nextDouble();
            System.out.println("wall density: ");
            wallDens = scan.nextDouble();
            container = new Trapezoidal(wallThick, wallDens, upLen, lowLen, width, height);
        }

        return container;

    }

    public static void checkRailConditions(double weight, double railCond) {
        if(weight > railCond)
            System.out.println("\n**WARNING: your train is too heavy**");
    }

    public static void checkPullingConditions(double weight, double pullingCap) {
        if(weight > pullingCap)
            System.out.println("***WARNING: the weight exceeds the pulling capacity**");
    }
}

