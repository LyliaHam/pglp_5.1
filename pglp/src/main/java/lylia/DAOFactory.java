
public class DAOFactory {

	public static DAO<PersonnelGroupe> getPersonneDAO(){
		return new PersonneDAO();
	}

}
