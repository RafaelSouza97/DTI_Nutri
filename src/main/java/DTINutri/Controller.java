package DTINutri;

import DTINutri.Domain.*;
import DTINutri.Repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Controller {
    private Client_Repository clients;
    private Food_Group_Repository food_groups;
    private Restriction_Repository restrictions;
    private Food_Repository foods;
    private Appointment_Repository appointments;

    public Controller() throws ParseException {
        this.clients = new_Clients();
        this.food_groups = new_food_groups();
        this.restrictions = new_restrictions();
        this.foods = new_foods(this.food_groups,this.restrictions);
        this.appointments = new_appointments(this.clients,this.restrictions,this.foods);
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

        Food_Group food_group2 = new Food_Group(food_groups.get_all_Food_Groups().size(),"Alimentos sólidos");
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
        Food food1 = new Food(foods.get_all_foods().size(),"Leite",750, food_groups.get_all_Food_Groups().get(0));
        //Inserting a restriction into a food
        food1.insertRestriction(restrictions.get_all_restrictions().get(0));
        //Inserting a Food into a list
        foods.insert_food(food1);

        Food food2 = new Food(foods.get_all_foods().size(),"Refrigerante",1000, food_groups.get_all_Food_Groups().get(0));
        food2.insertRestriction(restrictions.get_all_restrictions().get(3));
        food2.insertRestriction(restrictions.get_all_restrictions().get(2));
        foods.insert_food(food2);

        Food food3 = new Food(foods.get_all_foods().size(),"Suco s/ açúcar",500, food_groups.get_all_Food_Groups().get(0));
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

        Food food7 = new Food(foods.get_all_foods().size(),"Peito de Frango",500, food_groups.get_all_Food_Groups().get(2));
        foods.insert_food(food7);

        Food food8 = new Food(foods.get_all_foods().size(),"Bacon",1000, food_groups.get_all_Food_Groups().get(2));
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
        appointment1.setFood1(foods.get_all_foods().get(2));
        appointment1.setFood2(foods.get_all_foods().get(5));
        appointment1.setFood3(foods.get_all_foods().get(6));

        //Insert appointment into a list
        appointments.insert_appointment(appointment1);

        Appointment appointment2 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(1),"15-10-2021 09:00:00");
        appointment2.setWeight(70.5);
        appointment2.setBodyfat(15.2);
        appointment2.setPhsical_description("Teste Teste");
        appointment2.setCalories_goal(2250.0);
        appointment2.setFood1(foods.get_all_foods().get(0));
        appointment2.setFood2(foods.get_all_foods().get(4));
        appointment2.setFood3(foods.get_all_foods().get(8));
        appointments.insert_appointment(appointment2);


        Appointment appointment3 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(2),"15-10-2021 10:00:00");
        appointment3.setWeight(58.5);
        appointment3.setBodyfat(10.5);
        appointment3.setPhsical_description("Teste Teste");
        appointment3.setRestrictions(restrictions.get_all_restrictions().get(1));
        appointment3.setRestrictions(restrictions.get_all_restrictions().get(2));
        appointment3.setCalories_goal(3000.0);
        appointment3.setFood1(foods.get_all_foods().get(1));
        appointment3.setFood2(foods.get_all_foods().get(3));
        appointment3.setFood3(foods.get_all_foods().get(7));
        appointments.insert_appointment(appointment3);

        Appointment appointment4 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(0),"18-10-2021 12:00:00");
        appointment4.setWeight(80.5);
        appointment4.setBodyfat(17.0);
        appointment4.setPhsical_description("Teste Teste");
        appointment4.setRestrictions(restrictions.get_all_restrictions().get(1));
        appointment4.setCalories_goal(2000.0);
        appointment4.setFood1(foods.get_all_foods().get(2));
        appointment4.setFood2(foods.get_all_foods().get(4));
        appointment4.setFood3(foods.get_all_foods().get(6));
        appointments.insert_appointment(appointment4);

        Appointment appointment5 = new Appointment(appointments.get_all_appointment().size(),clients.get_all_clients().get(2),"18-10-2021 14:30:00");
        appointments.insert_appointment(appointment5);

        //showappointments(appointments);

        return appointments;
    }

    //Functions to insert values written by the user
    public Client Insert_Client(Scanner sc) throws ParseException {
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

        Client client = new Client(this.clients.get_all_clients().size(),name,birthdate,address,mail,phone_number,landline);

        System.out.println('\n' + "- VERIFICAÇÃO DOS DADOS INSERIDOS - ");
        showClient(client);

        return client;
    }
    public Appointment Insert_Appointment(Scanner sc) throws ParseException {
        int id_client;
        String daytime = "";
        Client client = null;


        System.out.println("- MARCAÇÃO DE CONSULTA -");

        boolean valid_data = false;
        while(client == null && !valid_data){
            try{
                System.out.println("Insira o id do cliente");
                id_client = sc.nextInt();
                sc.nextLine();
                client = this.clients.search_client(id_client);
                if(client == null){
                    System.out.println("Valor inválido! Digite novamente." + '\n');
                }else{
                    valid_data = true;
                }
            }catch (Exception e){
                System.out.println("Valor inválido! Digite novamente." + '\n');
                sc.nextLine();
            }
        }

        boolean valid_data1 = false;
        while (!valid_data1) {
            try {
                System.out.println("Insira a data de marcação da consulta (dd-mm-yyyy hh:mi):");
                daytime = sc.nextLine();
                Date data_teste = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(daytime);
                valid_data1 = true;
            } catch (Exception e) {
                System.out.println("Data inválida! Digite novamente no padrão 'dd-mm-yyyy hh:mi'." + '\n');
            }
        }

        Appointment appointment = new Appointment(this.getAppointments().get_all_appointment().size(),client,daytime);
        System.out.println('\n' + "- VERIFICAÇÃO DOS DADOS INSERIDOS - ");
        int ver = showAppointment(appointment);

        return appointment;
    }
    public boolean Insert_Appointment_details(Scanner sc, int id_appointment) {
        Double weight = 0.00;
        Double bodyfat = 0.00;
        String phsical_description = "";
        Double calories = 0.00;
        Food food1 = null;
        Food food2 = null;
        Food food3 = null;
        boolean restriction1 = false;
        boolean restriction2 = false;
        boolean restriction3 = false;
        boolean restriction4 = false;
        boolean status = false;

        boolean insert1 = false;
        while (!insert1){
            try {
                System.out.println("Insira o peso do cliente:");
                weight = sc.nextDouble();
                sc.nextLine();
                insert1 = true;
            }catch (Exception e){
                System.out.println("Valor inválido, insira novamente!");
                sc.nextLine();
            }
        }

        boolean insert2 = false;
        while (!insert2) {
            try {
                System.out.println("Insira o percentual de gordura do cliente:");
                bodyfat = sc.nextDouble();
                sc.nextLine();
                insert2 = true;
            } catch (Exception e) {
                System.out.println("Valor inválido, insira novamente!");
                sc.nextLine();
            }
        }

        System.out.println("Insira a sensação física do cliente:");
        phsical_description = sc.nextLine();

        boolean insert3 = false;
        while (!insert3) {
            try {
                System.out.println("Insira a meta calórica do cliente:");
                calories = sc.nextDouble();
                sc.nextLine();
                insert3 = true;
            } catch (Exception e) {
                System.out.println("Valor inválido, insira novamente!");
                sc.nextLine();
            }
        }

        String option1 = "";
        while(!option1.equals("S")&&!option1.equals("N")){
            System.out.println('\n' + "O paciente possui intolerância a lactose? (S/N)");
            option1 = sc.nextLine().toUpperCase();
            if(!option1.equals("S")&&!option1.equals("N")){
                System.out.println("Dados incorretos. Favor inserir no formato correto (S/N)");
            }
        }
        if(option1.equals("S")){
            restriction1 = true;
        }

        String option2 = "";
        while(!option2.equals("S")&&!option2.equals("N")){
            System.out.println('\n' + "O paciente possui intolerância a glúten? (S/N)");
            option2 = sc.nextLine().toUpperCase();
            if(!option2.equals("S")&&!option2.equals("N")){
                System.out.println("Dados incorretos. Favor inserir no formato correto (S/N)");
            }
        }
        if(option1.equals("S")){
            restriction2 = true;
        }

        String option3 = "";
        while(!option3.equals("S")&&!option3.equals("N")){
            System.out.println('\n' + "O paciente possui triglices alto? (S/N)");
            option3 = sc.nextLine().toUpperCase();
            if(!option3.equals("S")&&!option3.equals("N")){
                System.out.println("Dados incorretos. Favor inserir no formato correto (S/N)");
            }
        }
        if(option1.equals("S")){
            restriction3 = true;
        }

        String option4 = "";
        while(!option4.equals("S")&&!option4.equals("N")){
            System.out.println('\n' + "O paciente possui diabetes? (S/N)");
            option4 = sc.nextLine().toUpperCase();
            if(!option4.equals("S")&&!option4.equals("N")){
                System.out.println("Dados incorretos. Favor inserir no formato correto (S/N)");
            }
        }
        if(option1.equals("S")){
            restriction4 = true;
        }

        permutation_foods(calories);

        System.out.println('\n' + "- LISTA DE BEBIDAS -");
        List<Food> foods_list = foods.search_food_by_group(0);
        for (int i = 0; i < foods_list.size(); i++){
            Food selected_food = foods_list.get(i);
            System.out.println("ID: " + selected_food.getId_food() + ", Nome: " + selected_food.getName() + ", Calorias: " + selected_food.getCalories());
        }

        boolean valid_data1 = false;
        while (!valid_data1) {
            System.out.println('\n' + "Qual será a bebida inserida?");
            try {
                int number1 = sc.nextInt();
                if(foods_list.contains(foods.get_all_foods().get(number1))) {
                    food1 = foods.get_all_foods().get(number1);
                    valid_data1 = true;
                }else{
                    System.out.println("Valor inválido! Digite novamente." + '\n');
                }
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Valor inválido! Digite novamente." + '\n');
                sc.nextLine();
            }
        }


        System.out.println('\n' + "- LISTA DE ALIMENTOS SÓLIDOS -");
        List<Food> foods_list1 = foods.search_food_by_group(1);
        for (int i = 0; i < foods_list1.size(); i++){
            Food selected_food = foods_list1.get(i);
            System.out.println("ID: " + selected_food.getId_food() + ", Nome: " + selected_food.getName() + ", Calorias: " + selected_food.getCalories());
        }

        boolean valid_data2 = false;
        while (!valid_data2) {
            System.out.println('\n' + "Qual será o alimento sólido inserido?");
            try {
                int number2 = sc.nextInt();
                if(foods_list1.contains(foods.get_all_foods().get(number2))) {
                    food2 = foods.get_all_foods().get(number2);
                    valid_data2 = true;
                }else{
                    System.out.println("Valor inválido! Digite novamente." + '\n');
                }
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Valor inválido! Digite novamente." + '\n');
                sc.nextLine();
            }
        }


        System.out.println('\n' + "- LISTA DE CARNES/OVOS -");
        List<Food> foods_list2 = foods.search_food_by_group(2);
        for (int i = 0; i < foods_list2.size(); i++){
            Food selected_food = foods_list2.get(i);
            System.out.println("ID: " + selected_food.getId_food() + ", Nome: " + selected_food.getName() + ", Calorias: " + selected_food.getCalories());
        }

        boolean valid_data3 = false;
        while (!valid_data3) {
            System.out.println('\n' + "Qual será o tipo de carne/ovo inserido?");
            try {
                int number3 = sc.nextInt();
                if(foods_list2.contains(foods.get_all_foods().get(number3))) {
                    food3 = foods.get_all_foods().get(number3);
                    valid_data3 = true;
                }else{
                    System.out.println("Valor inválido! Digite novamente." + '\n');
                }
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Valor inválido! Digite novamente." + '\n');
                sc.nextLine();
            }
        }

        String option_insert = "";
        while(!option_insert.equals("S")&&!option_insert.equals("N")){
            System.out.println('\n' + "Deseja inserir os dados informados? (S/N)");
            option_insert = sc.nextLine().toUpperCase();
            if(!option_insert.equals("S")&&!option_insert.equals("N")){
                System.out.println("Dados incorretos. Favor inserir no formato correto (S/N)");
            }
        }

        if(option_insert.equals("S")){
            appointments.get_all_appointment().get(id_appointment).setWeight(weight);
            appointments.get_all_appointment().get(id_appointment).setBodyfat(bodyfat);
            appointments.get_all_appointment().get(id_appointment).setPhsical_description(phsical_description);
            if(restriction1){
                appointments.get_all_appointment().get(id_appointment).setRestrictions(this.restrictions.get_all_restrictions().get(0));
            }
            if(restriction2){
                appointments.get_all_appointment().get(id_appointment).setRestrictions(this.restrictions.get_all_restrictions().get(1));
            }
            if(restriction3){
                appointments.get_all_appointment().get(id_appointment).setRestrictions(this.restrictions.get_all_restrictions().get(2));
            }
            if(restriction4){
                appointments.get_all_appointment().get(id_appointment).setRestrictions(this.restrictions.get_all_restrictions().get(3));
            }
            appointments.get_all_appointment().get(id_appointment).setFood1(food1);
            appointments.get_all_appointment().get(id_appointment).setFood2(food2);
            appointments.get_all_appointment().get(id_appointment).setFood3(food3);
            status = true;
        }else{
            status = false;
        }
        return status;
    }


    //Functions to show data stored in repositories
    public void showClients(){
        //Show Client informations
        System.out.println("- TODOS OS CLIENTES -");
        for (int i = 0;i<this.clients.get_all_clients().size(); i++) {
            Client client_test = this.clients.get_all_clients().get(i);
            System.out.println("ID: " + client_test.getId_client() + ", Nome: " + client_test.getName() + ", Dt. Nascimento: " + client_test.getBirthdate());
        }
        System.out.println("");
    }
    public void showFood_Groups(){
        //Show Food_Group informations
        System.out.println("- TODOS OS GRUPOS DE ALIMENTOS -");
        for (int i = 0;i<this.food_groups.get_all_Food_Groups().size(); i++) {
            Food_Group food_group_test = this.food_groups.get_all_Food_Groups().get(i);
            System.out.println("ID: " + food_group_test.getId_food_group() + ", Nome: " + food_group_test.getName());
        }
        System.out.println("");
    }
    public void showRestrictions(){
        //Show Restriction informations
        System.out.println("- TODAS AS RESTRIÇÕES -");
        for (int i = 0;i<this.restrictions.get_all_restrictions().size(); i++) {
            Restriction restriction_test = this.restrictions.get_all_restrictions().get(i);
            System.out.println("ID: " + restriction_test.getId_restriction() + ", Nome: " + restriction_test.getName());
        }
        System.out.println("");
    }
    public void showFoods(){
        //Show Foods information
        System.out.println("- TODOS OS ALIMENTOS -");
        for (int i = 0;i<this.foods.get_all_foods().size(); i++) {
            Food food_test = this.foods.get_all_foods().get(i);
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
    public void showAppointments(){
        System.out.println("- TODAS AS CONSULTAS -");
        for (int i = 0;i<this.appointments.get_all_appointment().size(); i++) {
            Appointment appointment_test = this.appointments.get_all_appointment().get(i);
            System.out.print("ID: " + appointment_test.getId_appointment() + ", Cliente: " + appointment_test.getClient().getName() + ", Data: " + appointment_test.getDaytime());
            if(!appointment_test.getPhsical_description().isEmpty()){
                System.out.println(", Peso: " + appointment_test.getWeight() + ", Percentual de gordura: " + appointment_test.getBodyfat() + ", Sensação física: " + appointment_test.getPhsical_description() + ", Restrições: " + showRestriction(appointment_test.getRestrictions()) + ", Alimento 1: " + appointment_test.getFood1().getName() + ", Alimento 2: " + appointment_test.getFood2().getName() + ", Alimento 3: " + appointment_test.getFood3().getName());
            }else{
                System.out.println(" - (CONSULTA NÃO REALIZADA!)");
            }
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
    public static int showAppointment(Appointment appointment) {
        if (appointment == null) {
            //Não existe consulta
            System.out.println("A consulta informada não exite!");
            return 0;
        }else{
            System.out.print("ID: " + appointment.getId_appointment() + ", Nome: " + appointment.getClient().getName() + ", Data: " + appointment.getDaytime());
            if(!appointment.getPhsical_description().isEmpty()){
                //Consulta já realizada
                System.out.println(", Peso: " + appointment.getWeight() + ", Percentual de gordura: " + appointment.getBodyfat() + ", Sensação física: " + appointment.getPhsical_description() + ", Restrições: " + showRestriction(appointment.getRestrictions()) + ", Alimento 1: " + appointment.getFood1().getName() + ", Alimento 2: " + appointment.getFood2().getName() + ", Alimento 3: " + appointment.getFood3().getName());
                System.out.println('\n' + "A consulta informada já foi realizada!" + '\n');
                return 1;
            }else{
                //Consulta a se realizar
                System.out.println(" - (CONSULTA NÃO REALIZADA!)");
                return 2;
            }
        }
    }
    public static String showRestriction(List<Restriction> restriction) {
        String message = "";
        if (restriction.size() == 0) {
            message = "Não existem restrições!";
        }else{
            for(int i = 0; i<restriction.size();i++){
                message += restriction.get(i).getName();
                if(i < restriction.size() - 1){
                    message += ", ";
                }
            }
        }
        return  message;
    }

    //Fucntions to search each object
    public void searchClient(Scanner sc){
        int id = 0;
        System.out.println("- BUSCA DE CLIENTE -");

        boolean valid_data = false;
        while (!valid_data) {
            System.out.println("Informe o id do cliente:");
            try {
                id = sc.nextInt();
                valid_data = true;
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Valor inválido! Digite novamente." + '\n');
                sc.nextLine();
            }
        }

        Client client = this.clients.search_client(id);
        System.out.println("- DADOS DO CLIENTE -");
        showClient(client);
        System.out.println("");

        if(client != null) {
            List<Appointment> client_appointments_list = this.appointments.search_client_appointments(client.getId_client());
            showClientAppointments(client_appointments_list);
        }
    }
    public void searchAppointment(Scanner sc){
        int id = 0;
        System.out.println("- INICIAR CONSULTA -");

        boolean valid_data = false;
        while (!valid_data) {
            System.out.println("Informe o id da consulta:");
            try {
                id = sc.nextInt();
                sc.nextLine();
                valid_data = true;
            } catch (Exception e) {
                System.out.println("Valor inválido! Digite novamente." + '\n');
                sc.nextLine();
            }
        }

        Appointment appointment = this.appointments.search_appointment(id);
        System.out.println("- DADOS DA CONSULTA -");
        int ie_appointment = showAppointment(appointment);
        if(ie_appointment == 2){
            System.out.println("- INICIAR CONSULTA -");
            boolean status = Insert_Appointment_details(sc,appointment.getId_appointment());
            if(status){
                System.out.println("Consulta finalizada com sucesso!" + '\n');
            }else{
                System.out.println("Os dados inseridos foram descartados." +'\n');
            }
        }
        System.out.println("");
    }

    //Funcion to permutate the food values
    public void permutation_foods(double total_cal){
        System.out.println("- LISTA DE ALIMENTOS RECOMENDADOS -");
        Map<Double, List<Food>> mapa = new HashMap<Double, List<Food>>();

        List<Food> foods1 = foods.search_food_by_group(0);
        List<Food> foods2 = foods.search_food_by_group(1);
        List<Food> foods3 = foods.search_food_by_group(2);

        for(int x = 0; x<foods1.size();x++){
            for(int y = 0; y<foods2.size();y++){
                for (int z = 0; z<foods3.size();z++){
                    double calories = foods1.get(x).getCalories() + foods2.get(y).getCalories() + foods3.get(z).getCalories();
                    if(calories <= total_cal) {
                        System.out.println("Bebida: " + foods1.get(x).getName() + ", Alimento Sólido: " + foods2.get(y).getName() + ", Carne/Ovo: " + foods3.get(z).getName() + ", Total de Calorias: " + calories);
                    }
                    List<Food> food_combination = new ArrayList<Food>();
                    food_combination.add(foods1.get(x));
                    food_combination.add(foods2.get(y));
                    food_combination.add(foods3.get(z));
                    mapa.put(calories,food_combination);
                }
            }
        }
    }


    public Client_Repository getClients() {
        return clients;
    }
    public void setClients(Client_Repository clients) {
        this.clients = clients;
    }
    public Food_Group_Repository getFood_groups() {
        return food_groups;
    }
    public void setFood_groups(Food_Group_Repository food_groups) {
        this.food_groups = food_groups;
    }
    public Restriction_Repository getRestrictions() {
        return restrictions;
    }
    public void setRestrictions(Restriction_Repository restrictions) {
        this.restrictions = restrictions;
    }
    public Food_Repository getFoods() {
        return foods;
    }
    public void setFoods(Food_Repository foods) {
        this.foods = foods;
    }
    public Appointment_Repository getAppointments() {
        return appointments;
    }
    public void setAppointments(Appointment_Repository appointments) {
        this.appointments = appointments;
    }
}
