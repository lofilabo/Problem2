
Overview

i. Definition of Problem.

The problem is defined as follows: 

(Approximate translation to English)
	
	Using the map shown, determine the directions to drive a car from junction A to junction B

	One-way roads are indicated by an arrow showing the direction of traffic flow.

	Write an application program to solve this problem.  Provide a rich output to indicate the path by means of junctions.

	You will also need to provide: reference numbers for the junctions shown on the diagram.


(this document is available at https://docs.google.com/file/d/0B_voeTppgIM2SFpFaFptRmVKOWc/edit.  This problem is Question 2 on the sheet.)

ii. Ways of approaching the problem.

Whilst it would be possible to concieve of a banal single-use case to solve only the problem at hand, the key to a solution which completely satisfies the question requires an understanding of the generic problem of which this problem is a subset.  Although the topology and the nature of the question are different, the problem can be seen to be a variant of the Bridges of Koenigsburg puzzle, which is itself a recognised case of the Graph Theory Shortest Route scenario.

This scenario - to find the shortest route from vertex Va to Vertex Vb where the network comprises of an unlimited but finite number of Vertices, joined by an unlimited but finite number of Edges, and where each Edge may be traversed in one or both directions, has been consistently represented by the Dijkstra algorithm.  The problem of implementing Dijkstra in some general programming language is non-trivial, but fortunately, many canonical examples exist in standard Computer Science texts, which reduces the task in hand to applying one of them to the question described.

iii. Discussion of a solution to the problem.

The reader is invited to examine figure (/grfx/map001.jpg) which reproduces the diagram shown in the Question Text and annotates it in a manner suitable for applying a Java implmentation of the Dijkstra algorithm.  Points of note are as follows.

	1. Real implementations of Dijkstra include some coeffifient or metric of 'route difficulty', which are of intense practical utility depending on the application.  This could include factors such as maximimum velocity, tube radius and drag coefficient in mechanical engineering, impedence or resistance (in electrical engineering), length, and limiting factors such as choking points, traffic signals or valve operations, Rate Determining Steps (in organic chemistry), gestation period (in agriculture) and tool-up time and supply chain (in retail marketing).  The question makes no reference to any such coefficient, therefore it was been set throughout as 1.  Which is to say that the coefficient is available and implemented, but arbirarily defined as a unitary value.

	The reader is invited to conder how this coefficient may be arrived at in an actual evidence-based example of the type shown.  Of course, the traffic capacity of the roadways would have to be accounted for, along with the expected vehicle type and deadweight.  Crucially, no implmentation of Dijkstra takes account of Vertex Transition as a function of time; crossing a juction is assumed to be instantaneous, which may be a weakness in this application of the algorithm.

	2. The reader will note that each Edge has been represented by a Road identification number.  The question defines all roads but one (equivalent to 2 edges in our case) as 'two-way', which means that any one road beteen vertices 0 and 1 would be represented as:
		Road1_out, 	0, 1
		Road1_in,	1, 0
	
	for a 2-way road, and 
		Road1_out, 0,1

	for a 1-way road.

	The conventions _out and _in are used respectively to indicate the flow from the smaller vertex ID to the larger, or from the larger to the smaller.

	3. In this example, the classical network theory vertices and edges have been referred to as 'junctions' and 'roads'.  It is hoped this will be more clear to end users.


iv. Layout of the software.

The software is structured as follows:

	sw-----docs
		|	|--readme.txt (THIS DOCUMENT)
		|	|--routes.txt (a computer-readable form of the route mapping defined in map001.jpg)
		|
		|--grfx
		|	|--map001.jpg 
		|
		|
		|--sw------Problem.java
				|--route001
						|-------DijkstraImpl.java
						|-------Graph.java
						|-------Junction.java
						|-------Road.java

the route001 directory contains the implmentation of the Dijkstra algorithm and its support classes (for Graph, Road and Junction).  The reader is directed to the Program.java file, which constitutes the User Interface for the problem in question.  It is hoped that the user will, in concert with (/grfx/map001.jpg) be able to understand that the method defineNetwork() provides the definition for a Linked List which holds each possible 'road'.  Note that roads 12 and 16 are one-way and have only 'out lanes' defined on them.

The statement 

	routeplan.doTest(1, 12);

defines that we wish to obtain the shortest route from vertex (junction) 1 to junction 12.

v. Running the program.

The following has been tested on WinNT-type systems and Debian GNU-Linux Distribution type systems on x86 and ARM architechtures.  Java SE8 has been used throughout, although the use of Java and its libraries is very conservative and the program should compile with legacy versions back to JDK 1.2.

If the user is reading this file, the archive containing the problem should have been opened.  Extract this archive to somewhere on the file system where the command 

	java -version

yields a version number of 1.6.x, and the command

	javac

yields a message of type 
	
	"Usage: javac <options> <source files>"
 
and not an operating system error.

From within the sw subdirectory, Compile the problem solution with the java compiler invocation:

	javac Problem.java

and run it with the runtime invocation:

	java Problem

If the user prefers an IDE such as Eclipse, a new project should be created, and the source of sw/ should be imported from the file->import->general->file system menu.  To run the program from within the IDE, the run as -> Java Application option should be used on Problem.java.  Note that the IDE may require Problem.java to be given a namespace (package URI).	
The user is invited to compare the route suggested by the program to the route obtained by intuition from the diagram.  The user is invited to observe that the route suggested by the program is optimised to take advantage of the one-way street J9 - J11 and not the two-way street J8 - J12.


vi.  Conclusion and Critique.

The solution presented here is suboptimal in may ways.  In future, the following could be improved:

	1. A better algorithm implmentation.

	2. A Control Program which accepts a plain-text file of route definitions, and start- and end- points as command-line arguments.  The file routes.txt is given as an example of such a network definition file.

	3. No account is taken of the time needed to negotiate vertices (junctions).

The user may, for their own amusement, make sideways copies of the file Problem.java and implment their own network definitions.  The Route Map of Royal Dutch Airlines KLM, the Mass Transit Subway System of Tokyo and the Street Grid of New York City (1st St - 125th St, Ave A - 7th inc. Ave.Am.) are particularly challenging and interesting examples.


COPYRIGHT.

None.

No attempt to assert any form of copyright is made with respect to the contents of this repository / archive.  The User upholds that it is intended only for the attention of immediately concerned parties, until such time as the concerned parties have indicated that they have no further interest in it, or 1 calendar month has elapsed.  This statement does not constitute an NDA. 

