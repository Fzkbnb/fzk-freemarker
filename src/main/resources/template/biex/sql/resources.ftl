-- ${parentName}
-- 添加 ${author}
-- ${.now?date}

<#if hasParent>
delete from RESOURCES where id = ${parentId};

Insert into RESOURCES (id, parentid, rescode, resname, resdest, type, icon, sortnum, resurl, createby, createdate, updateby, updatedate, delflag)
values (${parentId}, null, '${parentCode}:setting:index', '${parentName}', null, 0,'fi-folder', 11, '#', 200000000000, 1526523483371, 200000000000, 1526523483371, 0);

commit;
</#if>

delete from RESOURCES where id = ${indexId};
delete from RESOURCES where id = ${dataId};
<#if hasOperator>
delete from RESOURCES where id = ${operatorId};
</#if>

Insert into RESOURCES (id, parentid, rescode, resname, resdest, type, icon, sortnum, resurl, createby, createdate, updateby, updatedate, delflag)
values (${indexId}, ${parentId}, '${parentCode}:setting:${classCode}:index', '${orderName}', null, 0, null, 1, '/${parentCode}/${classCode}', 200000000000, 1526523483371, 200000000000, 1526523483371, 0);

Insert into RESOURCES (id, parentid, rescode, resname, resdest, type, icon, sortnum, resurl, createby, createdate, updateby, updatedate, delflag)
values (${dataId}, ${indexId}, '${parentCode}:setting:${classCode}:data', '数据权限', null, 1, null, null, '#', 200000000000, 1505700151697, 200000000000, 1505700151697, 0);

<#if hasOperator>
Insert into RESOURCES (id, parentid, rescode, resname, resdest, type, icon, sortnum, resurl, createby, createdate, updateby, updatedate, delflag)
values (${operatorId}, ${indexId}, '${parentCode}:setting:${classCode}:operator', '操作权限', null, 1, null, null, '#', 200000000000, 1505700151697, 200000000000, 1505700151697, 0);
</#if>

commit;
