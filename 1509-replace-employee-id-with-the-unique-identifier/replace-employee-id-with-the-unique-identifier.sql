# Write your MySQL query statement below
select unique_id,name
from Employees as em
left join EmployeeUNI as eu
on em.id=eu.id;