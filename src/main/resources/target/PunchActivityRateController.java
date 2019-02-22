package exchange.controller.activity;

/**
* @program: exchange
*
* @description: 打卡签到年化利率控制器
*
* @author: fzk
*
* @create: 2019-2-22 11:36:50
**/
@Controller
@RequestMapping("/activity")
public class PunchActivityRateController extends GenericController
{
    @Autowired(required = false)
    PunchActivityRateService punchActivityRateService;
    /**
    * 列表页面导航
    * @return
    * @throws BusinessException
    */
    @RequestMapping(value = "/punchActivityRate")
    @RequiresPermissions("activity:setting:punchActivityRate:index")
    public String list() throws BusinessException
    {
        return "activity/punchActivityRate/list";
    }

    /**
    * 查询
    * @param entity
    * @param pagin
    * @return {@link JsonMessage}
    * @throws BusinessException
    */
    @ResponseBody
    @RequestMapping(value = "/punchActivityRate/data", method = RequestMethod.POST)
    @RequiresPermissions("activity:setting:punchActivityRate:data")
    public JsonMessage data(@ModelAttribute PunchActivityRate entity, @ModelAttribute Pagination pagin) throws BusinessException
    {
        PaginateResult<PunchActivityRate> result = punchActivityRateService.search(pagin, entity);
        return getJsonMessage(CommonEnums.SUCCESS, result);
    }
}
