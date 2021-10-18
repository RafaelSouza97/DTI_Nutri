package DTINutri;

import DTINutri.Domain.*;
import DTINutri.Repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class ApplicationStart {
    public static void main(String[] args) throws ParseException {
        Controller controller = new Controller();

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
                                        controller.showAppointments();
                                        command = "";
                                        break;
                                    case "2":
                                        //Acess a appointment
                                        controller.searchAppointment(sc);
                                        command = "";
                                        break;
                                    case "3":
                                        //Add a appointment scheduling
                                        Appointment appointment = controller.Insert_Appointment(sc);
                                        String option = "";
                                        while(!option.equals("S")&&!option.equals("N")){
                                            System.out.println('\n' + "Os dados estão corretos? (S/N)");
                                            option = sc.nextLine().toUpperCase();
                                            if(!option.equals("S")&&!option.equals("N")){
                                                System.out.println("Dados incorretos. Favor inserir no formato correto (S/N)");
                                            }
                                        }
                                        if(option.equals("S")){
                                            Appointment_Repository entry = controller.getAppointments();
                                            entry.insert_appointment(appointment);
                                            controller.setAppointments(entry);
                                            System.out.println("Consulta inserida com sucesso!" + '\n');
                                        }else{
                                            System.out.println("Os dados inseridos foram descartados." +'\n');
                                        }
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
                                        controller.showClients();
                                        command = "";
                                        break;
                                    case "2":
                                        //Search a client
                                        controller.searchClient(sc);
                                        command = "";
                                        break;
                                    default:
                                        //Insert a client
                                        Client client = controller.Insert_Client(sc);
                                        String option = "";
                                        while(!option.equals("S")&&!option.equals("N")){
                                            System.out.println('\n' + "Os dados estão corretos? (S/N)");
                                            option = sc.nextLine().toUpperCase();
                                            if(!option.equals("S")&&!option.equals("N")){
                                                System.out.println("Dados incorretos. Favor inserir no formato correto (S/N)");
                                            }
                                        }
                                        if(option.equals("S")){
                                            Client_Repository entry = controller.getClients();
                                            entry.insert_client(client);
                                            controller.setClients(entry);
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
                                        controller.showFoods();
                                        command = "";
                                        break;
                                    case "2":
                                        //Show all food groups
                                        controller.showFood_Groups();
                                        command = "";
                                        break;
                                    default:
                                        //Show all restrictions
                                        controller.showRestrictions();
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

}


