package com.design.machineManagement.service.impl;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.ScheduleClass;
import com.design.machineManagement.mapper.ScheduleClassMapper;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.ScheduleClassService;
import com.design.machineManagement.util.PageUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (ScheduleClass)表服务实现类
 *
 * @author makejava
 * @since 2022-07-23 13:35:04
 */
@Service("scheduleClassService")
public class ScheduleClassServiceImpl implements ScheduleClassService {
    @Autowired
    private ScheduleClassMapper scheduleClassMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<ScheduleClass> queryById(Integer id) {
       ScheduleClass scheduleClass=this.scheduleClassMapper.queryById(id);
         return RestFulBean.succ(scheduleClass);
    }

    /**
     * 新增数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(ScheduleClass scheduleClass) {
        if(scheduleClass.getCourseId()==null)
        {
            RestFulBean.error("课程不能为空");
        }
        if(scheduleClass.getMachineId()==null)
        {
            RestFulBean.error("机房号不能为空");
        }
        if(scheduleClass.getUserId()==null)
        {
            RestFulBean.error("教师不能为空");
        }
        if(scheduleClass.getWeekDay()==null)
        {
            RestFulBean.error("时间不能为空");
        }
        if(scheduleClass.getStartTime()==null)
        {
            RestFulBean.error("时间段不能为空");
        }
        if(scheduleClass.getEndTime()==null)
        {
            RestFulBean.error("时间段不能为空");
        }
        if (scheduleClass.getStartTime().equals(scheduleClass.getEndTime())) {
            return RestFulBean.error("时间段不能相等");
        }
        Integer aa = null;
        //时间段根据：去切割数据 比如 08:00 切成 08 00
        System.out.println(scheduleClass.getStartTime().split(":")[0]+"隔开"+scheduleClass.getStartTime().split(":")[1]+"fdfdfd");
        String first = scheduleClass.getStartTime().split(":")[0]; //取第一个 比如 08
        if ("12".equals(first)) {  //判断开始时间段是否等于12
            return RestFulBean.error("时间段包含午休时间,请重新选择");
        }
        if (first.startsWith("0")) { //再判断切出来的第一个first 是否是0开头的 比如 08
            String result = first.split("0")[1]; //如果是 则根据0再切割 然后取第二个 则 取 8
            aa = Integer.parseInt(String.valueOf(result)); //把字符串转为整形
        } else {//如果不是0开头的 则 直接把它转为整形 比如 10
            aa = Integer.parseInt(String.valueOf(first));
        }
        //第二个时间的同理可得
        Integer bb = null;
        String second = scheduleClass.getEndTime().split(":")[0];
        if (second.startsWith("0")) {
            String result1 = second.split("0")[1];
            bb = Integer.parseInt(String.valueOf(result1));
        } else {
            bb = Integer.parseInt(String.valueOf(second));
        }
        //第二个时间段减去第一个时间
        if (bb - aa < 0) {
            return RestFulBean.error("开始时间段不能大于结束时间段");
        }
        if (bb - aa > 2) {
            return RestFulBean.error("课程只能选两节课");
        }
        this.scheduleClassMapper.insert(scheduleClass);
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(ScheduleClass scheduleClass) {
        if(scheduleClass.getCourseId()==null)
        {
            RestFulBean.error("课程不能为空");
        }
        if(scheduleClass.getUserId()==null)
        {
            RestFulBean.error("教师不能为空");
        }
        if(scheduleClass.getWeekDay()==null)
        {
            RestFulBean.error("时间不能为空");
        }
        if(scheduleClass.getStartTime()==null)
        {
            RestFulBean.error("时间段不能为空");
        }
        if(scheduleClass.getEndTime()==null)
        {
            RestFulBean.error("时间段不能为空");
        }
        if (scheduleClass.getStartTime().equals(scheduleClass.getEndTime())) {
            return RestFulBean.error("时间段不能相等");
        }
        Integer aa = null;
        //时间段根据：去切割数据 比如 08:00 切成 08 00
        System.out.println(scheduleClass.getStartTime().split(":")[0]+"隔开"+scheduleClass.getStartTime().split(":")[1]+"fdfdfd");
        String first = scheduleClass.getStartTime().split(":")[0]; //取第一个 比如 08
        if ("12".equals(first)) {  //判断开始时间段是否等于12
            return RestFulBean.error("时间段包含午休时间,请重新选择");
        }
        if (first.startsWith("0")) { //再判断切出来的第一个first 是否是0开头的 比如 08
            String result = first.split("0")[1]; //如果是 则根据0再切割 然后取第二个 则 取 8
            aa = Integer.parseInt(String.valueOf(result)); //把字符串转为整形
        } else {//如果不是0开头的 则 直接把它转为整形 比如 10
            aa = Integer.parseInt(String.valueOf(first));
        }
        //第二个时间的同理可得
        Integer bb = null;
        String second = scheduleClass.getEndTime().split(":")[0];
        if (second.startsWith("0")) {
            String result1 = second.split("0")[1];
            bb = Integer.parseInt(String.valueOf(result1));
        } else {
            bb = Integer.parseInt(String.valueOf(second));
        }
        //第二个时间段减去第一个时间
        if (bb - aa < 0) {
            return RestFulBean.error("开始时间段不能大于结束时间段");
        }
        if (bb - aa > 2) {
            return RestFulBean.error("课程只能选两节课");
        }
        this.scheduleClassMapper.update(scheduleClass);
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
        this.scheduleClassMapper.deleteById(id);
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<Map> getList(Page<ScheduleClass> page) throws Exception {
        //前端传来的参数 第几页
        Integer pageNum =page.getPageNum();
        //mysql从0开始算起 0 为第一页 所以要减1   startNum 值为从第几条开始拿
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<ScheduleClass> list= scheduleClassMapper.getPageListByCondition(page);
        //根据条件查询数据的条数
        Integer count = scheduleClassMapper.getPageListCount(page);
        //拿到总条数跟总页数 在前端渲染
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //讲查询的数据用map对象返回
        map.put("list",list);
        return RestFulBean.succ(map);
    }
}
