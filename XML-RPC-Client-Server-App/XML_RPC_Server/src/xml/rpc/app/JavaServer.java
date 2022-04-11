package xml.rpc.app;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import org.apache.xmlrpc.*;


public class JavaServer {

	public Vector haversineDistance(Hashtable data){
		Vector disCal = new Vector();
		final int R = 6371; // Radious of the earth
		double lat1, lon1, lat2, lon2;
		lat1 =(Double) data.get("lat1");
		lon1 =(Double) data.get("lon1");
		lat2 =(Double) data.get("lat2");
		lon2 =(Double) data.get("lon2");


		Double latDistance = toRad.toRad(lat2-lat1);
		Double lonDistance = toRad.toRad(lon2-lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
				Math.cos(toRad.toRad(lat1)) * Math.cos(toRad.toRad(lat2)) *
						Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		Double distance = R * c;

		disCal.addElement(" " + distance);
		return disCal;

	}

	public boolean isPrimeCheck(int n) {
		int count = 0;

		// 0, 1 negative numbers are not prime
		if (n < 2)
			return false;

		// checking the number of divisors b/w 1 and the number n-1
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}

		// if reached here then must be true
		return true;
	}

	public Vector primes(Hashtable data) {
		int lower = (Integer) data.get("Lower");
		int upper = (Integer) data.get("Upper");
		Vector primeNumbers = new Vector();
		Vector primeNumber = new Vector();





		for (int i = lower; i <= upper; i++) {
			if (isPrimeCheck(i)) {
				primeNumbers.addElement(" "+i);
			}
		}
		int lastVal = primeNumbers.size();
		primeNumber.addElement(primeNumbers.get(0));
		primeNumber.addElement(primeNumbers.get(lastVal-1));
		return primeNumber;
	}

	/**
	 * The procedure sum that is called remotely 
	 * is implemented as a public method in a class.
	 * It takes two parameters and returns their sum
	 * 
	 * @param x first integer
	 * @param y second integer
	 * @return the sum of two parameters x, y
	 */

	public Integer addition(int x, int y) {
		System.out.println("I have just received a request with parameters " + x + ", " + y);
		return new Integer(x + y);
	}

	public Integer minus(int x, int y) {
		System.out.println("I have just received a request with parameters " + x + ", " + y);
		return new Integer(x - y);
	}

	/**
	 * The main method of the JavaServer class
	 * 
	 * @param args (here not used)
	 */
	public static void main(String[] args) {
		int port = 8088;
		String ip;
		try {
			// start a web server at a certain port, usually above 1000
			System.out.println("Attempting to start XML-RPC Server...");

			try {
				Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
				while (interfaces.hasMoreElements()) {
					NetworkInterface iface = interfaces.nextElement();
					// filters out 127.0.0.1 and inactive interfaces like Virtual Machines
					if (iface.isLoopback() || !iface.isUp() || iface.getDisplayName().contains("VMware")
							|| iface.getDisplayName().contains("Virtual"))
						continue;

					Enumeration<InetAddress> addresses = iface.getInetAddresses();
					while (addresses.hasMoreElements()) {
						InetAddress addr = addresses.nextElement();
						ip = addr.getHostAddress();
						if (!ip.contains(":")) { // if not ipv6
							MyData.info();
							System.out.println("on ip: " + ip + " port " + port);
						}
					}
				}
			} catch (SocketException e) {
				throw new RuntimeException(e);
			}

			/*
			 * The package org.apache.xmlrpc 
			 * contains the class WebServer 
			 * for a XML-RPC Server implementation.
			 * 
			 * The server is initialized by the port number (here: 80).
			 */
			WebServer server = new WebServer(port);
			/*
			 * An instance of the same server class
			 * is then associated with a handler (here "sample")
			 * that is accessible by the client.
			 */
			server.addHandler("sample", new JavaServer());
			server.start();

			System.out.println("... started successfully.");
			System.out.println();
			System.out.println("Accepting requests. (Halt program to stop.)");

		} catch (Exception exception) {
			System.err.println("JavaServer: " + exception);
		}
	}
}
