package excepcion;



	public class NoExistAuthor extends Exception {
		
		public NoExistAuthor() {
			
			
		}

		 @Override
		public String getMessage() {
				
				return "Don't exist any Author";
				
			}
	}

