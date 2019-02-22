<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var ${classCode}DataGrid;
    <#if hasSubData>
    var ${subClassCode}DataGrid;
    </#if>
    $(function () {
    <#if hasSubData>
        ${subClassCode}DataGrid = $('#${subClassCode}DataGrid').datagrid({
            striped: true,
            rownumbers: true,
            pagination: true,
            singleSelect: true,
            idField: 'id',
            pageSize: 20,
            pageList: [10, 20, 30, 40, 50, 100],
            columns: [[
                {
                    field: 'ck',
                    checkbox:false
                },
                <#list subEntityMap?keys as key>
                    {
                        width: '100',
                        title: '${subEntityMap[key]}',
                        field: '${key}'
                    },
                </#list>
                <#if hasSubOperator>
                {
                    field: 'action',
                    title: '操作',
                    width: 140,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="icoproduct-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="${subClassCode}_editFun(\'{0}\';" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="icoproduct-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="${subClassCode}_deleteFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </#if>
            ]],
            onLoadSuccess: function (data) {
                //用户未登录时刷新页面
                var codeNum = JSON.stringify(data.code);
                if(codeNum==2003){
                    window.location.reload();
                }
            }
            <#if hasSubOperator>
            ,
            toolbar: '${subClassCode}bar'
            </#if>
        });
    </#if>
        ${classCode}DataGrid = $('#${classCode}DataGrid').datagrid({
            url: '${r"${"}ctx${r"}"}/${parentCode}/${classCode}/data',
            striped: true,
            rownumbers: true,
            pagination: true,
            singleSelect: true,
            idField: 'id',
            pageSize: 20,
            pageList: [10, 20, 30, 40, 50, 100],
            columns: [[
                {
                    field: 'ck',
                    checkbox:false
                },
                <#list entityMap?keys as key>
                {
                    width: '100',
                    title: '${entityMap[key]}',
                    field: '${key}'
                },
                </#list>
                <#if hasOperator>
                {
                    field: 'action',
                    title: '操作',
                    width: 140,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="icoproduct-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-pencil icon-blue\'" onclick="${classCode}_editFun(\'{0}\';" >编辑</a>', row.id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="icoproduct-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'fi-x icon-red\'" onclick="${classCode}_deleteFun(\'{0}\');" >删除</a>', row.id);
                        return str;
                    }
                }
                </#if>
            ]],
            <#if hasSubData>
            onLoadSuccess: function (data) {
                var rows = $('#${classCode}DataGrid').datagrid("getRows");
                if (rows.length > 0) {
                    $("#relatedId").val(rows[0].id);
                    var opts = ${subClassCode}DataGrid.datagrid("options");
                    opts.url = '${r"${"}ctx${r"}"}/${parentCode}/${subClassCode}/data';
                    ${subClassCode}DataGrid.datagrid('reload', {
                        relatedId: rows[0].id
                    });
                    $('#${classCode}DataGrid').datagrid('selectRow', 0);
                }
            },
            onClickRow: function (rowIndex, rowData) {
                $("#relatedId").val(rowData.id);
                ${subClassCode}DataGrid.datagrid('reload', {relatedId: rowData.id});
            }
            <#else>
            onLoadSuccess: function (data) {
                //用户未登录时刷新页面
                var codeNum = JSON.stringify(data.code);
                if (codeNum == 2003) {
                    window.location.reload();
                }
            }
            </#if>
            <#if hasOperator>
            ,
            toolbar: '${classCode}bar'
            </#if>
        });
    });
    <#if hasOperator>
    //添加
    function ${classCode}_addFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 500,
            height: 300,
            href: '${r"${"}ctx${r"}"}/${parentCode}/${classCode}/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = ${classCode}DataGrid;
                    var f = parent.$.modalDialog.handler.find('#${classCode}_editForm');
                    f.submit();
                }
            }]
        });
    }
    //编辑
    function ${classCode}_editFun(id) {
        if (id == undefined) {
            var rows = ${classCode}DataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            ${classCode}DataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 500,
            height: 300,
            href: '${r"${"}ctx${r"}"}/${parentCode}/${classCode}/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = ${classCode}DataGrid;
                    var f = parent.$.modalDialog.handler.find('#${classCode}_editForm');
                    f.submit();
                }
            }]
        });
    }
    //删除
    function ${classCode}_deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = ${classCode}DataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            ${classCode}DataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前记录吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${r"${"}ctx${r"}"}/${parentCode}/${classCode}/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        ${classCode}DataGrid.datagrid('reload');
                    } else {
                        parent.$.messager.alert('错误', result.message, 'error');
                    }
                    $('#csrf-form').find('input[name="csrf"]').val(result.csrf);
                    setCsrfToken("csrf-form");
                    progressClose();
                }, 'JSON');
            }
        });
    }
    </#if>
    <#if hasSubOperator>
    //添加
    function ${subClassCode}_addFun() {
        parent.$.modalDialog({
            title: '添加',
            width: 500,
            height: 300,
            href: '${r"${"}ctx${r"}"}/${parentCode}/${subClassCode}/modify',
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = ${subClassCode}DataGrid;
                    var f = parent.$.modalDialog.handler.find('#${subClassCode}_editForm');
                    f.submit();
                }
            }]
        });
    }
    //编辑
    function ${subClassCode}_editFun(id) {
        if (id == undefined) {
            var rows = ${subClassCode}DataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            ${subClassCode}DataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title: '编辑',
            width: 500,
            height: 300,
            href: '${r"${"}ctx${r"}"}/${parentCode}/${subClassCode}/modify?id=' + id,
            buttons: [{
                text: '确定',
                handler: function () {
                    parent.$.modalDialog.openner_dataGrid = ${subClassCode}DataGrid;
                    var f = parent.$.modalDialog.handler.find('#${subClassCode}_editForm');
                    f.submit();
                }
            }]
        });
    }
    //删除
    function ${subClassCode}_deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = ${subClassCode}DataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            ${subClassCode}DataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除当前记录吗？', function (b) {
            if (b) {
                progressLoad();
                $.post('${r"${"}ctx${r"}"}/${parentCode}/${subClassCode}/del', {
                    ids: id
                }, function (result) {
                    if (result.code == ajax_result_success_code) {
                        parent.$.messager.alert('提示', result.message, 'info');
                        ${subClassCode}DataGrid.datagrid('reload');
                    } else {
                        parent.$.messager.alert('错误', result.message, 'error');
                    }
                    $('#csrf-form').find('input[name="csrf"]').val(result.csrf);
                    setCsrfToken("csrf-form");
                    progressClose();
                }, 'JSON');
            }
        });
    }
    </#if>

    function ${classCode}_searchFun() {
        ${classCode}DataGrid.datagrid('load', $.serializeObject($('#${classCode}Form')));
    }

    function ${classCode}_cleanFun() {
        $('#${classCode}Form input').val('');
        ${classCode}DataGrid.datagrid('load', {});
    }
</script>
<#if hasSubData>
<div style="width: 580px;height:30px;">
    <form id="${classCode}Form">
        <table>
            <tr>
                <th>查询字段1:</th>
                <td>
                    <input id="查询字段1" name="查询字段1" style="width:100px;">
                    </input>
                </td>
                <td>
                    <a href="javascript:void(0);" class="easyui-linkbutton"
                       data-options="iconCls:'fi-magnifying-glass',plain:true"
                       onclick="${classCode}_searchFun();">查询</a>
                    <a href="javascript:void(0);" class="easyui-linkbutton"
                       data-options="iconCls:'fi-x-circle',plain:true" onclick="${classCode}_cleanFun();">清空</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<div class="easyui-layout" data-options="fit:true,border:false" style="width:100%;height:100%;">
    <div data-options="region:'north',split:true" style="width: 580px;height:400px;">
        <table id="${classCode}DataGrid" data-options="fit:true,border:false,title:'${orderName}'"></table>
    </div>
    <input type="hidden" id="relatedId"/>
    <div data-options="region:'center'" style="padding: 5px; background: #eee;">
        <table id="${subClassCode}DataGrid" data-options="fit:true,border:false,title:'${subOrderName}'"></table>
    </div>
</div>
<#else>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="${classCode}Form">
            <table>
                <tr>
                    <th>查询字段1:</th>
                    <td>
                        <input id="查询字段1" name="查询字段1" style="width:100px;">
                        </input>
                    </td>
                    <td>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-magnifying-glass',plain:true"
                           onclick="${classCode}_searchFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="${classCode}_cleanFun();">清空</a>
                    </td>
                </tr>
            </table>

        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="${classCode}DataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>
</#if>
<#if hasOperator>
<div id="${classCode}bar" style="display: none;">
    <shiro:hasPermission name="${parentCode}:setting:${classCode}:operator">
        <a onclick="${classCode}_addFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>
</#if>
<#if hasSubOperator>
<div id="${subClassCode}bar" style="display: none;">
    <shiro:hasPermission name="${parentCode}:setting:${subClassCode}:operator">
        <a onclick="${subClassCode}_addFun();" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'fi-plus icon-green'">添加</a>
    </shiro:hasPermission>
</div>
</#if>

