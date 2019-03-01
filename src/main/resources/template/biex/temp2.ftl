package com.blocain.exchange.memory.dao;

/**
* @program: exchange
*
* @description:
*
* @author: fzk
*
* @create: 2019-02-27 13:30
**/
@ConditionalOnProperty(value = "ignite.enable", havingValue = "true", matchIfMissing = true)
@RepositoryConfig(cacheName = "${entityName}Cache")
public interface ${entityName}oryRepository extends IgniteRepository<${entityName}, Long>
{
}
