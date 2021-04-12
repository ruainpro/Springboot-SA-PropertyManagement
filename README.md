# Springboot-SA-PropertyManagement

It is an property Management SMall Project Madeon SPringboot-API With Sql.

# API Information

Login:

var settings = {
  "url": "http://localhost:8080/users/signin?username=user&password=user",
  "method": "POST",
  "timeout": 0,
  "headers": {
    "Content-Type": "application/json"
  },
  "data": JSON.stringify({"username":"bruce","password":"bruce"}),
};

$.ajax(settings).done(function (response) {
  console.log(response);
});

SIgnup:

var settings = {
  "url": "http://localhost:8080/users/signup",
  "method": "POST",
  "timeout": 0,
  "headers": {
    "Content-Type": "application/json"
  },
  "data": JSON.stringify({"username":"user","email":"user","password":"user","roles":["ROLE_USERS"]}),
};

$.ajax(settings).done(function (response) {
  console.log(response);
});

Get My Details

var settings = {
  "url": "http://localhost:8080/users/me",
  "method": "GET",
  "timeout": 0,
  "headers": {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSUyJ9XSwiaWF0IjoxNjE4MTM0MzkyLCJleHAiOjE2MTgxMzc5OTJ9.vMXazhqdUdiEJoOKcfyemWIN9mpXzEzFSuvDZvYaycY"
  },
};

$.ajax(settings).done(function (response) {
  console.log(response);
});


Get Property


var settings = {
  "url": "http://localhost:8080/property/getProperty",
  "method": "GET",
  "timeout": 0,
  "headers": {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSUyJ9XSwiaWF0IjoxNjE4MTkyMTMwLCJleHAiOjE2MTgxOTU3MzB9.Dkqk_W0YWz1id4S_XmFscdJG7KnV7pQMUi-wDq4q35o"
  },
};

$.ajax(settings).done(function (response) {
  console.log(response);
});


Post Property


var settings = {
  "url": "http://localhost:8080/property/addProperty",
  "method": "POST",
  "timeout": 0,
  "headers": {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSUyJ9XSwiaWF0IjoxNjE4MTQxNjE2LCJleHAiOjE2MTgxNDUyMTZ9.6S3kS9EAJYBdt3eEOw_FlKt1UltuYVq7o1-f7VUEw8E",
    "Content-Type": "application/json"
  },
  "data": JSON.stringify({"propertyTypes":"Rent","propertyName":" Full Furnished House For Sale in Bhaisepati, Bhaisepati Magar Gaun, Lalitpur ","propertyDescription":"Earthquake Resistant, Electricity, Water Supply, Telephone, Internet, Drainage, Solar Water, Cable TV, Parking, Well, Reserve Tank, Garden, Rental Income, Garbage Disposal","conddtionText":" Client Should Not have any Legal Issues or Criminal Records","totalCost":140000,"monthlyCost":120000,"extraAmount":20000}),
};

$.ajax(settings).done(function (response) {
  console.log(response);
});


Get Property By Id

var settings = {
  "url": "http://localhost:8080/property/getPropertyById?Id=2",
  "method": "GET",
  "timeout": 0,
  "headers": {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSUyJ9XSwiaWF0IjoxNjE4MTUzMzQxLCJleHAiOjE2MTgxNTY5NDF9.WMwf6ky8aq23YjRk8iagHZZogZgy4XuKcGfdzhWOOX4"
  },
};

$.ajax(settings).done(function (response) {
  console.log(response);
});


Search  Property

var settings = {
  "url": "http://localhost:8080/property/searchProperty?textSearch=11",
  "method": "GET",
  "timeout": 0,
  "headers": {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSUyJ9XSwiaWF0IjoxNjE4MTkyMTMwLCJleHAiOjE2MTgxOTU3MzB9.Dkqk_W0YWz1id4S_XmFscdJG7KnV7pQMUi-wDq4q35o"
  },
};

$.ajax(settings).done(function (response) {
  console.log(response);
});


Update Property

var settings = {
  "url": "http://localhost:8080/property/updatePropertyById?Id=2",
  "method": "PUT",
  "timeout": 0,
  "headers": {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSUyJ9XSwiaWF0IjoxNjE4MTk0MjgyLCJleHAiOjE2MTgxOTc4ODJ9.AbKaBpiq4f1EsbzMwh1xlql7e_J_0bZIY2VPK_SgiXM",
    "Content-Type": "application/json"
  },
  "data": JSON.stringify({"propertyTypes":"Rent","propertyName":"1111 Full Furnished House For Sale in Bhaisepati, Bhaisepati Magar Gaun, Lalitpur ","propertyDescription":"11Earthquake Resistant, Electricity, Water Supply, Telephone, Internet, Drainage, Solar Water, Cable TV, Parking, Well, Reserve Tank, Garden, Rental Income, Garbage Disposal","conddtionText":" 11111Client Should Not have any Legal Issues or Criminal Records","totalCost":111140000,"monthlyCost":1120000,"extraAmount":120000,"propertyStatus":false,"postedDate":"2021-04-11"}),
};

$.ajax(settings).done(function (response) {
  console.log(response);
});


Delete Property By Id


var settings = {
  "url": "http://localhost:8080/property/deletePropertyById?Id=3",
  "method": "DELETE",
  "timeout": 0,
  "headers": {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiYXV0aCI6W3siYXV0aG9yaXR5IjoiUk9MRV9VU0VSUyJ9XSwiaWF0IjoxNjE4MTk0MjgyLCJleHAiOjE2MTgxOTc4ODJ9.AbKaBpiq4f1EsbzMwh1xlql7e_J_0bZIY2VPK_SgiXM"
  },
};

$.ajax(settings).done(function (response) {
  console.log(response);
});
