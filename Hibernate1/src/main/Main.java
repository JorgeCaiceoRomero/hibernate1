package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.DepartamentoDAO;
import menus.Menu;
import pojos.Departamento;
import util.HibernateUtil;


public class Main {
	
	private static Logger logger = LogManager.getLogger(Main.class);
	
	static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		String methodName = Main.class.getSimpleName() + ".main()";
		logger.info(String.format("%1$s: >>>>>> Main execution started.", methodName));
		// La SessionFactory se instancia 1 vez por ejecución del programa.
		// Todas las sesiones de hibernate se obtienen de esa SessionFactory;	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		tx=session.beginTransaction();
		
		
		
		
		System.out.println("Sesion abierta");
		/*DepartamentoDAO.borrarDepartamento(session, 1000);
		//DepartamentoDAO.actualizarDepartamento(session, 1, "NombreActualizado");
		Departamento d = DepartamentoDAO.getDepartamento(session, 1);
		//DepartamentoDAO daodep = new DepartamentoDAO();
		//DepartamentoDAO.insertDepartamento(session,1000);
		System.out.println(d.toString());
	*/
		Menu m = new Menu();
		m.menuInicial(session);
		
		tx.commit();
		session.close();
		
		System.out.println("Sesion cerrada");
		
		logger.info(String.format("%1$s: >>>>>> Main execution finished.", methodName));
	}	
	

}
