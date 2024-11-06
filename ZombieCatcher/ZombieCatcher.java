import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZombieCatcher {

    // Existing overlappingPeriods method
    public static boolean overlappingPeriods(int start1, int end1, int start2, int end2) {
        return start1 < end2 && start2 < end1;
    }
    
    public static boolean overlappingDayAndNightPeriods(int start1, int end1, int start2, int end2) {
      // Case 1: Both periods do not cross midnight
      if (end1 > start1 && end2 > start2) {
          return start1 < end2 && start2 < end1;
      }
  
      // Adjust periods that cross midnight by adding 24 to the end time if needed
      int adjustedEnd1 = (end1 > start1) ? end1 : end1 + 24;
      int adjustedEnd2 = (end2 > start2) ? end2 : end2 + 24;
      
      // Adjusted start times remain the same
      int adjustedStart1 = start1;
      int adjustedStart2 = start2;

      // Case 2: One or both periods cross midnight
      return (adjustedStart1 < adjustedEnd2 && adjustedStart2 < adjustedEnd1);
    }


    // Existing getVisitors method for manual entry (used if no files are provided)
    public static int getVisitors(int infectionStart, int infectionEnd) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of visitors:");
        int visitorCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int quarantineCount = 0;
        for (int i = 0; i < visitorCount; i++) {
            System.out.println("Enter the visitor's name:");
            String name = scanner.nextLine();
            System.out.println("Enter the arrival time:");
            int arrival = scanner.nextInt();
            System.out.println("Enter the departure time:");
            int departure = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (overlappingPeriods(arrival, departure, infectionStart, infectionEnd)) {
                System.out.println(name + " needs to be quarantined.");
                quarantineCount++;
            } else {
                System.out.println(name + " does not need to be quarantined.");
            }
        }
        return quarantineCount;
    }

    // New method to handle file input
    public static int processFiles(String[] files, int infectionStart, int infectionEnd) {
        int quarantineCount = 0;

        for (String filename : files) {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("WARNING: " + filename + " not found.");
                continue;
            }

            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split(" ");
                    if (parts.length != 3) continue;  // Skip malformed lines

                    String name = parts[0];
                    int arrival = Integer.parseInt(parts[1]);
                    int departure = Integer.parseInt(parts[2]);

                    if (overlappingPeriods(arrival, departure, infectionStart, infectionEnd)) {
                        System.out.println(name + " needs to be quarantined.");
                        quarantineCount++;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("WARNING: " + filename + " not found.");
            }
        }

        return quarantineCount;
    }

    // Main method to handle either file-based or manual entry
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the start time:");
        int infectionStart = scanner.nextInt();
        System.out.println("Enter the end time:");
        int infectionEnd = scanner.nextInt();

        int quarantineCount;
        if (args.length > 0) {
            // Process files if provided in command-line arguments
            quarantineCount = processFiles(args, infectionStart, infectionEnd);
        } else {
            // Fallback to manual entry
            quarantineCount = getVisitors(infectionStart, infectionEnd);
        }

        System.out.println("Number of potential zombies: " + quarantineCount);
    }
}

