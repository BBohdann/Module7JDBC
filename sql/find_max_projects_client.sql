select c.name,count(p.id) as PROJECT_COUNT
   from client c
   join project p on p.client_id = c.id
   group by c.NAME
   having COUNT(p.ID) =
   (select count(p.id) from project p
   group by client_id
   ORDER BY COUNT(p.ID)
   desc limit 1);