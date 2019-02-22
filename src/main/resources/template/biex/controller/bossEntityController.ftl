package ${projectName}.controller.${parentCode};

/**
* @program: ${projectName}
*
* @description: ${entityDes}控制器
*
* @author: ${author}
*
* @create: ${.now?datetime}
**/
@Controller
@RequestMapping("/${parentCode}")
public class ${className}Controller extends GenericController
{
    @Autowired(required = false)
    ${className}Service ${entityCode}Service;
    /**
    * 列表页面导航
    * @return
    * @throws BusinessException
    */
    @RequestMapping(value = "/${entityCode}")
    @RequiresPermissions("${parentCode}:setting:${entityCode}:index")
    public String list() throws BusinessException
    {
        return "${parentCode}/${entityCode}/list";
    }

    /**
    * 查询
    * @param entity
    * @param pagin
    * @return {@link JsonMessage}
    * @throws BusinessException
    */
    @ResponseBody
    @RequestMapping(value = "/${entityCode}/data", method = RequestMethod.POST)
    @RequiresPermissions("${parentCode}:setting:${entityCode}:data")
    public JsonMessage data(@ModelAttribute ${className} entity, @ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<${className}> result = ${entityCode}Service.search(pagin, entity);
        return getJsonMessage(CommonEnums.SUCCESS, result);
    }
    <#if hasOperator>
    /**
    * 添加或修改
    * @param id
    * @return
    * @throws BusinessException
    */
    @RequestMapping(value = "/${entityCode}/modify")
    @RequiresPermissions("${parentCode}:setting:${entityCode}:operator")
    public ModelAndView modify(Long id) throws BusinessException
    {
        ModelAndView mav = new ModelAndView("${parentCode}/${entityCode}/modify");
        ${className} entity = new ${className}();
        if (id != null)
        {
            entity = ${entityCode}Service.selectByPrimaryKey(id);
        }
        mav.addObject("${entityCode}", entity);
        return mav;
    }

    /**
    * 保存
    * @param entity
    * @return {@link JsonMessage}
    * @throws BusinessException
    */
    @CSRFToken
    @ResponseBody
    @RequestMapping(value = "/${entityCode}/save", method = RequestMethod.POST)
    @RequiresPermissions("${parentCode}:setting:${entityCode}:operator")
    @ApiOperation(value = "保存", httpMethod = "POST")
    public JsonMessage save(@ModelAttribute ${className} entity) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        if (beanValidator(json, entity))
        {
            ${entityCode}Service.save(entity);
        }
        return json;
    }

    /**
    * 根据指定ID删除
    * @param id
    * @return {@link JsonMessage}
    * @throws BusinessException
    */
    @CSRFToken
    @ResponseBody
    @RequestMapping(value = "/${entityCode}/del", method = RequestMethod.POST)
    @RequiresPermissions("${parentCode}:setting:${entityCode}:operator")
    @ApiOperation(value = "根据指定ID删除", httpMethod = "POST")
    public JsonMessage del(Long id) throws BusinessException
    {
        JsonMessage json = getJsonMessage(CommonEnums.SUCCESS);
        ${entityCode}Service.delete(id);
        return json;
    }
    </#if>
}
