SELECT ename, COUNT(*) AS name_count
FROM employees
GROUP BY ename
ORDER BY name_count DESC
LIMIT 1;
