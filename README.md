> # Beymen Website Automation Scenarios

## Steps

1) Navigate to www.beymen.com
2) Check that the main page is opened. 
3) Enter the word from Excel files 1. row 1. cell that named as “şort” into the search box 
4) Delete this word from search box
5) Enter the word from Excel files 2. row 1. cell that named as “gömlek” into the search box 
6) Press the "enter" key from the keyboard 
7) Select a random product from the exhibited products according to the result
8) Write product description and price into the txt file 
9) Add the selected product to the cart 
10) Compare the accuracy of the price on the product page and the price of the product in the basket 
11) Increase products number to 2
12) Verify that the number of products is 2 
13) Delete product from the basket 
14) Verify that the basket is empty

## For Running Tests
1) `mvn clean install`

2) `mvn test`