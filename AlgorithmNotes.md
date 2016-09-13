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
This is ana example of a Generic queue

```
Public class Stack<E> implements Iterable<E>{
	public Stack();
	void push();
	E pop();
	boolean isEmpty();
	int size();
}
```
