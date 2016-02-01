delete from peserta_pelatihan;
delete from sesi;

insert into sesi (id, id_materi, mulai, sampai)
values ('s1', 'm4', '2015-02-01', '2015-02-05');

insert into sesi (id, id_materi, mulai, sampai)
values ('s2', 'm5', '2015-02-08', '2015-02-28');

insert into sesi (id, id_materi, mulai, sampai)
values ('s3', 'm6', '2015-02-01', '2015-02-01');

insert into peserta_pelatihan (id_sesi, id_peserta)
values ('s1', 'a1');

insert into peserta_pelatihan (id_sesi, id_peserta)
values ('s1', 'a2');

insert into peserta_pelatihan (id_sesi, id_peserta)
values ('s1', 'a3');

insert into peserta_pelatihan (id_sesi, id_peserta)
values ('s2', 'a2');

insert into peserta_pelatihan (id_sesi, id_peserta)
values ('s2', 'a3');

insert into peserta_pelatihan (id_sesi, id_peserta)
values ('s3', 'a1');