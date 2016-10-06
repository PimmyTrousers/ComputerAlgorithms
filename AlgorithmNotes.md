#8/29/16:

Example:
MaxElements (A, n)
- Input:
	- array of integers A
	- size of array n
- Output:
	- Maximum element in A

```
	CurrentMax  A[0]
	for(i = 1; i < n-1; i++)
	 do:
	   if(A[i] > CurrentMax) then:
	     CurrentMax  A[i]
       return CurrentMax
```

**Primitive types is Java:**
-	Byte
-	Short
-	Int
-	Long
-	Float
- Double
-	Boolean
-	Char

---

**Default values for primitive types**
- 	Byte : 0
- 	Short : 0
- 	Int : 0
- 	Long : 0
- 	Float : 0
- 	Double : 0
- 	Char : \u0000
- 	String : null
- 	Boolean : false

---

We reference static code by the class name and then the name of the method. We reference Instance code with  a state and then the name of the method.

# 9/1/16
## Continuing Java

Java byte code - analogous to machine code. Encoding that Java Virtual Machine understands. You can compile on any system and it will work on any other computer because of JVM layer between the compiler and the code.

**Data Extraction**

This is where we create new classes and methods. OOP stuff...

Encapsulation: Hiding implementation details behind the programming language. We don't care about how the code is written, we just care about how it works, it should work when we call the method and may give it our data.

Google: Encapsulation is an Object Oriented Programming concept that binds together the data and functions that manipulate the data, and that keeps both safe from outside interference and misuse. Data encapsulation led to the important OOP concept of data hiding.

If we want to create a class called XYPoint:

- We have a constructor that takes two input parameters
- Two getter methods to retrieve from the object

```
XYPoint(int x, int y){
  int xPoint();
  int yPoint();
}
```
To call the object in java we would:

```
XYPoint xyp = new XYPoint(0 , 0);
```

Java would also initialize values if you dont specify, for e.g.:

```
XYPoint xpy2 = new XYPoint();
print xyp2.x
```
This will print 0 as the value is initialized unlike C.

In Java you dont have to de-allocate memory like C as it has a garbage collector.

---
*In C we would do the same as*

```
struct{
  int x;
  int y;
} * XYPoint;
```
In C we would have to use `malloc` to allocate memory to create a new object.

---

In Java if we have an array:

```
int a[];
for (int i =0; i < 10; i++){
  a[i] = 0;
}
```
This will throw a `RunTimeException` error as the array size is not declared. Should declare the array as `arrayRefVar = new dataType[arraySize];.`

---
*Power of Encapsulation*

API for `public class Date`:

```
public class Date{
Date(int mo, int day, int year)
int month(); // getter method
int day(); // getter method
int year(); // getter method
String toString(); // Overwrite default toString() method
                  //and provide custom implementation
}
```

Example implementation of the API:

```
public class Date{
  private final int month;
  private final int year;
  private final int day;

  public Date(int m, int d, int y){
    month = m;
    day = d;
    year = y;
  }

  int month(){
    return month;
  }

  int day(){
    return day;
  }

  int year(){
    return year;
  }

  String toString(){
    return month() + "\" + day() + "\" + year() + "\";
  }
}
```

If you have another class, you cannot access these `private` variables. `Final` is when we set it and never change it.

If we want to use just one integer to represent the date we have to create an encoding:

```
public class Date{
  private final int _date;

  /*
  We dont need 32 bits to represent number 0-31 for date
  Therefore we are shifting the year and month to fit all the date
  variables in just one _date variable
  */
  public Date(int m, int d, int y){
    _date = y * 512 + m * 32 + d;
  }

  int month(){
    return (_date/32)%16;
  }

  int day(){
    return _date%32;
  }

  int year(){
    return _date/512;
  }

  String toString(){
    return month() + "\" + day() + "\" + year() + "\";
  }
}
```

---
Mutable vs Immutable

Some data types are by nature mutable. For example string, if you alter a string a new string object is created. For example if you two strings:
`String a = "tiny"` and `String b = "cat"` and concat them using `a = a.concat(b)`. There are three string objects created here, at `a`, `b` and the last one when we concat it. Arrays are also mutable.

Mutable data types uses more memory as it forces to create a new object with every edit. We have to care about it and while writing code, if we dont want something from outside don't change our encapsulated value, we have to care about and make sure it doesn't happen. Advantage is that these data types are flexible and their values can easily be changed.

```
Public class Vector{

  private final double [] values;

  Public Vector(double [] myvals){
    value = myvals;
  }

}
```

As we said `final` it cannot be altered. Let's consider if we have the following code:

```
double [] ds = {3.0 ,4.0};
vector V  = new Vector(ds);
ds[0] = 0.0;
ds[1] = 0.0;
```
The vector may have the new values. So we intended to make our vector Immutable by saying `final`, but we just changed its values here to `0.0`. `final` says it will not change the value to where the array points, so it will point to the `ds` memory space. When we create our vector `V`, its values points to the same place as `ds` values.

To fix it, we create a new array inside the instance and copy it. Known as `defensive-copy` and therefore we will change our code to:

```
Public class Vector{

  private final double [] values;

  Public Vector(double [] myvals){
    value = new double [myvals.length()];
    for (int i = 0; i < myvals.length(); i++){
      value[i] = myvals[i];
    }
  }

}
```

As the size of your data grows the execution time grows linearly, as you will need a copy of the array (in our case).

---

**Implementation of inheritance**

Java provides two types of implementation inheritance:

- Sub classing
  -The notion of object inheritance. If you have parent object for e.g. `animal` and a sub-class `cat.` It inheritance all the properties of `animal` but it will also have its own properties.
  -In Java we use `extends` keyword to tell a class inherits from its superclass.

- Sub typing
  -Its an alternative to inheritance in Java. Instead of inherit the properties and methods of a parent class, it allows us to inherit a relationship.
  -One can take unrelated classes and define a relationship.
  -For example if we have `animals` and `spaceships`. And we want to say they both require fuel, we can define a method `consume` which will be an `interface` in Java.
  -We use the `implements` keyword to sub type from a different class.

```
  Public interface Eater(){
    consume();
  }
```

*Inheriting from a base class*

- class getClass(); - This will return an object of the class itself.
- boolean equals(object); - Recieves an object and checks equality
- String toString(); - Prints out JavaEncoded string for the name if the datatype provide is not string.
- int hashCode(); - returns an integer, used for hashing

---

#9/7/16:

Subclassing is casting from a parent class
All classes inherit from the object class
Subtyping sets up a relationship between 2 objects
Intefaces are used for objects to inheret those functions and they are automatically part of the interface since they have the matching functions

```
interface summable {
	double sum();
}
```
for example, `vector implements summable`

if we have an object called studentGrades, it can implement summable `studentGrades implements summable`

```
class1: IntegerVector
class2: DoubleVector
```

both of these classes will implement the interface summable

The four key methods that everyone inherits from objects:
- getClass();
- toString();
- equals();
- hashCode();

*Equals asks if they point to the same object, if they have the same value but are not the same object then they will not match*

`hashCode();` will return an integer representation of that object AKA a fingerprint

```
Date d1 = new Date(2,4,1900);
Date d2 = new Date(4,11,2013);
Date d3 = new Date(2,4,1900);
	if(d1==d2){// this will be false
		 print("EQUAL");
	 }
	if(d1==d3){// this will be false
		print("EQUAL");
	}
	if(d1.equals(d3)){// this will be false
		print("EQUALS");
	}
	d3 = d1;
	if(d1.equals(d3)){// this will be true
		print("EQUALS");
	}
```

The equals method by default is the same as the double =='s.
The double equals with check if they are equal by reference AKA if they are pointing to the same memory location

But what if we want to check equality by reference?

`Override` is used to designate that you are taking the default implementation, instead of executing that run this code instead.

- if you pass `x.equals(x)` then itt must be true for all cases
- if `x.equals(y)` then `y.equals(x)` must be true
- if `x.equals(y)` and `x.equals(z)` then `z.equals(y)`

---

If you override equals incorrectly bad shit will happen. We need to define what will happen if the user passes null to the overridden function.
1. Null constraint, says that it should return false if null is passed
2. The overridden function must be consistent

An example below shows how to override a method

```
@Override
public boolean equals(Object obj) {
	if (this == obj) return true;
	if (obj == null) return false;
	if (obj instanceof Cat) {
		Cat that = (Cat)obj;
		return (this._meows == that._meows && super.equals(that));
	}
	return false;
}
```
instead of using the `instanceof` method which breaks our code we can use the `getClass()` method to fix this

```
	if (this.getClass().equals(obj.getClass())){
		return false;
	}
```

---

Listed below in an example from class

```
Cat cat = new Cat("tinycat");
Animal animal = new Animal("tinycat");
system.out.println(cat.equals(animal)); // should print false but prints true because cat is of type Animal
system.out.println(animal.equals(cat)); // should print false but prints false
```

Below is a class of IntegerSet which is an immutable type which is necessary since it will implement binary search.

```
public class IntegerSet
IntegerSet(int [])
int size()
boolean contains(int k)
```

##Binary Search:
Binary search checks if it is in the middle of the data set and if it is, it will return that position. If the position is greater than the key it will throw away the other half of the search and it will take the middle of that new set and repeat that process until it finds the middle of that array

---

##Generics

generics let us implement a method for any type of data

The issue with the code below is that you are stuck with ints which limit the amount of information you can store.

```
public class Vector
public vector(int []);
int valueAt(int);
int size();
```

Listed below is the same class but as a generic which lets us pass any type of data in.

```
public class Vector<E>
public vector(E []);
E valueAt(int);
int size();
```

Listed below is an exmaple of using the generic class above

```
Date [] dates
Vector <Integer>
Vector <Date> vec = new Vector<Date>(Dates);
ivec = new Vector <integer>

```

#9/12/16

```
a[]
b[]
int[]t = a;
a = b;
b = t;
```

This swaps the code in an efficient way. It could instead try to swap the arrays element by element but that would be a lot less efficient. This is a linear time operation.

---

```
Vector[] victor = new Vector[2];
Stdout.println(Victor[0].sum() + " " + victor[1].sum());
```

This will print out a null pointer exception since the object vector hasnt been created IE it has nothing to add.

```
Vector<E>
KeyValueSet<K,V,E>;
```
This says that the values K,V,E must be objects. At best they will be objects, When it is compiled it must be a type object but when it is ran you can pass whatever you want to it.

---

```
Public Vector<E>
	Vector(E[]);
	int size();
	E valueAt(int);
```
##Class Variables:
- private final E [] \_data;

##Constants:
```
Public (E[] a){
	_data = (E[]) new Object[a.length];
	for(i = 0; i < a.length; i++){
		_data[i]=a[i];
		\_data[i]=a[i];
	}
}
```

##methods:
```
public int size(){
	return \_data.length
}
```
```
Public E valueAt(int i){
	\_rangeCheck(i);
	return \_data[i];
}
```

```
Private void \_range_check(int i){
	if(i<0 || i >= size())
		throw new IndexOutOfBoundException("foo");
}
```

---

`Iterable <E>` provides one method, which returns another interface which is the `interator<E>` which has a method in it called `iterator();`.
The iterator interface has 3 key methods:
	- boolean hasNext();
	- E next();
	- void remove(); *Will remove the last element*

---

##InnerClass

*In Java, just like methods, variables of a class too can have another class as its member. Writing a class within another is allowed in Java. The class written within is called the nested class, and the class that holds the inner class is called the outer class.*


`private class Vector Iterator implements Iterator<E>` is an example of a of extending an interface

---

a bag is a data type in Java where you put data in and you can't take any out. It also has no iteration format.

```
Public class Bag<E> implements Iterable<E>
Bag();
void Add(E);
int size();
Iterator<E> iterator();
```
Above is an example of a bag. If you loop through the data you will go through a random path everytime.

```
Public class queue<E> implements Iterable<E>{
	Queue();
	enqueue();
	E dequeue();
	boolean isEmpty();
	int size();
}
```
This is an example of a Generic queue

```
Public class Stack<E> implements Iterable<E>{
	public Stack();
	void push();
	E pop();
	boolean isEmpty();
	int size();
}
```

#9/14/16

Algorithm's to solve equations like this: (1+(2-3))

##Dijkstra's two stack algorithm
Parses tokens. Tokens are the pieces of information that are useful to you
	1. Create two stacks
	2. Read from left to right
	3. As we read, if we find an operand we will push it onto the operand stack
	4. if we read an operator we will push it onto the operator stack
	5. Ignore left parenthesis
	6. reading right parenthesis
	7. pop na operator and however many number of operands it requires
	8. perform an operation
	9. push the result onto the operand stack

*pseudo-code*
```
Operators <-- new stacks
Operands <-- new stack
.
.
.
next_item <-- read_item()
if next item is operand then:
	stack_push(operands, next_item)
```

---

*Example*
(1 + ((2 + 3)) * (4 * 5))
	1. 2 + 3 = 5
	2. 4 * 5 = 20
	3. 20 * 5 = 100
	4. 100 + 1 = 101

---

##Linked List:

```
Private class Node{
	E data;
	Node next;
}
```

---

```
import java.util.Iterator;

public class Stack<E> implements Iterable<E> {

  private Node first;   // top of the stack
  private int N;    	// # of items

  private class Node {
	E item;
	Node next;
  }

  public boolean isEmpty() { return first == null; }
  public int size() { return N; }

  public void push(E item) {

	Node oldfirst = first;
	first = new Node();
	first.item = item;
	first.next = oldfirst;
	N++;
  }

  public E pop() {
	E item = first.item;
	first = first.next;
	N--;
	return item;
  }

  public Iterator<E> iterator() { return new ListIterator(); }

  private class ListIterator implements Iterator<E> {
	private Node current = first;

    public boolean hasNext() { return current != null; }

    public E next() {
	  E item = current.item;
	  current = current.next;
	  return item;
    }

    public void remove() { /* do nothing */ }

  }
}

```

Suppose we want to implement a new constructor that takes a stack as an arg `Public Stack(Stack<E> s)`
We add a constructor to the Node object

```
public Node (Node e){
	item = e.item;
	next = new node(e.next);
	}
```

##Order of growth classification

	1. Constant ('c', '1') - Program where running time is independent of the size of operators we are running it on. Example `a + b` -> constant time
	2. Logarithmic - Running time is based on the size of input is expressed by `y = c * log(N)`, where `N` represents the input size. The log is base 2 (x^A = B --> Logx(B) = A). `Binary Search` in the IntegerSet homework is in O(log(N)) time.
	3. Linear - Order of growth is directly proportional to the input size. y = c * N. Classic single For Loop. Examples of this are copying an array by element, finding the max in an array or printing each character in a string
	4. Linearithmic - `y = c * N * log(N)` worse than linear but not as bad as quadratic.
	5. Quadratic - `y = c * N^2`, an example of this would be checking for all pairs
	6. Cubic - `y = c * N^3`, do your best to stay away from this. You do not want to deal with this unless your input is very small
	7. Exponential - `y = c * N^N` an example of this would be exhaustive search. Check all subsets.

---

Def: Let f(n) and g(n) be functions defined on a set of natural numbers. A function is O(g(n)) if Ǝ 2 positive constants c and n0 so that f(n) <= c * g(n). *g(n) is the growth function*.

Prove: `T(n) = 5n + 20` is linear O(n) by getting to f(n) <= c * g(n)
	1. let n0 = 1
	2. T(n)/O(n) = (5n + 20)/n <= c for all n > 1
	3. observe `1 < n < n^2`
	4. (5n + 20n) / n <= c
	5. let c = 25
	6. 5n + 20 <= 25n which is f(n) <= c * g(n)
	7. 20 <= 20n and n > 1 therefore this is O(n)


#9/19/16

Suppose we have a function T(N) that is O(N). Is my function also O(N^2)? Technically yes it is since there is a possibility that it could O(N^2) at some point.

Suppose we have a `T(N) = 8n^2 + 10n + 25`
##*Proof*
**We have 2 functions, g(n) and f(n) over natural numbers. We say f(n) is O(g(n)) if there exists 2 positive constants c and n0 such that f(n) is less than or equal to c * g(n) for all n greater than n0.**

	1. Let n0 = 1
	2. We intend to show that T(n)/G(n) <= c for all n > 1
	3. (8n^2+10n+25)/(n^2) <= c
	4. Observe 1 < n < n^2 ...
	5. we can then say that (8n^2 + 10n^2 + 25n^2)/(n^2) is going to meet T(n)/G(n) <= (8n^2 + 10n^2 + 25n^2)/(n^2) = 43
	6. let c = 43 and n0 = 1
	7. 8n^2 + 10n + 25 <= 43n^2
	8. 10n + 25 < = 35n^2
	9. We can observe again that 1 < n < n^2 so that we now know that 10n + 25 will always be less than 35n^2.

---

Unfortunately we might not know the T(n) for our given function. Then we would have to derive what the T(n) is by running the function itself.
A way to do this could be to define a list of N's and double the value of N every time and compare the runtime for each set of N's.

##*Use stopwatch.java to measure your functions*

Cost Frequency models will be important in this class for classifying runtime information. Another way to do it is to block your code into pieces by the frequency that they are used and figure out the runtime for each part and add it up.

Cost Frequency:
```
	1. Cost of the operation (time)
	2. Frequency (How often does it happen)
```

`summation of Cost(q)*Frequency(q)` q is the block of code that you are analyzing.

Lets build a Cost Frequency model for an example!

```
boolean isValid(String str){
	if(str.length < 2 || str.length % 2 != 0){ // this first block is only executed once
		return false; // this is executed once
	}
	int mid = str.length/2; // this is executed once
	for(int 1 = 0; i < mid; i++){ // the init is executed once but the rest is executed mutliple times
		if(str.charAt(i)!= 'a'|| str.CharAt(mid+i)!= 'b'){
			return false;
		}
	}
	return true;
}
```
We are splitting the code by the frequency, so the first section is stuff that is only happening once and the other block is the stuff that will happen multiple times. We will refer to the stuff that runs only once as A so A will only be executed once. We will refer to the stuff that runs multiple times as B and the frequency of how many times B will run is dependent on the length of the string. B executes `n/2` times and A executes 1 time. Now we can build our cost frequency model. `T(n) = t0 + (t1*N/2)` is the runtime function for this example.

```
last_coin_standing(x,y)
Input: x number of quarters
 			 y position to eliminate

Output: last remaining quarters

quarters --> new array[x] // happens one time
for i <-- 1 to x do : // happens one time
	quarters[i] <-- i // happens N number of times
length <-- x // happens one time
pos <-- 0 // happens one time
while length > i do: // excutues n-1 times
	to_remove <-- pos + y - 1 // executes n-1 times
	to_remove <-- to_remove % length // executes n-1 times
copy_pos <-- 0 // executes n-1 times
new_array <-- new array[length - 1] // executes n-1 times
for i <-- 1 to length do: // occurs D number of times
	if j - 1 != to_remove then: // happens E number of times
		new_array[copy_pos] <-- quarters[j - 1] // happens E number of times
		copy_pos <-- copy_pos+1 // occurs D number of times
	quarters <-- new_array
	length <-- length-1
	pos <-- to_remove % length
return quarters[0] // happens one time
```
A: 1 (t0)
B: N (t1)
C: N-1 (t2)
D: (N(N + 1)/2) - 1 (t3)
E: (N(N - 1)/2) (t4)

`T(N) = t0 -t2 - t3 + N(t1 + t2 + (t3/2) - (t4/2)) + N^2((t4/2) + (t3/2))`
Our tilde approximation is: `~T(N) = N^2((t4 + t3)/2)`
We say some function f(n) has some tilde `~g(n)` if `lim as N approaches infinity of f(n)/g(n) = 1`

---

#9/20/16

Problems with HW 2:
	1. If you mess with the signature of the equals you will not override the equals method

Polymorphism is the idea that you can overload methods.
beware of the `Instanceof` method. It can violate symmetry.

---

Lets do a frequency cost analysis of Homework #2:
```
Input: Keys - array of keys
Output: New awway with dupes removed

temp_array <-- new array[length]// only done once
for i <-- 1 to length do:
	temp_array[i] <-- key[i-1];// happens N number of times
sort(temp_array);// only done once BUT the java doc says that the worst case is O(N*log(N))
pos <-- 1// only done once
for i <-- pos to length do:
	if key[i] != key[i-1] do:// happens N number of times - 1
		temp[pos] <-- key[i]// input dependent
		pos <-- pos +	1// input dependent
	a <-- new array[pos]// only done once
	for i <-- 1 to pos do:// only happens once
		a[i] <-- temp[i]
```
A: 1
B: N
C: N-1
D: X
E: Y
F: N*log(N) *Constant time*
T(N) = t0 + t1N + t2(N-1) + t3X + t4Y is the time function for this specific algorithm. By looking at this we can say that this is O(N).

---

##Proof of induction
Time to learn proof of induction! O_O
	1. The first step to this process is to establish a base case.
	2. create a inductive hypothesis
		a. prove it for k instances
		b. k --> k + 1

*Example with fibonacci numbers*
```
F0 = 1, F1 = 1, F2 = 2, F3 = 3, F4 = 5 . . . . Fi = Fi-1 + Fi-2
i >= 1
Claim: For all i >= 1 Fib number Fi < (5/3)^i
Base case:
	i = 1
	F1 = (5/3)^1

	1 < (5/3) (This is true)
	F2 = 2 < (5/3)^2
	F2 = 2 < (25/9) (This is true)

Inductive Hypothesis:
	Assume Fi < (5/3)^i is true for all i <= k

We need to show that:
	F(k+1) < (5/3)^(k+1)

F(k+1) = F(k) + F(k-1)

Induction Step:
	F(k+1) < (5/3)^k + (5/3)^(k-1)
	F(k+1) < (3/5)(5/3)^k+1 + (9/25)*(5/3)^(k+1)
	F(k+1) < (3/5 + 9/25)(5/3)^(k+1)
	F(k+1) < (24/25)(5/3)^(k+1)
	F(k+1) < (5/3)^(k+1) --> we can do this because (24/25) is almost 1 and has a small change to the main value
```
This is an example of a problem you might do in a generic math class. Below is an example of a problem we will see in this class
```
If N >= 1, then the sum from i=1 to N, i^2 = (N(N+1)(2N+1))/6
base case:
	let N = 1
	(1)^2 = 1 = ((1)((1)+1)(2(1)+1))/6 = 6/6 = 1

Assume the claim is true for 1 <= N <= k

Our induction hypothesis is:
	sum of i=0 to N+1 of i^2 = the sum from i=1 to N of i^2 + (N+1)^2
```

---

##Proof of contradiction
	1. Assume the opposite is true
	2. Show some known property is false under this assumption

```
Claim: There are an infinite number of prime numbers
We assume that this claim is false E Pk where Pk is the largest prime
```
#9/26/16

## Dynamic Connectivity

**Problem Specification**

1. Input is a sequence of integer pairs where the integer represents some object (p, q)
2. We interpret a pair (p, q) as meaning p is connected to q
3. Connected?
  - Reflective: (p, q)
  - Symmetric: (p, q) (q, p)
  - Transitive: (p, q) (q, r) (p, r)
4. Develop an algo that will filters pairs in the same equivalence class

**Example: **

On notepad

**Union Find**
It will be an abstract data type:
1. Initialization
2. Add connections between objects
3. Identify components/connections between objects (what equivalence class am I?)
4. Given x equivalence class, are you a member? (p, q belongs to X?)
5. Size

```
public class Abstract UnionFind
UnionFind (int N) //number of distinct object, size of our set

void union(int p, int q) //create a connection between p and q

int find(int p) //identify the component, how is it connected. which component/class

boolean connected(int p, int q) // returns true if they are connected

int size() // number of distinct components, in our example 2 (2 diff distinct connection going out)
```

Quick Find: Make find as quick as possible at any expense
 - User an array to maintain the connection information
 - id [p] == id [q] if p, q belongs to X

```
find (p)
Input: p integer representing object p
Output: integer component number of p

QuickFind:
  return id_array[p]; //constant time
```

Union has to traverse the array and transfer any id that is in same component as p

```
union (p, q, s) //performs linear time
Input: integer p and q representing objects p and q, s is the size
Ouput/Effect: p and q are connected (id_array[p] == id_array[q])

p_id <- find(p)
q_id <- find(q)

if p_id == q_id then:
  return s

N <- length of id_array
for i <- 0 to N -1 :
  if (id_array[i] == p_id) do:
    id_array[i] <- q_id

s <- s -1
return s
```

**Example**

`starting array`
0      1       2       3       4       5       6       7       8       9
---
`input(4, 3)`
0      1       2       3       3       5       6       7       8       9
---
`input(3, 8)`
0      1       2       8       8       5       6       7       8       9
---
`input(6, 5)`
0      1       2       8       8       5       5       7       8       9


For QuickFind we have `N+3` or `2N + 1` time penalty for union --> linear in both cases

**QuickUnion**

```
find (p)
Input: p integer representing object p
Output: integer component number of p

while(p != id_array[p]) do:
  p <- id_array[p]

return p
```

#9/28/16

- ID array of all unique objects
- Quick find
- Union operation is the drawback that limited us from calling this linear time
- Lets make union fast at the expense of the find.
Below is an implementation of find
```
find(p, id)

input: object #
output: root/component # for object P (int)

while id[p] != p do:
	p <-- id[p]
return p

```
Below is an example of the Union method
```
Union(p,q,id)
Input: p/q: objects p and q to connect (integer)
Output: // updates linkage structure

P_root <-- find(p)
q_root <-- find(q)
if P_root = q_root then:
	return
id[p_root] <-- q_root
count <-- count-1
```
**Time Analysis**

Find: 1 + depth of tree (think of it as a binary tree)
Union: The absolute best case is O(5)

---
**Algorithms**
Most of the algorithms that we are going to be looking at this semester will be compare based algorithms. In order to produce a sorted result we will implement a comparison operation and act upon that.
Sorting algorithms are based on the idea of a key, java uses the comparable interface on the key to put everything in an order by an ordering rule.

```
Comparable<T>
int compareTo(T t);
```
We use compareTo to compare our data types based on their natural order

1.	0 = v.compareTo(w) when v == w
		-1 = v.compareTo(w) when v < w
		1 = v.compareTo(w) when v > w

2. 	v, w must be compatible with each other. You will get an exception if they are incomparable or either value is null.

3.	Must be reflexive, transitive and symmetric

```
Public class Date implements comparable<Date>
	private int month;
	private int day;
	private int year;

	Public Date(m,d,y){
		month = m;
		day = d;
		year = y;
	}

int compareTo(Date obj){
	if(this.year > object.year){
		return 1;
	}
	if(this.year < object.year){
		return -1;
	}
	if(this.day > object.day){
		return 1;
	}
	if(this.day < object.day){
		return -1;
	}
	if(this.month > object.month){
		return 1;
	}
	if(this.month < object.month){
		return -1;
	}
	return 0;
}
```
```
Public class student implements comparable<student>{
	student (string fn, string ln);

	int compareTo(Student S){
		int val = this.ln.compareTo(s.ln);
		return val;
	}
}
```

#10/3/16

`Enum Rank {two, Three .....}`

Knuth's algorithm randomizes elements in an array.

midterm on October 19th:
	- 1/4 true or false
	- 1/3 will me mechanics regarding algorithms (ie how does it work)
	- remainder will be similar to the creative thinking problems on the homework.

Key - something that is comparable, could be irrelevant
Stability of an algorithm - A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input array to be sorted. Some sorting algorithms are stable by nature like Insertion sort, Merge Sort, Bubble Sort, etc. And some sorting algorithms are not, like Heap Sort, Quick Sort, etc.
##Sorting algorithms

*Selection Sort*
The basic idea is that you iterate through the unsorted array and swapping the current position with the smallest integer emelment
Below is the pseudo-code for swap
##Swap
```
Swap(a, i, j)
	input:
	a: array of items
	i, j --> positions to swap
	output: array with i, j swapped
	tmp <-- a[i]
	a[i] <-- a[j]
	a[j] <-- temp

```
Our boundary for Swap is O(N) for worst and best case
Below is the pseudo code for selection sort.
```
SelectionSort(a, n){
	a: array of items to sort
	n: length of array
	Output: natural order of items (keys)

	for i <-- 0 to N-1 do: //sorted partition of the array
		min <-- i
		for j <-- i+1 to N-1 do: // unsorted partition of the array
			if a[j] < a[min] then:
				min <-- j
			swap(a, i, min)
}
```
Best case and worst case for selection sort is O(N^2)

##Insertion sort
If you have a stream of data coming in you can sort it with Insertion sort

```
InsertionSort(a, n)
	Input:
	a - array of items
	n - number of items

	Output: Sorted array

	for i <-- 0 to N-1 do:
		j <-- i
		while j > 0 && a[j] < a[j-1] do:
			Swap(a, j, j-1)
			j <-- j-1

```
Best case this is linear O(N) since if it is already sorted the while loop with finish in N time. Worst case this is O(N^2)

#10/5/16

Suppose we want to improve upon Insertion sort where we want the increment to go back h amount of steps rather than one at a time:
By this we get,
##Shell sort (h-sorting)

We introduce the notion of a gap sequence with shell sort
h = {4,2,1}
for the example above, it will h-sort by 4 then 2 then 1.
shell sort has a tilde time of, `~O(n*log(n))`
CS people like it because it offers a lot of research material on how to optimize which gap sequencing scheme to pick.
You can almost get this to compete with quick sort with some of the published optimizations. The worst case also gets improved with these optimizations by reducing the exponent from a whole number such as 2 to 1.5.

```
0		1		2		3		4		5		6
T		I		N		Y		C		A		T	(h=4)
C		I		N		Y		T		A		T	(h=4)
C		A		N		Y		T		I		T	(h=4)
C		A		N		Y		T		I		T	(h=2)
C		A		N		I		T		Y		T (h=2)
A		C		N		I		T		Y		T	(h=1)
A		C		N		I		T		Y		T	(h=1)
A		C		I		N		T		Y		T	(h=1)
A		C		I		N		T		T		Y	(h=1)
```

There is a tradeoff with algorithms of memory and time. In order to improve in order of time we might have to take a hit in space. All the sorts we have gone over so far can all be done in the space that it is defined in. There is no need to duplicate or extend the arrays. Merge sort and quick sort are examples of sorting algorithms that require either recursion which takes up memory, or creating a copy of the array which takes up extra space.

---

If you have an int[] of size N you will lose 4N bytes of memory space because the size of all primitives in Java is 4 bytes

Harmonic Sum = 1 + 1/2 + 1/3 + 1/4 + 1/5 + ....... + 1/N ~O(log(n))
Triangular Sum = 1 + 2 + 3 + ...... + N ~O((N^2)/2)
Geometric Sum = 1 + 2 + 4 + 8 + ....... + N = ~O(2N-1)
N choose K  = ~O((N^K)/K!)
Exponential approximation = (1-1/x)^x = ~O(1/e)

##Merge Operation and Merge Sort
Merge: takes 2 ordered arrays --> combines into 1 ordered array
```
Input = a = [2, 4, 6, 8]
				b = [1, 3, 5, 7]
Output = c = [1, 2, 3, 4, 5, 6, 7, 8]
```
Pseudo code of merge sort
```
abstract_Merge(a[], low, mid, high)
	input: array of keys, with 2 ordered partitions defined by low, mid, high
			 	 low: beginning of first partition
				 mid: end of first partition
				 high: end of the second partition

	i <-- low
	j <-- mid+1
	for k <-- low to high do:
		aux[k] <-- a[k]
	for k <-- low to high do:
		if i > mid then
			a[k] <-- aux[j]
			j <-- j+1
		else if i < mid then
			a[k] <-- aux[i]
			i <-- i+1
		else if aux[j] < aux[i] then
			a[k] <-- aux[j]
			j <-- j+1
		else do:
			a[k] <-- aux[i]
			i <-- i+1
```

Example of Merge sort:

```
a[] = [a,d,f,g,w,a,b,e,f,m]
merge(a,0,4,9)
		K		I		J		a,d,f,g,w | ,a,b,e,f,m
		0		1		5		a,d,f,g,w | ,a,b,e,f,m
		1		1		6		a,a,f,g,w | ,a,b,e,f,m
		2		1		7		a,a,b,g,w | ,a,b,e,f,m
		3		2		7		a,a,b,d,w | ,a,b,e,f,m
		4		2		8		a,a,b,d,e | ,a,b,e,f,m
				
