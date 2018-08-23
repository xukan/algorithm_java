package algorithm_java;

/***********************2***************************/
/*
 * Problem2.java
 *
 * Problem 2
 * CS 5006 Final Exam
 * 
 * This program counts the words in a collection of books available 
 * online in plain text format from Project Gutenberg. The program 
 * uses an ExecutorService to run the counting tasks concurrently.
 * 
 * The problem is to provide a WordCounter class that implements
 * Callable<Integer>. The call() method counts the number of words
 * in its input and returns the count as an Integer.The WordCounter 
 * is used in main() to submit tasks to an ExecutorService.
 * 
 * The WordCounter is constructed with a URL that represents the URL 
 * of a book. The URL.openStream() method returns an InputStream that 
 * can be used to read lines through a BufferedReader. The reader must 
 * be closed after the last line is read.
 * 
 * Use a StringTokenizer on each input line to count the number of
 * words, and keep a running total for all the lines.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Problem2 {
	/**
	 * This class counts words from a URL location.
	 */
	static class WordCounter implements Callable<Integer> {
		// your code here
		private URL url;
		static final int OUT = 0;
	    static final int IN = 1;
		WordCounter(URL url) {
			this.url = url;
		}
		@Override
		public Integer call() throws Exception {
		    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line;
		    int count = 0;  
		    while ((line= in.readLine()) != null) {
		    	int state = OUT;
		        int i = 0;
		        // check every character
		        while (i < line.length()){
		            // If next character is a separator, set the 
		            // state as OUT
		            if (line.charAt(i) == ' ' || line.charAt(i) == '\n'
		                    || line.charAt(i) == '\t')
		                state = OUT;
		            // If next character is not a word separator
		            // and state is OUT, then set the state as IN
		            // and increment word count
		            else if (state == OUT){
		                state = IN;
		                ++count;
		            }
		            // Move to next character
		            i++;
		        }
		    }
		    in.close();
			return count;
		}
	}

	/**
	 * Get map of books and their URLs to word count.
	 * @return a map of books and their URLs
	 */
	static Map<String, URL> getBookList() {
		// create book list with Jane Austen novels on Project Gutenberg
		Map<String, URL> books = new HashMap<>();
		try {
			books.put("Pride and Prejudice", 
					  new URL("https://www.gutenberg.org/files/1342/1342-0.txt"));
			books.put("Emma", 
					  new URL("https://www.gutenberg.org/files/158/158-0.txt"));
			books.put("Persuation", 
					  new URL("http://www.gutenberg.org/cache/epub/105/pg105.txt"));
			books.put("Sense and Sensibility", 
					  new URL("http://www.gutenberg.org/cache/epub/161/pg161.txt"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return books;
	}
	
	/**
	 * Get map of books and their expected word counts.
	 * @return a map of books and their expected word counts.
	 */
	static Map<String, Integer> getExpectedWordCounts() {
		// create book list with Jane Austin novels on Project Gutenberg
		Map<String,Integer> counts = new HashMap<>();
		counts.put("Pride and Prejudice", 124592);
		counts.put("Emma", 160458);
		counts.put("Persuation",  86307);
		counts.put("Sense and Sensibility",  121590);
		return counts;
	}

	/**
	 * Count the number of words in a list of books, given their URLs.
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		System.out.println("Start problem 2\n");
		
		// get a cached thread pools service
		ExecutorService executor= Executors.newCachedThreadPool();

		// get the map of books and prepare a map of lengths
		Map<String,URL> books = getBookList();

		// submit a tasks for each book to count its words
		Map<String,Future<Integer>> wordCounts = 
				new HashMap<String, Future<Integer>>(books.size());
		for (Map.Entry<String,URL> entry : books.entrySet()) {
			wordCounts.put(entry.getKey(), 
						   executor.submit(new WordCounter(entry.getValue())));
		}

		// wait for the tasks to complete
		try {
			System.out.print("Counting words ");
			executor.shutdown();

			// show progress bar while waiting
			while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
				System.out.print(".");
			}
			System.out.println();
		} catch (InterruptedException e) {
			System.out.println();
			System.out.println(e);
		}
		System.out.println();

		Map<String,Integer> expectedCounts = getExpectedWordCounts();
		
		// report word counts for the books
		int totalCount = 0;
		int totalExpected = 0;
		for (Map.Entry<String, Future<Integer>> entry : wordCounts.entrySet()) {
			try {
				String book = entry.getKey();
				int count = entry.getValue().get();
				int expected = expectedCounts.get(book);
				totalCount += count;
				totalExpected += expected;
				// report word count for this book
				System.out.printf("%s: %d words (expected %d)\n", entry.getKey(), count, expected);
			} catch (InterruptedException | ExecutionException e) {
				// report error for this book
				System.out.printf("%s: %s", entry.getKey(), e);
			}
		}
		System.out.printf("\nTotal: %d words (expected %d)\n", totalCount, totalExpected);
		
		System.out.println("\nEnd problem 2");
	}
}
/***********************2***************************/

/***********************5***************************/

/*
 * Problem5.java
 * 
 * Problem 5
 * CS 5006 Final Exam
 *
 * Every rational number can be represented as a sum of fractions
 * whose numerator is 1 and whose denominator is a positive whole
 * number, such as 1/3.
 *
 * Following are few examples:
 *
 * 2/3 = 1/2 + 1/6
 * 6/14 = 1/3 + 1/11 + 1/231
 * 12/13 = 1/2 + 1/3 + 1/12 + 1/156
 *
 * These fractions can be generated by a Greedy Algorithm based
 * on reduce and conquer. For a number with the numerator nr and
 * denominator dr, such that dr > nr, find the greatest fraction 
 * whose numerator is 1, then recur for the remainder.
 * 
 * For 6/14. the ceiling of the reciprocal fraction 14/6 is 3,
 * so the first fraction is 1/3. Then continue for the remainder
 * (6/14 – 1/3) = (18/42 - 14/42) = 4/42.
 */
public class Problem5{
	/**
	 * This function prints a series of fractions that have a
	 * numerator of 1 for the numerator nr and denominator dr.
	 *
	 * If the numerator or denominator are 0, the function returns.
	 *
	 * If the numerator nr evenly divides the denominator dr, then
	 * the function uses simple division to print the faction of
	 * the form 1/n and returns
	 *
	 * If the denominator dr evenly divides the numerator nr, then
	 * the number is simply printed and the function returns.
	 *
	 * If the numerator nr is greater than the denominator dr, then
	 * the whole number portion is printed, and function continues
	 * with the remainder as the numerator and the same denominator.
	 *
	 * Otherwise, 1 over the ceiling (n) of the numerator nr divided
	 * by the denominator dr is printed, and the function continues
	 * with the numerator (nr*n-dr) and the denominator (dr*n).
	 *
	 * @param nr the numerator
	 * @param dr the denominator
	 */
	static public void printFractions(int nr, int dr) {
		// your code here
		// denominator is 0
		if(dr == 0) {
			System.out.println("");
			return;
		}
		//numerator is 0
		if (nr == 0) {
			System.out.println("0");
			return;
		}
		//numerator evenly divides the denominator
		if (nr % dr == 0 ) {
			System.out.println(nr/dr);
			return;
		}
		int num = gcd(nr, dr);
		nr /= num;
		dr /= num;
		while(nr != 1) {
			if (nr < dr) {
				int denom = dr / nr + 1; 
				System.out.print("1/" + denom +  " + ");
				int[] pair= fracSub(nr, dr, 1, denom);
				nr = pair[0];
				dr = pair[1];
			}else {
				System.out.print("1 + " );
				nr -=1;
			}
		}
		System.out.println(nr + "/" + dr);
	}
	 
	/**
	 * get the greatest divisor
	 * @param a the numerator
	 * @param b the denominator
	 */
	public static int gcd(int a, int b) {
	   if (b==0) return a;
	   return gcd(b,a%b);
	}
	
	/**
	 * get the result of substraction of two rational numbers
	 * @param first_nr first numerator
	 * @param first_dr first denominator
	 * @param second_nr second numerator
	 * @param second_dr second denominator
	 * @return array where the first number is numerator, second number is denominator
	 */
	public static int[] fracSub(int first_nr,int first_dr,int second_nr,int second_dr){		
		int dr;
		int nr;
		int[] res = new int[2];
	    if(first_dr==second_dr){      
	         dr=first_dr;      
	         nr=first_nr-second_nr;      
	    }else{      
	    	dr=first_dr*second_dr;      
	    	nr=first_nr*second_dr-first_dr*second_nr;      
	    }  
	    int gcd = gcd(nr,dr);
		dr = dr / gcd;
		nr = nr / gcd;	
		res[0] = nr;
		res[1] = dr;
	    return res;
	}
	
	/**
	 * Main program tests the function for a variety of inputs
	 * @param args unused
	 */
	public static void main(String args[]) {
		System.out.println("Start problem 5\n");
		
		int[] numerator = {2, 6, 12, 0, 6, 8, 4};
		int[] denominator = {3, 14, 13, 0, 5, 4, 8};
		String[] expected = {
		                "1/2 + 1/6",
		                "1/3 + 1/11 + 1/231",
		                "1/2 + 1/3 + 1/12 + 1/156",
		                "",
		                "1 + 1/5",
		                "2",
		                "1/2"
		};
		
		for (int i = 0; i < expected.length; i++) {
		        int nr = numerator[i], dr = denominator[i];
		        System.out.printf("Fraction representation of %d/%d is:\n", nr, dr);
		        printFractions(nr, dr);
		        System.out.printf("\nExpected:\n%s\n\n", expected[i]);
		}
		
		System.out.println("End problem 5");
	}
}
/***********************5***************************/
