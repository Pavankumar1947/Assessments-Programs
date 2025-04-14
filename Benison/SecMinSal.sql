SELECT MIN(salary) AS second_lowest_salary
FROM employees
WHERE salary > (
    SELECT MIN(salary) FROM employees
);
