package com.isep;

import java.util.ArrayList;

/**
 * Represente un cluster.
 * Un cluster est caracterise par les informations suivantes :
 * 		un centroide de type Data qui represente le barycentre du cluster
 *		un ensemble de donnees
 *		un identifiant
 * @author Paul
 */
public class Cluster {
	/**ensemble de donnees associes au cluster*/
	private ArrayList<Data> dataSet;
	/**centroide de type Data qui represente le barycentre du cluster*/
	private Data centroide;
	/**nombre total de clusters*/
	private static int nb;
	/**identifiant du cluster*/
	int id;

	/**
	 * Constructeur par default
	 */
	public Cluster(){
	 dataSet = new ArrayList<>();
	 centroide = new Data();
	 id = nb++;
	}
	 
	/**Initialise le centroide*/
	public Cluster(Data _centroide) {
	 centroide = _centroide;
	}
	 
	/**Ajoute une donnee au cluster et associe cette donnee au cluster*/
	public void add(Data data) {
	 dataSet.add(data);
	 data.setCluster(this);
	}
	 
	/**Supprime une donnee du cluster et supprime lassociation entre cette donnee et le cluster*/
	public void remove(Data data) {
	 dataSet.remove(data);
	 data.setCluster(null);
	}

	/** Recalcule les coordonnees du centroide*/
	public void calculCentroide() {
	 int nbElement = dataSet.size();
	 if(nbElement>0) {
	   int dimension = dataSet.get(0).getLongueur();
	   int[] tabI = {0};
	   for(int i=0; i<dimension;i++) {
	     tabI[0] = i;
	     double sumI = dataSet.stream()
	    		 .parallel()
	    		 .mapToDouble(d-> d.getValeur(tabI[0]))
	    		 .sum();
	     double average = sumI/(double)nbElement;
	     if(centroide.getValeur(i)!=average) {
	       centroide.setValeur(i, sumI/(double)nbElement);
	     }
	   }
	 }    	
	}
	
	
	/**@return lid du cluster, le nombre de donnees quil contients, les valeurs de ces donnes*/
	@Override
	public String toString() {
	 StringBuilder sb = new StringBuilder("cluster " + id + ", nb elts =  " + dataSet.size() + "\n");
	 sb.append("--> centroide = ").append(centroide).append("\n data = \n");
	 if (dataSet.size()<50) 
	   for(Data data:dataSet) sb.append(data.toString()).append("\n");
	 sb.append("	\n---- ");
	 return sb.toString();
	}
	
	/** Getters et Seters*/
	public ArrayList<Data> getDataSet() {
		return dataSet;
	}

	public void setDataSet(ArrayList<Data> dataSet) {
		this.dataSet = dataSet;
	}

	public Data getCentroide() {
		return centroide;
	}

	public void setCentroide(Data centroide) {
		this.centroide = centroide;
	}

	public static int getNb() {
		return nb;
	}

	public static void setNb(int nb) {
		Cluster.nb = nb;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
