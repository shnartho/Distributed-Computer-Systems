package xml.rpc.app;

import java.util.*;
import java.util.regex.Pattern;

import org.apache.xmlrpc.*;


public class JavaClient {

	/**
	 * Validates ip String input
	 * given by user
	 * 
	 * @return the validated ip string
	 */

	public static String getIp() {
		Scanner i = new Scanner(System.in);
		String inputStream = "127.0.0.1";
		Pattern PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

		for (boolean test = false; test == false;) {
			try {
				System.out.println("Enter an IP: ");

				inputStream = i.nextLine(); // reading from user
				test = PATTERN.matcher(inputStream).matches();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return inputStream;
	}

	/**
	 * Validates integer input
	 * given by user
	 * 
	 * @return validated integer
	 */
	public static int getInteger() {
		Scanner i = new Scanner(System.in);
		int value = 0;

		for (boolean test = false; test == false;) {
			try {
				System.out.println("(enter an integer):");
				value = i.nextInt();

				test = true;
				return value;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
			}
			i.nextLine();
		}
		return value;
	}

	/**
	 * The main method of the JavaClient class
	 * 
	 * @param args (here not used)
	 */

	public static void main(String[] args) {

		int port;
		String ip;
		String choice, cho;
		Scanner c= new Scanner(System.in);
		Object result;
		int el1, el2;
		try {
			System.out.println("\n+---------------Checking IP & PORT-----------------+");
			ip = getIp();
			System.out.print("And The PORT number ");
			port = getInteger();

			XmlRpcClient client = new XmlRpcClient("http://" + ip + ":" + String.valueOf(port) + "/");
			Vector<Integer> params = new Vector<Integer>();
			System.out.println();
			System.out.println("+----------------------Menu------------------------+");
			System.out.println(MyData.info());
			System.out.println("+--------------------------------------------------+");
			System.out.println("Enter your choice:");
			cho = c.nextLine();
			choice = cho.toLowerCase();

			switch (choice) {
				case "a":
					System.out.println("+----------------------------------------------------------------------------------------------------+");
					String s = MyData.show();
					System.out.println(s);
					System.out.println("+----------------------------------------------------------------------------------------------------+");
					break;
				case "b":
					try {
						Scanner scan = new Scanner(System.in);
						Vector paramss = new Vector();

						System.out.println("Lower Value:");
						int lower = scan.nextInt();
						System.out.println("Upper Value:");
						int upper = scan.nextInt();


						// create struct
						Hashtable lowup_values = new Hashtable();
						lowup_values.put("Lower", lower);
						lowup_values.put("Upper", upper);
						paramss.addElement(lowup_values);

						// send struct to server
						Object resultprime = client.execute("sample.primes", paramss);
						System.out.print("Prime numbers between the given range are " + resultprime);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case "c":
					try {
						Scanner input = new Scanner(System.in);
						Vector paramsss = new Vector();

						System.out.println("lat1 Value:");
						double lat1 = input.nextDouble();
						System.out.println("lon1 Value:");
						double lon1 = input.nextDouble();
						System.out.println("lat2 Value:");
						double lat2 = input.nextDouble();
						System.out.println("lon2 Value:");
						double lon2 = input.nextDouble();



						// create struct
						Hashtable distance = new Hashtable();
						distance.put("lat1", lat1);
						distance.put("lon1", lon1);
						distance.put("lat2", lat2);
						distance.put("lon2", lon2);

						paramsss.addElement(distance);

						// send struct to server
						Object resultprime = client.execute("sample.haversineDistance", paramsss);
						System.out.print("The distance between two Latitude and Longitude is: " + resultprime + " Kilometers");
					} catch (Exception e) {
						e.printStackTrace();
					}



					break;
				case "d":
					do {
						/*
						 * All the parameters of the procedure call are collected in a Vector.
						 */
						params.clear();
						System.out.print("First number ");
						el1 = getInteger();
						System.out.print("Second number ");
						el2 = getInteger();
						params.addElement(new Integer(el1));
						params.addElement(new Integer(el2));
						/*
						 * Here "sample" denotes a handler that is defined in the server.
						 */
						result = client.execute("sample.addition", params);
						/*
						 * the result of the remote procedure call
						 * is always an Object and it has to be casted
						 * to the appropriate type.
						 */
						int sum = ((Integer) result).intValue();
						System.out.println("+----------------------Minus-----------------------+");
						System.out.println("|   Server has returned the Addition: " + sum);
						System.out.println("+--------------------------------------------------+");
					} while (Boolean.TRUE);
					break;
				case "e":
					params.clear();
					System.out.print("First number ");
					el1 = getInteger();
					System.out.print("Second number ");
					el2 = getInteger();
					params.addElement(new Integer(el1));
					params.addElement(new Integer(el2));
					/*
					 * Here "sample" denotes a handler that is defined in the server.
					 */
					result = client.execute("sample.minus", params);
					/*
					 * the result of the remote procedure call
					 * is always an Object and it has to be casted
					 * to the appropriate type.
					 */
					int sum = ((Integer) result).intValue();
					System.out.println("+----------------------Minus-----------------------+");
					System.out.println("|    Server has returned the Minus: " + sum);
					System.out.println("+--------------------------------------------------+");
					break;
				case "f":
					break;

			}

		} catch (Exception exception) {
			System.err.println("JavaClient: " + exception);
		}
		System.out.println("\n\n\n         -----------@copyright-Md-Shahadat-Hossen-Nayem------------");
	}
}
