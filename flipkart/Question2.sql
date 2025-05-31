 -- calculate the running total of sales for each daywithin the past month


SELECT
    DATE(purchase_date) AS sale_date,
    SUM(amount) AS daily_sales,
    SUM(SUM(amount)) OVER (ORDER BY DATE(purchase_date)) AS running_total
FROM purchases
WHERE purchase_date >= CURDATE() - INTERVAL 1 MONTH
GROUP BY DATE(purchase_date)
ORDER BY sale_date;
