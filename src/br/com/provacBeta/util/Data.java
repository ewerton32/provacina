package br.com.provacBeta.util;

public class Data {
	
	private int segundo;
	private int minuto;
	private int hora;
	private int dia;
	private int mes;
	private int ano;
	
    public Data(int segundo, int minuto, int hora, int dia, int mes, int ano) {
		
		this.setSegundo(segundo);
		this.setMinuto(minuto);
		this.setHora(hora);
		this.setDia(dia);
		this.setMes(mes);
		this.setAno(ano);
	}
    public String toString(){
    	String resp = "\nData: " +this.getDia()+
    	              "/" + this.getMes()+
    	              "/" + this.getAno()+
    	              " - "+
    	              "horario: "+ this.getHora()+
    	              ":" + this.getMinuto() + 
    	              ";" + this.getSegundo();
    	return resp;
    }
    public String getData(){
    	String resp = "\nData: " +this.getDia()+
    	              "/" + this.getMes()+
    	              "/" + this.getAno();
    	return resp;
    }
    
    public String getHorario(){
    	String resp = "horario: "+ this.getHora()+
    	              ":" + this.getMinuto() + 
    	              ";" + this.getSegundo();
    	return resp;
    }
    
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public int getSegundo() {
		return segundo;
	}
	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}
	
	
	
	
	
	

}
