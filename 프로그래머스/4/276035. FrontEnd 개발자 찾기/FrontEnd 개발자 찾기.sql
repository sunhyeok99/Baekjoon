SELECT D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM DEVELOPERS D
WHERE SKILL_CODE & (
    select sum(code) 
    from skillcodes 
    where category = 'Front End'
    group by category
)
ORDER BY D.ID;