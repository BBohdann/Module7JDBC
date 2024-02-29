select
    w.name,
    m.max_salary AS salary
from
    worker w
join
    (select MAX(salary) as max_salary from worker) m
on
    w.salary = m.max_salary;