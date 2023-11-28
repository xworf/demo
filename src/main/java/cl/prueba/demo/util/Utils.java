/*
 * 
 */
package cl.prueba.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class Utils.
 */
public class Utils {
	
	/**
	 * Valida email.
	 *
	 * @param email the email
	 * @return the boolean
	 */
	public static Boolean validaEmail (String email) {
		if (email != null && !"".equalsIgnoreCase(email)) {
			return true;
		}else {
			Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		}
		
	}
	
	/**
	 * Generar token.
	 *
	 * @param longitud the longitud
	 * @return the string
	 */
	public static String generarToken(int longitud) {
	    // El banco de caracteres
	    String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    // La cadena en donde iremos agregando un carácter aleatorio
	    String cadena = "";
	    for (int x = 0; x < longitud; x++) {
	        int indiceAleatorio = numeroAleatorio(0, banco.length() - 1);
	        char caracterAleatorio = banco.charAt(indiceAleatorio);
	        cadena += caracterAleatorio;
	    }
	    return cadena;
	}
	private static int numeroAleatorio(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
	
	/**
	 * Formato fecha.
	 *
	 * @param fecha the fecha
	 * @return the string
	 */
	public static String formatoFecha(Date fecha) {
		String pattern = "MM-dd-yyyy HH:MM:SS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(fecha);
	}
	
	/**
	 * Validar password.
	 *
	 * @param regex the regex
	 * @param password the password
	 * @return true, if successful
	 */
	public static boolean validarPassword(String regex, String password)  {
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
