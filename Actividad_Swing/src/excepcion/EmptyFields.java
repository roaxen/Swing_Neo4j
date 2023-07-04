package excepcion;

public class EmptyFields extends Exception{

	public EmptyFields() {
		
		
	}

	 @Override
	public String getMessage() {
			
			return "fALTAN POR RELLENAR CAMPOS EMPTYfIELDS";
			
		}
}

