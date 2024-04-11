Purpose:	The purpose of this Lab assignment is to:
•	Practice Multithreaded application development.
•	Develop a Multithreaded GUI Java application using Collection API. 

Exercise 1:

This exercise is similar to PrintTask example from Week 12.
Write a Java application that handles multiple ATM transactions (withdraw, deposit) at the same time. Create an Account class and implement both deposit and withdraw operations. Synchronize the operations to allow thread synchronization. Use Java Runnable interface to implement a Transaction class. Perform withdraw and deposit operations in run method. 

Create an AccountTest class to test multiple transactions (threads). Use an ArrayList to create a list of three or more Transaction objects. Use method execute of ExecutorService to execute the threads. Display the results.




Screenshot:

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/c69f872d-5807-4c36-baf6-546bff775aab)

 

Deposit

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/2e7d37cd-2d86-4d90-91fa-9b8ca3fe9104)

 

Withdraw

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/7d1141df-7ba4-414a-a10b-ec25ad58f4bf)

 

Perform both at the same time using Transact Both button

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/30f1b2f8-7bf3-44fb-88ab-cd6c8d660bc6)

  

Other functionalities:
Display Balance

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/7676c0d7-87b4-40ce-bccc-c0949b85076f)

 

Error message when trying to withdraw but withdraw field has no value

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/f3d53fc8-9af1-4997-a85a-53cc4e15a0d0)


 
Error message when trying to deposit but deposit field has no value

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/2900d17d-6a0a-43e9-88b7-061ea8559bb5)

 

Error message when trying to transact both but any field has no value

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/7744c2b8-ed85-4807-acf7-1fe81b84243f)

 
Error displayed when fields are populated by non-integers

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/272b705a-7a0d-4121-94d4-cb423c264d13)

 

Error displayed when insufficient funds upon trying to withdraw

![image](https://github.com/dyeyniyel/comp228-lab6-Multithreading/assets/158533198/41583834-8c72-4c06-9d0e-aeb4134898a0)

 

