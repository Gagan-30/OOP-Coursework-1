CS1811 Formative Coursework

This assignment must be submitted by 8 November (2pm).

Feedback will be provided on the date provided in the coursework grid that can be found here.
Learning Outcomes Assessed

This assignment tests your ability to write a complete Java program, using the control flow constructs described in the lectures. That is,

    sequencing,
    branching,
    loops,
    method calls.

You will write a program that interacts with the user via a Scanner and performs some simple calculations.
Instructions

Submit an electronic copy of your work using the submission link below.
Use of AI

The use of generative AI tools (e.g. Microsoft Copilot, ChatGPT, Grammarly, etc.) is not permitted for this assignment. More information regarding the use of generative AI in your studies can be found here.
Academic Misconduct

Coursework submissions are routinely checked for academic misconduct (working together, copying from sources, etc.). Penalties can range from a 10% deduction of the assignment mark, zero for the assignment or the case being referred to a Senior Vice-Principal to make a decision (for repeat offences). Note that is academic misconduct if you fail to correctly reference or acknowledge where you have used generative AI tools to help you produce your submission. If the use of generative AI tools is prohibited for this assignment, then any use of such tools constitutes academic misconduct. Further details can be found here.
Marking Criteria

There are two components to the marking of this assignment

    functionality (90 marks), and
    quality (10 marks).

The functionality is assessed through automated testing. We will run an extended version of the assignment tester on your code and you will receive marks based on the percentage of tests that you pass. These tests will include hidden tests that are not in the version of the tester we release to students. This is standard practice – you are expected to take responsibility for the correctness of your code, which means not just relying on the tests we provide.

The quality of your code is evaluated by evaluating whether you have followed good programming style, i.e., formatting your code so that it is readable (make good use of indentation), using good variable names, and avoiding overly complex or incomplete solutions.

For example, to print the numbers from 1 to 10, the following code is badly formatted and repetitive.

System.out.println("1"); System.out.println("2");
        System.out.println(
        "3");
    System.out.println("4");
System.out.println("5"   );System.out.println( "6"
                        ); System.out.println("7");
System.out.println("8"); System.out.println("9");
    System.out.println("10");

A much cleaner solution is shorter and nicely indented.

for (int i = 1; i <= 10; i++)
    System.out.println(i);

Each question is clearly labelled with the available marks. Marks are awarded according to the following rubric.

    Question 0: 5 marks
    Question 1: 20 marks
    Question 2: 20 marks
    Question 3: 20 marks
    Question 4: 15 marks
    Question 5: 10 marks
    Question 6: 10 marks

Important: make sure your submitted code compiles with the command

$ javac *.java

Code that does not compile cannot pass any tests, and will lose 90 marks!

Once you have submitted your solution on Moodle, download it again and test it.

Please contact use the CS1811 forum if you have any specific questions. If your question cannot be posted publicly, then contact Julien (julien.lange@rhul.ac.uk).
Overview

You will write a program ZombieCatcher to help restaurants, cafes, and other venues on campus slow down the potential outbreak of a zombie apocalypse in Egham!

Programming the full system will be complicated. For now, we will only implement a proof of concept program. The user will first enter a time period where a zombie was known to be on the premises. A time period will be represented by two integers – a start and an end time. For example a start of 5 and end of 7 means the zombie was on the premises from 5 o’ clock to 7 o’ clock. We will only count whole hours for this exercise.

After entering this time period, the user then enters the names of all visitors and the time they were on site. The program will print out if each visitor needs to be quarantined, and summarise at the end how many potential new zombies have been identified.

An example run is shown below, with a zombie present from 5 to 7, and two visitors. The first will need to have be quarantined as soon as possible, the second will not. A total of 1 potential new zombie has been identified.

$ java ZombieCatcher
Enter the start time:
5
Enter the end time:
7
Enter the number of visitors:
2
Enter the vistor's name:
Sulaimaan
Enter the arrival time:
4
Enter the departure time:
8
Sulaimaan needs to be quarantined.
Enter the visitor's name:
Dmani
Enter the arrival time:
8
Enter the departure time:
9
Dmani does not need to be quarantined.
Number of potential zombies: 1

Detailed Instructions

It is best to complete your work on NoMachine – you will have automatic backups and the instructions below will work as expected.

Create a file ZombieCatcher.java. In this file you will write a Java program. (Your file name must match the specification exactly!)

Submit your file ZombieCatcher.java using the submission button below.

You can test your submission using the CS1811 Assignment 1 Testing Tool . Please download the tester file and save it to the same directory where you are working on your assignment. To use the tester, first compile your code, and then run the command below. This walkthrough video, with a slightly different tester, may help if you are having difficulties.

$ javac ZombieCatcher.java
$ java -jar cs1811Assignment1ZombieTesterStudent.jar

This will run a series of tests you can use to verify the correctness of you solution. If a test does not pass, an explanation will be provided. An example output is shown below.

Running testQ0_MainClass

   Test passed

Running testQ1_00OverlappingPeriodsMethod

   Test passed

Running testQ1_01OverlappingPeriodsMethod

   After calling

     Boolean b0 = ZombieCatcher.overlappingPeriods(8, 9, 10, 11);

   expected the result of ZombieCatcher.overlappingPeriods(8, 9, 10, 11) to
   be false because the periods don't overlap. Instead the call returned true.

Tests failed

In the above run, the first test passed, but the second test showed that there was a problem with the method overlappingPeriods in the ZombieCatcher class. In particular, it returns the wrong answer with the arguments 8, 9, 10, 11. You can write a test class with a main method that runs the code shown to debug the problem.

You program will take input from the keyboard and print output. The tester will test this too and provide information about failing tests. For example,

Running testQ2_01GetVisitorsMethod

  Test failed!

  Failing interaction:
  > Enter the number of visitors:
  < 1
  > Enter the visitor's name:
  < Llodra
  > Enter the arrival time:
  < 8
  > Enter the department time:
  < 10
  > Llodra does not need to be quarantined.

  Expected 'Llodra needs to be quarantined.'

In the above run, input is marked with < and output with >. Your program does not need to output these symbols. The test failed because the output was wrong. The program said “Llodra does not need to be quarantined.” when it should have said “Llodra needs to be quarantined.”.
Questions
Question 0: Your Program Class [5 Marks]

Create a file ZombieCatcher.java and declare inside it a class ZombieCatcher.

After completing this question, compile your code with

$ javac ZombieCatcher.java

and then run the tester

$ java -jar cs1811Assignment1ZombieTesterStudent.jar

You should see that testQ1_00MainClass is passed:

Running testQ0_MainClass

  Test passed

If this is not the case, make sure that you have not defined a package at the top of your ZombieCatcher.java file.
Question 1: Overlapping Periods [20 Marks]

Add a static method overlappingPeriods to your ZombieCatcher class. It should

    take four int arguments representing two time periods:
        the first argument is the start of period 1,
        the second argument is the end of period 1,
        the third argument is the start of period 2, and
        the fourth argument is the end of period 2;
    return a boolean that is true if the periods overlapped.

A number gives the hour in 24-hour format (0 is midnight, 7 is in the morning, and 19 is in the evening). For example, a time period from 17 to 19 overlaps with a period from 18 to 21. Conversely, the time periods 14 to 16 and 16 to 18 do not overlap, even though they meet.

For now you can assume that times do not cross midnight. That is the start time is always a smaller number than the end time. For example, the time period 19 to 21 is valid, but the period 23 to 1 is not.

You will never get a null period, e.g., a period from time 2 to time 2.

After completing this question, compile your code with

$ javac ZombieCatcher.java

and then run the tester

$ java -jar cs1811Assignment1ZombieTesterStudent.jar

You should see that testQ0_MainClass and hopefully all tests starting with testQ1_ now pass.

Hint: see this tutorial for some tips on getting started.
Question 2: Reading the Entry/Exit Logs [20 Marks]

Add a (static) method getVisitors to your ZombieCatcher class. It should do the following.

    Take two int arguments representing the start and end of a time period when a zombie was known to be in the venue.
    Ask the user "Enter the number of visitors: (use println for this) and then read the number of visitors from the keyboard.
    For each visitor
        ask the user to Enter the visitor's name: and read it from the keyboard,
        ask the user to Enter the arrival time: and read it from the keyboard,
        ask the user to Enter the departure time: and read it from the keyboard,
        print ____ needs to be quarantined. if they overlap with the infection time period (where ____ is the visitor’s name), or print ____ does not need to be quarantined. if they do not.
    Return an int value which is the number of visitors who need to be quarantined.

Don’t forget to compile your code and run the tester . All tests starting testQ2_ should now pass.

Hint: this method needs a Scanner over System.in but does not take one as an argument. See this tutorial for a way to do this without arguments.

Hint: depending on your implementation, you may run into a subtle bug with this question. See this tutorial to see how to diagnose failed tests, and in particular fix the subtle bug you might have found.
Question 3: Your Main Method [20 Marks]

Add a main method to your ZombieCatcher class. This should do the following.

    Ask the user to Enter the start time: and read the arrival time of the zombie from the keyboard.
    Ask the user to Enter the end time: and read the departure time of the zombie from the keyboard.
    Use getVisitors to read the visitor list and print out who needs to be quarantined.
    At the end, print out Number of potential zombies: n where n is the number of people who need to be quarantined.

Don’t forget to compile your code and run the tester . All tests starting testQ3_ should now pass.
Question 4: After Midnight [15 Marks]

In the previous exercises, we assume that time periods do not cross midnight.

To begin support for this, write a method overlappingDayAndNightPeriods that works like overlappingPeriods but supports time periods that might cross midnight. For example, 22 to 1 would mean the customer arrived at 10pm and left and 1am. This time period should overlap with 21 to 2 but not 2 to 21.

You can assume that all venues open on or after 7, and close before or at 6. In this case the time period 2 to 4 would overlap with 23 to 3.

Don’t forget to compile your code and run the tester . All tests starting testQ4_ should now pass.
Question 5: Reading Files [10 Marks]

Some marks of an assignment should be designed to test the ability of students to show independence and creative thought. This question will go beyond the aspects of the module taught so far, and look ahead. In particular, you may wish to view the sections on arrays and advanced arrays (Week 8) that cover command line arguments and reading files (Week 9). You may also look at Section 5.3 (arrays) and Section 6.3 (files) of the module textbook.

We will take our proof of concept program further. Instead of having to type in the entry and exit times of all visitors, we will read the data from a file instead. This data file might be produced by the venues that scan your student IDs on entry.

Extend your program so that the user can supply a list of files on the command line. If no files are specified, the program should ask the user to enter each visitor individually. Otherwise, your program should iterate through the list of files, and read the entry and exit data from them. For this question, the program should only output the names of the visitors who might be a zombie.

An example file might be formatted as follows:

Yusif 18 19
Amber 17 22
Marco 14 17

An example run might be

$ java ZombieCatcher access-log-1.txt access-log-2.txt
Enter the start time:
16
Enter the end time:
18
Amber needs to be quarantined.
Marco needs to be quarantined.
Number of potential zombies: 2

If a file is not found, your program should print “WARNING: <filename> not found.” and continue to the next file, where “<filename>” is the name of the file that was not found. An example interaction is shown below.

$ java ZombieCatcher notafile.txt access-log-1.txt
Enter the start time:
16
Enter the end time:
18
WARNING: notafile.txt not found.
Amber needs to be quarantined.
Marco needs to be quarantined.
Number of potential zombies: 2

Question 6: Code Quality [10 Marks]

Marks for this question will depend both on the quality of your code. See the marking criteria section for an example of good vs. bad programming style.

Important: make sure your submitted code compiles with the command

$ javac *.java

Code that does not compile cannot pass any tests, and will lose 90 marks!

Once you have submitted your solution on Moodle, download it again and test it.
