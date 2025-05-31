-- To retrieve the top 5 highest-paid employees in each department, sorted by salary in descending order

SELECT *
FROM (
    SELECT 
        employee_id,
        name,
        department_id,
        salary,
        ROW_NUMBER() OVER (PARTITION BY department_id ORDER BY salary DESC) AS rn
    FROM employees
) AS ranked
WHERE rn <= 5
ORDER BY department_id, salary DESC;


--using Sub querys
SELECT e1.*
FROM employees e1
WHERE (
    SELECT COUNT(DISTINCT e2.salary)
    FROM employees e2
    WHERE e2.department_id = e1.department_id
      AND e2.salary > e1.salary
) < 5
ORDER BY e1.department_id, e1.salary DESC;
