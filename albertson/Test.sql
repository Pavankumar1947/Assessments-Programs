// fetch who logged in more than 3 times a week


SELECT userid COUNt(*) AS login_count, WEEK(login_time AS week_no)
FROM logins
GROUP BY user_id,WEEK(login_time)
HAVING COUNT(*)> 3;