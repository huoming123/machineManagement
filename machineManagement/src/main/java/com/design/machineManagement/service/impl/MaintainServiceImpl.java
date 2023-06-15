package com.design.machineManagement.service.impl;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Maintain;
import com.design.machineManagement.mapper.MaintainMapper;
import com.design.machineManagement.service.MaintainService;
import com.design.machineManagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.design.machineManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Maintain)表服务实现类
 *
 * @author makejava
 * @since 2022-07-26 14:47:58
 */
@Service("maintainService")
public class MaintainServiceImpl implements MaintainService {
    @Autowired
    private MaintainMapper maintainMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Maintain> queryById(Integer id) {
       Maintain maintain=this.maintainMapper.queryById(id);
         return RestFulBean.succ(maintain);
    }

    /**
     * 新增数据
     *
     * @param maintain 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Maintain maintain) {
        if(maintain.getRoomNo()==null){
            return RestFulBean.error("机房不能为空");
        }
        if(maintain.getComputerNo()==null){
            return RestFulBean.error("电脑编号不能为空");
        }
        if(maintain.getProblem()==null){
            return RestFulBean.error("故障问题不能为空");
        }
        //  根据机房跟电脑编号查询未处理的申请记录
        Maintain  maintained =maintainMapper.queryByRoomNoAndcomputerNo(maintain);
        if(maintained!=null){
            return RestFulBean.error("该电脑已有教师申请报修,不要重复申请");
        }
        this.maintainMapper.insert(maintain);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param maintain 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Maintain maintain) {
        if(maintain.getWorker()==null){
            return RestFulBean.error("维修人不能为空");
        }
        if(maintain.getMaintainPhone()==null){
            return RestFulBean.error("维修电话不能为空");
        }
        if(maintain.getStatus()==null){
            return RestFulBean.error("维修状况不能为空");
        }
        if(maintain.getMaintainTime()==null){
            return RestFulBean.error("维修时间不能为空");
        }
        if(maintain.getMaintainPhone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(maintain.getMaintainPhone());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        String orderId=maintain.getOrderId().trim();//字符串去空
        Maintain maintain1=maintainMapper.getByOrderId(orderId);//根据维修工单获取唯一数据
        if(maintain1!=null){
            return RestFulBean.error("该维修工单已经添加");
        }
        this.maintainMapper.update(maintain);
        return RestFulBean.succ("修改成功");
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.maintainMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getList(Page<Maintain> page)throws Exception {
        //前端传来的参数 第几页
        Integer pageNum = page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum = (pageNum - 1) * page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Maintain> list = maintainMapper.getPageListByCondition(page);
        if(list.size()>0){
            for(Maintain maintain:list){
                if(maintain.getStatus()==null){  //如果状态值为空 说明这个维修单还没处理 删除可以编辑
                    maintain.setDisabled(false);
                    maintain.setMaintenanceState("未处理"); //前端显示的维修状态
                }
                else{
                    if(maintain.getStatus()==1){
                        maintain.setMaintenanceState("已修好");
                    }
                    if(maintain.getStatus()==0){
                        maintain.setMaintenanceState("报废");
                    }
                    maintain.setDisabled(true); //处理之后数据就不给删除了
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = maintainMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list", list);
        return RestFulBean.succ(map);
    }

    @Override
    public RestFulBean<Map> getListCount(Page<Maintain> page) throws Exception {
        Maintain lastMaintain =new Maintain();
        Integer total =0;
        lastMaintain.setMaintenanceState("合计:");
        //根据前端传来的的条件进行查询  //分页查询
        List<Maintain> list = maintainMapper.getPageCountListByCondition(page);
        if(list.size()>0){
            for(Maintain maintain:list){
                total=total + maintain.getCount();//合计
                if(maintain.getStatus()==null){  //如果状态值为空 说明这个维修单还没处理 删除可以编辑
                    maintain.setDisabled(false);
                    maintain.setMaintenanceState("未处理"); //前端显示的维修状态
                }
                else{
                    if(maintain.getStatus()==1){
                        maintain.setMaintenanceState("已修好");
                    }
                    if(maintain.getStatus()==0){
                        maintain.setMaintenanceState("报废");
                    }
                    maintain.setDisabled(true); //处理之后数据就不给删除了
                }
            }
        }
        lastMaintain.setCount(total); //合计总数
        list.add(list.size(),lastMaintain);//最后一行添加一条数据
        // 得到最大页数，总条数
        Map<Object, Object> map = PageUtil.pagingPrepare(page, list.size());
        // 得到分页数据
        List<Maintain> pagetList = new LinkedList<>();
        int startIndex = (page.getPageNum() - 1) * page.getPageSize();
        int a = 0;
        while (a < page.getPageSize() && startIndex < list.size()) {
            a++;
            pagetList.add(list.get(startIndex++));
        }
        map.put("list", pagetList);
        return RestFulBean.succ(map);

    }
}
