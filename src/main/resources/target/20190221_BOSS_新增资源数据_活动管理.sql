-- 活动管理
-- 添加 fzk
-- 2019-2-22


delete from RESOURCES where id = 120000000004;
delete from RESOURCES where id = 120000000005;

Insert into RESOURCES (id, parentid, rescode, resname, resdest, type, icon, sortnum, resurl, createby, createdate, updateby, updatedate, delflag)
values (120000000004, 120000000001, 'activity:setting:punchActivityRate:index', '签到活动', null, 0, null, 1, '/activity/punchActivityRate', 200000000000, 1526523483371, 200000000000, 1526523483371, 0);

Insert into RESOURCES (id, parentid, rescode, resname, resdest, type, icon, sortnum, resurl, createby, createdate, updateby, updatedate, delflag)
values (120000000005, 120000000004, 'activity:setting:punchActivityRate:data', '数据权限', null, 1, null, null, '#', 200000000000, 1505700151697, 200000000000, 1505700151697, 0);


commit;
