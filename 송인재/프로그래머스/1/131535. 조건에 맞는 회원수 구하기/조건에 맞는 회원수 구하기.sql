-- 코드를 입력하세요
SELECT count(1) users
from user_info
where year(joined)=2021 and age between 20 and 29;