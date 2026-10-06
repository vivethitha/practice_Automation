Feature: To validate the wishlist,product page functionality,F Assured functionality,Add to cart functionality,saved for later functionality
Scenario: To navigate to a particular product and adding it to wishlist whether login is asked or not
Given hit the chrome browser
When navigate to home then cleaning & bath then air fresheners
And navigate to the second page of PLP by clciking the bottom of the page
And click wishlist icon of the sandal spray product
And validte login in adding in wishlist message and print in console and close the login popup and click that product and move to PDP
And in product page enter your pincode check the delivery date and print it in console
And click F Assured label and validate whether it is opening or not and click add to cart
And Assert and print whether the product is added to cart or not and increases the quantity of product to two and assert the confirmation message and print in console
And click save for later and validate whether it is moved to that section and check whether the cart is empty now
And now remove the product from save for later and validate the confirmation message

 