-- 코드를 입력하세요
# SELECT crcc.car_id, crcc.car_type, round(crcc.daily_fee * 30 * (100 - crcdp.discount_rate) / 100) fee
select crcc.car_id, crcc.car_type, round(crcc.daily_fee * 30 * (100 - crcdp.discount_rate) / 100) fee
from car_rental_company_car crcc
join car_rental_company_discount_plan crcdp on crcdp.car_type=crcc.car_type and crcdp.duration_type='30일 이상'
where crcc.car_type in ('SUV', '세단') and crcc.car_id not in (
    select distinct car_id
    from car_rental_company_rental_history
    where (year(start_date)=2022 and month(start_date)=11) or 
        (year(end_date)=2022 and month(end_date)=11) or
        (start_date < '2022-11-01' and end_date > '2022-11-30')
)
group by crcc.car_id
having fee between 500000 and 1999999
order by 3 desc, 2, 1 desc;