-- Find customers who have made purchase every month for last six months

SELECT customer_id
FROM purchases
WHERE purchase_date >= DATE_SUB(DATE_FORMAT(CURDATE(), '%Y-%m-01'), INTERVAL 5 MONTH)
GROUP BY customer_id
HAVING COUNT(DISTINCT DATE_FORMAT(purchase_date, '%Y-%m')) = 6;