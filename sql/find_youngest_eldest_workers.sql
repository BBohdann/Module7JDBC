with youngest_worker as(
select 'YOUNGEST' as type,
NAME,
BIRTHDAY from worker where BIRTHDAY = (select max(BIRTHDAY) from worker)),

eldest_worker as(
select 'ELDEST' as type,
NAME,
BIRTHDAY from worker where BIRTHDAY = (select min(BIRTHDAY) from worker))


SELECT * FROM (
    SELECT * FROM youngest_worker
    UNION ALL
    SELECT * FROM eldest_worker
)
ORDER BY
    CASE WHEN TYPE = 'YOUNGEST' THEN 1 ELSE 2 END;