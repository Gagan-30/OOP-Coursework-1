import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZombieCatcher {

    // Check if two time periods overlap
    public static boolean overlappingPeriods(int start1, int end1, int start2, int end2) {
        return start1 < end2 && start2 < end1; // Check if time intervals overlap
    }
    
    // Handle day/night period overlap
    public static boolean overlappingDayAndNightPeriods(int start1, int end1, int start2, int end2) {
        // Case where both periods dont cross midnight
        if (end1 > start1 && end2 > start2) {
            return start1 < end2 && start2 < end1;
        }
  
        // Adjust for periods crossing midnight by adding 24 hrs to end time
        int adjustedEnd1 = (end1 > start1) ? end1 : end1 + 24;
        int adjustedEnd2 = (end2 > start2) ? end2 : end2 + 24;
      
        int adjustedStart1 = start1;
        int adjustedStart2 = start2;

        return (adjustedStart1 < adjustedEnd2 && adjustedStart2 < adjustedEnd1);
    }

      // Manually input visitor data, check infection period overlap
      public static int getVisitors(int infectionStart, int infectionEnd) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Enter the number of visitors:");
          int visitorCount = scanner.nextInt();
          scanner.nextLine(); 

	  int quarantineCount = 0;
          for (int i = 0; i < visitorCount; i++) {
              System.out.println("Enter the visitor's name:");
              String name = scanner.nextLine();
              System.out.println("Enter the arrival time:");
              int arrival = scanner.nextInt();
              System.out.println("Enter the departure time:");
              int departure = scanner.nextInt();

              scanner.nextLine();

	      // Check infection period overlap
              if (overlappingPeriods(arrival, departure, infectionStart, infectionEnd)) {
                  System.out.println(name + " needs to be quarantined.");
                  quarantineCount++;
              } else {
                  System.out.println(name + " does not need to be quarantined.");
              }
          }
          return quarantineCount;
      }

      // Process visitor data files
      public static int processFiles(String[] files, int infectionStart, int infectionEnd) {
	  int quarantineCount = 0;

    	  for (String filename : files) {
              File file = new File(filename);
        	  if (!file.exists()) {
            	      System.out.println("WARNING: " + filename + " not found.");
            	      continue; // skip if no file
        	  }
        	//System.out.println("Processing file: " + filename);  // Verify if the file is being processed

              try (Scanner fileScanner = new Scanner(file)) { 
                    while (fileScanner.hasNextLine()) { // Read each line of file
                    	    String line = fileScanner.nextLine();
                	    //System.out.println("Reading line: " + line);  // Debugging line to see what data is being read

                	    String[] parts = line.split(" "); // Split line 
                	    if (parts.length != 3) continue;

                	    String name = parts[0]; // Extract name
                      	    int arrival = Integer.parseInt(parts[1]); // Extract arrival time
                   	    int departure = Integer.parseInt(parts[2]); // Extract departure time

		            // Check infection period overlap
                	    if (overlappingPeriods(arrival, departure, infectionStart, infectionEnd)) {
                    	 	System.out.println(name + " needs to be quarantined.");
                    		quarantineCount++;
                	    }
            	    }
              } catch (FileNotFoundException e) { // Handle file not found 
               	   System.out.println("WARNING: " + filename + " not found.");
              }
    	  }

    	  return quarantineCount;
    }

    // Handle manual entry or file based
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the start time:");
        int infectionStart = scanner.nextInt();
        System.out.println("Enter the end time:");
        int infectionEnd = scanner.nextInt();

        int quarantineCount;

        // Check if files provided in cmd arguments
        if (args.length > 0) {
            // File entry
            quarantineCount = processFiles(args, infectionStart, infectionEnd);
        } else {
            // Manual entry
            quarantineCount = getVisitors(infectionStart, infectionEnd);
        }
        System.out.println("Number of potential zombies: " + quarantineCount);
    }
}
