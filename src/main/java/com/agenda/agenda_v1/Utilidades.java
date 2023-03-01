/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agenda.agenda_v1;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ismae
 */
public class Utilidades {

    public static boolean contieneSoloLetras(String cadena) {
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre a y z, ni entre A y Z, ni es un espacio
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    public static boolean contieneSoloNumeros(String cadena) {
        // Si la cadena está vacía, debemos devolver false
        if (cadena.length() == 0) {
            return false;
        }
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre 0 y 9
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static boolean validarNifONie(String nifONie) {

        Pattern p = Pattern.compile("([\\dXxYyZz])(\\d{7})([a-zA-Z])");
        Matcher m = p.matcher(nifONie);
        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        boolean correcto = false;
        String dniEquivalente;
        int dni;

        if (m.matches()) {
            //convertir primera letra de Nie a número
            switch (m.group(1).charAt(0)) {
                case 'x':
                case 'X':
                    dniEquivalente = "0" + m.group(2);
                    break;
                case 'y':
                case 'Y':
                    dniEquivalente = "1" + m.group(2);
                    break;
                case 'z':
                case 'Z':
                    dniEquivalente = "2" + m.group(2);
                    break;
                default:
                    dniEquivalente = m.group(1) + m.group(2);
            }
            // Aquí tenemos en dni una cadena con el nº de DNI o equivalente
            dni = Integer.parseInt(dniEquivalente);
            // Si el carácter al final del DNI/NIF en mayúsculas coincide con el que obtenemos de la cadena letrasDni
            if (letrasDni.charAt(dni % 23) == m.group(3).toUpperCase().charAt(0)) {
                correcto = true; //solo se llega aquí si el patrón coincide y si la letra final es correcta
            }
        }
        return correcto;
    } //fin validarNifONie
    
    
}
