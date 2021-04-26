package menus;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;

import dao.DepartamentoDAO;
import dao.EmpleadoDAO;
import pojos.Departamento;
import pojos.Empleado;

public class Menu {
	
	public static void menuInicial(Session s) {
		
		Scanner teclado = new Scanner (System.in);
		int entrada=1;

		while(entrada!=3) {
			System.out.println("           MENU");
			System.out.println("1- Trabajar con empleados");
			System.out.println("2- Trabajar con departamentos");
			System.out.println("3- Salir");
			entrada=teclado.nextInt();
			switch(entrada) {
			case 1:
				menuEmpleados(s);
				break;
			case 2:
				menuDepartamentos(s);
				break;
			case 3: 
				System.exit(0);
			}
		}
	}
	
	public static void menuEmpleados(Session s) {
		
		Scanner teclado = new Scanner (System.in);
		int entrada=1;
		int insercion;
		String nuevoNombre;
		while(entrada!=5) {
			System.out.println("           MENU EMPLEADOS");
			System.out.println("1- Insertar");
			System.out.println("2- Eliminar");
			System.out.println("3- Modificar");
			System.out.println("4- Ver");
			System.out.println("5- Atras");
			entrada=teclado.nextInt();
			switch(entrada) {
				case 1:
					System.out.print("Introduzca el id del empleado a insertar: ");
					insercion = teclado.nextInt();
					Empleado e = new Empleado(insercion, "pepe", "perez", "garcia", "zamora", "25-08-20", "Calle", "1111111",
			                "Informatico", 3);
					EmpleadoDAO.insertEmpleado(s, e);
					break;
				case 2:
					System.out.print("Introduzca el id del empleado a eliminar: ");
					insercion = teclado.nextInt();
					EmpleadoDAO.borrarEmpleado(s, insercion);
					break;
				case 3:
					System.out.print("Introduzca el id del empleado a modificar: ");
					insercion = teclado.nextInt();
					System.out.print("Introduzca el nuevo nombre del empleado a modificar: ");
					nuevoNombre  = teclado.next();
					EmpleadoDAO.actualizarEmpleado(s, insercion, nuevoNombre);
					break;
				case 4:
					ArrayList<Empleado> empleados = (ArrayList<Empleado>) EmpleadoDAO.getAllEmpleados(s);
					for (Empleado d : empleados) {
						System.out.println(d.toString());
					}
					break;
				case 5:
					menuInicial(s);
			}
			
			if(entrada==5) {
				menuInicial(s);
			}
		}
	}
	
	public static void menuDepartamentos(Session s) {
		
		
		Scanner teclado = new Scanner (System.in);
		int entrada=1;
		int insercion;
		String nuevoNombre;
		while(entrada!=5) {
			System.out.println("           MENU Departamentos");
			System.out.println("1- Insertar");
			System.out.println("2- Eliminar");
			System.out.println("3- Modificar");
			System.out.println("4- Ver");
			System.out.println("5- Atras");
			entrada=teclado.nextInt();
			switch(entrada) {
				case 1:
					System.out.print("Introduzca el id del departamento a insertar: ");
					
					insercion = teclado.nextInt();
					DepartamentoDAO.insertDepartamento(s, insercion);
					break;
				case 2:
					System.out.print("Introduzca el id del departamento a eliminar: ");
					insercion = teclado.nextInt();
					DepartamentoDAO.borrarDepartamento(s, insercion);
					break;
				case 3:
					System.out.print("Introduzca el id del departamento a modificar: ");
					insercion = teclado.nextInt();
					System.out.print("Introduzca el nuevo nombre del departamento a modificar: ");
					nuevoNombre  = teclado.next();
					DepartamentoDAO.actualizarDepartamento(s, insercion, nuevoNombre);
					break;
				case 4:
					ArrayList<Departamento> departamentos = (ArrayList<Departamento>) DepartamentoDAO.getAllDepartamentos(s);
					for (Departamento d : departamentos) {
						System.out.println(d.toString());
					}
					break;
				case 5:
					menuInicial(s);
			}
			
			if(entrada==5) {
				menuInicial(s);
			}
		}
	}
	
	
	
	
}
