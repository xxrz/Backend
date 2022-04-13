SELECT Student.Sno,Student.Sname
FROM Student,SC
WHERE Student.Sno=SC.Sno AND SC.Cno='001' AND 
EXISTS( SELECT * FROM SC AS SC_2 WHERE SC_2.Sno=SC.Sno AND SC_2.Cno='002');


SELECT *
FROM Student,SC
WHERE Student.Sno=SC.Sno 

SELECT *
FROM Student
JOIN SC
ON Student.Sno=SC.Sno 

SELECT *
FROM SC
GROUP BY Sno,Cno

SELECT Student.Sno,Student.Sname
FROM Student
JOIN (
SELECT s1.Sno
FROM SC AS s1,SC AS s2
WHERE s1.Sno = s2.Sno AND s1.Cno='001' AND s2.Cno='002') AS t
ON t.Sno = Student.Sno


SELECT s1.Sno 
FROM SC AS s1, SC AS s2
WHERE s1.Sno = s2.Sno AND s1.Cno='001' AND s2.Cno='002' AND s1.score > s2.score


SELECT a.Sno
FROM (SELECT Sno,score FROM SC WHERE Cno='001') a,
(SELECT Sno,score FROM SC WHERE Cno='002') b
WHERE a.score > b.score AND a.Sno=b.Sno;

SELECT Sno,AVG(score)
FROM SC
GROUP BY Sno
HAVING AVG(score) > 60

SELECT Student.Sno,Sname,COUNT(Cno),SUM(score)
FROM Student
LEFT JOIN SC
ON Student.`Sno` = SC.`Sno`
GROUP BY SC.Sno

SELECT Student.Sno,Student.Sname,COUNT(SC.Cno),SUM(score)
FROM Student LEFT OUTER JOIN SC ON Student.Sno=SC.Sno
GROUP BY Student.Sno,Sname

SELECT COUNT(Tname)
FROM Teacher
WHERE Tname LIKE '张%'

SELECT Student.Sno, Student.`Sname`
FROM Student
WHERE Sno NOT IN (
	SELECT DISTINCT SC.Sno
	FROM SC, Course, Teacher
	WHERE SC.`Cno` = Course.`Cno` AND Teacher.`Tno`=Course.`Cno` AND
		Teacher.Tname='叶平'
)


SELECT t.Sno, t.Sname
FROM Student
JOIN (
SELECT Student.Sno, Sname,Teacher.Tname
FROM Student
JOIN SC ON SC.Sno = Student.Sno
JOIN Course ON Course.cno = SC.Cno
JOIN Teacher ON Teacher.Tno = Course.Tno
GROUP BY Student.Sno
HAVING Teacher.Tname !='叶平') AS t
ON Student.`Sno`=t.Sno

SELECT Sno
FROM Student

SELECT t.Sno,t.Sname
FROM (
SELECT Student.Sno, Sname,Teacher.Tname
FROM Student
JOIN SC ON SC.Sno = Student.Sno
JOIN Course ON Course.cno = SC.Cno
JOIN Teacher ON Teacher.Tno = Course.Tno
GROUP BY Student.Sno
HAVING Teacher.Tname !='叶平'
) AS t

SELECT DISTINCT Student.Sno, Sname
FROM Student
JOIN SC ON SC.Sno = Student.Sno
JOIN Course ON Course.cno = SC.Cno
JOIN Teacher ON Teacher.Tno = Course.Tno
WHERE Tname !='叶平'

SELECT t.Sno,t.Sname
FROM(
SELECT *
FROM Student
JOIN SC ON SC.Sno = Student.Sno
JOIN Course ON Course.cno = SC.Cno
JOIN Teacher ON Teacher.Tno = Course.Tno
WHERE Teacher.Tname = '叶平') AS t
GROUP BY t.Sname
HAVING COUNT(t.Tname='叶平')=(
	SELECT COUNT(Course.Cno)
	FROM Course,Teacher
	WHERE Course.Tno = Teacher.`Tno` AND Teacher.Tname='叶平')

SELECT Sno
FROM SC
GROUP BY sno
HAVING COUNT(Cno)=2

SELECT Sno
FROM SC
GROUP BY sno
HAVING Cno='2'
	
	
SELECT Sno,Sname
FROM Student
WHERE Sno IN(
	SELECT Student.Sno
	FROM Student
	JOIN SC ON SC.Sno = Student.Sno
	JOIN Course ON Course.cno = SC.Cno
	JOIN Teacher ON Teacher.Tno = Course.Tno
	WHERE Tname = '叶平'
	GROUP BY Sno
	HAVING COUNT(Tname='叶平')=(
		SELECT COUNT(Course.Cno)
		FROM Course,Teacher
		WHERE Course.Tno = Teacher.`Tno` AND Teacher.Tname='叶平')
)


SELECT Sno,Sname
FROM Student
WHERE Sno IN
(SELECT Sno
FROM SC ,Course ,Teacher
WHERE SC.Cno=Course.Cno AND Teacher.Tno=Course.Tno AND Teacher.Tname='叶平' 
GROUP BY Sno HAVING COUNT(SC.Cno)=
(SELECT COUNT(Cno) FROM Course,Teacher WHERE Teacher.Tno=Course.Tno AND Tname='叶平'));

SELECT

