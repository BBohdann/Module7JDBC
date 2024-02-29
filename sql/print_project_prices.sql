select p.id,
sum(w.salary)*EXTRACT(MONTH FROM AGE(FINISH_DATE, START_DATE)) AS PRISE
from project p
join project_worker pw
on p.id = pw.project_id
join worker w on
w.id = pw.worker_id
group by p.id
order by prise desc;