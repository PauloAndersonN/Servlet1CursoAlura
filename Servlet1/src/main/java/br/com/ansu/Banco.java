package br.com.ansu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	static List<Empresa> lista = new ArrayList<Empresa>();
	static Integer chaveSequencial = 1;
	
	static {
			
			Empresa empresa1 = new Empresa();
			empresa1.setId(chaveSequencial++);
			empresa1.setNome("AnsuCom1");
			
			Empresa empresa2 = new Empresa();
			empresa2.setId(chaveSequencial++);
			empresa2.setNome("AnsuCom2");
			
			lista.add(empresa1);
			lista.add(empresa2);
			
	}
	
	
	public void adiciona(Empresa empresa){
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		
		return Banco.lista;
	}
	
	public void remove(Integer id){
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()){
			Empresa emp = it.next();
			if(emp.getId() == id){
				it.remove();
			}
		}
	}
	
	public Empresa buscaPorId(Integer id){
		for(Empresa empresa : lista ){
			if(empresa.getId() == id){
				return empresa;
			}
		}
		
		return null;
		
	}
}
