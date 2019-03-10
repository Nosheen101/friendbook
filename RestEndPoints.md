Friend Book Application 

How to use:
      This is a spring boot web application . You just run this application(run class FriendBookApplication.java) and verify if its up or not by using the url :
       http://localhost:9098/friendbook/

Following are the API with payload :

1- Create User or SignUp
   
   curl -X POST \
  http://localhost:9098/friendbook/signup \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 18c69126-6dda-434e-ad46-6dbcc637b2d0' \
  -H 'cache-control: no-cache' \
  -d '{
	"user_name": "nosheen",
	"first_name" : "nosheen",
	"last_name":"Sharif",
	"email_address":"ddd@yahoo.com",
	"password" : "abc",
	"confirm_password":"abc"
 }' 
 
 2- Login User
    curl -X POST \
  http://localhost:9098/friendbook/login \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 8fc5dc7e-2857-40f7-84f9-fe96f0ac6a5c' \
  -H 'cache-control: no-cache' \
  -d '{
	"user_name": "nosheen",
	"password" : "abc"
 }'
 
 3- Add Friends
 		URL:	 http://localhost:9098/friendbook/{userId}/addfriends 
 		Request Body :[2,3] //ids for the users you want to add as friend
 	curl -X POST \
  http://localhost:9098/friendbook/1/addfriends \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 53028433-52c4-4d20-a9bd-4390ca0d60b1' \
  -H 'cache-control: no-cache' \
  -d '[2,3]'
  
  4- Remove Friends
       URL:	 http://localhost:9098/friendbook/{userId}/removefriends 
 		Request Body :[2,3] //ids for the users you want to remove from friend list
 		
 	curl -X POST \
  http://localhost:9098/friendbook/1/removefriends \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: ff83f3f4-8dc8-4942-9e9f-b3a80fa18206' \
  -H 'cache-control: no-cache' \
  -d '[2]'	
  
  5- Get All User List:
  
  curl -X GET \
  http://localhost:9098/friendbook/ \
  -H 'Postman-Token: 01b378e7-e5eb-4f7a-b8dd-46d1a03f495f' \
  -H 'cache-control: no-cache'
  
  6- Get User By Id:
  	URL: http://localhost:9098/friendbook/{userid}
  
    curl -X GET \
  http://localhost:9098/friendbook/1 \
  -H 'Postman-Token: 0bae7819-f3d3-414c-a9dc-b94599548507' \
  -H 'cache-control: no-cache'
  
  7- Search By Name (search in firstName,lastName,userName)
     URL: http://localhost:9098/friendbook/search/{name}
  
  curl -X GET \
  http://localhost:9098/friendbook/search/nosheen \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: c25c82d2-74a5-4671-ac31-998f44e78891' \
  -H 'cache-control: no-cache' \
  -d '[2,3]'