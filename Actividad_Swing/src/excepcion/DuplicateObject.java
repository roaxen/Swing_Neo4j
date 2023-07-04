package excepcion;

public class DuplicateObject extends Exception {
	
	public DuplicateObject() {
		
		
	}

	 @Override
	public String getMessage() {
			
			return "Ya existe una entrada con estos campos DUPLICATEOBJECT";
			
		}
}
