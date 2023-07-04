package excepcion;



	public class NoExistBook extends Exception {
		
		public NoExistBook() {
			
			
		}

		 @Override
		public String getMessage() {
				
				return "Don't exist any Book";
				
			}
	}

