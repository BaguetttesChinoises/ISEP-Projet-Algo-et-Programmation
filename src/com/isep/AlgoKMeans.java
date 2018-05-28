package com.isep;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implemente lalgorithme des K-mean.
 * Un cluster est caracterise par les informations suivantes :
 * 		un centroide de type Data qui represente le barycentre du cluster
 *		un ensemble de donnees
 *		un identifiant
 * @author Paul
 */

public class AlgoKMeans {
	/** tableau de données (tableau de tableaux de double)*/
	private static  double samples[][];
	/**Liste des donnees*/
	private static ArrayList<Data> dataSet = new ArrayList<>();
	/**Liste des clusters*/
	private static ArrayList<Cluster> clusters = new ArrayList<>();
	
	/**Initialise la liste de Data et cree les clusters
	 * @param _nbClusters le nombre de cluster
	 * @param _dim la longueur dune donnee*/
	private static void initialisation(int _nbClusters, int _dim) {;
	 for(double[] data:samples) {
	   dataSet.add(new Data(data));
	 }	 
	 createClusters(_nbClusters);
	}
	
	/**
	 * Creation des clusters.
	 * @param _nbClusters
	 */
	private static void createClusters(int _nbClusters) {
	 for(int c = 1; c<_nbClusters; c++) {
		 Data centroid = dataSet.get((int)(dataSet.size()*Math.random()));
		 Cluster cluster = new Cluster(centroid);
		 clusters.add(cluster);
	 }
	 System.out.println("Initially, centroids are:");
	 clusters.forEach(c->System.out.println(c.getCentroide().toString()));
	}
	
	/** Trouve pour chaque donnee le cluster le plus adapte, celui dont le centroide est le plus proche
	* @param data la donnee a placer dans le cluster
	* @return le cluster dont le centroide est le plus proche de la data*/
	private static Cluster searchCluster(Data data) {
	 Cluster bestCluster = null;
	 double minimum = Double.POSITIVE_INFINITY;
	 double distance=0;
	 for(Cluster cluster:clusters) {
	   distance = data.dist(cluster.getCentroide());
	   if(distance < minimum){ minimum = distance; bestCluster = cluster; }
	 }
	 return bestCluster;
	}

	/**Algorithme des K-mean:
	 * Place chaque donnee dans le meilleur cluster grace a un for on realise les actions suivantes :
	 * 		Calcule le nouveau centroide de chaque cluster
	 * 		place les donnees dans le cluster le plus adapte
	 */
	private static void kMeanCluster() {
	 //Pour chaque donnee, cherche le meilleur cluster pour une donnee et lui ajoute une donnee
	 dataSet.forEach(data -> searchCluster(data).add(data));
	 boolean moving = true;
	 while(moving) {
	  moving = false;
	  clusters.forEach(c -> c.calculCentroide());
	  for(Data data:dataSet) {
	   Cluster bestCluster = searchCluster(data);
	   if(data.getCluster() != bestCluster){
	    moving = true;
	    data.getCluster().remove(data);
	    bestCluster.add(data);
	   }
	  }
	 }
	}

	public static double[][] getSamples() {
		return samples;
	}

	public static void setSamples(double[][] samples) {
		AlgoKMeans.samples = samples;
	}

	public static ArrayList<Data> getDataSet() {
		return dataSet;
	}

	public static void setDataSet(ArrayList<Data> dataSet) {
		AlgoKMeans.dataSet = dataSet;
	}

	public static ArrayList<Cluster> getClusters() {
		return clusters;
	}

	public static void setClusters(ArrayList<Cluster> clusters) {
		AlgoKMeans.clusters = clusters;
	}
	
	
	
}
