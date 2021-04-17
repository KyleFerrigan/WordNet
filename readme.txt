/******************************************************************************
 *  Name: Kyle Ferrigan
 *  NetID: kbferrigan
 *  Precept:  N/A
 *
 *  Partner Name: Patrick Galati
 *  Partner NetID: pagalati
 *  Partner Precept: N/A
 *
 *  Operating system: Kyle: Win10; Patrick: Win10
 *  Compiler: Kyle: JetBrains IntelliJ IDEA; Patrick: Netbeans
 *  Text editor / IDE: Kyle: JetBrains IntelliJ IDEA; Patrick: Netbeans
 *
 *  Have you taken (part of) this course before:
 *  Kyle: No; Patrick: No
 *  Hours to complete assignment (optional):
 *  9 hours each
 ******************************************************************************/

Programming Assignment 4: WordNet


/* *****************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 **************************************************************************** */
We used a hashtable with bags holding strings, You told us the bags were required in class,
and we used a hash table as it is fast access and should have minimal collisions with the keys


/* *****************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 **************************************************************************** */
We used a hashtable with bags holding integers, You told us the bags were required in class,
and we used a hash table as it is fast access and should have minimal collisions with the keys



/* *****************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithm? Express your answer as a function of the
 *  number of vertices V and the number of edges E in the digraph.
 *  (Do not use other parameters.) 
 **************************************************************************** */

Description:
We are calling Digraph.java for the immutable Directed Acylic Graph. Because the Digraph updates the indegrees and adjacency lists, it will return the a deep copy of the specificed graph so that we only interact with the copy for the shorest common ancestor between vertices.

Order of growth of running time:
Big O (V + E)

/* *****************************************************************************
 *  Describe concisely your algorithm to compute the shortest common ancestor
 *  in ShortestCommonAncestor. For each method, give the order of growth of
 *  the best- and worst-case running times. Express your answers as functions
 *  of the number of vertices V and the number of edges E in the digraph.
 *  (Do not use other parameters.) 
 *
 *  If you use hashing, assume the uniform hashing assumption so that put()
 *  and get() take constant time per operation.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't forget
 *  to count the time needed to initialize the marked[], edgeTo[], and
 *  distTo[] arrays.
 **************************************************************************** */

Description:
We used breadth first directed paths to create the graphs for the directed acylic graph comparison. By measuring the distance between vertices, we can determine the length and ancestor of the vertices.

                                 running time
method                  best case            worst case
--------------------------------------------------------
length()               O (V)                 O (V + E)

ancestor()             O (V)                 O (V + E)

lengthSubset()         O (V)                 O (V + E)

ancestorSubset()       O (V)                 O (V + E)



/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
None that we are aware of

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings and lectures, but do
 *  include any help from people (including
 *  classmates and friends) and attribute them by name.
 **************************************************************************** */
We did not receive any extra help on this assignment

/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */
We did not really know how to initially approach ShortestCommonAncestor.java and
especially WordNet.java as the datastructures needed was not clear cut.

/* *****************************************************************************
 *  If you worked with a partner, give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */
 We both helped each other out on all the code but Kyle primarily worked on Wordnet
 and Patrick primarily worked on ShortestCommonAncestor and Outcast



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **************************************************************************** */



/* *****************************************************************************
 *  Include the screenshots of your output.
 **************************************************************************** */
