package model;

public class Author {

	private String name, surname,surname2,country;

	public Author (String name,String surname,String surname2,String country) {
		
		this.name = name;
		this.surname = surname;
		this.surname2 = surname2;
		this.country = country;
		
	}

public boolean equals(Author a) {

	if (a.getName().trim().equalsIgnoreCase(name.trim()) &&
		a.getSurname().trim().equalsIgnoreCase(surname.trim()) && 
		a.getSurname2().trim().equalsIgnoreCase(surname2.trim()) &&
		a.getCountry().trim().equalsIgnoreCase(country.trim())) {
		return true;
	}else {return false;}
	
	
}


	@Override
	public String toString() {
		return name + " " + surname + " " + surname2 + ", Country: " + country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
