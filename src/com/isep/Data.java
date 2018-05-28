package com.isep;

import java.util.Arrays;
import java.util.Locale;

/**
 * Represente une donnee.
 * La classe Data est caracterisee par les informations suivantes :
 * 		une liste de valeurs qui représente les donnees
 * 		une longueur qui correspond au nombre de valeurs par donnee
 * 		un lien vers le cluster associe (en effet chaque cluster contient des donnees)
 * @author Paul
 */
public class Data {
	
	 /**correspond au nombre de valeurs par donnee*/
	 private int longueur;
	 /**liste de valeurs qui represente les donnees*/
	 private double[]valeurs;
	 /**cluster associe a une donnee*/
	 private Cluster cluster;
	 
	/**
	 * Constructeur par default
	 * @param _length le nombre de valeurs*/
	 public Data(int _longueur) {
		 longueur = _longueur;
		 valeurs = new double[longueur];
	 }
	 /**
	  * Initialise les valeurs et la longueur.
	  * @param tab la liste des valeurs*/
	 public Data(double ...tab) {
	  valeurs = Arrays.copyOf(tab, tab.length);
	 }
	 
	 /**
	  *  calcule la distance Eclidienne entre une donnee et une autre : 
	  * @param o lautre donnee quil faut comparee
	  * @return le distance entre la donnee actuelle et lautre donnee*/
	 public double dist(Data o) {
	  double sum = 0;
	  for(int i=0; i<longueur; i++)
	    sum += Math.pow(valeurs[i] - o.valeurs[i], 2);
	  return Math.sqrt(sum);
	 }
	 
	 /** 
	  * @return retourne la liste des valeurs en les formatant à 2 chiffres après la virgules*/
	 @Override
	 public String toString() {
	  StringBuilder sb = new StringBuilder("(");
	  String separation=", ";
	  for(double v:valeurs) 
	    sb.append(String.format(Locale.ENGLISH,"%.2f", v)).append(separation);
	  sb.append(")");
	  return sb.toString();
	 }
	 
	 /** Getters et Seters*/
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public double[] getValeurs() {
		return valeurs;
	}
	public void setValeurs(double[] valeurs) {
		this.valeurs = valeurs;
	}
	public void setValeur(int i, double valeur) {
		this.valeurs[i] = valeur;
	}
	public Cluster getCluster() {
		return cluster;
	}
	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}
	public double getValeur(int i) {
		return this.valeurs[i];
	}
	
}
