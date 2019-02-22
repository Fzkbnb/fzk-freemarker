<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ include file="/commons/setup_ajax.jsp" %>
<script type="text/javascript">
    var punchActivityRateDataGrid;
    $(function () {
        punchActivityRateDataGrid = $('#punchActivityRateDataGrid').datagrid({
            url: '${ctx}/activity/punchActivityRate/data',
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
                {
                    width: '100',
                    title: '时间',
                    field: 'currentDate'
                },
                {
                    width: '100',
                    title: 'serialVersionUID',
                    field: 'serialVersionUID'
                },
                {
                    width: '100',
                    title: '年化利率',
                    field: 'rate'
                },
                {
                    width: '100',
                    title: '占比',
                    field: 'percent'
                },
            ]],
            onLoadSuccess: function (data) {
                //用户未登录时刷新页面
                var codeNum = JSON.stringify(data.code);
                if (codeNum == 2003) {
                    window.location.reload();
                }
            }
        });
    });

    function punchActivityRate_searchFun() {
        punchActivityRateDataGrid.datagrid('load', $.serializeObject($('#punchActivityRateForm')));
    }

    function punchActivityRate_cleanFun() {
        $('#punchActivityRateForm input').val('');
        punchActivityRateDataGrid.datagrid('load', {});
    }
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="punchActivityRateForm">
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
                           onclick="punchActivityRate_searchFun();">查询</a>
                        <a href="javascript:void(0);" class="easyui-linkbutton"
                           data-options="iconCls:'fi-x-circle',plain:true" onclick="punchActivityRate_cleanFun();">清空</a>
                    </td>
                </tr>
            </table>

        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="punchActivityRateDataGrid" data-options="fit:true,border:false"></table>
    </div>
</div>

