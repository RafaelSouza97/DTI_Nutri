package DTINutri;

import DTINutri.Domain.*;
import DTINutri.Repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class ApplicationStart {
    public static void main(String[] args) throws ParseException {
        Client_Repository clients = new_Clients();
        Food_Group_Repository food_groups = new_food_groups();
        Restriction_Repository restrictions = new_restrictions();
        Food_Repository foods = new_foods(food_groups,restrictions);
        Appointment_Repository appointments = new_appointments(clients,restrictions,foods);

        Scanner sc = new Scanner(System.in);
        String command = "";
        System.out.println("Olá Marina, seja bem vinda ao DTINutri!" + '\n');
        while (!command.equals("-")){
            //HomeScreen
            command = Home_Screen(sc, command);
            if (!command.equals("-")) {
                System.out.println("");
                switch (command) {
                    case "1":
                        while (!command.equals("-") && !command.equals("/")) {
                            command = Appointments_Screen(sc);
                            if (!command.equals("-") && !command.equals("/")) {
                                System.out.println("");
                                switch (command) {
                                    case "1":
                                        //Show all appointments
                                        showAppointments(appointments);
                                        command = "";
                                        break;
                                    case "2":
                                        //Acess a appointment
                                        searchAppointment(sc,appointments);
                                        command = "";
                                        break;
                                    case "3":
                                        //Add a appointment scheduling
                                        System.out.println("- MARCAR CONSULTA -");
                                        Insert_Appointment(sc,appointments.get_all_appointment().size(),clients);
                                        command = "";
                                        break;
                                }
                            }
                        }
                        break;
                    case "2":
                        while (!command.equals("-") && !command.equals("/")) {
                            command = Clients_Screen(sc);
                            if (!command.equals("-") && !command.equals("/")) {
                                System.out.println("");
                                switch (command) {
                                    case "1":
                                        //Show all clients
                                        showClients(clients);
                                        command = "";
                                        break;
                                    case "2":
                                        //Search a client
                                        searchClient(sc,clients,appointments);
                                        command = "";
                                        break;
                                    default:
                                        //Insert a client
                                        Client client = Insert_Client(sc,clients.get_all_clients().size());
                                        String option = sc.nextLine();
                                        if(option.equals("S")){
                                            clients.insert_client(client);
                                            System.out.println("Cliente inserido com sucesso!" + '\n');
                                        }else{
                                            System.out.println("Os dados inseridos foram descartados." +'\n');
                                        }
                                        command = "";
                                        break;
                                }
                            }
                        }
                        break;
                    default:
                        while (!command.equals("-") && !command.equals("/")) {
                            command = Registration_Screen(sc);
                            if (!command.equals("-") && !command.equals("/")) {
                                System.out.println("");
                                switch (command) {
                                    case "1":
                                        //Show all foods
                                        showFoods(foods);
                                        command = "";
                                        break;
                                    case "2":
                                        //Show all food groups
                                        showFood_Groups(food_groups);
                                        command = "";
                                        break;
                                    default:
                                        //Show all restrictions
                                        showRestrictions(restrictions);
                                        command = "";
                                        break;
                                }
                            }
                        }
                        break;
                }
            }
            System.out.println("");
        }
        System.out.println("Obrigado por ter utilizado o DTINutri, até breve!");
    }

    //Functions of the screens
    public static String Home_Screen(Scanner sc, String command){
        while (!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("-")) {
            System.out.println("- TELA INICIAL -");
            System.out.println("Escolha uma das opções para continuar:");
            System.out.println("[1] Consultas" + '\n' + "[2] Clientes" + '\n' + "[3] Cadastros Gerais" + '\n' + "[-] Encerrar a aplicação");
            System.out.print("Insira a opção: ");
            command = sc.nextLine();
            if (!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("-")){
                System.out.println("Opção inválida! Digite novamente." + '\n');
            }
        }
        return command;
    }
    public static String Appointments_Screen(Scanner sc){
        //Consultas
        String command = "";
        while (!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("/") && !command.equals("-")) {
            System.out.println("- CONSULTAS -");
            System.out.println("Escolha uma das opções para continuar:");
            System.out.println("[1] Ver todas as consultas" + '\n' + "[2] Iniciar uma consulta" + '\n' + "[3] Marcar uma consulta" + '\n' + "[/] Voltar a tela anterior" + '\n' + "[-] Encerrar a aplicação");
            System.out.print("Insira a opção: ");
            command = sc.nextLine();
            if (!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("/") && !command.equals("-")){
                System.out.println("Opção inválida! Digite novamente." + '\n');
            }
        }
        return command;
    }
    public static String Clients_Screen(Scanner sc){
        //Clientes
        String command = "";
        while (!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("/") && !command.equals("-")) {
            System.out.println("- CLIENTES -");
            System.out.println("Escolha uma das opções para continuar:");
            System.out.println("[1] Ver todos os clientes" + '\n' + "[2] Verificar todos os dados de um cliente" + '\n' + "[3] Cadastrar um cliente" + '\n' + "[/] Voltar a tela anterior" + '\n' + "[-] Encerrar a aplicação");
            System.out.print("Insira a opção: ");
            command = sc.nextLine();
            if (!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("/") && !command.equals("-")) {
                System.out.println("Opção inválida! Digite novamente." + '\n');
            }
        }
        return command;
    }
    public static String Registration_Screen(Scanner sc){
        //Clientes
        String command = "";
        while (!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("/") && !command.equals("-")) {
            System.out.println("- CADASTROS GERAIS -");
            System.out.println("Escolha uma das opções para continuar:");
            System.out.println("[1] Ver todos os alimentos" + '\n' + "[2] Ver todos os grupos de alimentos" + '\n' + "[3] Ver todas as restrições" + '\n' + "[/] Voltar a tela anterior" + '\n' + "[-] Encerrar a aplicação");
            System.out.print("Insira a opção: ");
            command = sc.nextLine();
            if (!command.equals("1") && !command.equals("2") && !command.equals("3") && !command.equals("/") && !command.equals("-")) {
                System.out.println("Opção inválida! Digite novamente." + '\n');
            }
        }
        return command;
    }

    //Functions to insert predefined values
    public static Client_Repository new_Clients() throws ParseException {
        Client_Repository clients = new Client_Repository();

        //Creating a Client
        Client client1 = new Client(clients.get_all_clients().size(),"Matheus Vicente Lorenzo da Cruz", "26-06-1965", "Rua Padre Vieira, 530, Centro, Duque de Caxias - RJ","matheus@gmail.com", "(21) 98928-5757","(21) 2944-2887");
        //Inserting a Client into Client_Repository
        clients.insert_client(client1);

        Client client2 = new Client(clients.get_all_clients().size(),"Ian Ruan Kevin da Mota", "07-02-1975", "Avenida Mar da Noruega, 829, Intermares, Cabedelo - PB","ian@outlook.com", "(83) 99581-0947","(83) 2674-8773");
        clients.insert_client(client2);

        Client client3 = new Client(clients.get_all_clients().size(),"José Carlos João Fernandes", "27-04-1966", "Avenida Marginal, 492, Farolândia, Aracaju - SE","jose@yahoo.com", "(79) 99816-4095","(79) 2790-8651");
        clients.insert_client(client3);

        Client client4 = new Client(clients.get_all_clients().size(),"Eliane Luzia Brenda Gomes", "24-03-1997", "Rua F, 808, Parque Dois Irmãos, Fortaleza - CE","eliane@gmail.com", "(85) 99866-9338","(85) 2594-5827");
        clients.insert_client(client4);

        Client client5 = new Client(clients.get_all_clients().size(),"Teresinha Allana Aparício", "11-03-1956", "Rua A, 826, Rondonópolis - MT","teresinha@gmail.com", "(66) 2947-8944","(66) 98789-4198");
        clients.insert_client(client5);

        //showClients(clients);

        return clients;
    }
    public static Food_Group_Repository new_food_groups(){
        Food_Group_Repository food_groups = new Food_Group_Repository();

        //Creating a Food_Group
        Food_Group food_group1 = new Food_Group(food_groups.get_all_Food_Groups().size(),"Bebidas");
        //Insert a Food_Group into a List
        food_groups.insert_Food_Group(food_group1);

        Food_Group food_group2 = new Food_Group(food_groups.get_all_Food_Groups().size(),"Alimentos sólidos p/ vegetarianos");
        food_groups.insert_Food_Group(food_group2);

        Food_Group food_group3 = new Food_Group(food_groups.get_all_Food_Groups().size(),"Carnes e Ovo");
        food_groups.insert_Food_Group(food_group3);

        //showFood_Groups(food_groups);

        return food_groups;
    }
    public static Restriction_Repository new_restrictions(){
        Restriction_Repository restrictions = new Restriction_Repository();

        //Create a restriction
        Restriction restriction1 = new Restriction(restrictions.get_all_restrictions().size(),"Lactose");
        //Insert a restriction into a list
        restrictions.insert_restrictions(restriction1);

        Restriction restriction2 = new Restriction(restrictions.get_all_restrictions().size(),"Glúten");
        restrictions.insert_restrictions(restriction2);

        Restriction restriction3 = new Restriction(restrictions.get_all_restrictions().size(),"Lipídeos");
        restrictions.insert_restrictions(restriction3);

        Restriction restriction4 = new Restriction(restrictions.get_all_restrictions().size(),"Glicose");
        restrictions.insert_restrictions(restriction4);

        //showRestrictions(restrictions);

        return restrictions;

    }
    public static Food_Repository new_foods(Food_Group_Repository food_groups, Restriction_Repository restrictions){
        Food_Repository foods = new Food_Repository();

        //Creating a Food
        Food food1 = new Food(foods.get_all_foods().size(),"Leite",500, food_groups.get_all_Food_Groups().get(0));
        //Inserting a restriction into a food
        food1.insertRestriction(restrictions.get_all_restrictions().get(0));
        //Inserting a Food into a list
        foods.insert_food(food1);

        Food food2 = new Food(foods.get_all_foods().size(),"Refrigerante",750, food_groups.get_all_Food_Groups().get(0));
        food2.insertRestriction(restrictions.get_all_restrictions().get(3));
        food2.insertRestriction(restrictions.get_all_restrictions().get(2));
        foods.insert_food(food2);

        Food food3 = new Food(foods.get_all_foods().size(),"Suco s/ açúcar",250, food_groups.get_all_Food_Groups().get(0));
        foods.insert_food(food3);

        Food food4 = new Food(foods.get_all_foods().size(),"Queijo Cheddar",1000, food_groups.get_all_Food_Groups().get(1));
        food4.insertRestriction(restrictions.get_all_restrictions().get(0));
        food4.insertRestriction(restrictions.get_all_restrictions().get(2));
        foods.insert_food(food4);

        Food food5 = new Food(foods.get_all_foods().size(),"Pão Francês",750, food_groups.get_all_Food_Groups().get(1));
        food5.insertRestriction(restrictions.get_all_restrictions().get(1));
        food5.insertRestriction(restrictions.get_all_restrictions().get(2));
        foods.insert_food(food5);

        Food food6 = new Food(foods.get_all_foods().size(),"Presunto",500, food_groups.get_all_Food_Groups().get(1));
        foods.insert_food(food6);

        Food food7 = new Food(foods.get_all_foods().size(),"Peito de Frango",750, food_groups.get_all_Food_Groups().get(2));
        foods.insert_food(food7);

        Food food8 = new Food(foods.get_all_foods().size(),"Bacon",750, food_groups.get_all_Food_Groups().get(2));
        food8.insertRestriction(restrictions.get_all_restrictions().get(2));
        foods.insert_food(food8);

        Food food9 = new Food(foods.get_all_foods().size(),"Ovo",750, food_groups.get_all_Food_Groups().get(2));
        foods.insert_food(food9);

        //showFoods(foods);

        return foods;
    }
    public static Appointment_Repository new_appointments(Client_Repository clients, Restriction_Repository restrictions, Food_Repository foods) throws ParseException {
        Appointment_Repository appointments = new Appointment_Repository();

        //Create a appointment
        Appointment appointment1 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(0),"15-10-2021 08:00:00");
        //Setting the appointment values
        appointment1.setWeight(92.5);
        appointment1.setBodyfat(20.0);
        appointment1.setPhsical_description("Teste Teste");
        appointment1.setRestrictions(restrictions.get_all_restrictions().get(1));
        appointment1.setCalories_goal(1500.0);
        //Insert appointment into a list
        appointments.insert_appointment(appointment1);

        Appointment appointment2 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(1),"15-10-2021 09:00:00");
        appointment1.setWeight(70.5);
        appointment1.setBodyfat(15.2);
        appointment1.setPhsical_description("Teste Teste");
        appointment1.setRestrictions(restrictions.get_all_restrictions().get(1));
        appointment1.setRestrictions(restrictions.get_all_restrictions().get(2));
        appointment1.setCalories_goal(2000.0);
        appointments.insert_appointment(appointment2);

        Appointment appointment3 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(2),"15-10-2021 10:00:00");
        appointment1.setWeight(58.5);
        appointment1.setBodyfat(10.5);
        appointment1.setPhsical_description("Teste Teste");
        appointment1.setRestrictions(restrictions.get_all_restrictions().get(1));
        appointment1.setCalories_goal(2500.0);
        appointments.insert_appointment(appointment3);

        Appointment appointment4 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(0),"18-10-2021 12:00:00");
        appointment1.setWeight(80.5);
        appointment1.setBodyfat(17.0);
        appointment1.setPhsical_description("Teste Teste");
        appointment1.setRestrictions(restrictions.get_all_restrictions().get(1));
        appointment1.setCalories_goal(1750.0);
        appointments.insert_appointment(appointment4);

        Appointment appointment5 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(2),"18-10-2021 14:30:00");
        appointment1.setWeight(65.5);
        appointment1.setBodyfat(12.5);
        appointment1.setPhsical_description("Teste Teste");
        appointment1.setRestrictions(restrictions.get_all_restrictions().get(1));
        appointment1.setCalories_goal(2250.0);
        appointments.insert_appointment(appointment5);

        //showappointments(appointments);

        return appointments;
    }

    //Functions to insert values written by the user
    public static Client Insert_Client(Scanner sc, int id) throws ParseException {
        String name = "";
        String birthdate = "";
        String address = "";
        String mail = "";
        String phone_number = "";
        String landline = "";

        System.out.println("- CADASTRO DE CLIENTE -");
        System.out.println("Insira o nome do cliente:");
        name = sc.nextLine();

        boolean valid_data = false;
        while (!valid_data) {
            try {
                System.out.println("Insira a data de nascimento do cliente (dd-mm-yyyy):");
                birthdate = sc.nextLine();
                Date data_teste = new SimpleDateFormat("dd-MM-yyyy").parse(birthdate);
                valid_data = true;
            } catch (Exception e) {
                System.out.println("Data inválida! Digite novamente no padrão 'dd-mm-yyyy'." + '\n');
            }
        }

        System.out.println("Insira o endereço do cliente:");
        address = sc.nextLine();

        do{
            System.out.println("Insira o e-mail do cliente:");
            mail = sc.nextLine();
            if (!mail.contains("@")){
                System.out.println("Email inválido! Digite novamente."+'\n');
            }
        }while (!mail.contains("@"));

        System.out.println("Insira o número de celular do cliente:");
        phone_number = sc.nextLine();

        System.out.println("Insira o número de telefone do clinte:");
        landline = sc.nextLine();

        Client client = new Client(id,name,birthdate,address,mail,phone_number,landline);

        System.out.println('\n' + "- VERIFICAÇÃO DOS DADOS INSERIDOS - ");
        showClient(client);
        System.out.println('\n' + "Os dados estão corretos? (S/N)");

        return client;
    }
    public static Appointment Insert_Appointment(Scanner sc, int id, Client_Repository clients) throws ParseException {
        int id_client;
        String daytime = "";
        Client client = null;


        System.out.println("- MARCAÇÃO DE CONSULTA -");
        while(client == null){
            System.out.println("Insira o id do cliente");
            id_client = sc.nextInt();
            sc.nextLine();
            client = clients.search_client(id_client);
            if(client == null){
                System.out.println("Valor inválido! Digite novamente." + '\n');
            }
        }

        boolean valid_data = false;
        while (!valid_data) {
            try {
                System.out.println("Insira a data de nascimento do cliente (dd-mm-yyyy):");
                daytime = sc.nextLine();
                Date data_teste = new SimpleDateFormat("dd-MM-yyyy").parse(daytime);
                valid_data = true;
            } catch (Exception e) {
                System.out.println("Data inválida! Digite novamente no padrão 'dd-mm-yyyy'." + '\n');
            }
        }

        Appointment appointment = new Appointment(id,client,daytime);
        System.out.println('\n' + "- VERIFICAÇÃO DOS DADOS INSERIDOS - ");
        showAppointment(appointment);
        System.out.println('\n' + "Os dados estão corretos? (S/N)");

        return appointment;
    }

    //Functions to show data stored in repositories
    public static void showClients(Client_Repository clients){
        //Show Client informations
        System.out.println("- TODOS OS CLIENTES -");
        for (int i = 0;i<clients.get_all_clients().size(); i++) {
            Client client_test = clients.get_all_clients().get(i);
            System.out.println("ID: " + client_test.getId_client() + ", Nome: " + client_test.getName() + ", Dt. Nascimento: " + client_test.getBirthdate());
        }
        System.out.println("");
    }
    public static void showFood_Groups(Food_Group_Repository food_groups){
        //Show Food_Group informations
        System.out.println("- TODOS OS GRUPOS DE ALIMENTOS -");
        for (int i = 0;i<food_groups.get_all_Food_Groups().size(); i++) {
            Food_Group food_group_test = food_groups.get_all_Food_Groups().get(i);
            System.out.println("ID: " + food_group_test.getId_food_group() + ", Nome: " + food_group_test.getName());
        }
        System.out.println("");
    }
    public static void showRestrictions(Restriction_Repository restrictions){
        //Show Restriction informations
        System.out.println("- TODAS AS RESTRIÇÕES -");
        for (int i = 0;i<restrictions.get_all_restrictions().size(); i++) {
            Restriction restriction_test = restrictions.get_all_restrictions().get(i);
            System.out.println("ID: " + restriction_test.getId_restriction() + ", Nome: " + restriction_test.getName());
        }
        System.out.println("");
    }
    public static void showFoods(Food_Repository foods){
        //Show Foods information
        System.out.println("- TODOS OS ALIMENTOS -");
        for (int i = 0;i<foods.get_all_foods().size(); i++) {
            Food food_test = foods.get_all_foods().get(i);
            System.out.print("ID: " + food_test.getId_food() + ", Nome: " + food_test.getName() + ", Grupo: " + food_test.getFood_group().getName() + ", Restrições: ");
            if(food_test.getRestrictions().isEmpty()){
                System.out.print("Nenhuma;" + '\n');
            }else {
                for (int y = 0; y < food_test.getRestrictions().size(); y++) {
                    Restriction restrictions = food_test.getRestrictions().get(y);
                    System.out.print(restrictions.getName());
                    if (y < food_test.getRestrictions().size() - 1) {
                        System.out.print(", ");
                    } else {
                        System.out.print(";" + '\n');
                    }
                }
            }
        }
        System.out.println("");
    }
    public static void showAppointments(Appointment_Repository appointments){
        System.out.println("- TODAS AS CONSULTAS -");
        for (int i = 0;i<appointments.get_all_appointment().size(); i++) {
            Appointment appointment_test = appointments.get_all_appointment().get(i);
            System.out.println("ID: " + appointment_test.getId_appointment() + ", Cliente: " + appointment_test.getClient().getName() + ", Data: " + appointment_test.getDaytime());
        }
        System.out.println("");
    }
    public static void showClientAppointments(List<Appointment> appointments){
        System.out.println("- TODAS AS CONSULTAS -");
        if(appointments.size() == 0) {
            System.out.println("O cliente não possui consultas!");
        }else{
            for (int i = 0;i<appointments.size(); i++) {
                Appointment appointment_test = appointments.get(i);
                System.out.println("ID: " + appointment_test.getId_appointment() + ", Cliente: " + appointment_test.getClient().getName() + ", Data: " + appointment_test.getDaytime());
            }
        }
        System.out.println("");
    }


    //Functions to show each object
    public static void showClient(Client client) {
        if (client == null) {
            System.out.println("O cliente informado não exite!");
        }else{
            System.out.println("Nome: " + client.getName() + ", Dt Nascimento: " + client.getBirthdate() + ", E-mail: " + client.getMail() + ", Celular: " + client.getPhone_number() + ", Telefone: " + client.getLandline());
        }
    }
    public static void showAppointment(Appointment appointment) {
        if (appointment == null) {
            System.out.println("A consulta informada não exite!");
        }else{
            System.out.println("ID: " + appointment.getId_appointment() + ", Nome: " + appointment.getClient().getName() + ", Data: " + appointment.getDaytime());
        }
    }

    //Fucntions to search each object
    public static void searchClient(Scanner sc, Client_Repository clients, Appointment_Repository appointments){
        int id = 0;
        System.out.println("- BUSCA DE CLIENTE -");
        System.out.println("Informe o id do cliente:");

        boolean valid_data = false;
        while (!valid_data) {
            try {
                id = sc.nextInt();
                sc.nextLine();
                valid_data = true;
            } catch (Exception e) {
                System.out.println("Valor inválido! Digite novamente." + '\n');
            }
        }

        Client client = clients.search_client(id);
        System.out.println("- DADOS DO CLIENTE -");
        showClient(client);
        System.out.println("");

        if(client != null) {
            List<Appointment> client_appointments_list = appointments.search_client_appointments(client.getId_client());
            showClientAppointments(client_appointments_list);
        }
    }
    public static void searchAppointment(Scanner sc, Appointment_Repository appointments){
        int id = 0;
        System.out.println("- INICIAR CONSULTA -");
        System.out.println("Informe o id da consulta:");

        boolean valid_data = false;
        while (!valid_data) {
            try {
                id = sc.nextInt();
                sc.nextLine();
                valid_data = true;
            } catch (Exception e) {
                System.out.println("Valor inválido! Digite novamente." + '\n');
            }
        }

        Appointment appointment = appointments.search_appointment(id);
        System.out.println("- DADOS DA CONSULTA -");
        showAppointment(appointment);
        System.out.println("");

    }


}


