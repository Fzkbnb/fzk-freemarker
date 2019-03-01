/*********************************************************按业务类业分割，上面是币对相关的业务对象，下面是全局的业务对象*****************************************************************/
/**
* 证券信息表关系映射
* @param cacheName
* @return
*/
public static JdbcType jdbcTypeStockInfoMem(String cacheName, String tableName)
{
JdbcType type = new JdbcType();
type.setCacheName(cacheName);
type.setKeyType(Long.class);
type.setValueType(StockInfoMem.class);
type.setDatabaseTable(tableName);
type.setKeyFields(new JdbcTypeField(Types.NUMERIC, "id", Long.class, "id"));
type.setValueFields(

<#list props as prop>
new JdbcTypeField(Types.${prop.igniteType}, "${prop.name}", ${prop.type}.class, "${prop.name}"),
</#list>
);
return type;
}