package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagramma {
	
	private String parola ;
	private int dim ;
	private boolean isCorrect ;
	
	Set<String> anagrammi = new HashSet<String> () ;
	
	
	public Anagramma(String parola) {
		super();
		this.parola = parola;
		this.dim = parola.length() ;
		this.isCorrect = false ;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anagramma other = (Anagramma) obj;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return parola;
	}
}
	
