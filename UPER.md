<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
Write clean java code in order to make a store/product application that calculates taxes.
<h2>
    2. Planning the Solution
</h2>

I looked at the documentation and planned to write tests for each piece. 
<h2>
    3. Executing the Plan
</h2>
I started with the simplest test.(Null check) and let intellij type most of my code for me.
TDD is actually pretty awesome considering you can think about what you want the method to be called and what you want 
to pass it in the Test, then when it flags it red you can alt + enter and create the method or field automagically. 
I implemented the singleton pattern in this under the store class. 
<h2>
    4. Reflection / Refactor
</h2>
Originally I started out with store containing a list of Products and manually making a product set in the store test. 
I also committed after every failing test and every passing test so you could see the logic and refactor steps. 
I took the store once it got big and did a huge refactor and moved products to an enumish type setup and then I made a cart class to hold multiple products. 

I took the product enum type and added ID's to everything in order to make it easy to further extend the app. 
What I am thinking I could do is provide a console input command set and display a list of products to purchase via their ID.
Then by entering the ID number it could add to the cart. 

I actually like TDD a lot now. 