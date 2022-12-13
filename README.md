# Hospital-Claim-Management-System
Rest api for Hospital claim management system


1-many
1 hospital many doctor
1 doctor 1 hospita
l user many insurance claimed
1 user 1 doctor only 
1 user go procedure with 1 doctor 
many users go with many doctor 


list of doctor in  hospital
list of pateints assign to a doctor
list of patients assign to a doctor
list of hospital
list of patients
list of claims by patient
list of all doctor rolesdesc 
list of insurance claim by a user


:user account entity :
user id:fk
username 
useraccountid :pk 
useraccountbalance_insurance_money=






//
userepo
doctorrepo
doctorrolerepo
hospitalrepo
insurance_repo
procedure_Repo


Should I have a service for each entity?
No. You do not need to create one service for one entity. In DDD you would create services for operations that do not
 naturally map to a single entity (or value object).

@entity
@Getter
@Setter
@Constructor
@NoArgsConstructor
@AllArgsConstructor
@ToString


hospital-book
doctor-order
to find : number of doctor in a hospital

select count(doctor.doctor_id) as number_of_doctor
from hospital
left join doctor
on(hospital.hospital_id = doctor.hospital_id)
group by 
hospital.hospital_id;








login for user and after that claiming for insurance 

//create upadet and delte for appointement 
select * from doctor where doctor_total_price between 1 AND (select user_insurance_money from user where user_id=7)  AND doctor_type=500;

