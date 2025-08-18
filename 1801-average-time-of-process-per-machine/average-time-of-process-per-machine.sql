select a.machine_id as machine_id,
       ROUND(AVG(a.processing_time), 3) as processing_time
From (SELECT 
    machine_id,
    process_id,
    MAX(CASE WHEN activity_type = 'end' THEN timestamp END) - 
    MIN(CASE WHEN activity_type = 'start' THEN timestamp END) as processing_time
FROM Activity
GROUP BY machine_id, process_id) as a
group by machine_id;
