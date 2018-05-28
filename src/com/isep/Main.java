package com.isep;

public class Main {

	public static void main(String[] args) {
		/**
		 * un exemple dutilisation dune donne.
		 * On souhait represente le donnee x(1,2) et y(3.,4.)
		 */
		//*****************************//
		System.out.println("*****************************");
		Data x = new Data(2);
		double[] valeursX = {1.,2.};
		x.setValeurs(valeursX);
		System.out.println("x:" + x.toString());
		
		Data y = new Data(2);
		double[] valeursY = {3.,4.};
		y.setValeurs(valeursY);
		System.out.println("y:" + y.toString());
		
		System.out.println("distance entre x et y:" + x.dist(y));
		System.out.println("*****************************");
		//*****************************//
		
		/**
		 * un exemple dutilisation dun cluster.
		 * On souhait represente les cluster 
		 * cluster 0 : { x(1,2)}
		 * cluster 1 : { y(3,4)}
		 */
		//*****************************//
		System.out.println("*****************************");
		Cluster cluster0 = new Cluster();
		cluster0.add(x);
		Cluster cluster1 = new Cluster();
		cluster1.add(y);
		System.out.println(cluster0.toString());
		System.out.println(cluster1.toString());
		System.out.println("*****************************");
		//*****************************//


		
		
	}

}
