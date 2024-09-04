# Simple Order Manager - Entity Relationship Diagram

This document outlines the database model for a Simple Order Manager System. The system consists of the following entities:

- **Clients**: Stores client information.
- **Address**: Stores multiple addresses associated with a client.
- **Products**: Stores product information including stock, description, and pricing.
- **Orders**: Stores information related to customer orders.
- **Order Items**: Stores individual products associated with specific orders.

## Database Tables



---
![Captura de tela 2024-09-04 205054](https://github.com/user-attachments/assets/e3fd3949-738d-4080-9e61-c2fd1594555f)

## SQL: List Orders with Number of Items

```sql
SELECT o.id AS order_id, COUNT(oi.id) AS total_items
FROM orders o
JOIN order_items oi ON o.id = oi.order_id
GROUP BY o.id;


---

## Indexes:

On the Orders table:
- `client_id` (to speed up queries filtering by `client_id`).

On the Order_Items table:
- `order_id` (to speed up queries filtering by `order_id`).
- `product_id` (to speed up queries filtering by `product_id`).

On the Products table:
- `price` (if you frequently filter or sort by `price`).

On the Clients table:
- `email` (since it’s unique and often used for lookups).
