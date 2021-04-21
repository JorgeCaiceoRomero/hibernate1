package dao;

import org.hibernate.Session;



import pojos.Departamento;

public class DepartamentoDAO {
	
	public static void insertDepartamentos(Session s, int numDepts) {
	    for (int codigo = 1; codigo <= numDepts; codigo++) {
	      insertDepartamento(s, codigo);
	    }
	  }
	
	public static void insertDepartamento(Session s, int codigo) {		
		int codigoDep = codigo;
		String nombre = "Nombre de "+codigo;
		int codResponsable = codigo+1;
		
		Departamento departamento = new Departamento(codigoDep, nombre, codResponsable);
		s.save(departamento);
	}
	
}
