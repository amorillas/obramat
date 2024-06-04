# Obramat backend assessment by Álvaro Morillas

## Run the API

`./gradlew bootRun`

## Orders test curls
```
curl -i http://localhost:8080/orders -H "Content-Type:application/json" -d '{"creationDate": "2024-06-02T02:20:37+00:00", "productsCount": 0, "price": 12.34, "priceWithIVA": 14.93, "status": "PENDING"}'
curl -i -X PUT http://localhost:8080/orders/1 -H "Content-Type:application/json" -d '{"creationDate": "2025-06-02T02:20:37+00:00", "productsCount": 0, "price": 14.34, "priceWithIVA": 17.35, "status": "PAID"}'
curl -i http://localhost:8080/orders
curl -i http://localhost:8080/orders/1
curl -i http://localhost:8080/orders/1/complete
curl -i http://localhost:8080/orders/search/findAllByCreationDateAndStatusAndPrice?creationDate=2024-06-02&status=PENDING&price=12.34
curl -i -X DELETE http://localhost:8080/orders/1
curl -i http://localhost:8080/orders/create-complete-H "Content-Type:application/json" -d '{"order": {"creationDate": "2024-06-02T02:20:37+00:00", "price": 12.34, "status": "PENDING"}, "products": [{"name": "Cemento", "description": "Saco de cemento Portland para construcción.", "price": 12.34}]}'
```

## Products test curls
```
curl -i http://localhost:8080/products
curl -i http://localhost:8080/products/search/findByNameContaining?name=Cemen
curl -i http://localhost:8080/products -d '{"order": "/1", "name": "Cemento", "description": "Saco de cemento Portland para construcción.", "price": 12.34}' -H "Content-Type:application/json"
curl -i -X PUT http://localhost:8080/products/1 -d '{"order": "/1", "name": "Cemento 2", "description": "Otra cosa.", "price": 15.55}' -H "Content-Type:application/json"
curl -i http://localhost:8080/products/1
curl -i -X DELETE http://localhost:8080/products/1
```

## Observations

This assessment only covers the backend part. It's interesting to check the knowledge we have about Spring Boot. To
be honest, I've never used it professionally, and I've been discovering different features in the time I've spent 
developing this service. I'm sure I would be able to adapt myself to it like I've done through my career with different
languages and frameworks. You can find that all the mandatory API endpoints have been implemented, but I haven't had 
enough time to implement automated tests, since I've been testing them manually with curl commands (the ones above).
The idea would be to implement acceptance tests for happy cases to each endpoint and for cases that would return 
validation errors or not existing entities. For the `OrderService` I would implement unit tests mocking the repositories
to be able to test them with different DB results, but not depending on the actual DB. I would use the features that 
Spring provides for this, that include JUnit and Mockito libraries, and a specific client for acceptance tests.

As a developer I'm more focused on backend. Although I can work maintaining and adding new features to existing Angular 
or React frontend applications, I've never had the opportunity to create frontend apps from scratch using those
frameworks. That's why I decided to focus on the backend part, given the limited time I've had for implementing this 
assessment. Please, take that into consideration.
