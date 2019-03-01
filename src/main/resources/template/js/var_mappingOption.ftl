var ${varName} = {

<#list varMap?keys as key>
"${key}":"${varMap[key]}",
</#list>
};

//下拉菜单
$("#${varName}Td").html(printOptions(${varName}, '${varName}', '${varName}', '', '', 'width:100px'));
$("#${varName}").combobox({
valueField: 'code',
textField: 'name'
});

function get_${varName}Name(target){
var res = '';
$.each(${varName},function(key,value){
if(key == target){
res = value;
return false;
}
});
return res;

}

//该方法为通用方法模板
function printOptions(list,id,name, target, option,style) {
style = style || "";
var data=[];
var html="<input id='"+id+"' name='"+name+"' style='"+style+"' class=\"easyui-combobox\" data-options=\" "+option+"valueField:'code',textField:'name',editable:false, panelHeight:'auto' , data: ";
$.each(list, function (key, value) {
if (key == target) {
data.push({ "name": value, "code": key ,selected:true});
} else {
data.push({ "name": value, "code": key });
}

});

html+= JSON.stringify(data).replace(/"/g, "'");
html += "\" />";
return html;
};