1. Create New Order:

curl --location --request POST 'http://localhost:8081/order' \
--header 'Content-Type: application/json' \
--data-raw ' {
        
        "orderItems": [
        {
            "productCode": 111,
            "productName": "product 11",
            "quantity": 1

        },
        {
            "productCode": 123,
            "productName": "product 11",
            "quantity": 2
            
        }
        ],
        "orderDate" : "2020-07-10",
        "customerName": "cust111",
        "shippingAddress": "shippingAddress 111",
        "totalPrice": 100
}
2. Retreive All Orders
curl --location --request GET 'http://localhost:8081/order' \
--header 'Content-Type: application/json' \
--data-raw ''

3. Retreive Order by Id

curl --location --request GET 'http://localhost:8081/order/1' \
--header 'Content-Type: application/json' \
--data-raw ''

