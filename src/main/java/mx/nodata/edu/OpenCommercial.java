package mx.nodata.edu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;

/* OpenCommercial.java */


/**  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

  /** Prompts the user for the name X of a company (a single string), opens
   *  the Web site corresponding to www.X.com, and prints the first five lines
   *  of the Web page in reverse order.
   *  @param arg is not used.
   *  @exception Exception thrown if there are any problems parsing the 
   *             user's input or opening the connection.
   */
  public static void main(String[] arg) throws Exception {

	InputStreamReader keyboardInputStreamReader;
	InputStreamReader urlInputStreamReader;
	BufferedReader keyboard;
	BufferedReader website;
	ArrayList<String> websiteLine;
	ListIterator<String> listIterator;
	
	String inputLine = "";
	String urlString = ""; 
	int numberOfLines = 5;
    
    // 1. Create a BufferedReader to read text lines  from the console
    keyboardInputStreamReader = new InputStreamReader(System.in);
    keyboard = new BufferedReader(keyboardInputStreamReader);
    
    // 2. Prompts the user for the name X of a company
    System.out.print("Please enter the name of a company (without spaces): ");
    System.out.flush();        /* Make sure the line is printed immediately. */
    inputLine = keyboard.readLine();
    
    // 3. Prints the input entered
    System.out.println();
    System.out.println(inputLine);
    
    // 4. Create a BufferedReader to read content from a URL
    urlString = "http://www." + inputLine + ".com";
    URL url = new URL(urlString);
    urlInputStreamReader = new InputStreamReader(url.openStream());
    website = new BufferedReader(urlInputStreamReader);
    
    // 5. Initialize the list
    websiteLine = new ArrayList<String>();
    
    // 6. Read the lines using the BufferedReader and add to a list 
    for(int i = 0; i < numberOfLines; i++){
    	websiteLine.add(website.readLine());
    }
    
    // 7. Print the lines in reverse order
    listIterator = websiteLine.listIterator(websiteLine.size());
    while(listIterator.hasPrevious()){
      System.out.println(listIterator.previous());
    }
  }
}
