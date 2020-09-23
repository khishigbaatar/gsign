SELECT
    perform.id,
    perform.emp_code,
    perform.reviewedby,
    perform.performance
FROM
  emp_performance perform
WHERE
  emp_code = /*empCode*/'100'
