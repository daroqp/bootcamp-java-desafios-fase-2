package ar.com.educacionit.universidad.desafios;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int[] mesesCon31Dias = new int[] { 1, 3, 5, 7, 8, 10, 12 };
		int[] meseCon30Dias = new int[] { 4, 6, 9, 11 };
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el dia:");
		int dd = teclado.nextInt();
		
		System.out.println("Ingrese el mes:");
		int mm = teclado.nextInt();
		
		System.out.println("Ingrese el año:");
		int yyyy = teclado.nextInt();
		
		boolean isValidDay = verificarDiaValido( dd );
		boolean isValidMonth = verificarMesValido( mm );
		boolean isValidYear = verificarAñoValido( yyyy );
		
		if( isValidDay && isValidMonth && isValidYear ) {
			
			boolean isMesCon31Dias = Arrays.binarySearch(mesesCon31Dias, mm) >= 0;
			boolean isMesCon30Dias = Arrays.binarySearch(meseCon30Dias, mm) >= 0;

			if ( isMesCon31Dias ) {
				
				System.out.println("Es una fecha valida.");
				
			} else if( isMesCon30Dias ) {

				boolean isDiaValidoPorMes = dd <= 30;

				if( isDiaValidoPorMes ) {
					System.out.println("Es una fecha valida.");
				} else {
					System.out.println("No es una fecha valida.");
				}

			} else {

				boolean isBisiesto = verificarAñoBisiesto( yyyy );
				boolean isDiaBisiestoValido = dd <= 29;
				boolean isDiaNoBisiestoValido = dd <= 28;
			
				if( isBisiesto && isDiaBisiestoValido ) {
					System.out.println("Es una fecha valida.");
				} else if( !isBisiesto && isDiaNoBisiestoValido ) {
					System.out.println("Es una fecha valida.");
				} else {
					System.out.println("No es una fecha valida.");
				}
			}
			
		} else {
			System.out.println("No es una fecha valida.");
		}
		
		teclado.close();
	}
	
	public static boolean verificarDiaValido(int day) {
		return day >= 1 && day <= 31;
	}
	
	public static boolean verificarMesValido(int month) {
		return month >= 1 && month <= 12;
	}
	
	public static boolean verificarAñoValido(int year) {
		 return year >= 1900 && year <= 2099;
	}
	
	public static boolean verificarAñoBisiesto(int year) {

		boolean isDivisible4 =  year % 4 == 0; 
		boolean isDivFor100 = year % 100 == 0;
		boolean isDivFor400 = year % 400 == 0;
		
		return isDivisible4 && (!isDivFor100 || isDivFor400);
	}

}
