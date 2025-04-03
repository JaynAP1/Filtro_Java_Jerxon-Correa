package org.example;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.misiones.misionDAO.*;
import static org.example.ninjas.model.ninjaDAO.*;

public class Funciones {
    static Scanner sc = new Scanner(System.in);

    public static void menu() throws SQLException {
        System.out.println("Presione enter para continuar");
        sc.nextLine();

        System.out.println("""
                =====================================
                |1).Ver ninjas.
                |2).Mostrar misiones.
                |3).Mostrar las misiones que un ninja a completado.
                |4).Asignar una mision a un ninja.
                |5).Marcar una mision como completada.
                |6).Mostrar todas las misiones completadas.
                =====================================
                """);
        String seleccion = sc.nextLine();
        opciones(seleccion);
    }
    public static void opciones(String seleccion) throws SQLException {
        switch (seleccion){
            case "1" ->{
                verNinjaHabilidad();
            }
            case "2" ->{
                orderMision();
            }
            case "3" ->{
                misionesCompletasNinja();
            }
            case "4" ->{
                asignacionMision();
            }
            case "5" ->{
                verEnCurso();
            }
            case "6" ->{
                orderMisionesCompletas();
            }
            default -> {
                System.out.println("Selector no definido");
                menu();
            }
        }
    }

    //vista misiones
    public static void orderMision() throws SQLException{
        if (viewMisiones().isEmpty()){
            System.out.println("No hay misiones en este momento");
        }else {
            for (int i = 0; i< viewMisiones().size();i++){
                System.out.println("==============================");
                System.out.println("ID: "+ viewMisiones().get(i).getId() + "\nDescripcion: "+viewMisiones().get(i).getDescripcion()+"\nRango: "+viewMisiones().get(i).getRango()+"\nRecompensa: $"+viewMisiones().get(i).getRecompensa());
            }
        }
        menu();
    }
    public static void orderMisionesCompletas() throws SQLException{
        for (int i = 0; i< viewCompletesMisiones().size(); i++){
            System.out.println("==============================================");
            System.out.println("id Mision: "+ viewCompletesMisiones().get(i).getId() + "\nid Ninja: "+viewCompletesMisiones().get(i).getId_ninja()+"\nDescripcion: "+viewCompletesMisiones().get(i).getDescripcion()+ "\nFecha de inicio: "+ viewCompletesMisiones().get(i).getFecha_inicio()+"\nFecha de finalizacion: "+viewCompletesMisiones().get(i).getFecha_final());
        }
        menu();
    }
    public static void misionesCompletasNinja() throws SQLException{
        try{
            System.out.println("Ingrese la id del ninja que desea verle las misiones completadas: ");
            int idNinja = sc.nextInt();
            if (viewCompletesNinjasMisiones(idNinja).isEmpty()){
                System.out.println("Este ninja no ah hecho ninguna mision");
            }else{
                for(int i = 0; i< viewCompletesNinjasMisiones(idNinja).size();i++){
                    System.out.println("=====================");
                    System.out.println("id Mision: "+ viewCompletesNinjasMisiones(idNinja).get(i).getId() + "\nid Ninja: "+viewCompletesNinjasMisiones(idNinja).get(i).getId_ninja()+"\nDescripcion: "+viewCompletesNinjasMisiones(idNinja).get(i).getDescripcion()+ "\nFecha de inicio: "+ viewCompletesNinjasMisiones(idNinja).get(i).getFecha_inicio()+"\nFecha de finalizacion: "+viewCompletesNinjasMisiones(idNinja).get(i).getFecha_final());
                }
            }
            menu();
        }catch (Exception e){
            System.out.println("Dato no valido");
            menu();
        }
    }
    public static void orderM() throws SQLException{
        if (viewMisiones().isEmpty()){
            System.out.println("No hay misiones para completar");
        }else{
            for (int i = 0; i< viewMisiones().size();i++){
                System.out.println("==============================");
                System.out.println("ID: "+ viewMisiones().get(i).getId() + "\nDescripcion: "+viewMisiones().get(i).getDescripcion()+"\nRango: "+viewMisiones().get(i).getRango()+"\nRecompensa: $"+viewMisiones().get(i).getRecompensa());
            }
        }
    }
    public static void verEnCurso() throws SQLException{
        try {
            if (verMisionesCurso().isEmpty()){
                System.out.println("No hay misiones en curso");
                menu();
            }else{
                for (int i = 0; i< verMisionesCurso().size(); i++){
                    System.out.println("=====================================");
                    System.out.println("id Mision: "+ verMisionesCurso().get(i).getId() + "\nid Ninja: "+verMisionesCurso().get(i).getId_ninja()+"\nDescripcion: "+verMisionesCurso().get(i).getDescripcion()+ "\nFecha de inicio: "+ verMisionesCurso().get(i).getFecha_inicio()+"\nFecha de finalizacion: "+verMisionesCurso().get(i).getFecha_final());
                }
                System.out.println("Cual de las siguientes misiones quieres asignar como completada: ");
                int idMision = sc.nextInt();
                sc.nextLine();
                System.out.println("Escriba la fecha de hoy para completar el sistema terminar mision: ");
                String fechaFinal = sc.nextLine();

                misionCompletada(idMision,fechaFinal);
                menu();
            }

        }catch (Exception e){
            System.out.println("Dato no valido");
            menu();
        }

    }
    public static void asignacionMision() throws SQLException{
        orderM();
        try {
            System.out.println("Elija la id de la mision que desea establecerle a un ninja: ");
            int idMision = sc.nextInt();
            sc.nextLine();

            verTodosNinjas();
            System.out.println("Elija la id del ninja que desea establecerle la mision: ");
            int idNinja = sc.nextInt();
            sc.nextLine();

            System.out.println("Establezca la fecha de inicion para la mision(AAAA-MM-DD): ");
            String FechaInicio = sc.nextLine();

            asignarMision(idMision,idNinja,FechaInicio);
            menu();
        }catch (Exception e){
            System.out.println("Dato no valido");
            menu();
        }
    }

    //Vista ninja
    public static void verTodosNinjas() throws SQLException{
        for (int i = 0; i < viewAllNinja().size(); i++ ){
            System.out.println("ID: "+viewAllNinja().get(i).getId()+"\nNombre: "+ viewAllNinja().get(i).getNombre() +"\nRango: "+viewAllNinja().get(i).getRango()+"\nAldea: "+viewAllNinja().get(i).getAldea());
        }
    }
    public static void verNinjaHabilidad() throws SQLException{
        System.out.println("Escribe la id del ninja que deseas ver: ");
        try {
            int idNinja = sc.nextInt();
            OrderNinja(idNinja);
            sc.nextLine();
            System.out.println("¿Deseas ver las habilidades?------(Si/No)");
            String selector = sc.nextLine();
            if (selector.equalsIgnoreCase("si")){
                orderHabilidades(idNinja);
                menu();
            }
            else if(selector.equalsIgnoreCase("no")){
                menu();
            }
            else {
                System.out.println("Dato no valido");
                menu();
            }
        }
        catch (Exception e){
            System.out.println("Dato no valido");
            menu();
        }
    }

    public static void OrderNinja(int id) throws SQLException {
        System.out.println("Nombre: "+ viewNinja(id).get(0).getNombre() +"\nRango: "+viewNinja(id).get(0).getRango()+"\nAldea: "+viewNinja(id).get(0).getAldea());
    }
    public static void orderHabilidades(int id) throws SQLException{
        for (int i = 0; i < viewHabilidades(id).size();i++){
            System.out.println("===============================================");
            System.out.println("Nombre de la habilidad: " + viewHabilidades(id).get(i).getNombre()+ "\nDescripcion: "+viewHabilidades(id).get(i).getDescripcion());
        }
    }

}
