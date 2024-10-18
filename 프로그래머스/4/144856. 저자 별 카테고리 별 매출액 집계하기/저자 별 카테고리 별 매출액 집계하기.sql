SELECT A.AUTHOR_ID , A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * S.SALES) AS TOTAL_SALES 
                        FROM BOOK B JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
                        JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
                        WHERE S.SALES_DATE LIKE '2022-01-%'
                        GROUP BY B.AUTHOR_ID, B.CATEGORY
                        ORDER BY B.AUTHOR_ID , CATEGORY DESC
                        
