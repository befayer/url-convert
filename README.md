This app helps you get a short link if you send him a long one.

# **Get started:** 

## To get a short link:
1. You need to send a POST request, for example, using Postman. As an example , let 's take "http://localhost:8080/api/url/get-convert-url/netology.ru"
2. Done. You will get a short link on the screen, and the long one will already be in the database, which you can get by sending a GET request.

For this:
1. Send a GET request via Postman:
"http://localhost:8080/api/url/get-long-url/-1454289302"
2. You will get a link if it is in the database.

# **Testing:**

There are 2 classes for testing, just run them:

"TestMVC.java" for testing the MVC layer

"TestService.java" to test the operation of the application logic
