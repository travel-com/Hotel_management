drop table guest;
drop table room;
drop seuence guestId;
drop sequence roomseq;
create sequence roomseq start with 1;

create table room(
id number(10),
roomno varchar2(10) primary key,
roomType varchar2(20),
cost_of_room number(10,2)
);
insert into room values (roomseq.nextval,'101','acdouble',2000);
insert into room values (roomseq.nextval,'102','acsingle',1000);




drop table guest;
create sequence guestId start with 1;

create table guest (
id number(10),
name Varchar2(100),
roomno varchar2(10),
mobile varchar2(10),
email varchar2(40),
idProof varchar2(50),
Arrivaldate Date,
Departuredate Date,
Address varchar2(200),
constraint r1 foreign key (roomno) references room(roomno)
);

insert into guest values(guestId.nextval,'kavita','101','7979579','kavita100@gmail.com','908437898','23-feb-2019','25-feb-2019','nitrr');
insert into guest values(guestId.nextval,'kavita','103','7979579','kavita100@gmail.com','908437898','23-feb-2019','25-feb-2019','nitrr');

