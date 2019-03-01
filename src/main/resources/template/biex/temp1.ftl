package com.blocain.exchange.memory.service;


/**
* @program: exchange
*
* @description:
*
* @author: fzk
*
* @create: 2019-02-27 13:28
**/
@Service
@ConditionalOnProperty(value = "ignite.enable", havingValue = "true", matchIfMissing = true)
public class ${entityName}oryServiceImpl implements ${entityName}oryService
{
@Autowired
protected ${entityName}oryRepository ${entityName1}oryRepository;


@Override
public void save(Long id, ${entityName} entity)
{
${entityName1}oryRepository.save(id, entity);
}

@Override
public ${entityName} findById(Long id)
{
return ${entityName1}oryRepository.findById(id).get();
}

@Override
public List<${entityName}> findAll()
    {
    return Lists.newArrayList(${entityName1}oryRepository.findAll());
    }
    }