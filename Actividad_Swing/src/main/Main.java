package main;

import java.util.ArrayList;

import dao.DaoControler;
import model.*;

import structure.Principal;

public class Main {
	public static DaoControler dao = new DaoControler();
	public static ArrayList<Author> writers ;
	public static ArrayList<MyBook> books = new ArrayList<>(); //
	public static ArrayList<String> genre = new ArrayList<>(); //
	
	

	public static void main(String[] args) {
		

		
		
		actualizarDatos();
		
		Principal prueba = new Principal();
		

	
		
	}

	public static void actualizarDatos() {
		
		DaoControler dao = new DaoControler();
		
		Main.writers = dao.selectAllAutores();
		Main.books = dao.selectAllLibros();
		
		
		
	}
	

}
