
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonneDAO implements DAO<PersonnelGroupe>{

	String filename = "Personnes.ser";
	
	@Override
	public PersonnelGroupe create(PersonnelGroupe obj) {

        try {
        	ObjectOutputStream out = 
            		new ObjectOutputStream(
            				new FileOutputStream(filename));
            out.writeObject(obj);
            
            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
		return obj;
	}

	@Override
	public PersonnelGroupe read() {
		
		PersonnelGroupe person = null;

		try {
			ObjectInputStream in = new ObjectInputStream(
        		new FileInputStream(filename));
			
			person = (PersonnelGroupe) in.readObject();
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
		return person;
	}

	@Override
	public PersonnelGroupe update(PersonnelGroupe obj) {
		return create(obj);
	}

	@Override
	public void delete(PersonnelGroupe obj) {

		try {
			ObjectOutputStream out = 
	        		new ObjectOutputStream(
	        				new FileOutputStream(filename));
            out.writeObject(null);
            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
		
	}

}
