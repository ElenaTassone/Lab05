package it.polito.tdp.anagrammi.model;

import java.util.*;
import java.math.*;

import it.polito.tdp.anaframmi.DAO.AnagrammaDAO;

public class Model {
	
	List<Lettera> lettere  = new ArrayList<Lettera> () ;
	Set<Anagramma> result ;
	
 	public Set<Anagramma> cercaAnagramma(String daCercare){
		result = new HashSet<Anagramma> () ;
		Anagramma a = new Anagramma(daCercare) ;
		AnagrammaDAO dao = new AnagrammaDAO () ;
		
		for (int i = 0 ; i <a.getDim() ; i++){
			Lettera l = new Lettera (a.getParola().charAt(i), i) ;
			lettere.add(l) ;
		}
		
		List<Lettera> parziale = new LinkedList<Lettera>() ;
		int step = 0 ;
		
		recursive (parziale, step, result) ;
		
		lettere.clear();
		
		for(Anagramma a1 : result){
			a1.setCorrect(dao.isCorrect(a1.getParola()));
		}
		
		return result ;
	}

	private void recursive(List<Lettera> parziale, int step, Set<Anagramma> result) {
		
		if(parziale.size() == lettere.size()){
			String parola = "" ;
			Anagramma completa = null ;
			for(Lettera l : parziale ){
				parola += l.toString() ;
			}
			completa = new Anagramma (parola) ;
			result.add(completa) ;
		}
		
		
		for( Lettera l : lettere){
			if(!parziale.contains(l)){
				parziale.add(l);
				recursive(parziale, step+1, result) ;
				parziale.remove(l) ;
			}
		}
		
	}

 	}
